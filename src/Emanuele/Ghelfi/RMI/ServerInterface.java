package Emanuele.Ghelfi.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Emanuele on 16/04/2016.
 */
public interface ServerInterface extends Remote {

    int getConnectedClient() throws RemoteException;

    String sayHello() throws RemoteException;
}
