package sample;

import java.util.Collection;
import java.util.List;

/**
 * Created by Emanuele on 30/03/2016.
 */
public interface BaseSet extends Iterable<Integer>{
    /**
     * It should return a List of integer. Implements this method returning a list in your class so that you can call
     * generic for
     * @return a List of your class
     */
    List<Integer> GetCollection();
}
