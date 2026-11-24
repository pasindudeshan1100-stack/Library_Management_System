package Service;

import Entity.BookEntity;
import Hibernate.HibernateUtil;
import Model.MemberDTO;
import Repository.MemberRepository;
import db.DBConnection;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddMemberServiceImpl implements AddMemberService {

    Connection connection= DBConnection.getInstance().getConnection();
    Session session= HibernateUtil.getInstance().getSession();

    MemberRepository memberRepository=new MemberRepository();


//    public boolean addMember(MemberDTO memberDTO) {
//        String sql="INSERT INTO members (full_name,email,phone_number,adress) VALUES (?,?,?,?);";
//        try {
//           PreparedStatement preparedStatement= connection.prepareStatement(sql);
//             preparedStatement.setString(1,name);
//             preparedStatement.setString(2,email);
//             preparedStatement.setString(3,phonenumber);
//             preparedStatement.setString(4,adress);
//
//       return preparedStatement.executeUpdate()>0;
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        Transaction transaction= session.beginTransaction();
//
//        MemberEntity memberEntity=new MemberEntity();
//        memberEntity.setName(memberDTO.getName());
//        memberEntity.setEmail(memberDTO.getEmail());
//        memberEntity.setPhoneNumber(memberDTO.getPhonenumber());
//        memberEntity.setAdress(memberDTO.getAdress());
//        session.persist(memberEntity);
//        transaction.commit();
//        return true;
//    }

    public List<MemberDTO> getAllMembers(){
        List<MemberDTO> members=new ArrayList<>();
        String sql="SELECT * FROM members;";
        try {
           PreparedStatement preparedStatement= connection.prepareStatement(sql);
           ResultSet resultSet=preparedStatement.executeQuery();
           while (resultSet.next()){
              MemberDTO member=new MemberDTO(
                      resultSet.getString("member_id"),
                      resultSet.getNString("full_name"),
                      resultSet.getString("email"),
                      resultSet.getString("phone_number"),
                      resultSet.getString("adress")
              );
              members.add(member);
           }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to load members.", e);

        }
        return members;
    }

    public boolean UpdateMember(String name, String email, String adress, String phonenumber) {
        String sql="UPDATE members SET full_name=?,email=?,phone_number=?,adress=? WHERE member_id=?;" ;
        try {
          PreparedStatement preparedStatement=  connection.prepareStatement(sql);
          preparedStatement.setString(1,name);
          preparedStatement.setString(2,email);
          preparedStatement.setString(3,adress);
          preparedStatement.setString(4,phonenumber);

          return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteMember(String id) {
        String sql="DELETE FROM members WHERE member_id=?;";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean addMemberDetails(MemberDTO memberDTO) {
        return memberRepository.addmember(memberDTO);
    }

    @Override
    public boolean updateMemberDetails(MemberDTO memberDTO) {
        return memberRepository.updateMember(memberDTO);
    }

    @Override
    public BookEntity searchMemberDetails(Integer id) {
        return null;
    }

    @Override
    public boolean deletememberDetails(Integer id) {
        return memberRepository.deletemember(id);
    }
}
