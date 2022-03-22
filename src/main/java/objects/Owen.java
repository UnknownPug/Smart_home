package objects;

import java.util.List;

public class Owen extends Device {
    public Food bake(int time, List<Food> ingredients) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        String bakedFood = "BAKED ";
        for (Food food : ingredients) {
            bakedFood += food.getFoodName() + " ,";
        }
        setUsageTime(getUsageTime() + time);
        ingredients.clear();
        Food newFood = new Food(bakedFood);
        newFood.bakeFood();
        return newFood;
    }
}
