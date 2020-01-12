class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        log(weather);

        switch (weather) {
            case "SUN":
                updateCoordinates(10, 0, 2);
                break;
            case "RAIN":
                updateCoordinates(5, 0, 0);
                break;
            case "FOG":
                updateCoordinates(1, 0, 0);
                break;
            case "SNOW":
                updateCoordinates(0, 0, -7);
                break;
            default:
                throw new RuntimeException("invalid weather");
        }

        if (coordinates.getHeight() <= 0) {
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
        return "JetPlane#" + name + "(" + id + ")";
    }
}