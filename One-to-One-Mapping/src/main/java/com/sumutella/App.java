package com.sumutella;

import com.sumutella.entity.Detail;
import com.sumutella.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Detail.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Detail detail = new Detail("fb.com/sumutella", "running");
        Instructor instructor = new Instructor("Semir Kurt", "e186906@metu.edu.tr", detail);

        session.beginTransaction();

        session.save(instructor);

        session.getTransaction().commit();


        sessionFactory.close();

    }
}
