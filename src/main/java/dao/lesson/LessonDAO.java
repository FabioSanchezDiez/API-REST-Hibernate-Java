package dao.lesson;

import models.Lesson;
import org.hibernate.Session;
import util.HibernateUtil;

public class LessonDAO implements LessonDAOInterface{
    @Override
    public Lesson searchById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Lesson lesson = session.find(Lesson.class, id);
        session.close();

        return lesson;
    }
}
