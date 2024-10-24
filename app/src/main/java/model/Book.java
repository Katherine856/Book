package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {
	private Long id;
	private String isbn;
	private String title;
	private String author;
	private String category;
	private boolean available;
	private LocalDate publicationDate;
	private BigDecimal price;

	// Constructor
	public Book(Long id, String isbn, String title, String author, String category, boolean available,
			LocalDate publicationDate, BigDecimal price) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.category = category;
		this.available = available;
		this.publicationDate = publicationDate;
		this.price = price;
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book:" + " ISBN = '" + isbn + '\'' + ", Titulo = '" + title + '\'' + ", Autor = '" + author + '\''
				+ ", Categoria = '" + category + '\'' + ", Disponible = " + available + ", Fecha de publicación = "
				+ publicationDate + ", Precio = " + price;
	}
}
