import dao.ApiKeyDAO;
import dao.CourseDAO;
import dao.UserDAO;
import services.CoursesAPIREST;

public class Server {
    public static void main(String[] args) {
        CoursesAPIREST api = new CoursesAPIREST(new CourseDAO(), new UserDAO(), new ApiKeyDAO());
    }
}