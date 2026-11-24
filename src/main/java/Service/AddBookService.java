package Service;

import Entity.BookEntity;
import Model.BookDTO;
import Repository.BookRepository;

public interface AddBookService {
    boolean addBookDetails(BookDTO bookDTO);
    boolean updateBookdetails(BookDTO bookDTO);
    BookEntity searchBookDetails(Integer bookId);
    boolean deleteBook(Integer bookId);


}
