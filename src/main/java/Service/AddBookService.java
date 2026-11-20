package Service;

import Entity.BookEntity;
import Model.BookDTO;
import Repository.BookRepository;

public interface AddBookService {
    public boolean addBookDetails(BookDTO bookDTO);
    public  boolean updateBookdetails(BookDTO bookDTO);
    public BookEntity searchBookDetails(Integer bookId);


}
