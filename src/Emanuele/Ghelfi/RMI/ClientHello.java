package Emanuele.Ghelfi.RMI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by Emanuele on 20/04/2016.
 */

/**
 * Look at Client's description
 */
public class ClientHello {
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

            String helloServer = serverInterface.sayHello();
            System.out.println("Server said: "+helloServer);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
