package objects;

import states.TurnedOnState;

public class AirCondRemote extends Remote {

    public AirCondRemote(AirCondition airCondition) {
        this.device = airCondition;
    }

    public void increaseTemp(int temp, Room room) {
        for (Device d : room.getDevices()) {
            if (d instanceof AirCondition) {
                if (d.getActivityState() instanceof TurnedOnState) {
                    ((AirCondition) d).increaseTemp(temp);
                } else System.out.println("device is not turned on");
            }

        }
    }

    public void decreaseTemp(int temp, Room room) {
        for (Device d : room.getDevices()) {
            if (d instanceof AirCondition) {
                if (d.getActivityState() instanceof TurnedOnState) {
                    ((AirCondition) d).decreaseTemp(temp);
                } else System.out.println("device is not turned on");

            }
        }
    }

}
