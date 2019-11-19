package com.sumutella.app;

import com.sumutella.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
public class SaveRetrieve
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try{
            //Student student = new Student("Semir Kurt", "e186906@metu.edu.tr");
            session.beginTransaction();

            //session.save(student);

            Student student = session.get(Student.class, 1);
            System.out.println(student);

            session.getTransaction().commit();



        } finally {
            sessionFactory.close();
        }



    }
}
