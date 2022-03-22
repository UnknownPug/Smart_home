package API;

import objects.Documentation;
import objects.WashingMachine;
import states.TurnedOnState;

public class WashingMachineAPI implements FuncWearOutAPI {
    WashingMachine washingMachine;

    public WashingMachineAPI(WashingMachine washingMachine) {
        this.washingMachine = washingMachine;
    }

    public void turnOn() {
        washingMachine.turnOn();
    }

    public void turnOff() {
        washingMachine.turnOff();
    }

    public void washClothes() {
        if (washingMachine.getActivityState() instanceof TurnedOnState) {
            washingMachine.washClothes();
        } else System.out.println("device is not turned on");
    }

    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing Washing Machine");
        washingMachine.fixDevice();

    }

    public Documentation getDocumentation() {
        return washingMachine.getDocumentation();
    }
}
