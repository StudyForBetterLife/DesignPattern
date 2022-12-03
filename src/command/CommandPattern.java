package command;

import command.command.impl.GarageDoorOpenCommand;
import command.command.impl.LightOnCommand;
import command.invoker.SimpleRemoteControl;
import command.receiver.GarageDoor;
import command.receiver.Light;

/**
 * 커맨드 패턴에서 클라이언트에 해당하는 클래스
 */
public class CommandPattern {
    public static void main(String[] args) {
        final SimpleRemoteControl remote = new SimpleRemoteControl(); // remote 변수 : 인보커(invoker)

        final Light light = new Light(); // light : 리시버
        final LightOnCommand lightOnCommand = new LightOnCommand(light); // lightOnCommand : 커맨드 객체

        final GarageDoor garageDoor = new GarageDoor(); // 리시버
        final GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor); // 커맨드 객체

        remote.setCommand(lightOnCommand); // invoker의 setCommand 메소드로 커맨드 객체를 전달
        remote.buttonWasPressed(); // invoker로 커맨드 객체의 execute 메소드를 호출

        remote.setCommand(garageDoorOpenCommand);
        remote.buttonWasPressed();
    }
}
