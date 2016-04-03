package Emanuele.Ghelfi.MiniCronPack;

import Emanuele.Ghelfi.Executors.Actionable;

import java.util.Date;

/**
 * Created by Emanuele on 03/04/2016.
 */
public class Action implements Actionable {

    private Date hour;


    @Override
    public void DoIt() {

    }

    public Action(Date hour) {
        this.hour = hour;
    }

    @Override
    public int GetNumber() {
        throw new NoSuchMethodError("Action");
    }
}
