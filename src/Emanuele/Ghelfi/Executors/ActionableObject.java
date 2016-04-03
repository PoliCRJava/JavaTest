package Emanuele.Ghelfi.Executors;

/**
 * Created by Emanuele on 03/04/2016.
 */
public class ActionableObject implements Actionable {

    private int number;
    private int count;

    public ActionableObject(int count, int number){
        this.count = count;
        this.number = number;
    }

    @Override
    public void DoIt() {
        // do something like count

        for(int i = 0; i<count; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }

    @Override
    public int GetNumber() {
        return number;
    }
}
