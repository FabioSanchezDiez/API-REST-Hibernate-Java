import dao.CourseDAO;
import services.CoursesAPIREST;

public class Server {
    public static void main(String[] args) {
        CoursesAPIREST api = new CoursesAPIREST(new CourseDAO());
    }
}
