package objects;

public class AirCondition extends Device {
    private int temp;


    public AirCondition() {
    }

    public void increaseTemp(int num) {
        temp = temp + num;
        getElectricityAPI().increaseCounter(getkWPerHour());
    }

    public void decreaseTemp(int num) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        temp = temp - num;
    }
}
