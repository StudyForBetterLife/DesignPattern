package command.command.impl;

import command.command.Command;

/**
 * 일종의 null object
 * null 처리 로직을 줄이고 싶을 때 활용한다.
 * null object 를 일종의 디자인 패턴으로 분류하기도 한다.
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }
}
