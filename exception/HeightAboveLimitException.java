package exception;

public class HeightAboveLimitException extends AvajLauncherException {

    public HeightAboveLimitException(String message) {
        super(message);
    }

    public HeightAboveLimitException(String message, Throwable cause) {
        super(message, cause);
    }

}