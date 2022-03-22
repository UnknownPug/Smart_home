package objects.SensorsAndSystems;

import objects.Device;
import objects.Room;

public class LightSystem extends Device {

    public LightSystem() {
    }

    public void turnLightOn(Room room) {
        getElectricityAPI().increaseCounter(getkWPerHour());
        room.setLightIsOn(true);
    }

    public void turnLightOff(Room room) {
        room.setLightIsOn(false);
    }
}
