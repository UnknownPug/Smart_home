package states;

import objects.Food;

public class FoodBakedState implements FoodBakedOrRawState {

    public FoodBakedState() {
    }

    @Override
    public void bakeFood(Food food) {
        System.out.println("Food" + food.getFoodName() + " is already baked");
    }
}
