package Emanuele.Ghelfi.OverflowTest;

/**
 * Created by Emanuele on 12/06/2016.
 */
public class Overflow {

    public static void main(String[] args) {

        int n =2;

        while (n>0){
            n = n*n;
            System.out.println(n);
        }

        System.out.println("FINITO, sono uscito da while: "+n);
    }
}
