package objects.SensorsAndSystems;

import objects.Device;
import objects.Event;
import objects.Observer;
import objects.Sensor;
import reportSystem.EventReportStruct;

import java.util.ArrayList;
import java.util.List;

public class StrongWindSensor extends Device implements Sensor {
    List<Observer> observers = new ArrayList<>();

    public StrongWindSensor(List<Observer> observers) {
        this.observers = observers;
    }

    public StrongWindSensor() {
        turnOn();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(Event event) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        Sensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();
        for (Observer observer : observers) {
            System.out.println("Strong wind is approaching to our house");
            observer.update(event, this);
            listeners.add(observer);
        }
        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }
}
