package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Book;

public class BookDAOImpl implements BookDAO {
	private final List<Book> books = new ArrayList<>();
    private static long currentId = 1;

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            // Si el libro no tiene ID, asigna uno nuevo
            book.setId(currentId++);
            books.add(book);
        } else {
            // Si el libro tiene un ID, busca el libro existente y actualízalo
        	books.replaceAll(b -> b.getId().equals(book.getId()) ? book : b);
        }
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public void delete(Long id) {
        books.removeIf(b -> b.getId().equals(id));
    }
}
