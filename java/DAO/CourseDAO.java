package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Course;
import Util.HibernateUtil;

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

    public Course getCourseById(int course_id) {
        Course course = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            course = session.get(Course.class, course_id);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            // Handle exception
        }
        return course;
    }
}
