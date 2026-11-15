package Hibernate;

import Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private  static HibernateUtil instance;

    private HibernateUtil(){
        Configuration configuration=new Configuration();
        configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/library_system?createDatabaseIfNotExist=true");
        configuration.setProperty("hibernate.connection.username","root");
        configuration.setProperty("hibernate.connection.password","1234");
        configuration.setProperty("hibernate.hbm2ddl.auto","update");
        configuration.addAnnotatedClass(MemberEntity.class);
        configuration.addAnnotatedClass(BookEntity.class);
        configuration.addAnnotatedClass(IssueBookEntity.class);
        configuration.addAnnotatedClass(ReturnBookEntity.class);
        configuration.addAnnotatedClass(BookHistoryEntity.class);

        sessionFactory= configuration.buildSessionFactory();

    }
    public static HibernateUtil getInstance(){
        if (instance==null){
            instance=new HibernateUtil();
        }
        return instance;
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
