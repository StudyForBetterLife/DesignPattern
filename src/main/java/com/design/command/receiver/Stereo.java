package command.receiver;

public class Stereo {
    private String location = "";

    public Stereo() {
    }

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " stereo on");
    }

    public void setCD() {
        System.out.println(location + " set cd");
    }

    public void setVolume(int i) {
        System.out.println(location + " set volume: " + i);
    }

    public void off() {
        System.out.println(location + " stereo off");
    }
}
