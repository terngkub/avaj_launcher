package avajlauncher;
import exception.ArgsException;
import java.io.File;
import simulator.Simulator;

class AvajLauncher {
    public static void main(String[] args) { try {
            if (args.length != 1) {
                throw new ArgsException("Usage: java -cp src avajlauncher/AvajLauncher [scenario_file]");
            }
            File file = new File(args[0]);
            Simulator simulator = new Simulator(file);
            simulator.runSimulation();
        } catch (ArgsException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}