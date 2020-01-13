package exception;

public class EmptyScenarioFileException extends AvajLauncherException {

    public EmptyScenarioFileException(String message) {
        super(message);
    }

    public EmptyScenarioFileException(String message, Throwable cause) {
        super(message, cause);
    }

}