package Repository;

import Entity.UserEntity;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class LoginRepository {

    Session session= HibernateUtil.getInstance().getSession();

    public UserEntity checkUserNameandPassword(String userName,String password){
        String HQL="FROM UserEntity WHERE username = :UserName AND password = : Password";

        UserEntity userEntity=session.createQuery(HQL,UserEntity.class)
                .setParameter("UserName",userName)
                .setParameter("Password",password)
                .uniqueResult();

        return userEntity;
    }
}

