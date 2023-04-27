package se.yrgo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

import java.util.List;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        //creating tutor and students
        Tutor firstTutor = new Tutor("12345", "Anna", 31000);
        Student peter = new Student("Peter Ashby");
        Student eva = new Student("Eva Andersson");
        Student ola = new Student("Ola Petersson");

        firstTutor.addStudentToTeachingGroup(peter);
        firstTutor.addStudentToTeachingGroup(eva);
        firstTutor.addStudentToTeachingGroup(ola);

        List<Student> students = firstTutor.getTeachingGroup();
        for(Student student : students) {
            System.out.println(student);
        }
//
        //adding all students and  firstTutor to hibernate db
        session.save(peter);
        session.save(eva);
        session.save(ola);
        session.save(firstTutor);

        //Printing out all students from a particular teacher. NB! Tutor id can be different
        Tutor myTutor = (Tutor)session.get(Tutor.class, 90);
        students = myTutor.getTeachingGroup();
        for(Student student : students) {
            System.out.println(student);
        }

        tx.commit();
        session.close();
    }


    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}

