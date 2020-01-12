import java.util.ArrayList;

public abstract class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        log(flyable, "registered to");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        log(flyable, "unregistered from");
    }

    private void log(Flyable flyable, String message) {
        Logger.getInstance().log("Tower says: " + flyable.toString() + " " + message + " weather tower");
    }

    protected void conditionChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}