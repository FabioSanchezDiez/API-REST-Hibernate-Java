package dao.apikey;

import models.ApiKey;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.security.SecureRandom;
import java.util.List;

public class ApiKeyDAO implements ApiKeyDAOInterface{
    @Override
    public List<ApiKey> returnAllApiKeys(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<ApiKey> apis = session.createQuery("from ApiKey", ApiKey.class).list();
        session.close();

        return apis;
    }

    @Override
    public ApiKey checkValidApiKey(String apikey, String requestMethod){
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

        if (foundedApiKey.getReadOnly() && (requestMethod.equals("POST") || requestMethod.equals("PUT") || requestMethod.equals("DELETE"))) return null;

        session.beginTransaction();
        foundedApiKey.decrementUse();
        session.update(foundedApiKey);
        session.getTransaction().commit();
        session.close();

        return foundedApiKey;
    }

    @Override
    public ApiKey createApiKey(ApiKey apiKey){
        String key = generateApiKey();
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            session.beginTransaction();
            apiKey.setApiKey(key);
            session.save(apiKey);
            session.getTransaction().commit();
        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }

        session.close();

        return apiKey;
    }

    private String generateApiKey(){
        char[] validCharacters = "0123456789abcdefghijklmnopqrstuvwxyz-_ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder apiKeyBuilder = new StringBuilder();

        for (int i = 0; i < 40; i++) {
            int randomIndex = secureRandom.nextInt(validCharacters.length);
            apiKeyBuilder.append(validCharacters[randomIndex]);
        }

        return apiKeyBuilder.toString();
    }
}
