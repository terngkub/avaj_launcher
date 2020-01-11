class Baloon extends Aircraft implements Flyable {
    // private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        // todo
        System.out.println("baloon " + name + " " + coordinates.getLongtitude() + " " + coordinates.getLatitdue() + " " + coordinates.getHeight());
    }

    // public void registerTower(WeatherTower weatherTower) {
    //     this.weatherTower = weatherTower;
    // }
}