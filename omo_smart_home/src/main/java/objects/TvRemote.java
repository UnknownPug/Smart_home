package objects;

import states.TurnedOnState;

public class TvRemote extends Remote {
    public TvRemote(Tv tv) {
        this.device = tv;
    }

    public void watchTV() {
        if (device.getActivityState() instanceof TurnedOnState) {
            ((Tv) device).watchTV();
        } else System.out.println("device is not turned on");
    }

    public void changeChannel() {
        ((Tv) device).changeChannelForward();
    }
}
