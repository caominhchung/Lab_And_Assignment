package fa.training.dao;

import fa.training.entities.Book;
import java.util.Set;
public interface BookDao {
    Book insertBook(Book book) throws IllegalArgumentException;
    Book getBookByISBN(String isbn);
    Set<Book> getAllBook();
    boolean updateBook(Book book) throws IllegalArgumentException;
    boolean deleteBookById(String isbn);
    Set<Book> getBookNotAvailable();
    Set<Book> getBookTopNumberInWarehouse(int top);
}
