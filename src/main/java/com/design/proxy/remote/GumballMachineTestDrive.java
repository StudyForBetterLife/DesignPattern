package proxy.remote;

import java.rmi.Naming;

public class GumballMachineTestDrive {

    /**
     * - 원격 서비스(GumballMachineTestDrive) 를 실행하기 전에 "rmiregistry &"을 통해 rmiregistry를 백그라운드에서 실행시킨다.
     * - 사용되는 메소드에서 직렬화가 필요한부분을 모두 직렬화해야 한다. (State)
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
            int count = Integer.parseInt(args[1]);
            GumballMachine gumballMachine = new GumballMachine(args[0], count);

            // rebind() 메소드를 통해 gumballMachine 을 RMI 레지스트리에 등록한다. -> RMI 시스템은 레지스트리에 스텁만 등록한다
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
