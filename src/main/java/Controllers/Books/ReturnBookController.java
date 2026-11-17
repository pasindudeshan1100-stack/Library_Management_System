package Controllers.Books;

import Entity.BookEntity;
import Entity.MemberEntity;
import Entity.ReturnBookEntity;
import Hibernate.HibernateUtil;
import Model.ReturnBookDTO;
import db.DBConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReturnBookController {
    Connection connection= DBConnection.getInstance().getConnection();
    Session session= HibernateUtil.getInstance().getSession();

    public boolean addReturnBook(ReturnBookDTO returnBookDTO) {
//        String sql="INSERT INTO returnBooks (member_id,book_id,book_title,return_date)VALUES (?,?,?,?);";
//        try {
//            java.sql.PreparedStatement preparedStatement =connection.prepareStatement(sql);
//            preparedStatement.setString(1,memberId);
//            preparedStatement.setString(2,bookId);
//            preparedStatement.setString(3,booktitle);
//            preparedStatement.setString(4, String.valueOf(returnDate));
//            return preparedStatement.executeUpdate()>0;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        Transaction transaction=session.beginTransaction();
        ReturnBookEntity returnBookEntity=new ReturnBookEntity();
        BookEntity bookEntity = session.find(BookEntity.class, returnBookDTO.getBookId());
        MemberEntity memberEntity = session.find(MemberEntity.class, returnBookDTO.getMemberId());
        returnBookEntity.setBook(bookEntity);
        returnBookEntity.setMember(memberEntity);
        returnBookEntity.setReturnDate(returnBookDTO.getReturnDate());
        session.persist(returnBookEntity);
        transaction.commit();
        return  true;
    }

    public void updateReturnedBooks(String bookId, String memberId) {
        String sql="UPDATE issueBooks SET status='RETURNED'WHERE book_id=? AND member_id=? AND status IN ('ISSUED', 'OVERDUE');";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,memberId);
            preparedStatement.setString(2,bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
