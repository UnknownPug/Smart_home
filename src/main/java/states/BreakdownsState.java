package states;

import objects.Device;

public interface BreakdownsState {
    void fixDevice(Device device);

    void breakDevice(Device device);
}
