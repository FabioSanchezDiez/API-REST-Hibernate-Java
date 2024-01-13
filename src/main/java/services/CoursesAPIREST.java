package services;

import adapters.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.CourseDAOInterface;
import models.Course;
import spark.Spark;

import java.time.LocalDate;
import java.util.List;

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

        // Configurar filtro CORS
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

        Spark.get("/courses/:page/:size", ((request, response) -> {
            int page = Integer.parseInt(request.params("page"));
            int size = Integer.parseInt(request.params("size"));
            long numberOfCourses = dao.returnNumberOfCourses();

            List<Course> courses = dao.returnAllCourses(page,size);

            PaginationResponse<Course> paginationResponse = new PaginationResponse<>(courses, numberOfCourses, page, size);
            return gson.toJson(paginationResponse);
        }));
    }
}
