package Emanuele.Ghelfi.Executors;

/**
 * Created by Emanuele on 01/04/2016.
 */
public class GenericRunnable implements Runnable{

    private Actionable actionable;
    private RunnableCallback runnableCallback;

    /**
     * Constructor
     * @param actionable the actionable object.
     * @param runnableCallback runnableCallback because OnFinish is called.
     */
    public GenericRunnable(Actionable actionable, RunnableCallback runnableCallback){
        this.actionable = actionable;
        this.runnableCallback = runnableCallback;
    }

    @Override
    public void run() {
        actionable.DoIt();
        runnableCallback.OnFinish(actionable.GetNumber());
    }


}
