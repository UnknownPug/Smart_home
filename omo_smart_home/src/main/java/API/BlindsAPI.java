package API;

import objects.Blinds;
import objects.Documentation;
import objects.Room;
import objects.Window;

import java.util.List;


public class BlindsAPI implements FuncWearOutAPI {
    private List<Blinds> blinds;

    public BlindsAPI(List<Blinds> blinds) {
        this.blinds = blinds;
    }

    /**
     * rises up all blinds in room.
     *
     * @param room
     */
    public void turnOn(Room room) {
        for (Window window : room.getWindows()) {
            window.getBlinds().turnOn();
        }
    }

    /**
     * rises down all blinds in room.
     *
     * @param room
     */
    public void turnOff(Room room) {
        for (Window window : room.getWindows()) {
            window.getBlinds().turnOff();
        }
    }

    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing Blinds");
        for (Blinds b : blinds) {
            b.fixDevice();
        }
    }

}
