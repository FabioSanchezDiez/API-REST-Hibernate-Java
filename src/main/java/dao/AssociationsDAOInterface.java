package dao;

import dto.CourseDTO;
import models.Course;
import models.User;

import java.util.List;

public interface AssociationsDAOInterface {
    List<CourseDTO> returnOwnedCourses(User user);
    List<User> returnUsersWithCourse(Course course);
}
