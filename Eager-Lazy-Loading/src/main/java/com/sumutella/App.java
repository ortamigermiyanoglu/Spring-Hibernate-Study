package com.sumutella;

import com.sumutella.entity.Course;
import com.sumutella.entity.Detail;
import com.sumutella.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
        Instructor instructor = null;

        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Detail.class).buildSessionFactory();
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
//            //IF THE FETCH TYPE WERE EAGER, IT WAS GOING TO BRING COURSES ON INSTRUCTOR, INSTRUCTOR DETAIL IN BELOW CODE
//            Instructor instructor = session.get(Instructor.class, 7);

            // HOW TO ESCAPE FROM LAZY INITIALIZATION EXCEPTION
            Query<Instructor> query = session.createQuery("select  i from Instructor i join fetch i.courses " +
                    "where i.id =:paremetrizedId", Instructor.class);
            query.setParameter("paremetrizedId", 8);

            instructor = query.getSingleResult();
            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
        }

        finally {
            session.close();
            sessionFactory.close();
        }

        System.out.println(instructor.getCourses());
    }
}
