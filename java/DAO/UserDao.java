package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Model.auca_user;
import Util.HibernateUtil;

public class UserDao {

    private final SessionFactory sessionFactory;

    public UserDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void saveUser(auca_user user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public auca_user getUser(String email, String password, String role) {
        Session session = sessionFactory.openSession();
        try {
            return (auca_user) session.createQuery("FROM auca_user WHERE email = :email AND password = :password AND role = :role")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .setParameter("role", role)
                    .uniqueResult();
        } finally {
            session.close();
        }
    }

}
