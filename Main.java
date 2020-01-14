import java.io.File;

class Main {
    public static void main(String[] args) { try {
            if (args.length != 1) {
                throw new RuntimeException("no scenariofile given");
            }
            File file = new File(args[0]);
            Simulator simulator = new Simulator(file);
            simulator.runSimulation();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}