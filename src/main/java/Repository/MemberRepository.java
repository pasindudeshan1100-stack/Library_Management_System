package Repository;

import Entity.MemberEntity;
import Hibernate.HibernateUtil;
import Model.MemberDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberRepository {

    Session session= HibernateUtil.getInstance().getSession();
    public  boolean addmember(MemberDTO memberDTO){
       Transaction transaction= session.beginTransaction();
        MemberEntity member=new MemberEntity();
        try {
            member.setName(memberDTO.getName());
            member.setEmail(memberDTO.getEmail());
            member.setPhoneNumber(memberDTO.getPhonenumber());
            member.setAdress(memberDTO.getAdress());
            session.persist(member);
            transaction.commit();
            return  true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
            return false;
        }
    }
}
