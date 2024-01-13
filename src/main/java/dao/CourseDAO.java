package dao;

import models.Course;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Course> returnCoursesLike(String search){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Course> query = session.createQuery("from Course c where c.name like :search", Course.class);
        query.setParameter("search", "%"+search+"%");
        List<Course> courses = query.list();

        session.close();

        return courses;
    }

    public List<Course> returnCoursesIn(List<String> categories) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Course> query = session.createQuery("from Course c where c.category in (:categories)", Course.class);
        query.setParameterList("categories",categories);
        List<Course> courses = query.list();

        session.close();

        return courses;
    }

    public List<Map<String, Double>> returnUsersAverage(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Double average = session.createQuery("select avg(c.registeredUsers) from Course c", Double.class).getSingleResult();
        List<Map<String, Double>> usersAverage = List.of(new HashMap<>(Map.of("usersAverage", Math.round(average * 100.0) / 100.0)));

        session.close();

        return usersAverage;
    }

    public long returnNumberOfCourses(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        long numberOfCourses = (long) session.createQuery("select count(*) from Course").getSingleResult();
        session.close();

        return numberOfCourses;
    }

}
