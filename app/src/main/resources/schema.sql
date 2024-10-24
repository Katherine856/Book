-- En este caso no se usa por que todo el ciclo del desarrollo es en memoria

-- script para crear la tabla de libros
CREATE TABLE BOOK (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(13) NOT NULL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    available BOOLEAN DEFAULT TRUE,
    publication_date DATE,
    price DECIMAL(10, 2)
);

-- script para insertar algunos libros de ejemplo
INSERT INTO BOOK (isbn, title, author, category, publication_date, price) VALUES
('978-3-16-148410-0', 'El Gran Gatsby', 'F. Scott Fitzgerald', 'Ficción', '1925-04-10', 10.99),
('978-1-56619-909-4', '1984', 'George Orwell', 'Ficción', '1949-06-08', 15.50),
('978-0-395-19395-8', 'Cien años de soledad', 'Gabriel García Márquez', 'Ficción', '1967-05-30', 12.75);
