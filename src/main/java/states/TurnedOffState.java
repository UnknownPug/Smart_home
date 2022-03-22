package states;

import objects.Device;

public class TurnedOffState implements ActivityState {

    public TurnedOffState() {
    }

    @Override
    public void turnOn(Device device) {
        device.setActivityState(new TurnedOnState());
    }

    @Override
    public void turnOff(Device device) {
        System.out.println("Device is already turned off");
    }
}
