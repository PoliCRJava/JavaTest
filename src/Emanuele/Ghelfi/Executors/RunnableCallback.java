package Emanuele.Ghelfi.Executors;

/**
 * Created by Emanuele on 03/04/2016.
 */
public interface RunnableCallback {
    /**
     * This function is called when a Runnable finishes.
     * @param number is the number of the runnable that has finished
     */
    void OnFinish(int number);
}
