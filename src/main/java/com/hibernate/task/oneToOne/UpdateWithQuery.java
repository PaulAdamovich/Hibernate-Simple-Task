package com.hibernate.task.oneToOne;

import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class UpdateWithQuery {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.createQuery("update Employee set salary=1000" + "where department='IT'")
                            .executeUpdate();

            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}
