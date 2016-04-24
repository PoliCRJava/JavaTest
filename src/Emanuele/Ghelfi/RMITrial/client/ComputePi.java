package Emanuele.Ghelfi.RMITrial.client;

import Emanuele.Ghelfi.RMITrial.compute.Compute;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Emanuele on 20/04/2016.
 */
public class ComputePi {

    public static void main(String args[]){
        System.setProperty("java.security.policy","client.policy");
        if(System.getSecurityManager()==null){
            System.setSecurityManager(new SecurityManager());
        }

        try{
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute compute = (Compute) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[1]));
            BigDecimal pi = compute.executeTask(task);
            System.out.println(pi);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
