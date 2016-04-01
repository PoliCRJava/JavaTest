package Arcari.Leonardo.SortAlgorithms;

/**
 * Test class
 */
public class SortAlgDriver {
    public static void main(String[] args) {
        Persona[] persone = {   new Persona("a", "a", "a"),
                                new Persona("k", "k", "k"),
                                new Persona("c", "c", "c"),
                                new Persona("b", "b", "b")};
        Student[] students = {  new Student("a", "a", "a", "2"),
                                new Student("k", "k", "k", "2"),
                                new Student("a", "a", "a", "1"),
                                new Student("b", "b", "b", "3")};
        Persona[] polim = {     new Student("a", "a", "a", "2"),
                                new Student("k", "k", "k", "2"),
                                new Student("a", "a", "a", "1"),
                                new Student("b", "b", "b", "3")};
        String[] strings = {    "Ciao3",
                                "Ciao2",
                                "Ciao1",
                                "Anatra"};

        testSort(persone);
        testSort(students);
        testSort(polim);
        testSort(strings);
    }

    private static <T extends Comparable<? super T>> void testSort(T[] a) {
        System.out.println("----- Before Sorting -----");
        for (T t : a) {
            System.out.println(t);
        }
        SortAlgorithms.sortAscending(a);
        System.out.println("----- Sorting -----");
        for (T t : a) {
            System.out.println(t);
        }
    }
}
