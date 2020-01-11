class Main {
    public static void main(String[] args) {
        Flyable h = AircraftFactory.newAircraft("Helicopter", "A", 10, 20, 30);
        Flyable j = AircraftFactory.newAircraft("JetPlane", "B", 40, 50, 60);
        Flyable b = AircraftFactory.newAircraft("Baloon", "C", 70, 80, 90);
        h.updateConditions();
        j.updateConditions();
        b.updateConditions();
    }
}