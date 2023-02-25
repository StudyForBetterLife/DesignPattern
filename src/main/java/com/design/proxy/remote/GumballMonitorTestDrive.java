package proxy.remote;

import java.rmi.Naming;

public class GumballMonitorTestDrive {

    /**
     * 1. 클라이언트에서 RMI 레지스트리를 lookup 한다
     * <p>
     * 2. RMI 레지스트리에서 stub 객체(GumballMachineRemote)를 리턴한다.
     * <p>
     * 3. 클라이언트에서 stub의 메소드(report)를 호출한다. (gumballMonitor.report();)
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] location = {"rmi://santafe.mightygumball.com/gumballmachine",
                "rmi://boulder.mightygumball.com/gumballmachine",
                "rmi://austin.mightygumball.com/gumballmachine"};

        if (args.length > 0) {
            location = new String[1];
            // 클라이언트에서는 GumballMachineTestDrive에서 gumballMachine 을 RMI 레지스트리에 등록할 때 사용한 이름 "gumballmachine"을 적어줘야 한다.
            // argument 첫번째 인자에 서비스(GumballMachineTestDrive)가 돌아가는 시스템의 hostname 또는 ip 주소를 입력한다.
            location[0] = "rmi://" + args[0] + "/gumballmachine";
        }

        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]); // lookup -> 스텁 객체 반환
                monitor[i] = new GumballMonitor(machine);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (GumballMonitor gumballMonitor : monitor) {
            gumballMonitor.report(); // 스텁의 메소드 호출. (클라이언트는 스텁이 실제 객체라고 생각한다)
        }
    }
}
