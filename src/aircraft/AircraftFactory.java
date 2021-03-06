package aircraft;
import exception.InvalidAircraftException;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longtitude, int latitude, int height) {
        switch (type) {
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longtitude, latitude, height));
            case "JetPlane":
                return new JetPlane(name, new Coordinates(longtitude, latitude, height));
            case "Baloon":
                return new Baloon(name, new Coordinates(longtitude, latitude, height));
            default:
                throw new InvalidAircraftException("invalid aircraft type");
        }
    }

}