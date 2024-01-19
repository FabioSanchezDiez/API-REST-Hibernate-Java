package dao;

import models.ApiKey;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import java.util.List;

public class ApiKeyDAO implements ApiKeyDAOInterface{
    public List<ApiKey> getApiKeys(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<ApiKey> apis = session.createQuery("from ApiKey", ApiKey.class).list();
        session.close();

        return apis;
    }

    public ApiKey checkValidApiKey(String apikey){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<ApiKey> query = session.createQuery("select a from ApiKey a where a.apiKey = :apikey", ApiKey.class);
        query.setParameter("apikey", apikey);
        ApiKey foundedApiKey;

        try{
            foundedApiKey = query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }

        if (!foundedApiKey.getActive()) return null;

        session.close();

        return foundedApiKey;
    }
}
