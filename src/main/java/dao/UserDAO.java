package dao;

import classes.Email;
import models.User;
import org.hibernate.Session;
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



}
