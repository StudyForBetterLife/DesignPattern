package command.invoker;

import command.command.Command;
import command.command.impl.NoCommand;

public class RemoteControlWithUndo {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        final NoCommand noCommand = new NoCommand(); // 빈 커맨드 객체
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------- 리모컨 -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuilder.append("[slot ")
                    .append(i)
                    .append("]")
                    .append(onCommands[i].getClass().getSimpleName())
                    .append("   ")
                    .append(offCommands[i].getClass().getSimpleName())
                    .append("\n");
        }
        stringBuilder.append("[undo] ")
                .append(undoCommand.getClass().getSimpleName())
                .append("\n");
        return stringBuilder.toString();
    }
}
