package Emanuele.Ghelfi.RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by Emanuele on 16/04/2016.
 */

/**
 * This two class (Client and HelloClient are developed to try RMI and RMI Multi thread,
 * Client calls a Server method that makes server sleep for 100s, if in the meantime you run ClientHello
 * the server will return hello before the first request.
 * So RMI is MultiThread by itself. You have to manage concurrency in you own
 */
public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("Insert the host address");
            Scanner scanner = new Scanner(System.in);
            String host = scanner.next();
            Registry registry = LocateRegistry.getRegistry(host);

            String[] registryList = registry.list();

            for (int i = 0; i< registryList.length;i++){
                System.out.println(registryList[i]);
            }

            String remoteObjectName = Constants.SERVER;
            ServerInterface serverInterface = (ServerInterface) registry.lookup(remoteObjectName);

            int num = serverInterface.getConnectedClient();
            System.out.println("Num connessi: "+num);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }


}
