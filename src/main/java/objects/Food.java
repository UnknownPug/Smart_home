package objects;

import states.FoodBakedOrRawState;
import states.FoodCoolSate;
import states.FoodHeatedOrCoolState;
import states.FoodRawState;

public class Food {

    /**
     * represented by string. can be heated, cool, baked and rare.
     */

    private String foodName;

    private FoodBakedOrRawState foodBakedState = new FoodRawState();
    private FoodHeatedOrCoolState foodCooledSate = new FoodCoolSate();

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public FoodBakedOrRawState getFoodBakedState() {
        return foodBakedState;
    }

    public void setFoodBakedState(FoodBakedOrRawState foodBakedState) {
        this.foodBakedState = foodBakedState;
    }

    public FoodHeatedOrCoolState getFoodCooledSate() {
        return foodCooledSate;
    }

    public void setFoodCooledSate(FoodHeatedOrCoolState foodCooledSate) {
        this.foodCooledSate = foodCooledSate;
    }

    public void heatFood() {
        foodCooledSate.heatFood(this);
    }

    public void coolFood() {
        foodCooledSate.coolFood(this);
    }

    public void bakeFood() {
        foodBakedState.bakeFood(this);
    }

    @Override
    public String toString() {
        return foodName;
    }
}
