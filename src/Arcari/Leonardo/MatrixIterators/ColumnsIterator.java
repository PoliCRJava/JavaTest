package Arcari.Leonardo.MatrixIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by leonardoarcari on 23/03/16.
 */
public class ColumnsIterator<E> implements Iterator<E> {
    private Matrix<E> matrix;
    private int rowIndex;
    private int columnIndex;

    public ColumnsIterator(Matrix<E> matrix) {
        this.matrix = matrix;
        this.rowIndex = 0;
        this.columnIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return columnIndex != matrix.getColumns();
    }

    @Override
    public E next() {
        if (hasNext()) {
            E tmp = matrix.getItem(rowIndex, columnIndex);
            rowIndex = (rowIndex + 1) % matrix.getRows();
            if (rowIndex == 0) columnIndex++;
            return tmp;
        } else throw new NoSuchElementException();
    }
}
