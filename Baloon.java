class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "RAIN":
                System.out.println("baloon rain");
                break;
            case "FOG":
                System.out.println("baloon fog");
                break;
            case "SUN":
                System.out.println("baloon sun");
                break;
            case "SNOW":
                System.out.println("baloon snow");
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