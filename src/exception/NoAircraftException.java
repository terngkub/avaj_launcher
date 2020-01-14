package exception;

public class NoAircraftException extends AvajLauncherException {

    public NoAircraftException(String message) {
        super(message);
    }

    public NoAircraftException(String message, Throwable cause) {
        super(message, cause);
    }

}