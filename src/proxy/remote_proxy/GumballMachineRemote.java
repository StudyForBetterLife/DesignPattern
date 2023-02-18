package proxy.remote_proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import proxy.remote_proxy.state.State;

public interface GumballMachineRemote extends Remote {
  int getCount() throws RemoteException;
  String getLocation() throws RemoteException;
  State getState() throws RemoteException;
}
