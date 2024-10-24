package exception;

public class BookNotFoundException extends Exception {

    private final Long bookId;  // Almacena solo un ID de libro
    private final String errorCode;

    // Constructor para un solo libro
    public BookNotFoundException(Long bookId, String message) {
        super(message);
        this.bookId = bookId;
        this.errorCode = "BOOK_NOT_FOUND";
    }

    // Constructor para un mensaje solo
    public BookNotFoundException(String message) {
        super(message);
        this.bookId = null; // No hay un ID de libro
        this.errorCode = "UNKNOWN_ERROR";
    }

    public Long getBookId() {
        return bookId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return String.format("Error Code: %s, Book ID: %s, Message: %s",
            errorCode, (bookId != null ? bookId.toString() : "N/A"), getMessage());
    }
}

