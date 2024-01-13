package services;

import adapters.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.CourseDAOInterface;
import models.Course;
import spark.Spark;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CoursesAPIREST {
    private final CourseDAOInterface dao;

    // Adapter for LocalDate type
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();

    public CoursesAPIREST(CourseDAOInterface implementation){
        Spark.port(8080);
        dao = implementation;

        // Configuring filter CORS
        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
            response.header("Access-Control-Allow-Credentials", "true");
            // Informamos al cliente sobre el tipo de datos que está devolviendo el cuerpo de la respuesta
            response.type("application/json");
        });


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

    }
}
