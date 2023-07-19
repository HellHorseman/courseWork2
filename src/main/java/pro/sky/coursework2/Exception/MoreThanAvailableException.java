package pro.sky.coursework2.Exception;

public class MoreThanAvailableException extends RuntimeException {
    public MoreThanAvailableException() {
    }

    public MoreThanAvailableException(String message) {
        super(message);
    }

    public MoreThanAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoreThanAvailableException(Throwable cause) {
        super(cause);
    }

    public MoreThanAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
