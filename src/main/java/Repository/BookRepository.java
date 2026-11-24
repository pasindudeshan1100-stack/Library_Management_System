package Repository;

import Entity.BookEntity;
import Hibernate.HibernateUtil;
import Model.BookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookRepository {

    Session session= HibernateUtil.getInstance().getSession();

    public boolean addBook(BookDTO bookDTO){

        Transaction transaction=session.beginTransaction();
        try {

            BookEntity bookEntity=new BookEntity();
            bookEntity.setAuthor(bookDTO.getAuthor());
            bookEntity.setTitle(bookDTO.getTitle());
            bookEntity.setCategory(bookDTO.getCategory());
            bookEntity.setYear(bookDTO.getYear());
            bookEntity.setQuantity(bookDTO.getQuantity());
            session.persist(bookEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
            return false;
        }

    }

    public boolean updateBook(BookDTO bookDTO){

        Transaction transaction=session.beginTransaction();

        try {

            BookEntity existingBook = session.find(BookEntity.class, bookDTO.getBookid());

            if (existingBook != null) {
                existingBook.setTitle(bookDTO.getTitle());
                existingBook.setAuthor(bookDTO.getAuthor());
                existingBook.setCategory(bookDTO.getCategory());
                existingBook.setQuantity(bookDTO.getQuantity());
                existingBook.setYear(bookDTO.getYear());

                transaction.commit();
                return true;

            }

           transaction.rollback();
            return false;


        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            throw new RuntimeException(e);
        }
    }

    public BookEntity searchBook(Integer bookId){
        try {
            return session.find(BookEntity.class, bookId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }
    public boolean DeleteBook(Integer bookId) {
        Transaction transaction = session.beginTransaction();
        try {
            BookEntity book = session.find(BookEntity.class, bookId);

            if (book!=null){
                session.remove(book);
                transaction.commit();
                return  true;
            }
            return  false;

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

}
