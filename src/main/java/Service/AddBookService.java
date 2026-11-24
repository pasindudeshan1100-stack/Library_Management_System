package Service;

import Entity.BookEntity;
import Model.BookDTO;

public interface AddBookService {
    boolean addBookDetails(BookDTO bookDTO);
    boolean updateBookdetails(BookDTO bookDTO);
    BookEntity searchBookDetails(Integer bookId);
    boolean deleteBook(Integer bookId);


}
