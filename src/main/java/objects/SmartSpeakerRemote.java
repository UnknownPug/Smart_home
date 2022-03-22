package objects;

public class SmartSpeakerRemote extends Remote {

    public SmartSpeakerRemote(SmartSpeaker smartSpeaker) {
        this.device = smartSpeaker;
    }

    /**
     * turns on music on smart speaker.
     */
    public void playMusic() {
        ((SmartSpeaker) device).playMusic();
    }
}
