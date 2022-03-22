package objects.SensorsAndSystems;

import objects.*;

public class WaterLeakSystem extends Device implements Observer {

    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType() == EventType.WATER_LEAK) {
            System.out.println("The water has stopped flowing into the house");
        }
    }
}
