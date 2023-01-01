package com.hibernate.task.manyToMany;

import com.hibernate.task.manyToMany.entity.Children;
import com.hibernate.task.manyToMany.entity.Section;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeCreateChildren {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Children children = new Children("Igor", 9);
            Section sect1 = new Section("Football");
            Section sect2 = new Section("Voleyball");

            children.addSectionToChild(sect1);
            children.addSectionToChild(sect2);

            session.save(children);
            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}

