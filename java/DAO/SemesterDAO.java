package DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Model.Semester;
import Util.HibernateUtil;

public class SemesterDAO {

    public void save(Semester sem) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(sem);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }

    public void update(Semester sem) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(sem);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }

    public void delete(Semester sem) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(sem);
            transaction.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
    }

    public Semester getSemesterById(int id) {
        Semester semester = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            semester = session.get(Semester.class, id);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
        return semester;
    }
    public List<Semester> getAllSemesters() {
        List<Semester> semesters = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Semester> query = session.createQuery("FROM Semester", Semester.class);
            semesters = query.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
        return semesters;
    }
}
