package Emanuele.Ghelfi.RMITrial.engine;

import Emanuele.Ghelfi.RMITrial.compute.Compute;
import Emanuele.Ghelfi.RMITrial.compute.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Emanuele on 20/04/2016.
 */
public class ComputeEngine implements Compute {

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }

    public ComputeEngine() {
        super();
    }


    public static void main(String[] args){
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }

        try{
            String name = "Compute";
            Compute engine = new ComputeEngine();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine,0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name,stub);
            System.out.println("ComputeEngine bind succesfully");
        } catch (RemoteException e) {
            System.err.println("Compute Engine Exception");
            e.printStackTrace();
        }
    }
}
