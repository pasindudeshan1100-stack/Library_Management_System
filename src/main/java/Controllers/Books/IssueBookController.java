package Controllers.Books;

import Entity.BookEntity;
import Entity.IssueBookEntity;
import Entity.MemberEntity;
import Hibernate.HibernateUtil;
import Model.BookDTO;
import Model.IssueBookDTO;
import Model.MemberDTO;
import db.DBConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class IssueBookController {
    Connection connection= DBConnection.getInstance().getConnection();
    Session session= HibernateUtil.getInstance().getSession();

    public boolean addIssueBook(IssueBookDTO issueBookDTO) {

        MemberDTO memberDTO=new MemberDTO();
        BookDTO bookDTO=new BookDTO();
//        String sql="INSERT INTO issueBooks(member_id,book_id,issue_date,due_date)  VALUES (?,?,?,?);";
//        try {
//           PreparedStatement preparedStatement= connection.prepareStatement(sql);
//           preparedStatement.setString(1,memberId);
//           preparedStatement.setString(2,bookId);
//           preparedStatement.setString(3, String.valueOf(issueDate));
//           preparedStatement.setString(4, String.valueOf(dueDate));
//         return   preparedStatement.executeUpdate()>0;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        Transaction transaction=session.beginTransaction();
        try {
            IssueBookEntity issueBookEntity = new IssueBookEntity();
            BookEntity bookEntity = session.find(BookEntity.class, issueBookDTO.getBookId());
            MemberEntity memberEntity = session.find(MemberEntity.class, issueBookDTO.getMemberId());
            issueBookEntity.setBook(bookEntity);
            issueBookEntity.setMember(memberEntity);
            issueBookEntity.setIssueDate(issueBookDTO.getIssueDate());
            issueBookEntity.setDueDate(issueBookDTO.getDueDate());
            session.persist(issueBookEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException(e);
        }

    }


    public void updateOverdueBooks() {
        String sql="UPDATE issueBooks SET status='OVERDUE' WHERE due_date< CURDATE() AND status='ISSUED'; ";
        try {
            java.sql.PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



