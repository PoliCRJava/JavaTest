package Emanuele.Ghelfi.RMITrial.compute;

/**
 * Created by Emanuele on 20/04/2016.
 */

/**
 * The Task interface defines a single method, execute, which has no parameters and throws no exceptions.
 * Because the interface does not extend Remote, the method in this interface doesn't need to list java.rmi.RemoteException in its throws clause
 * @param <T> represents the result type of the task's computation. This interface's execute method returns the result of the computation and thus its return type is T.
 */
public interface Task<T> {

    T execute();
}
