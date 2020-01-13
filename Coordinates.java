import exception.NegativeCoordinateException;
import exception.HeightAboveLimitException;

class Coordinates {

    private int longtitude;
    private int latitude;
    private int height;

    Coordinates(int longtitude, int latitude, int height) {
        if (longtitude < 0) {
            throw new NegativeCoordinateException("negative longtitude " + longtitude);
        }
        if (latitude < 0) {
            throw new NegativeCoordinateException("negative latitude " + latitude);
        }
        if (height < 0) {
            throw new NegativeCoordinateException("negative height " + height);
        }
        if (height > 100) {
            throw new HeightAboveLimitException("height " + height + " above 100");
        }

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