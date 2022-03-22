package objects.SensorsAndSystems;

import objects.Device;
import objects.Event;
import objects.Observer;
import objects.Sensor;
import reportSystem.EventReportStruct;

import java.util.ArrayList;
import java.util.List;

public class FireSensor extends Device implements Sensor {
    private List<Observer> observers = new ArrayList<>();

    public FireSensor(List<Observer> observers) {
        this.observers = observers;
    }

    public FireSensor() {
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
            System.out.println("A fire broke out inside the house");
            observer.update(event, this);
            listeners.add(observer);
        }
        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }

}
