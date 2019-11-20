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
public class App {


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = null;
        Session session = null;

        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(Detail.class).buildSessionFactory();
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

//        Detail detail = new Detail("to be deleted","to be deleted");
//        Instructor instructor = new Instructor("to be deleted", "to be deleted");
//
//        instructor.setDetail(detail);

            Detail detail = session.get(Detail.class, 4);


            System.out.println(detail.getInstructor());

            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
        }

        finally {
            session.close();
            sessionFactory.close();

        }




    }
}
