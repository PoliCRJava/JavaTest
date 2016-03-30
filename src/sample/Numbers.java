package sample;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Emanuele on 30/03/2016.
 * It implements Iterable for use generic for
 */
public class Numbers implements Iterable<Integer> {

    private ArrayList<Integer> myList;

    /**
     * Default Constructor.Initializes the ArrayList
     */
    public Numbers(){
        myList = new ArrayList<>();
    }

    /**
     * This method allows you to insert num in the arrayList
    @param num is the number to insert into the ArrayList
     */
    public void AddNum(int num){
        myList.add(num);
    }

    //For testing
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        Numbers numbers = new Numbers();
        numbers.AddNum(5);
        numbers.AddNum(10);
        numbers.AddNum(-5);
        numbers.AddNum(-7);
        numbers.AddNum(-9);
        numbers.AddNum(56);
        numbers.AddNum(65);
        numbers.AddNum(-96);
        for (int n:numbers) {
            System.out.println("Ecco: "+n +"\n");
        }
    }

    @Override
    /**
     * Returns an Iterator for iterate the array from Min value to Max value
     */
    public Iterator<Integer> iterator() {
        return new MinToMax(myList);
    }

    /**
     * Custom iterator for iterate a list of integer
     */
    public static class MinToMax implements Iterator<Integer>{

        private int visited;
        private ArrayList<Integer> myList;


        public MinToMax(ArrayList<Integer> myList){
            visited=0;
            if(myList!=null){
                this.myList = myList;
                this.myList.sort(new CustomComparator());
            }

        }

        @Override
        public boolean hasNext() {
            if(visited<myList.size()){
                return true;
            }
            return false;

        }

        @Override
        public Integer next() throws NoSuchElementException {
            if(hasNext()){
                visited++;
                return myList.get(visited-1);
            }
            else throw new NoSuchElementException("MinToMax");
        }
    }
}
