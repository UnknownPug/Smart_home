package states;


import objects.Device;

public class TurnedOnState implements ActivityState {
    public TurnedOnState() {

    }

    @Override
    public void turnOn(Device device) {
        System.out.println("Device is already turned on");
    }

    @Override
    public void turnOff(Device device) {
        device.setActivityState(new TurnedOffState());
    }
}
