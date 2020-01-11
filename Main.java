class Main {
    public static void main(String[] args) {
        Flyable a = AircraftFactory.newAircraft("Helicopter", "A", 10, 20, 30);
        Flyable b = AircraftFactory.newAircraft("JetPlane", "B", 40, 50, 60);
        Flyable c = AircraftFactory.newAircraft("Baloon", "C", 70, 80, 90);

        WeatherTower weatherTower = new WeatherTower();
        a.registerTower(weatherTower);
        b.registerTower(weatherTower);
        c.registerTower(weatherTower);

        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
    }
}