package dao.user;

import classes.Email;
import dto.UserDTO;
import models.Course;
import models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class UserDAO implements UserDAOInterface{

    @Override
    public User searchById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = session.find(User.class, id);
        session.close();

        return user;
    }

    @Override
    public User searchByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user;

        try{
            user = session.createQuery("from User u where u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
        session.close();

        return user;
    }

    @Override
    public User confirmAccount(String token) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user;

        try{
            user = session.createQuery("from User u where u.token = :token", User.class)
                    .setParameter("token", token)
                    .getSingleResult();

            session.beginTransaction();
            user.setToken(null);
            user.setConfirmed(true);
            session.update(user);
            session.getTransaction().commit();

            } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.close();

        return user;
    }

    @Override
    public User createUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            user.hashPassword();
            user.createToken();
            session.save(user);
            session.getTransaction().commit();

            Email email = new Email(user.getEmail(), user.getName(), user.getToken());
            email.sendConfirmation();

        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        session.close();
        return user;
    }

    @Override
    public User updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            user.hashPassword();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }

        session.close();

        return user;
    }

    @Override
    public User deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user;
        try{
            session.beginTransaction();
            user = searchById(id);

            if(user != null){
                session.delete(user);
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
        return user;
    }

    @Override
    public User returnAuthenticatedUser(UserDTO userDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
            query.setParameter("email", userDTO.getEmail());
            User user = query.uniqueResult();

            // Check if the user exists and the password is correct
            if (user != null && user.checkPassword(userDTO.getPassword(), user.getPassword()) && user.getConfirmed()) {
                // Authentication successful
                session.close();
                return user;
            } else {
                // Authentication failed
                return null;
            }

        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
            return null;
        }
    }
}
