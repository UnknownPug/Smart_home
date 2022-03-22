package API;

import objects.Car;

public class CarAPI {
    Car car;

    public CarAPI(Car car) {
        this.car = car;
    }

    /**
     * person drives goes somewhere by car.
     */
    public void driveCar() {
        car.driveCar();
    }
}
