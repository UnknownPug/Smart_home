package API;

import objects.Documentation;
import objects.Food;
import objects.Fridge;

public class FridgeAPI implements FuncWearOutAPI {
    Fridge fridge;

    public FridgeAPI(Fridge fridge) {
        this.fridge = fridge;
    }

    public void turnOn() {
        fridge.turnOn();
    }

    public void turnOff() {
        fridge.turnOff();
    }

    public Food getFood() {
        return fridge.getFood();
    }

    public boolean addFood(Food food) {
        return fridge.addFood(food);
    }

    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing fridge");
        fridge.fixDevice();
    }

    public Documentation getDocumentation() {
        // it should take some time according to F9 of assignment
        return fridge.getDocumentation();
    }

    public void removeFoodByPerson(Food food) {
        fridge.getFoodInFridge().remove(food);
    }
}
