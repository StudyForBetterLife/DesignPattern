package command.command.impl;

import command.command.Command;
import command.receiver.Light;

public class LightOffCommand implements Command {
    private final Light light; // 리시버 객체

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
