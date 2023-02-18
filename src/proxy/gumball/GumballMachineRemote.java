package proxy.gumball;

import java.rmi.Remote;
import java.rmi.RemoteException;
import proxy.gumball.state.State;

public interface GumballMachineRemote extends Remote {
  int getCount() throws RemoteException;
  String getLocation() throws RemoteException;
  State getState() throws RemoteException;
}
