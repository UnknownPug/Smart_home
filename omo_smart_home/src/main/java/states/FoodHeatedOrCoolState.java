package states;

import objects.Food;

public interface FoodHeatedOrCoolState {
    void heatFood(Food food);

    void coolFood(Food food);
}
