package com.hibernate.task.manyToMany;

import com.hibernate.task.manyToMany.entity.Children;
import com.hibernate.task.manyToMany.entity.Section;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeDeleteChild {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Children children = session.get(Children.class, 17);
            session.delete(children);

            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}


