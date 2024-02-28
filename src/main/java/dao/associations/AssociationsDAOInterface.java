package dao.associations;

import dto.CourseDTO;
import models.*;

import java.util.List;

public interface AssociationsDAOInterface {
    List<CourseDTO> returnOwnedCourses(User user);
    List<Course> returnOwnedCourses(User user, boolean isFullCourse);
    List<User> returnUsersWithCourse(Course course);
    boolean joinCourse(Course course, User user);
    CourseDTO returnCourseByReview(Review review);
    List<Review> returnReviewsByUser(User user);
    Review createReview(User user, Course course, Review review);
    CourseDTO returnCourseBySection(Section section);
    List<Section> returnSectionsByCourse(Course course);
    Section createSection(Course course, Section section);
    Section returnSectionByLesson(Lesson lesson);
    List<Lesson> returnLessonsBySection(Section section);
    Lesson createLesson(Section section, Lesson lesson);
}
