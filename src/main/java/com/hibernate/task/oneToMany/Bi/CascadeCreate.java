package com.hibernate.task.oneToMany.Bi;

import com.hibernate.task.oneToMany.Bi.entity.Departments;
import com.hibernate.task.oneToMany.Bi.entity.Employees;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeCreate {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Departments department = new Departments("Salary", 1500L, 700L);
            Employees emp1 = new Employees("Vanya", "Ivanov", "900");
            Employees emp2 = new Employees("Irina", "Smirnova", "1300");
            Employees emp3 = new Employees("Sasha", "Sidodrov", "1200");

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);
            department.addEmployeeToDepartment(emp3);

            session.save(department);
            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}