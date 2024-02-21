package dao;

import dto.CourseDTO;
import models.Course;
import models.User;

import java.util.List;

public interface AssociationsDAOInterface {
    List<CourseDTO> returnOwnedCourses(User user);
    List<Course> returnOwnedCourses(User user, boolean isFullCourse);
    List<User> returnUsersWithCourse(Course course);
    boolean joinCourse(Course course, User user);
}
