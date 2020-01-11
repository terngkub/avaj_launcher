class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "RAIN":
                System.out.println("jetplane rain");
                break;
            case "FOG":
                System.out.println("jetplane fog");
                break;
            case "SUN":
                System.out.println("jetplane sun");
                break;
            case "SNOW":
                System.out.println("jetplane snow");
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