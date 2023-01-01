package com.hibernate.task.oneToMany.Uni;

import com.hibernate.task.oneToMany.Uni.entity.DepartmentUni;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeRead {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            DepartmentUni department = session.get(DepartmentUni.class, 5);
            System.out.println(department.getEmplyeeList());

            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}


