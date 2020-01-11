import java.util.Random;

class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private Random random = new Random();

    private WeatherProvider() {}

    static public WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sum = coordinates.getLatitdue() + coordinates.getLongtitude() + coordinates.getHeight() + Math.abs(random.nextInt());
        return weather[sum % 4];
    }
}