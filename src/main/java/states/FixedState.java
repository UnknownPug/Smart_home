package states;

import objects.Device;

public class FixedState implements BreakdownsState {

    public FixedState() {
    }

    @Override
    public void fixDevice(Device device) {
        System.out.println("Device is already fixed!");
    }

    @Override
    public void breakDevice(Device device) {
        device.setBreakdownsState(new BrokenState());
    }
}
