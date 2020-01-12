import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Simulator {
    
    private static HashSet<String> aircraftTypes = new HashSet<String>(Arrays.asList("JetPlane", "Helicopter", "Baloon"));

    private int simulationNumber;
    private WeatherTower weatherTower = new WeatherTower();

    Simulator(String fileName) {
        parseFile(fileName);
    }

    private void parseFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            parseSimulationNumber(scanner);
            parseAircraft(scanner);
        }
        catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private void parseSimulationNumber(Scanner scanner) {
        if (scanner.hasNextLine()) {
            String numberString = scanner.nextLine();
            simulationNumber = Integer.parseInt(numberString);
        } else {
            throw new RuntimeException("file is empty");
        }
    }
    
    private void parseAircraft(Scanner scanner) {
        int lineNb = 2;
        while (scanner.hasNextLine()) {

            // get line and split
            String line = scanner.nextLine();
            String[] fields = line.split(" ");

            // check number of field
            if (fields.length != 5) {
                throw new RuntimeException("line " + lineNb + " doesn't have 4 fields");
            }

            // check aircraft type
            if (!aircraftTypes.contains(fields[0])) {
                throw new RuntimeException("line " + lineNb + " has invalid aircraft type");
            }

            try {
                // check latitude
                int latitude = Integer.parseInt(fields[2]);
                if (latitude < 0) {
                    throw new RuntimeException("line " + lineNb + " negative coordination");
                }

                // check longtitude
                int longtitude = Integer.parseInt(fields[3]);
                if (longtitude < 0) {
                    throw new RuntimeException("line " + lineNb + " negative coordination");
                }

                // check height
                int height = Integer.parseInt(fields[4]);
                if (height < 0) {
                    throw new RuntimeException("line " + lineNb + " negative coordination");
                } else if (height > 100) {
                    throw new RuntimeException("line " + lineNb + " height more than 100");
                }

                // create aircraft and register
                Flyable aircraft = AircraftFactory.newAircraft(fields[0], fields[1], latitude, longtitude, height);
                aircraft.registerTower(weatherTower);

            } catch(NumberFormatException e) {
                throw new RuntimeException("line " + lineNb + " " + e.getMessage());
            }

            lineNb++;
        }
    }

    public void runSimulation() {
        for (int i = 0; i < simulationNumber; i++) {
            weatherTower.changeWeather();
        }
    }
}