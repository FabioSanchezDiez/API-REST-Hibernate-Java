package dao;

import models.Course;
import models.Review;
import models.User;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class ReviewDAO implements ReviewDAOInterface{
    @Override
    public Review searchById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Review review = session.find(Review.class, id);
        session.close();

        return review;
    }

    @Override
    public List<Review> returnBestReviews() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Review> query = session.createQuery("from Review r where r.rating = :condition", Review.class)
                .setMaxResults(6)
                .setParameter("condition", 5);
        List<Review> reviews = query.list();

        return reviews;
    }

    @Override
    public Review searchByUserAndCourse(User user, Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Review review = session.createQuery("from Review r where r.user.id = :userId and r.course.id = :courseId", Review.class)
                    .setParameter("userId", user.getId())
                    .setParameter("courseId", course.getId())
                    .getSingleResult();
            return review;
        } catch (NoResultException e) {
            return null;
        }
    }
}
