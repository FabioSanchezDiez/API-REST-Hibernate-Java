package dao;

import dto.CourseDTO;
import models.Course;
import models.Review;
import models.User;

import java.util.List;

public interface AssociationsDAOInterface {
    List<CourseDTO> returnOwnedCourses(User user);
    List<Course> returnOwnedCourses(User user, boolean isFullCourse);
    List<User> returnUsersWithCourse(Course course);
    boolean joinCourse(Course course, User user);
    CourseDTO returnCourseByReview(Review review);
    List<Review> returnReviewsByUser(User user);
    Review createReview(User user, Course course, Review review);
}
