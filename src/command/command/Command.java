package command.command;

/**
 * 커맨드 객체는 모두 같은 인터페이스(Command)를 구현해야 한다.
 * 해당 인터페이스는 메소드가 하나뿐이다.
 */
public interface Command {
    void execute();
}
