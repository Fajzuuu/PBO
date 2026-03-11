public class TV {

    int channel;
    int volumeLevel;
    boolean on;

    // Constructor
    public TV() {
        channel = 1;
        volumeLevel = 1;
        on = false;
    }

    // Menyalakan TV
    public void TurnOn() {
        on = true;
    }

    // Mematikan TV
    public void TurnOff() {
        on = false;
    }

    // Mengatur channel
    public void SetChannel(int newChannel) {
        if (on && newChannel >= 1 && newChannel <= 120) {
            channel = newChannel;
        }
    }

    // Mengatur volume
    public void SetVolume(int newVolumeLevel) {
        if (on && newVolumeLevel >= 1 && newVolumeLevel <= 7) {
            volumeLevel = newVolumeLevel;
        }
    }

    // Channel naik
    public void ChannelUp() {
        if (on && channel < 120) {
            channel++;
        }
    }

    // Channel turun
    public void ChannelDown() {
        if (on && channel > 1) {
            channel--;
        }
    }

    // Volume naik
    public void VolumeUp() {
        if (on && volumeLevel < 7) {
            volumeLevel++;
        }
    }

    // Volume turun
    public void VolumeDown() {
        if (on && volumeLevel > 1) {
            volumeLevel--;
        }
    }
}