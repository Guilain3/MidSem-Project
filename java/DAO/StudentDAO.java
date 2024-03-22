package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Student;
import Util.HibernateUtil;

//import java.time.LocalDate;

public class StudentDAO {

    public void save(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }

    public void update(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }

    public void delete(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }
}
