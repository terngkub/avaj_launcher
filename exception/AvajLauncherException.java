package exception;

public class AvajLauncherException extends RuntimeException {

    public AvajLauncherException(String message) {
        super(message);
    }

    public AvajLauncherException(String message, Throwable cause) {
        super(message, cause);
    }

}