package exception;

public class InvalidWeatherException extends AvajLauncherException {

    public InvalidWeatherException(String message) {
        super(message);
    }

    public InvalidWeatherException(String message, Throwable cause) {
        super(message, cause);
    }

}