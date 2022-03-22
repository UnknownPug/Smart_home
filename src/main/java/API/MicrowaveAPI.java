package API;

import objects.Documentation;
import objects.Food;
import objects.Microwave;
import states.TurnedOnState;

public class MicrowaveAPI implements FuncWearOutAPI {
    Microwave microwave;

    public MicrowaveAPI(Microwave microwave) {
        this.microwave = microwave;
    }

    public void turnOn() {
        microwave.turnOn();
    }

    public void turnOff() {
        microwave.turnOff();
    }

    /**
     * heats input food, changes its state on heated.
     *
     * @param food
     */
    public void heatFood(Food food) {
        if (microwave.getActivityState() instanceof TurnedOnState) {
            microwave.heatFood(food);
        } else System.out.println("device is not turned on");
    }

    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing microwave");
        microwave.fixDevice();
    }

    public Documentation getDocumentation() {
        return microwave.getDocumentation();
    }
}
