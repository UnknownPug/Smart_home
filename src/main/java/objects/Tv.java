package objects;

import java.util.ArrayList;
import java.util.List;

public class Tv extends Device {
    private final List<String> channels = new ArrayList<>();
    private int indexOfCurrentChannel = 0;
    private Remote tvRemote;

    public Tv(TvRemote tvRemote) {
        this.tvRemote = tvRemote;
    }

    public Tv() {
    }

    public int getIndexOfCurrentChannel() {
        return indexOfCurrentChannel;
    }

    public void setIndexOfCurrentChannel(int indexOfCurrentChannel) {
        this.indexOfCurrentChannel = indexOfCurrentChannel;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void changeChannelForward() {
        if (indexOfCurrentChannel == channels.size() - 1) {
            indexOfCurrentChannel = 0;
        } else indexOfCurrentChannel += 1;
    }

    public void changeChannelBackward() {
        if (indexOfCurrentChannel == 0) {
            indexOfCurrentChannel = channels.size() - 1;
        } else indexOfCurrentChannel -= 1;
    }

    public void watchTV() {
        getElectricityAPI().increaseCounter(getkWPerHour());
    }
}
