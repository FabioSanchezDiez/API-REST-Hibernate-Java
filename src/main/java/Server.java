import dao.*;
import services.CoursesAPIREST;

public class Server {
    public static void main(String[] args) {
        CoursesAPIREST api = new CoursesAPIREST(new CourseDAO(), new UserDAO(), new ReviewDAO(), new AssociationsDAO(), new ApiKeyDAO());
    }
}