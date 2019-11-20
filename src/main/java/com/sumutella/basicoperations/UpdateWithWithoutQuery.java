package com.sumutella.basicoperations;

import com.sumutella.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author sumutella
 * @time 10:05 PM
 * @since 11/19/2019, Tue
 */
public class UpdateWithWithoutQuery {


    public static void main(String[] args) {
        SessionFactory sessionFactory =new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        //Student student = session.get(Student.class, 2);
        //student.setFullName("Ahmet Faruk Gebzeli");

        session.createQuery("update Student set fullName='Ahmet Gebzeli' where id=2").executeUpdate();

        session.getTransaction().commit();
        sessionFactory.close();


    }

}
