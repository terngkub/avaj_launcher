package exception;

public class InvalidAircraftException extends AvajLauncherException {

    public InvalidAircraftException(String message) {
        super(message);
    }

    public InvalidAircraftException(String message, Throwable cause) {
        super(message, cause);
    }

}