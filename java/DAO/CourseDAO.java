package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Course;
import Util.HibernateUtil;

//import java.time.LocalDate;

public class CourseDAO {

    public void save(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }

    public void update(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }

    public void delete(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(course);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }
}
