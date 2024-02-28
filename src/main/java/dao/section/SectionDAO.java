package dao.section;

import models.Section;
import org.hibernate.Session;
import util.HibernateUtil;

public class SectionDAO implements SectionDAOInterface{
    @Override
    public Section searchById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Section section = session.find(Section.class, id);
        session.close();

        return section;
    }
}
