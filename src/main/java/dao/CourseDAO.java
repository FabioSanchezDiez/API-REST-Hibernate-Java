package dao;

import models.Course;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.query.Query;
import java.util.List;

public class CourseDAO implements CourseDAOInterface{

    public List<Course> returnAllCourses(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Course> courses = session.createQuery("from Course", Course.class).list();
        session.close();

        return courses;
    }

    public List<Course> returnAllCourses(int page, int objects) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Query HQL with limits for do pagination
        Query<Course> query = session.createQuery("from Course", Course.class);
        query.setMaxResults(objects);
        query.setFirstResult((page - 1) * objects);


        List<Course> courses = query.list();

        session.close();

        return courses;
    }

    public long returnNumberOfCourses(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        long numberOfCourses = (long) session.createQuery("select count(*) from Course").getSingleResult();
        session.close();

        return numberOfCourses;
    }

}
