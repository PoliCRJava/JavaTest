package Iterators;

import java.util.*;

/**
 * Created by Emanuele on 30/03/2016.
 */
public class MinToMaxIterator implements Iterator<Integer> {
    private BaseSet baseSet;
    private List<Integer> collection;
    private int visited;

    @Override
    public boolean hasNext() {
        if(visited<collection.size()){
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            visited++;
            return collection.get(visited-1);
        }
        else throw new NoSuchElementException("MinToMax");
    }

    public MinToMaxIterator(BaseSet baseSet){
        this.baseSet=baseSet;
        this.collection=baseSet.GetCollection();
        Collections.sort(collection);
    }
}
