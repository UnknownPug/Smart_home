package objects;

public class Microwave extends Device {

    public void heatFood(Food food) {
        food.heatFood();
        getElectricityAPI().increaseCounter(getkWPerHour());
    }
}
