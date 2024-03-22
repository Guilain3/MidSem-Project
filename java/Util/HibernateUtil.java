package Util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Model.AcademicUnit;
//import Model.AcademicUnitEnum;
import Model.Course;
import Model.CourseDefinition;
//import Model.QualificationEnum;
import Model.Semester;
import Model.Student;
import Model.StudentRegistration;
import Model.Teacher;
import Model.auca_user;

public class HibernateUtil {
    
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                 
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/auca");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "000000");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(auca_user.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(StudentRegistration.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Semester.class);
                configuration.addAnnotatedClass(CourseDefinition.class);
                configuration.addAnnotatedClass(AcademicUnit.class);
                //configuration.addAnnotatedClass(AcademicUnitEnum.class);
                //configuration.addAnnotatedClass(QualificationEnum.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
