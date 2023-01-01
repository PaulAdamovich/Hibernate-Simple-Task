package com.hibernate.task.manyToMany;

import com.hibernate.task.manyToMany.entity.Section;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeDeleteSection {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Section section = session.get(Section.class, 10);
            session.delete(section);

            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}


