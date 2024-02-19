package dao;

import models.Course;
import models.User;

import java.util.List;

public interface AssociationsDAOInterface {
    List<Course> returnOwnedCourses(User user);
    List<User> returnUsersWithCourse(Course course);
}
