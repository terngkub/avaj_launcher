package simulator;
import exception.*;
import aircraft.Flyable;
import aircraft.AircraftFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Simulator {
    
    private static HashSet<String> aircraftTypes = new HashSet<String>(Arrays.asList("JetPlane", "Helicopter", "Baloon"));

    private int simulationNumber;
    private WeatherTower weatherTower = new WeatherTower();

    public Simulator(File file) {
        parseFile(file);
    }

    private void parseFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            parseSimulationNumber(scanner);
            parseAircraft(scanner);
        }
        catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(-1);
        }
    }

    private void parseSimulationNumber(Scanner scanner) {
        try {
            if (scanner.hasNextLine()) {
                String numberString = scanner.nextLine();
                simulationNumber = Integer.parseInt(numberString);
            } else {
                throw new EmptyScenarioFileException("file is empty");
            }
        } catch (NumberFormatException e) {
            throw new exception.ParsingException("line 1 cannot parse the number: " + e.getMessage(), e);
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
                throw new exception.ParsingException("line " + lineNb + " doesn't have 5 fields");
            }

            // check aircraft type
            if (!aircraftTypes.contains(fields[0])) {
                throw new InvalidAircraftException("line " + lineNb + " has invalid aircraft type");
            }

            try {
                // check latitude
                int latitude = Integer.parseInt(fields[2]);
                if (latitude < 0) {
                    throw new NegativeCoordinateException("line " + lineNb + " negative latitude");
                }

                // check longtitude
                int longtitude = Integer.parseInt(fields[3]);
                if (longtitude < 0) {
                    throw new NegativeCoordinateException("line " + lineNb + " negative longtitude");
                }

                // check height
                int height = Integer.parseInt(fields[4]);
                if (height < 0) {
                    throw new NegativeCoordinateException("line " + lineNb + " negative height");
                } else if (height > 100) {
                    throw new HeightAboveLimitException("line " + lineNb + " height more than 100");
                }

                // create aircraft and register
                Flyable aircraft = AircraftFactory.newAircraft(fields[0], fields[1], latitude, longtitude, height);
                aircraft.registerTower(weatherTower);

            } catch(NumberFormatException e) {
                throw new exception.ParsingException("line " + lineNb + " cannot parse the number: " + e.getMessage(), e);
            }

            lineNb++;
        }

        if (lineNb == 2) {
            throw new NoAircraftException("no aircraft in the scenario file");
        }
    }

    public void runSimulation() {
        for (int i = 0; i < simulationNumber; i++) {
            weatherTower.changeWeather();
        }
    }
}