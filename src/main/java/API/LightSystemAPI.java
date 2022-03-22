package API;

import objects.Documentation;
import objects.Room;
import objects.SensorsAndSystems.LightSystem;

public class LightSystemAPI implements FuncWearOutAPI {
    LightSystem lightSystem;

    public LightSystemAPI(LightSystem lightSystem) {
        this.lightSystem = lightSystem;
    }

    public void turnOn(Room room) {
        lightSystem.turnLightOn(room);
    }

    public void turnOff(Room room) {
        lightSystem.turnLightOff(room);
    }

    @Override
    public void fixDevice(Documentation documentation) {
        lightSystem.fixDevice();
    }
}
