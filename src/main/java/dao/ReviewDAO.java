package dao;

import models.Course;
import models.Review;
import models.User;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.NoResultException;

public class ReviewDAO implements ReviewDAOInterface{
    @Override
    public Review searchById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Review review = session.find(Review.class, id);
        session.close();

        return review;
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
