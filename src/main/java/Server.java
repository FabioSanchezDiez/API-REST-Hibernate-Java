import dao.apikey.ApiKeyDAO;
import dao.associations.AssociationsDAO;
import dao.course.CourseDAO;
import dao.lesson.LessonDAO;
import dao.review.ReviewDAO;
import dao.section.SectionDAO;
import dao.user.UserDAO;
import services.CoursesAPIREST;

public class Server {
    public static void main(String[] args) {
        CoursesAPIREST api = new CoursesAPIREST(new CourseDAO(), new UserDAO(), new ReviewDAO(), new SectionDAO(), new LessonDAO(), new AssociationsDAO(), new ApiKeyDAO());
    }
}