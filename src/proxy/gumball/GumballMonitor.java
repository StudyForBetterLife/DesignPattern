package proxy.gumball;


import java.rmi.RemoteException;

/**
 * 프록시를 활용하는 클라이언트 객체.
 */
public class GumballMonitor {

  private final GumballMachineRemote machine; // GumballMachine 구상 클래스가 아니라 Remote 원격 인터페이스인 GumballMachineRemote를 사용한다.

  public GumballMonitor(GumballMachineRemote machine) {
    this.machine = machine;
  }

  public void report() {
    try {
      System.out.println("Gumball Machine: " + machine.getLocation());
      System.out.println("Current inventory: " + machine.getCount() + " gumballs");
      System.out.println("Current state: " + machine.getState());
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
