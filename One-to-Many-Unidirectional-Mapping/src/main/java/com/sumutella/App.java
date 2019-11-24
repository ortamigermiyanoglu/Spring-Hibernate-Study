package com.sumutella;

import com.sumutella.entity.Course;
import com.sumutella.entity.Detail;
import com.sumutella.entity.Instructor;
import com.sumutella.entity.Review;
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
                    .addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Detail.class).addAnnotatedClass(Review.class)
                    .buildSessionFactory();
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Course course = session.get(Course.class, 5);

            course.getReviews().add(new Review("Yildiray Hoca keske amcam olsaydi"));
            course.getReviews().add(new Review("hocam cok iyisiniz, masallah"));

            session.save(course);

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
