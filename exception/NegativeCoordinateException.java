package exception;

public class NegativeCoordinateException extends AvajLauncherException {

    public NegativeCoordinateException(String message) {
        super(message);
    }

    public NegativeCoordinateException(String message, Throwable cause) {
        super(message, cause);
    }

}