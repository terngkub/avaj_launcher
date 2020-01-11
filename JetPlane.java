class JetPlane extends Aircraft implements Flyable {
    // private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        // todo
        System.out.println("jetplane " + name + " " + coordinates.getLongtitude() + " " + coordinates.getLatitdue() + " " + coordinates.getHeight());
    }

    // public void registerTower(WeatherTower weatherTower) {
    //     this.weatherTower = weatherTower;
    // }
}