package exception;

public class ArgsException extends AvajLauncherException {

    public ArgsException(String message) {
        super(message);
    }

    public ArgsException(String message, Throwable cause) {
        super(message, cause);
    }

}