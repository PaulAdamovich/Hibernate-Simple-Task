package com.hibernate.task.manyToMany;

import com.hibernate.task.manyToMany.entity.Children;
import com.hibernate.task.manyToMany.entity.Section;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeCreateSection {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Section section = new Section("Football");
            Children child1 = new Children("Ivan", 12);
            Children child2 = new Children("Maria", 9);
            Children child3 = new Children("Nikita", 13);
            Children child4 = new Children("Zurab", 6);

            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);
            section.addChildToSection(child4);

            session.persist(section);
            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}
