package objects.SensorsAndSystems;

import objects.*;

import java.util.ArrayList;
import java.util.List;

public class BackupGenerator extends Device implements Observer {
    private List<Device> devices = new ArrayList<>();

    public void BackupGenerator() {
        turnOn();
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType() == EventType.POWER_OUTAGE) {
            getActivityState().turnOn(this);
            System.out.println("Turning on all devices");
            for (Device device : devices) {
                device.turnOn();
            }
        }
    }
}
