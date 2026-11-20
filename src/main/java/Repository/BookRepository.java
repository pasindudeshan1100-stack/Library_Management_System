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
}
