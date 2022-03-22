package API;

import objects.Documentation;
import objects.Tv;
import states.TurnedOnState;

public class TvAPI implements FuncWearOutAPI {
    Tv tv;

    public TvAPI(Tv tv) {
        this.tv = tv;
    }

    public void turnOn() {
        tv.turnOn();
    }

    public void turnOff() {
        tv.turnOff();
    }

    /**
     * changes channel on the next in the list of channels.
     */
    public void changeChannelForward() {
        tv.changeChannelForward();
    }

    /**
     * changes channel on the previous in the list of channels.
     */
    public void changeChannelBackward() {
        tv.changeChannelBackward();
    }

    @Override
    public void fixDevice(Documentation documentation) {
        System.out.println("Fixing TV");
        tv.fixDevice();
    }

    public Documentation getDocumentation() {
        return tv.getDocumentation();
    }

    public void watchTV() {
        if (tv.getActivityState() instanceof TurnedOnState) {
            tv.watchTV();
        } else System.out.println("device is not turned on");

    }
}
