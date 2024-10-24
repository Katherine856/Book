package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.BookDAO;
import exception.BookNotFoundException;
import exception.InvalidBookException;
import model.Book;

public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Book createBook(Book book) throws InvalidBookException {
        validateBook(book); // Validar el libro
        return bookDAO.save(book);
    }

    @Override
    public Book getBookById(Long id) throws BookNotFoundException, InvalidBookException {
        if (id == null) {
            throw new InvalidBookException("El ID no puede ser nulo");
        }
        
        // Buscar por ID
        return bookDAO.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id, "No se encontró un libro con el ID especificado."));
    }

    @Override
    public List<Book> findBooksByTitle(String titlePart) throws BookNotFoundException {
        if (titlePart == null) {
            throw new IllegalArgumentException("La parte del título no puede ser nula");
        }

        // Filtrar por nombre
        List<Book> foundBooks = bookDAO.findAll().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(titlePart.toLowerCase()))
                .collect(Collectors.toList());

        // Lanzar excepción si no se encuentran libros
        if (foundBooks.isEmpty()) {
            throw new BookNotFoundException("No se encontraron libros con el título especificado.");
        }

        return foundBooks;
    }

    @Override
    public List<Book> findBooksByPriceRange(BigDecimal min, BigDecimal max) throws BookNotFoundException {
        if (min == null || max == null) {
            throw new IllegalArgumentException("El rango de precios no puede ser nulo");
        }
        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("El precio mínimo no puede ser mayor que el precio máximo");
        }

        // Filtrar por precio
        List<Book> books = bookDAO.findAll().stream()
                .filter(b -> b.getPrice().compareTo(min) >= 0 && b.getPrice().compareTo(max) <= 0)
                .collect(Collectors.toList());

        // Lanzar excepción si no se encuentran libros
        if (books.isEmpty()) {
            throw new BookNotFoundException("No se encontraron libros en el rango de precios especificado.");
        }

        return books;
    }
   
    @Override
    public List<Book> findBooksByAuthor(String author) throws BookNotFoundException {
        if (author == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo");
        }

        // Filtrar por autor
        List<Book> books = bookDAO.findAll().stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        // Lanzar excepción si no se encuentran libros
        if (books.isEmpty()) {
        	throw new BookNotFoundException("No se encontraron libros del autor especificado.");
        }

        return books;
    }

    @Override
    public List<Book> getAllBooksSortedByPublicationDate() {
        List<Book> books = bookDAO.findAll();
        if (books == null) {
            throw new IllegalStateException("La lista de libros no puede ser nula");
        }
        
        // Ordenar por fecha de publicación
        return books.stream()
        		.sorted(this::compareByPublicationDate)
                .collect(Collectors.toList());
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) throws BookNotFoundException, InvalidBookException {
        validateBook(updatedBook); // Validar el libro actualizado
        Book existingBook = bookDAO.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id, "No se encontró un libro con el ID especificado."));
        
        // Actualizar los campos del libro existente
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setPublicationDate(updatedBook.getPublicationDate());

        return bookDAO.save(existingBook); // Guardar el libro actualizado
    }

    @Override
    public void deleteBook(Long id) throws BookNotFoundException, InvalidBookException {
        if (id == null) {
            throw new InvalidBookException("El ID no puede ser nulo");
        }
        
        Book book = bookDAO.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id, "No se encontró un libro con el ID especificado."));
        
        // Eliminar un libro
        bookDAO.delete(book.getId());
    }

    // Método privado para validar libros
    private void validateBook(Book book) throws InvalidBookException {
        if (book == null) {
            throw new InvalidBookException("El libro no puede ser nulo.");
        }

        List<String> invalidFields = new ArrayList<>();

        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            invalidFields.add("título");
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            invalidFields.add("autor");
        }
        if (book.getPublicationDate() == null) {
            invalidFields.add("fecha de publicación");
        }
        if (book.getPrice() == null || book.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            invalidFields.add("precio");
        }

        if (!invalidFields.isEmpty()) {
            throw new InvalidBookException("Los siguientes campos son inválidos: " + String.join(", ", invalidFields));
        }
    }
    
    // Método de comparación para la referencia de método
    private int compareByPublicationDate(Book b1, Book b2) {
        return b1.getPublicationDate().compareTo(b2.getPublicationDate());
    }
}

