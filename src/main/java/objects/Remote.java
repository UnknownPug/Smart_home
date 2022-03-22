package objects;

public class Remote {
    Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public Remote() {

    }

    public void turnOnRemotely() {
        device.turnOn();
    }

    public void turnOffRemotely() {
        device.turnOff();
    }
}
