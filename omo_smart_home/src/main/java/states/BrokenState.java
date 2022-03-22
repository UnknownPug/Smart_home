package states;

import objects.Device;

public class BrokenState implements BreakdownsState {

    public BrokenState() {
    }

    @Override
    public void fixDevice(Device device) {
        device.setBreakdownsState(new FixedState());
    }

    @Override
    public void breakDevice(Device device) {
        System.out.println("Device is still broken");
    }
}
