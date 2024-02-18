package dao;

import classes.Email;
import models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.PersistenceException;

public class UserDAO implements UserDAOInterface{

    @Override
    public User searchById(Long id) {
        return null;
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
    public User returnAuthenticatedUser(String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
            query.setParameter("email", email);
            User user = query.uniqueResult();

            // Check if the user exists and the password is correct
            if (user != null && user.checkPassword(password, user.getPassword())) {
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
