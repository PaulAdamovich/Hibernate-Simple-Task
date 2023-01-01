package com.hibernate.task.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory SessionFactory = buildFactory();
    private static SessionFactory buildFactory() {
        try{
        return  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    } catch (Throwable ex){
        throw new ExceptionInInitializerError();
        }
    }
    public static SessionFactory getSessionFactory(){
        if(SessionFactory == null){
            buildFactory();
        }
        return SessionFactory;
    }
    public static void shutdownFactory(){
        getSessionFactory().close();
    }
}
