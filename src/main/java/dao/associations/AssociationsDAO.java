package dao.associations;

import dao.review.ReviewDAO;
import dto.CourseDTO;
import models.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

public class AssociationsDAO implements AssociationsDAOInterface {

    // [START] === (User and Course models) ManyToMany Relationship methods for access from both sides ===

    @Override
    public List<CourseDTO> returnOwnedCourses(User user) {
        List<CourseDTO> courses;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<User> query = session.createQuery(
                    "select u from User u join fetch u.courses where u.email = :email", User.class);
            query.setParameter("email", user.getEmail());
            List<Course> coursesWithoutMapped = query.getSingleResult().getCourses();
            courses = coursesWithoutMapped.stream().map( course -> new CourseDTO(course.getId(), course.getImage(), course.getName(), course.getRegisteredUsers())).toList();

        }catch (Exception e){
            courses = new ArrayList<>();
        }
        session.close();
        return courses;
    }

    @Override
    public List<Course> returnOwnedCourses(User user, boolean isFullCourse) {
        List<Course> courses;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<User> query = session.createQuery(
                    "select u from User u join fetch u.courses where u.id = :id", User.class);
            query.setParameter("id", user.getId());
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

    @Override
    public boolean joinCourse(Course course, User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{

            List<Course> courses = returnOwnedCourses(user, true);
            course.increaseRegisteredUsers();
            courses.add(course);
            user.setCourses(courses);

            List<User> users = returnUsersWithCourse(course);
            users.add(user);
            course.setUsers(users);

            session.beginTransaction();

            session.update(course);
            session.update(user);
            session.getTransaction().commit();

        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }

        session.close();
        return true;
    }

    // [END] === (User and Course models) ManyToMany Relationship methods ===


    // [START] === (Review model) OneToMany Relationship methods for access from both sides ===

    @Override
    public CourseDTO returnCourseByReview(Review review) {
        CourseDTO courseMapped;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<Review> query = session.createQuery("select r from Review r join fetch r.course where r.id = :id", Review.class);
            query.setParameter("id", review.getId());
            Course course = query.getSingleResult().getCourse();
            courseMapped = new CourseDTO(course.getId(), course.getImage(), course.getName(), course.getRegisteredUsers());
        } catch (Exception e){
            courseMapped = null;
        }

        session.close();
        return courseMapped;
    }

    @Override
    public List<Review> returnReviewsByUser(User user) {
        List<Review> reviews;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<User> query = session.createQuery("select u from User u join fetch u.reviews where u.id = :id", User.class);
            query.setParameter("id", user.getId());
            reviews = query.getSingleResult().getReviews();
        } catch (Exception e){
            reviews = new ArrayList<>();
        }

        session.close();

        return reviews;
    }

    @Override
    public Review createReview(User user, Course course, Review review) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            session.beginTransaction();

            if(new ReviewDAO().searchByUserAndCourse(user, course) != null) throw new PersistenceException();

            review.setUser(user);
            review.setCourse(course);
            session.save(review);
            session.getTransaction().commit();

        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.close();
        return review;
    }

    // [END] === (Review model) OneToMany Relationship methods ===


    // [START] === (Section model) OneToMany Relationship methods for access from both sides ===

    @Override
    public CourseDTO returnCourseBySection(Section section) {
        CourseDTO courseMapped;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<Section> query = session.createQuery("select s from Section s join fetch s.course where s.id = :id", Section.class);
            query.setParameter("id", section.getId());
            Course course = query.getSingleResult().getCourse();
            courseMapped = new CourseDTO(course.getId(), course.getImage(), course.getName(), course.getRegisteredUsers());
        } catch (Exception e){
            courseMapped = null;
        }

        session.close();
        return courseMapped;
    }

    @Override
    public List<Section> returnSectionsByCourse(Course course) {
        List<Section> sections;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<Course> query = session.createQuery("select c from Course c join fetch c.sections where c.id = :id", Course.class);
            query.setParameter("id", course.getId());
            sections = query.getSingleResult().getSections();
        } catch (Exception e){
            sections = new ArrayList<>();
        }

        session.close();

        return sections;
    }

    @Override
    public Section createSection(Course course, Section section) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            session.beginTransaction();

            section.setCourse(course);
            session.save(section);
            session.getTransaction().commit();

        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.close();
        return section;
    }

    // [END] === (Section model) OneToMany Relationship methods ===


    // [START] === (Lesson model) OneToMany Relationship methods for access from both sides ===
    @Override
    public Section returnSectionByLesson(Lesson lesson) {
        Section section;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<Lesson> query = session.createQuery("select l from Lesson l join fetch l.section where l.id = :id", Lesson.class);
            query.setParameter("id", lesson.getId());
            section = query.getSingleResult().getSection();
        } catch (Exception e){
            section = null;
        }

        session.close();
        return section;
    }

    @Override
    public List<Lesson> returnLessonsBySection(Section section) {
        List<Lesson> lessons;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            Query<Section> query = session.createQuery("select s from Section s join fetch s.lessons where s.id = :id", Section.class);
            query.setParameter("id", section.getId());
            lessons = query.getSingleResult().getLessons();
        } catch (Exception e){
            lessons = new ArrayList<>();
        }

        session.close();

        return lessons;
    }

    @Override
    public Lesson createLesson(Section section, Lesson lesson) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            session.beginTransaction();

            lesson.setSection(section);
            session.save(lesson);
            session.getTransaction().commit();

        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.close();
        return lesson;
    }

}
