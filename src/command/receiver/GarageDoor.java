package command.receiver;

public class GarageDoor {
    private String location = "";

    public GarageDoor() {
    }

    public GarageDoor(String location) {
        this.location = location;
    }

    public void up() {
        System.out.println(location + " garage up");
    }

    public void down() {
        System.out.println(location + " garage down");
    }
}
