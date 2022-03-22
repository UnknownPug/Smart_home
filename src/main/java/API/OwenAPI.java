package API;

import objects.Documentation;
import objects.Food;
import objects.Owen;
import states.TurnedOnState;

import java.util.List;

public class OwenAPI implements FuncWearOutAPI {
    Owen owen;

    public OwenAPI(Owen owen) {
        this.owen = owen;
    }

    public void turnOn() {
        owen.turnOn();
    }

    public void turnOff() {
        owen.turnOff();
    }

    /**
     * changes state of food on baked.
     *
     * @param time
     * @param food
     */
    public void bake(int time, List<Food> food) {
        if (owen.getActivityState() instanceof TurnedOnState) {
            owen.bake(time, food);
        } else System.out.println("device is not turned on");

    }

    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing own");
        owen.fixDevice();
    }

    public Documentation getDocumentation() {
        return owen.getDocumentation();

    }
}
