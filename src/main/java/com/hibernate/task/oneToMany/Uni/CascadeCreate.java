package com.hibernate.task.oneToMany.Uni;

import com.hibernate.task.oneToMany.Uni.entity.DepartmentUni;
import com.hibernate.task.oneToMany.Uni.entity.EmplyeeUni;
import com.hibernate.task.util.HibernateUtil;
import org.hibernate.Session;

public class CascadeCreate {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            DepartmentUni department = new DepartmentUni("HR", 900, 600);
            EmplyeeUni emp1 = new EmplyeeUni("Nikita", "Brovarov", 700);
            EmplyeeUni emp2 = new EmplyeeUni("Marina","Nikitina", 650 );
            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

            session.save(department);
            session.getTransaction().commit();
            System.out.println("===== Done! =====");
        } finally {
            session.close();
            HibernateUtil.shutdownFactory();
        }
    }
}
