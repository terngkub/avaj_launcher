class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        log(weather);

        switch (weather) {
            case "SUN":
                updateCoordinates(2, 0, 4);
                break;
            case "RAIN":
                updateCoordinates(0, 0, -5);
                break;
            case "FOG":
                updateCoordinates(0, 0, -3);
                break;
            case "SNOW":
                updateCoordinates(0, 0, -15);
                break;
            default:
                // todo handle exception
                System.out.println("invalid weather");
        }

        if (coordinates.getHeight() < 0) {
            log("landing");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    public String toString()
    {
        return "Baloon#" + name + "(" + id + ")";
    }
}