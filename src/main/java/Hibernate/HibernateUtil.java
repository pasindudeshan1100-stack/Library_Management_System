package Hibernate;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static Session session;
    private  static HibernateUtil instance;

    private HibernateUtil(){
        Configuration configuration=new Configuration().configure()

        .addAnnotatedClass(MemberEntity.class)
        .addAnnotatedClass(BookEntity.class)
        .addAnnotatedClass(IssueBookEntity.class)
        .addAnnotatedClass(ReturnBookEntity.class)
        .addAnnotatedClass(BookHistoryEntity.class);

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        session =sessionFactory.openSession();




    }
    public static HibernateUtil getInstance(){
        if (instance==null){
            instance=new HibernateUtil();
        }
        return instance;
    }
    public Session getSession(){
        return session;
    }

}
