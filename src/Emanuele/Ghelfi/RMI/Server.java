package Emanuele.Ghelfi.RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import static java.lang.Thread.sleep;

/**
 * Created by Emanuele on 16/04/2016.
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

    private int connectedClient = 0;

    @Override
    public int getConnectedClient() throws RemoteException {
        try {
            sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        connectedClient++;
        return connectedClient;
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello";
    }


    public Server(int connectedClient)throws RemoteException {
        this.connectedClient = connectedClient;
    }

    public Server() throws RemoteException {
        this.connectedClient = 0;
    }

    public static void main(String[] args) throws RemoteException {
        System.out.println("Server is started...");
        Server server = new Server();
        System.out.println("Binding...");
        Registry registry = LocateRegistry.getRegistry();

        try {
            registry.bind(Constants.SERVER,server);
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
            try {

                registry.unbind(Constants.SERVER);
                registry.bind(Constants.SERVER,server);
                System.out.println("BINDED CORRECTLY");
            } catch (NotBoundException e1) {
                e1.printStackTrace();
            } catch (AlreadyBoundException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("Waiting...");
    }
}
