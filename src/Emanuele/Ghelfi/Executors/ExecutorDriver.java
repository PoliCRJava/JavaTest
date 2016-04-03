package Emanuele.Ghelfi.Executors;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Emanuele on 03/04/2016.
 */
public class ExecutorDriver implements RunnableCallback{

    private ArrayList<GenericRunnable> genericRunnables;
    private ArrayList<ActionableObject> actionableObjects;
    private int finished;
    private Date initDate;
    private Date finishDate;
    private boolean finishedThread = false;


    public ExecutorDriver() {
        genericRunnables = new ArrayList<>();
        actionableObjects = new ArrayList<>();
        finishedThread = false;
    }

    public void GenerateArray(int size, int actionableCount){
        genericRunnables = new ArrayList<>();
        actionableObjects = new ArrayList<>();
        for(int i = 0;i < size; i++){
            ActionableObject actionableObject = new ActionableObject(actionableCount,i);
            actionableObjects.add(actionableObject);
            GenericRunnable genericRunnable = new GenericRunnable(actionableObject,this);
            genericRunnables.add(genericRunnable);
        }
    }

    @Override
    public void OnFinish(int number) {
        System.out.println("finished "+ number);
        finished++;
        if(finished==genericRunnables.size()){
            //Finished All
            finishDate = new Date();
            System.out.println("Finish: "+ new Timestamp(finishDate.getTime()));
            System.out.println("Duration " + (finishDate.getTime()-initDate.getTime()) );
            if(!finishedThread){
                finishedThread = true;
                System.out.println("Now Starts with Executor!");
                ResetAll();
                StartAllWithExecutor();
            }
        }
    }

    public void ResetAll(){
        finished=0;
        GenerateArray(1000,1000);
    }

    public void StartAllWithThread(){
        initDate = new Date();
        System.out.println("Init: "+ new Timestamp(initDate.getTime()));
        for (int i = 0;i< genericRunnables.size();i++){
            Thread thread = new Thread(genericRunnables.get(i));
            thread.start();
        }
    }

    public void StartAllWithExecutor(){
        initDate = new Date();
        System.out.println("Executor init: "+ new Timestamp(initDate.getTime()));
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0;i< genericRunnables.size();i++){
            executor.execute(genericRunnables.get(i));
        }
    }

    // For testing
    public static void main(String[] args){
        ExecutorDriver executorDriver = new ExecutorDriver();
        executorDriver.GenerateArray(1000,1000);
        executorDriver.StartAllWithThread();
    }


}
