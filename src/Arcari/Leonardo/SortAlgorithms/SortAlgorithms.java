package Arcari.Leonardo.SortAlgorithms;

/**
 * Utility class shipping static sorting methods.
 */
public class SortAlgorithms {

    /**
     * Bubble sort ascending algorithm. You can call it on every class implements Comparable interface.
     * @param v Array of E objects
     * @param <E> Class of objects in @p v
     */
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
