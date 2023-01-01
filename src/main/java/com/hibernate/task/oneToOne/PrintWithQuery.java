package com.hibernate.task.oneToOne;

import com.hibernate.task.util.HibernateUtil;
import com.hibernate.task.oneToOne.entity.Employee;
import org.hibernate.Session;

import java.util.List;

public class PrintWithQuery {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            List<Employee> employeeList = session.createQuery("from Employee " + "where salary=800")
                            .getResultList();
            for(Employee emp:employeeList){
                System.out.println(emp);
            }

            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}
