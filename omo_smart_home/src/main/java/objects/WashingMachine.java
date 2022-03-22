package objects;

import API.WaterAPI;

public class WashingMachine extends Device {
    private final WaterAPI waterAPI = new WaterAPI();

    public void washClothes() {
        waterAPI.increaseCounter(40);
        getElectricityAPI().increaseCounter(getkWPerHour());

    }

    public WaterAPI getWaterAPI() {
        return waterAPI;
    }
}
