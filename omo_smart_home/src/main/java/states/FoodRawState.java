package states;

import objects.Food;

public class FoodRawState implements FoodBakedOrRawState {
    public FoodRawState() {
    }

    @Override
    public void bakeFood(Food food) {
        food.setFoodBakedState(new FoodBakedState());
    }
}
