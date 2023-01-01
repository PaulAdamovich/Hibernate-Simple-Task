package com.hibernate.task.oneToMany.Bi;

import com.hibernate.task.oneToMany.Bi.entity.Departments;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeRead {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            System.out.println("Get Departments");
            Departments department = session.get(Departments.class, 3L);

            System.out.println("Show Departments");
            System.out.println(department);

            System.out.println("Show Employee");
            System.out.println(department.getEmployeeList());

            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}