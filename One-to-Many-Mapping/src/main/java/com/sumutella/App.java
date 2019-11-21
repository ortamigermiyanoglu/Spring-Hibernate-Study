package com.sumutella;

import com.sumutella.entity.Course;
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

        SessionFactory sessionFactory = null;
        Session session = null;

        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Detail.class).buildSessionFactory();
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 7);
            Course course1 = new Course("Networking" ,instructor);
            Course course2 = new Course("3D Animation", instructor);
            session.save(course1);
            session.save(course2);

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
