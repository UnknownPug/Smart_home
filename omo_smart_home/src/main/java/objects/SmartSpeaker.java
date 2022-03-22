package objects;

import java.util.ArrayList;
import java.util.List;

public class SmartSpeaker extends Device {

    private final List<String> musicPlaylist = new ArrayList<>();
    private int indexOfCurrentMusicPlaylist = 0;

    public SmartSpeaker() {
    }

    public List<String> getMusicPlaylist() {
        return musicPlaylist;
    }

    public void addMusic(String music) {
        musicPlaylist.add(music);
    }

    public void playMusic() {
        getElectricityAPI().increaseCounter(getkWPerHour());
    }

    public void changeSoundtrackForward() {
        if (indexOfCurrentMusicPlaylist == musicPlaylist.size() - 1) {
            indexOfCurrentMusicPlaylist = 0;
        } else {
            indexOfCurrentMusicPlaylist++;
        }
    }

    public void changeSoundtrackBackward() {
        if (indexOfCurrentMusicPlaylist == 0) {
            indexOfCurrentMusicPlaylist = musicPlaylist.size() - 1;
        } else {
            indexOfCurrentMusicPlaylist--;
        }
    }
}
