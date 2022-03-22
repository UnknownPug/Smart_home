package API;

import objects.Bicycle;

public class BicycleAPI {
    Bicycle bicycle;

    public BicycleAPI(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    /**
     * person doing sport by riding a bicycle.
     */
    public void rideBicycle() {
        bicycle.rideBicycle();
    }
}
