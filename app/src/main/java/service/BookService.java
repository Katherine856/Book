package service;

import exception.BookNotFoundException;
import exception.InvalidBookException;
import model.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    Book createBook(Book book) throws InvalidBookException;
    Book getBookById(Long id) throws BookNotFoundException, InvalidBookException;
    List<Book> findBooksByTitle(String titlePart) throws BookNotFoundException;
    List<Book> findBooksByPriceRange(BigDecimal min, BigDecimal max) throws BookNotFoundException;
    List<Book> findBooksByAuthor(String author) throws BookNotFoundException;
    List<Book> getAllBooksSortedByPublicationDate();
    void deleteBook(Long id) throws BookNotFoundException, InvalidBookException;
	Book updateBook(Long id, Book updatedBook) throws BookNotFoundException, InvalidBookException;
}
