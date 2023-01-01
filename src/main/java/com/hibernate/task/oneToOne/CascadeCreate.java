package com.hibernate.task.oneToOne;

import com.hibernate.task.util.HibernateUtil;
import com.hibernate.task.oneToOne.entity.Detail;
import com.hibernate.task.oneToOne.entity.Employee;
import org.hibernate.Session;

public class CascadeCreate {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Employee employee = new Employee("Piotr", "Pavlov", "IT", 800);
            Detail detail = new Detail("Moscow", "98237423", "pavlov@email.ru");

            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.save(detail);
            session.save(employee);

            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}