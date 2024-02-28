package dao.review;

import models.Course;
import models.Review;
import models.User;

import java.util.List;

public interface ReviewDAOInterface {
    Review searchById(Long id);
    List<Review> returnBestReviews();
    Review searchByUserAndCourse(User user, Course course);
}
