package cz.jpcz.exceptions;

public class InputDataException extends RuntimeException {

    public InputDataException(String message) {
        super(message);
    }

    public InputDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
