class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String toString()
    {
        return "JetPlane#" + name + "(" + id + ")";
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "RAIN":
                logCondition("rain");
                break;
            case "FOG":
                logCondition("fog");
                break;
            case "SUN":
                logCondition("sun");
                break;
            case "SNOW":
                logCondition("snow");
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