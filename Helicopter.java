class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "RAIN":
                System.out.println("helicopter rain");
                break;
            case "FOG":
                System.out.println("helicopter fog");
                break;
            case "SUN":
                System.out.println("helicopter sun");
                break;
            case "SNOW":
                System.out.println("helicopter snow");
                break;
            default:
                System.out.println("invalid weather");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}