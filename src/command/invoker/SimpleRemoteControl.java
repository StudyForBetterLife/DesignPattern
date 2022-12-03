package command.invoker;

import command.command.Command;

public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    /**
     * 커맨드 객체로 제어할 명령을 설정하는 메소드
     *
     * @param command
     */
    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
