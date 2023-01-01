package com.hibernate.task.oneToMany.Bi;

import com.hibernate.task.oneToMany.Bi.entity.Employees;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeDelete {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Employees emp = session.get(Employees.class, 4L);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}
