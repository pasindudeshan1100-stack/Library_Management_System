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
    public boolean updateMember(MemberDTO memberDTO){
        Transaction transaction=session.beginTransaction();
        try {
            MemberEntity member=session.find(MemberEntity.class,memberDTO.getId());
            if (member!=null){
                member.setName(memberDTO.getName());
                member.setEmail(memberDTO.getEmail());
                member.setAdress(memberDTO.getAdress());
                member.setPhoneNumber(memberDTO.getPhonenumber());
                transaction.commit();
                return  true;
            }
            transaction.rollback();
            return  false;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            throw new RuntimeException(e);
        }
    }
    public  boolean deletemember(Integer id){
        Transaction transaction=session.beginTransaction();
        try {
            MemberEntity member=session.find(MemberEntity.class,id);
            if (member!=null){
                session.remove(member);
                transaction.commit();
                return true;
            }
            return  false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public MemberEntity searchMember(Integer id){
        try {
            return session.find(MemberEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
