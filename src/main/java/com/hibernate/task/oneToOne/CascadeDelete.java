package com.hibernate.task.oneToOne;

import com.hibernate.task.util.HibernateUtil;
import com.hibernate.task.oneToOne.entity.Detail;
import org.hibernate.Session;

public class CascadeDelete {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 12L);
            detail.getEmployee().setEmpDetail(null);

            session.delete(detail);
            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}
