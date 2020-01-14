package simulator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    
    private static Logger instance = new Logger();
    private File logFile = new File("simulation.txt");

    private Logger() {
        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(-1);
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        try {
            FileWriter writer = new FileWriter(logFile, true);
            writer.write(message + '\n');
            writer.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(-1);
        }
    }
}