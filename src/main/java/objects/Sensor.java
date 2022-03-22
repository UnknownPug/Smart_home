package objects;


public interface Sensor {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyAllObservers(Event event);
}
