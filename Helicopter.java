class Helicopter extends Aircraft implements Flyable {
    // private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        // todo
        System.out.println("helicoptor " + name + " " + coordinates.getLongtitude() + " " + coordinates.getLatitdue() + " " + coordinates.getHeight());
    }

    // public void registerTower(WeatherTower weatherTower) {
    //     this.weatherTower = weatherTower;
    // }
}