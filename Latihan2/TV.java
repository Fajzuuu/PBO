public class TV {

    int channel;
    int volumeLevel;
    boolean on;

    public TV() {
        channel = 1;
        volumeLevel = 1;
        on = false;
    }

    public void TurnOn() {
        on = true;
    }

    public void TurnOff() {
        on = false;
    }

    public void SetChannel(int newChannel) {
        if (on && newChannel >= 1 && newChannel <= 120) {
            channel = newChannel;
        }
    }

    public void SetVolume(int newVolumeLevel) {
        if (on && newVolumeLevel >= 1 && newVolumeLevel <= 7) {
            volumeLevel = newVolumeLevel;
        }
    }

    public void ChannelUp() {
        if (on && channel < 120) {
            channel++;
        }
    }

    public void ChannelDown() {
        if (on && channel > 1) {
            channel--;
        }
    }

    public void VolumeUp() {
        if (on && volumeLevel < 7) {
            volumeLevel++;
        }
    }

    public void VolumeDown() {
        if (on && volumeLevel > 1) {
            volumeLevel--;
        }
    }
}