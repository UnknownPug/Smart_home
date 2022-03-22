package objects;

import reportSystem.EventReportStruct;
import states.BrokenState;

import java.util.ArrayList;
import java.util.List;

public class Fridge extends Device implements Sensor {
    private final List<Observer> observers = new ArrayList<>();
    private final List<Food> foodInFridge = new ArrayList<>();
    private final int foodLimitAmount = 10;

    /**
     * tries to add food into fridge. Check if fridge works and not full, otherwise returns false.
     *
     * @param food
     * @return
     */
    public boolean addFood(Food food) {
        if (getBreakdownsState() instanceof BrokenState) {
            System.out.println("Device is broken. Cant use it now. Gonna call smone to fix it");
            notifyAllObservers(new Event(EventType.BROKEN_DEVICE)); // call somebody to fix
            return false;
        }
        setUsageTime(getUsageTime() + 100);
        if (getUsageTime() > getMAX_USAGE_CONSTANT()) {
            this.breakDevice();
            System.out.println("we gonna break this device");
            return false;
        }
        if (foodInFridge.size() + 1 <= foodLimitAmount) {
            foodInFridge.add(food);
            return true;
        } else {
            System.out.println("Fridge is fulled");
            return false;
        }
    }

    public List<Food> getFoodInFridge() {
        return foodInFridge;
    }

    /**
     * if fridge is empty notifies person to go to the shop for purchases.
     *
     * @return fst found food
     */
    public Food getFood() {
        if (foodInFridge.size() == 0) {
            notifyAllObservers(new Event(EventType.EMPTY_FRIDGE));
            return null;
        }
        Food retFood = foodInFridge.get(0);
        foodInFridge.remove(retFood);
        return retFood;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(Event event) {
        Sensor sourceSensor = this;
        List<Observer> listeners = new ArrayList<>();

        System.out.println("Fridge is empty OR broken");
        if (observers.size() > 0) {
            observers.get(0).update(event, this);
            listeners.add(observers.get(0));
            getEventAPI().addNewEventReportStruct(new EventReportStruct(event, sourceSensor, listeners));
        } else System.out.println("No attached observers in fridge");

    }

}
