package objects.SensorsAndSystems;

import objects.*;

public class FireSystem extends Device implements Observer {

    @Override
    public void update(Event event, Sensor sensor) {
        if (event.getEventType() == EventType.FIRE) {
            System.out.println("The extinguishing system was launched");
        }
    }
}
