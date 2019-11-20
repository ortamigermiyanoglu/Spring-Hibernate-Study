package com.sumutella.basicoperations;

import com.sumutella.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author sumutella
 * @time 9:48 PM
 * @since 11/19/2019, Tue
 */
public class QueryApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        String hql ="from Student s where s.fullName like '%s%' or s.email like'%metu%' and s.id = 1";


        try {

            session.beginTransaction();
            Student student = session.createQuery(hql, Student.class).getSingleResult();

            System.out.println(student);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
