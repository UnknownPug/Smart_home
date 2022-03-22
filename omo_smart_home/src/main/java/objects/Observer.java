package objects;

public interface Observer {
    void update(Event event, Sensor sensor); // sensor - source
}
