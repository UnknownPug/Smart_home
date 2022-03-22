package objects.SensorsAndSystems;

import objects.*;
import reportSystem.EventReportStruct;
import states.TurnedOnState;

import java.util.ArrayList;
import java.util.List;

public class PowerOutageSensor extends Device implements Sensor {
    List<Observer> observers = new ArrayList<>(); // devices
    BackupGenerator backupGenerator;

    public PowerOutageSensor(BackupGenerator backupGenerator) {
        this.backupGenerator = backupGenerator;
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
            System.out.println("The devices were unplugged due power outage");
            if (((Device) observer).getActivityState() instanceof TurnedOnState) {
                backupGenerator.addDevice((Device) observer);
                observer.update(event, this);
                listeners.add(observer);
            }
        }
        backupGenerator.update(new Event(EventType.POWER_OUTAGE), this);
        listeners.add(backupGenerator);

        getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
    }
}
