package exceptions;

public class ForbbidenRequestException extends RuntimeException {
    public ForbbidenRequestException(String message) {
        super(message);
    }
}
