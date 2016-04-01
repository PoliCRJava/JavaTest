package Arcari.Leonardo.SortAlgorithms;

/**
 * Created by leonardoarcari on 22/03/16.
 */
public class SortAlgorithms {
    public static <E extends Comparable<? super E>> void sortAscending(E[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i+1; j < v.length; j++) {
                if (v[i].compareTo(v[j]) > 0 ) {
                    E tmp = v[i];
                    v[i] = v[j];
                    v[j] = tmp;
                }
            }
        }
    }
}
