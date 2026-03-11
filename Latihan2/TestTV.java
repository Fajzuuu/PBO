public class TestTV {
    public static void main(String[] args) {
        TV tv1 = new TV();
        tv1.TurnOn();
        tv1.SetChannel(30);
        tv1.SetVolume(3);

        TV tv2 = new TV();
        tv2.TurnOn();
        tv2.ChannelUp();
        tv2.ChannelUp();
        tv2.VolumeUp();

        System.out.println("tv1's channel is " + tv1.channel + " and volume level is " + tv1.volumeLevel);
        System.out.println("tv2's channel is " + tv2.channel + " and volume level is " + tv2.volumeLevel);
    }
}
