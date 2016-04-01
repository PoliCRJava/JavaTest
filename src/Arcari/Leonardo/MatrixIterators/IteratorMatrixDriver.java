package Arcari.Leonardo.MatrixIterators;

import java.util.Iterator;

/**
 * Created by leonardoarcari on 23/03/16.
 */
public class IteratorMatrixDriver {
    public static void main(String[] args) {
        Integer[][] intData = new Integer[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                intData[i][j] = i+j;
            }
        }

        Matrix<Integer> intMatrix = new Matrix<>(intData, 5, 3);
        Iterator<Integer> rowsIterator = intMatrix.rowsIterator();
        Iterator<Integer> columnsIterator = intMatrix.columnsIterator();

        System.out.println("----- Rows Iterator -----");
        testIterator(rowsIterator);
        System.out.println("----- Columns Iterator -----");
        testIterator(columnsIterator);
    }

    private static <E> void testIterator (Iterator<E> i) {
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
