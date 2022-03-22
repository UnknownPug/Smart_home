package states;

import objects.Food;

public class FoodHeatedState implements FoodHeatedOrCoolState {

    public FoodHeatedState() {
    }

    @Override
    public void heatFood(Food food) {
        System.out.println("Food " + food.getFoodName() + " is already heated!");
    }

    @Override
    public void coolFood(Food food) {
        food.setFoodCooledSate(new FoodCoolSate());
    }
}
