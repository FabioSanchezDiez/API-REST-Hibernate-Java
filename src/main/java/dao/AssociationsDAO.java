package dao;

import models.Course;
import models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class AssociationsDAO implements AssociationsDAOInterface {

    @Override
    public List<Course> returnOwnedCourses(User user) {
        List<Course> courses;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<User> query = session.createQuery(
                    "select u from User u join fetch u.courses where u.email = :email", User.class);
            query.setParameter("email", user.getEmail());
            courses = query.getSingleResult().getCourses();
        }catch (NoResultException e){
            courses = new ArrayList<>();
        }
        session.close();
        return courses;
    }

    @Override
    public List<User> returnUsersWithCourse(Course course) {
        List<User> users;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<Course> query = session.createQuery(
                    "select c from Course c join fetch c.users where c.id = :id", Course.class);
            query.setParameter("id", course.getId());
            users = query.getSingleResult().getUsers();
        } catch (NoResultException e){
            users = new ArrayList<>();
        }

        session.close();
        return users;
    }
}
