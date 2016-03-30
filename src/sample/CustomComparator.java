package sample;

import java.util.Comparator;

/**
 * Created by Emanuele on 30/03/2016.
 */
public class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1.intValue()<o2.intValue()){
            return -1;
        }
        if(o1.intValue() == o2.intValue()){
            return 0;
        }
        return 1;
    }
}
