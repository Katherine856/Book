package exception;

public class InvalidBookException extends Exception {
	private final String errorCode;
    private final String invalidField;
    private final Object invalidValue;

    public InvalidBookException(String message) {
        super(message);
        this.errorCode = "INVALID_BOOK"; // Código de error general
        this.invalidField = null; // Campo inválido no especificado
        this.invalidValue = null; // Valor inválido no especificado
    }

    public InvalidBookException(String message, String invalidField, Object invalidValue) {
        super(message);
        this.errorCode = "INVALID_BOOK";
        this.invalidField = invalidField;
        this.invalidValue = invalidValue;
    }

    public InvalidBookException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "INVALID_BOOK";
        this.invalidField = null;
        this.invalidValue = null;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getInvalidField() {
        return invalidField;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Error Code: %s, Message: %s", errorCode, getMessage()));
        if (invalidField != null) {
            sb.append(String.format(", Invalid Field: %s, Invalid Value: %s", invalidField, invalidValue));
        }
        return sb.toString();
    }
	
}
