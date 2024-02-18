package dao;

import models.Course;
import models.User;

import java.util.List;

public interface AssociationsDAOInterface {
    List<User> returnUsersWithCourse(Course course);
}
