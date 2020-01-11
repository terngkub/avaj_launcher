class Coordinates {

    private int longtitude;
    private int latitude;
    private int height;

    Coordinates(int longtitude, int latitude, int height) {
        // todo handle exception
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongtitude() {
        return longtitude;
    }

    public int getLatitdue() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}