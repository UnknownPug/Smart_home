package states;

import objects.Food;

public class FoodCoolSate implements FoodHeatedOrCoolState {

    public FoodCoolSate() {
    }

    @Override
    public void heatFood(Food food) {
        food.setFoodCooledSate(new FoodHeatedState());
    }

    @Override
    public void coolFood(Food food) {
        System.out.println("Food " + food.getFoodName() + " is still cooled");
    }
}
