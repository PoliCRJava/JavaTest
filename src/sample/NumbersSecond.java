package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Emanuele on 30/03/2016.
 */
public class NumbersSecond implements BaseSet{

    private ArrayList<Integer> arrayList;

    public void AddToArray(int value){
        arrayList.add(value);
    }

    public NumbersSecond(){
        arrayList = new ArrayList<>();
    }

    public static void main(String[] args){
        NumbersSecond numbersSecond = new NumbersSecond();
        numbersSecond.AddToArray(5);
        numbersSecond.AddToArray(10);
        numbersSecond.AddToArray(-9);
        numbersSecond.AddToArray(0);

        numbersSecond.AddToArray(-59);

        numbersSecond.AddToArray(57);

        System.out.println("Print Min to Max");
        for (int value:numbersSecond)
        {
            System.out.println(""+value+"\n");
        }


    }

    @Override
    public List<Integer> GetCollection() {
        return arrayList;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MinToMaxIterator(this);
    }
}
