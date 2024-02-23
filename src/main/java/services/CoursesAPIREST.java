package services;

import adapters.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.*;
import dto.CourseDTO;
import dto.UserDTO;
import models.ApiKey;
import models.Course;
import models.Review;
import models.User;
import spark.Spark;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CoursesAPIREST {
    private final CourseDAOInterface dao_course;
    private final UserDAOInterface dao_user;
    private final ReviewDAOInterface dao_review;
    private final AssociationsDAOInterface dao_association;
    private final ApiKeyDAOInterface apidao;

    // Adapter for LocalDate type
    private final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();

    public CoursesAPIREST(CourseDAOInterface implementation_course, UserDAOInterface implementation_user, ReviewDAOInterface implementation_review,AssociationsDAOInterface implementation_association, ApiKeyDAOInterface apikey){
        Spark.port(8080);
        dao_course = implementation_course;
        dao_user = implementation_user;
        dao_review = implementation_review;
        dao_association = implementation_association;
        apidao = apikey;


        Spark.exception(Exception.class, (e, req, res) -> {
            e.printStackTrace();
            res.status(500);
            res.body("Excepcion en tu codigo");
        });

        // Configuring filter CORS
        Spark.before((request, response) -> {

            response.header("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
            response.header("Access-Control-Allow-Credentials", "true");

            /*
                El filtro CORS da muchos problemas a la hora de intentar acceder desde el frontend localhost con autenticación
                metiendo en los headers él API KEY. Para evitar problemas en el entorno de desarrollo he hecho una
                pequeña validación comprobando que cuando se intenta acceder desde nuestro frontend local evite
                la validación del API KEY.
             */

            String referer = (request.headers("Referer") != null) ? request.headers("Referer") : "";

            if(!referer.equals("http://127.0.0.1:5500/")){
                String key = request.headers("APIKEY");
                String requestMethod = request.requestMethod();
                if (key == null || key.isEmpty()) Spark.halt(404, "Acceso denegado, utiliza un API KEY válida");

                if(!checkApiKey(key,requestMethod)) Spark.halt(404, "Acceso denegado, utiliza un API KEY válida");
            }

            // Informamos al cliente sobre el tipo de datos que está devolviendo el cuerpo de la respuesta
            response.type("application/json");
        });

        // GET methods
        Spark.get("/courses", (request, response) -> {
            List<Course> courses = dao_course.returnAllCourses();
            return gson.toJson(courses);
        });

        // Pagination
        Spark.get("/courses/pagination/:page/:size", ((request, response) -> {
            int page = Integer.parseInt(request.params("page"));
            int size = Integer.parseInt(request.params("size"));
            long numberOfCourses = dao_course.returnNumberOfCourses();

            List<CourseDTO> courses = dao_course.returnAllCourses(page,size);

            PaginationResponse<CourseDTO> paginationResponse = new PaginationResponse<>(courses, numberOfCourses, page, size);
            return gson.toJson(paginationResponse);
        }));

        Spark.get("/courses/search/id/:id", (request, response) -> {
            Long search = Long.valueOf(request.params("id"));
            Course course = dao_course.searchById(search);
            return gson.toJson(course);
        });

        // Like filter
        Spark.get("/courses/search/:search", (request, response) -> {
            String search = request.params("search");
            List<CourseDTO> courses = dao_course.returnCoursesLike(search);
            return gson.toJson(courses);
        });

        // IN filter
        Spark.get("/courses/filter/:filters", (request, response) -> {
            String filter = request.params("filters");
            List<String> filters = List.of(filter.split(","));

            List<CourseDTO> courses = dao_course.returnCoursesIn(filters);
            return gson.toJson(courses);
        });

        // AVG function
        Spark.get("/courses/usersaverage", (request, response) -> {
            List<Map<String, Double>> course = dao_course.returnUsersAverage();
            return gson.toJson(course);
        });

        // DTO and Where condition
        Spark.get("/courses/popular/:condition", (request, response) -> {
            Integer condition = Integer.parseInt(request.params("condition"));
            List<CourseDTO> course = dao_course.returnSummaryPopularCourses(condition);
            return gson.toJson(course);
        });

        // POST methods
        Spark.post("/courses", ((request, response) -> {
            Course course = gson.fromJson(request.body(), Course.class);
            Course createdCourse = dao_course.createCourse(course);
            if(createdCourse != null){
                return gson.toJson(createdCourse);
            } else{
                response.status(404);
                return "Curso ya existente";
            }
        }));

        // PUT methods
        Spark.put("/courses/update/:id", ((request, response) -> {
            Long id = Long.parseLong(request.params("id"));
            Course course = gson.fromJson(request.body(), Course.class);
            course.setId(id);

            Course updatedCourse = dao_course.updateCourse(course);

            if(updatedCourse != null){
                return gson.toJson(updatedCourse);
            } else{
                response.status(404);
                return "Curso no encontrado";
            }
        }));

        // DELETE methods
        Spark.delete("/courses/delete/:id", ((request, response) -> {
            Long id = Long.parseLong(request.params("id"));
            Course deleted = dao_course.deleteById(id);
            if (deleted != null) {
                return gson.toJson(deleted);
            } else{
                response.status(404);
                return "Curso no encontrado";
            }
        }));

        // Users Endpoints
        Spark.get("/users/search/id/:id", (request, response) -> {
            Long id = Long.valueOf(request.params("id"));
            User user = dao_user.searchById(id);
            if(user != null){
                return gson.toJson(user);
            } else{
                response.status(404);
                return "El usuario no existe";
            }
        });

        Spark.get("/users/search/:email", (request, response) -> {
            String email = request.params("email");
            User user = dao_user.searchByEmail(email);
            if(user != null){
                return gson.toJson(user);
            } else{
                response.status(404);
                return "El usuario no existe";
            }
        });

        Spark.get("/users/confirm/:token", (request, response) -> {
            String token = request.params("token");
            User user = dao_user.confirmAccount(token);
            if(user != null){
                return gson.toJson(user);
            } else{
                response.status(404);
                return "Usuario ya confirmado o no existente";
            }
        });

        Spark.post("/users", ((request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            User createdUser = dao_user.createUser(user);
            if(createdUser != null){
                return gson.toJson(createdUser);
            } else{
                response.status(404);
                return "Usuario ya existente";
            }
        }));

        /*
         * [NOT SECURE]
         * A basic login simulation implementation. When the user exists
         * my API sends the user to the frontend which manage the auth.
         */
        Spark.post("/users/auth", (((request, response) -> {
            UserDTO user = gson.fromJson(request.body(), UserDTO.class);
            User authUser = dao_user.returnAuthenticatedUser(user);
            if(authUser != null){
                return gson.toJson(authUser);
            } else{
                response.status(404);
                return "Inicio de sesión incorrecto";
            }
        })));

        // Reviews endpoints
        Spark.get("/reviews/best", (request, response) -> {
            List<Review> reviews = dao_review.returnBestReviews();
            return gson.toJson(reviews);
        });

        //Associations Endpoints

        //Get courses for the user by email
        Spark.get("/courses/users/:email", (request, response) -> {
            String email = request.params("email");
            User user = dao_user.searchByEmail(email);
            List<CourseDTO> ownedCourses = dao_association.returnOwnedCourses(user);
            if(ownedCourses != null){
                return gson.toJson(ownedCourses);
            } else{
                response.status(404);
                return "El usuario no existe";
            }
        });

        Spark.get("/courses/reviews/:id", (request, response) -> {
            Long id = Long.valueOf(request.params("id"));
            Review review = dao_review.searchById(id);
            CourseDTO course = dao_association.returnCourseByReview(review);
            if(course != null){
                return gson.toJson(course);
            } else{
                response.status(404);
                return "La reseña no existe";
            }
        });

        //Get users for the course by id
        Spark.get("/users/courses/:id", (request, response) -> {
            Long id = Long.valueOf(request.params("id"));
            Course course = dao_course.searchById(id);
            List<User> users = dao_association.returnUsersWithCourse(course);
            if(users != null){
                return gson.toJson(users);
            } else{
                response.status(404);
                return "El curso no existe";
            }
        });

        //Enroll user in the course
        Spark.post("/users/courses/:iduser/:idcourse", (request, response) -> {
            Long idUser = Long.parseLong(request.params("iduser"));
            Long idCourse = Long.parseLong(request.params("idcourse"));
            User user = dao_user.searchById(idUser);
            Course course = dao_course.searchById(idCourse);
            return gson.toJson(dao_association.joinCourse(course, user));
        });

        //Get reviews for the user by id
        Spark.get("/reviews/users/:id", (request, response) -> {
            Long id = Long.valueOf(request.params("id"));
            User user = dao_user.searchById(id);
            List<Review> reviews = dao_association.returnReviewsByUser(user);
            if(reviews != null){
                return gson.toJson(reviews);
            } else{
                response.status(404);
                return "El usuario no existe";
            }
        });

        //Insert new review
        Spark.post("/reviews/:iduser/:idcourse", (request, response) -> {
            Long idUser = Long.parseLong(request.params("iduser"));
            Long idCourse = Long.parseLong(request.params("idcourse"));
            User user = dao_user.searchById(idUser);
            Course course = dao_course.searchById(idCourse);
            Review review = gson.fromJson(request.body(), Review.class);
            Review reviewCreated = dao_association.createReview(user, course, review);
            if(reviewCreated != null){
                return gson.toJson(reviewCreated);
            } else{
                response.status(404);
                return "Ya has escrito una reseña en este curso";
            }
        });

        // API KEY
        Spark.get("/apikey", (request, response) -> {
            List<ApiKey> course = apidao.returnAllApiKeys();
            return gson.toJson(course);
        });

        Spark.post("/apikey/generate", ((request, response) -> {
            ApiKey key = gson.fromJson(request.body(), ApiKey.class);
            ApiKey createdApiKey = apidao.createApiKey(key);
            if(createdApiKey != null){
                return gson.toJson(createdApiKey);
            } else{
                response.status(404);
                return "Error al crear la API KEY";
            }
        }));

        Spark.notFound((request, response) -> {
            response.type("application/json");
            return "{\"error\": \"Ruta no encontrada\",\"hint1\": \"/courses\"," +
                    "\"hint2\": \"/courses/pagination/:page/:size_page\",\"hint3\": \"/courses/search/:search\"}";
        });
    }

    private boolean checkApiKey(String key, String requestMethod) {
        ApiKey validApiKey = apidao.checkValidApiKey(key,requestMethod);
        return validApiKey != null;
    }
}
