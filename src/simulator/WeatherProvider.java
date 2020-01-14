package simulator;
import aircraft.Coordinates;
import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private Random random = new Random();

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sum = coordinates.getLatitdue() + coordinates.getLongtitude() + coordinates.getHeight() + Math.abs(random.nextInt());
        return weather[sum % 4];
    }
}