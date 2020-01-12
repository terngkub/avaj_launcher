class Main {
    public static void main(String[] args) { try {
            if (args.length != 1) {
                throw new RuntimeException("no scenariofile given");
            }
            Simulator simulator = new Simulator(args[0]);
            simulator.runSimulation();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}