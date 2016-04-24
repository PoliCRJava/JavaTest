package Emanuele.Ghelfi.RMITrial.compute;


import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * Created by Emanuele on 20/04/2016.
 */

/**
 * The compute.Compute interface defines the remotely accessible part, the compute engine itself.
 * By extending the interface java.rmi.Remote, the Compute interface identifies itself as an interface
 * whose methods can be invoked from another Java virtual machine. Any object that implements this interface can be
 * a remote object.
 * As a member of a remote interface, the executeTask method is a remote method.
 * Therefore, this method must be defined as being capable of throwing a java.rmi.RemoteException.
 * This exception is thrown by the RMI system from a remote method invocation to indicate that either a communication failure or a protocol error has occurred.
 * A RemoteException is a checked exception, so any code invoking a remote method needs to handle this exception by either catching it or declaring it in its throws clause.
 */
public interface Compute extends Remote {

    /**
     *
     * @param t
     * @param <T> that associates its own return type with the result type of the passed Task instance
     * @return the result of the execution of the Task instance passed to it
     * @throws RemoteException
     */
    <T> T executeTask(Task<T> t) throws RemoteException;
}
