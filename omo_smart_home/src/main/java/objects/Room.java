package objects;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Sensor> sensors = new ArrayList<>();
    private final List<Window> windows = new ArrayList<>();
    private final List<Device> devices = new ArrayList<>();
    private final int temp = 24;
    private final String roomName;
    private boolean lightIsOn = false;

    public Room(String roomName) {
        this.roomName = roomName;
    }

    public void setLightIsOn(boolean lightIsOn) {
        this.lightIsOn = lightIsOn;
    }

    public Room addDevice(Device device) {
        devices.add(device);
        return this;
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public Room addWindow(Window window) {
        windows.add(window);
        return this;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public String getRoomName() {
        return roomName;
    }
}
