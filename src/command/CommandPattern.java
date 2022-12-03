package command;

import command.command.impl.*;
import command.invoker.RemoteControl;
import command.invoker.SimpleRemoteControl;
import command.receiver.GarageDoor;
import command.receiver.Light;
import command.receiver.Stereo;

/**
 * 커맨드 패턴에서 클라이언트에 해당하는 클래스
 */
public class CommandPattern {
    public static void main(String[] args) {
//        simpleRemoteControl();
        remoteControl();
    }

    private static void simpleRemoteControl() {
        final SimpleRemoteControl remote = new SimpleRemoteControl(); // remote 변수 : 인보커(invoker)

        final Light light = new Light(); // light : 리시버
        final LightOnCommand lightOnCommand = new LightOnCommand(light); // lightOnCommand : 커맨드 객체

        final GarageDoor garageDoor = new GarageDoor(); // 리시버
        final GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor); // 커맨드 객체

        remote.setCommand(lightOnCommand); // invoker의 setCommand 메소드로 커맨드 객체를 전달
        remote.buttonWasPressed(); // invoker로 커맨드 객체의 execute 메소드를 호출

        remote.setCommand(garageDoorUpCommand);
        remote.buttonWasPressed();
    }

    private static void remoteControl() {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor("Garage");
        Stereo livingRoomStereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);
        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);
        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(livingRoomStereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(livingRoomStereo);

        remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);
        remoteControl.setCommand(2, garageDoorUpCommand, garageDoorDownCommand);
        remoteControl.setCommand(3, stereoOnWithCDCommand, stereoOffCommand);

        System.out.println(remoteControl);

        for (int i = 0; i < 4; i++) {
            remoteControl.onButtonWasPushed(i);
            remoteControl.offButtonWasPushed(i);
        }
    }

    private static void remoteControlWithLambda() {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor("Garage");
        Stereo livingRoomStereo = new Stereo("Living Room");

        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(livingRoomStereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(livingRoomStereo);

        remoteControl.setCommand(0, livingRoomLight::on, livingRoomLight::off);
        remoteControl.setCommand(1, kitchenLight::on, kitchenLight::off);
        remoteControl.setCommand(2, garageDoor::up, garageDoor::down);
        remoteControl.setCommand(3, stereoOnWithCDCommand, stereoOffCommand);

        System.out.println(remoteControl);

        for (int i = 0; i < 4; i++) {
            remoteControl.onButtonWasPushed(i);
            remoteControl.offButtonWasPushed(i);
        }
    }
}
