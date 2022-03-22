package states;

import objects.Device;

public interface ActivityState {
    void turnOn(Device device);

    void turnOff(Device device);
}
