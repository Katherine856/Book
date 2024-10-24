package dao;

import java.util.List;
import java.util.Optional;

import model.Book;

public interface BookDAO {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    void delete(Long id);
}
