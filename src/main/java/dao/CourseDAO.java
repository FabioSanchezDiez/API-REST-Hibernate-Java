package dao;

import dto.CourseDTO;
import models.Course;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDAO implements CourseDAOInterface{

    @Override
    public List<Course> returnAllCourses(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Course> courses = session.createQuery("from Course", Course.class).list();
        session.close();

        return courses;
    }

    @Override
    public List<CourseDTO> returnAllCourses(int page, int objects) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Query HQL with limits for do pagination
        Query<CourseDTO> query = session.createQuery("select new dto.CourseDTO(c.id, c.image, c.name, c.registeredUsers) from Course c", CourseDTO.class);
        query.setMaxResults(objects);
        query.setFirstResult((page - 1) * objects);


        List<CourseDTO> courses = query.list();

        session.close();

        return courses;
    }

    @Override
    public List<CourseDTO> returnCoursesLike(String search){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<CourseDTO> query = session.createQuery("select new dto.CourseDTO(c.id, c.image, c.name, c.registeredUsers) from Course c where c.name like :search", CourseDTO.class);
        query.setParameter("search", "%"+search+"%");
        List<CourseDTO> courses = query.list();

        session.close();

        return courses;
    }

    @Override
    public List<CourseDTO> returnCoursesIn(List<String> categories) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<CourseDTO> query = session.createQuery("select new dto.CourseDTO(c.id, c.image, c.name, c.registeredUsers) from Course c where c.category in (:categories)", CourseDTO.class);
        query.setParameterList("categories",categories);
        List<CourseDTO> courses = query.list();

        session.close();

        return courses;
    }

    @Override
    public List<Map<String, Double>> returnUsersAverage(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Double average = session.createQuery("select avg(c.registeredUsers) from Course c", Double.class).getSingleResult();
        List<Map<String, Double>> usersAverage = List.of(new HashMap<>(Map.of("usersAverage", Math.round(average * 100.0) / 100.0)));

        session.close();

        return usersAverage;
    }

    @Override
    public List<CourseDTO> returnSummaryPopularCourses(Integer condition){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<CourseDTO> query = session.createQuery("select new dto.CourseDTO(c.id, c.image, c.name, c.registeredUsers) from Course c where c.registeredUsers > :condition order by c.registeredUsers DESC", CourseDTO.class);
        query.setParameter("condition", condition);
        List <CourseDTO> popularCourses = query.list();

        session.close();

        return popularCourses;
    }

    @Override
    public Course searchById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Course course = session.createQuery("from Course c where c.id = :id", Course.class)
                .setParameter("id",id)
                .getSingleResult();

        session.close();

        return course;
    }

    @Override
    public Course createCourse(Course course){
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }

        session.close();
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }

        session.close();

        return course;
    }

    @Override
    public Course deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course course;
        try{
            session.beginTransaction();
            course = searchById(id);

            if(course != null){
                session.delete(course);
            } else{
                return null;
            }
            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
        return course;
    }

    @Override
    public long returnNumberOfCourses(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        long numberOfCourses = (long) session.createQuery("select count(*) from Course").getSingleResult();
        session.close();

        return numberOfCourses;
    }

}
