public abstract class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    protected void updateCoordinates(int latitude, int longtitude, int height) {
        int newHeight = coordinates.getHeight() + height;
        
        coordinates = new Coordinates(
            coordinates.getLatitdue() + latitude,
            coordinates.getLongtitude() + longtitude,
            (newHeight > 100) ? 100 : newHeight);
    }

    private long nextId() {
        return ++idCounter;
    }

    protected void log(String message) {
        Logger.getInstance().log(toString() + ": " + message);
    }
}