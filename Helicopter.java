class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        log(weather);

        switch (weather) {
            case "SUN":
                updateCoordinates(0, 10, 2);
                break;
            case "RAIN":
                updateCoordinates(0, 5, 0);
                break;
            case "FOG":
                updateCoordinates(0, 1, 0);
                break;
            case "SNOW":
                updateCoordinates(0, 0, -12);
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
        return "Helicopter#" + name + "(" + id + ")";
    }
}