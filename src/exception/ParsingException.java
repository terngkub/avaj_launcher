package exception;

public class ParsingException extends AvajLauncherException {

    public ParsingException(String message) {
        super(message);
    }

    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }

}