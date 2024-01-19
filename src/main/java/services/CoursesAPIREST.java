package services;

import adapters.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.ApiKeyDAOInterface;
import dao.CourseDAOInterface;
import dto.CourseDTO;
import models.ApiKey;
import models.Course;
import spark.Spark;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CoursesAPIREST {
    private final CourseDAOInterface dao;
    private final ApiKeyDAOInterface apidao;

    // Adapter for LocalDate type
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();

    public CoursesAPIREST(CourseDAOInterface implementation, ApiKeyDAOInterface apikey){
        Spark.port(8080);
        dao = implementation;
        apidao = apikey;

        // Configuring filter CORS
        Spark.before((request, response) -> {
            String key = request.headers("APIKEY");

            if (key == null || key.isEmpty()) Spark.halt(404, "Acceso denegado, utiliza un API KEY válida");

            if(!checkApiKey(key)) Spark.halt(404, "Acceso denegado, utiliza un API KEY válida");

            response.header("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
            response.header("Access-Control-Allow-Credentials", "true");

            // Informamos al cliente sobre el tipo de datos que está devolviendo el cuerpo de la respuesta
            response.type("application/json");
        });


        // GET methods

        Spark.get("/courses", (request, response) -> {
            List<Course> courses = dao.returnAllCourses();
            return gson.toJson(courses);
        });

        // Pagination
        Spark.get("/courses/pagination/:page/:size", ((request, response) -> {
            int page = Integer.parseInt(request.params("page"));
            int size = Integer.parseInt(request.params("size"));
            long numberOfCourses = dao.returnNumberOfCourses();

            List<Course> courses = dao.returnAllCourses(page,size);

            PaginationResponse<Course> paginationResponse = new PaginationResponse<>(courses, numberOfCourses, page, size);
            return gson.toJson(paginationResponse);
        }));

        // Like filter
        Spark.get("/courses/search/:search", (request, response) -> {
            String search = request.params("search");
            List<Course> courses = dao.returnCoursesLike(search);
            return gson.toJson(courses);
        });

        // IN filter
        Spark.get("/courses/filter/:filters", (request, response) -> {
            String filter = request.params("filters");
            List<String> filters = List.of(filter.split(","));

            List<Course> courses = dao.returnCoursesIn(filters);
            return gson.toJson(courses);
        });

        // AVG function
        Spark.get("/courses/usersaverage", (request, response) -> {
            List<Map<String, Double>> course = dao.returnUsersAverage();
            return gson.toJson(course);
        });

        // DTO and Where condition
        Spark.get("/courses/popular/:condition", (request, response) -> {
            Integer condition = Integer.parseInt(request.params("condition"));
            List<CourseDTO> course = dao.returnSummaryPopularCourses(condition);
            return gson.toJson(course);
        });

        // POST methods
        Spark.post("/courses", ((request, response) -> {
            Course course = gson.fromJson(request.body(), Course.class);
            Course createdCourse = dao.createCourse(course);
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

            Course updatedCourse = dao.updateCourse(course);

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
            boolean deleted = dao.deleteById(id);
            if (!deleted) {
                response.status(404);
                return "Curso no encontrado";
            }
            return "Curso eliminado";
        }));

        // API KEY
        Spark.get("/apikey", (request, response) -> {
            List<ApiKey> course = apidao.getApiKeys();
            return gson.toJson(course);
        });
    }

    private boolean checkApiKey(String key) {
        ApiKey validApiKey = apidao.checkValidApiKey(key);
        return validApiKey != null;
    }
}
