import java.util.ArrayList;

class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: registered to weather tower");
    }

    public void unregister(Flyable flyable) {
    }

    protected void conditionChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}