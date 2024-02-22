package dao;

import models.Course;
import models.Review;
import models.User;

public interface ReviewDAOInterface {
    Review searchById(Long id);
    Review searchByUserAndCourse(User user, Course course);
}
