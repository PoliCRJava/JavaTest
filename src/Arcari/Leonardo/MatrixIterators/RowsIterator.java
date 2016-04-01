package Arcari.Leonardo.MatrixIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by leonardoarcari on 23/03/16.
 */
public class RowsIterator<E> implements Iterator<E> {
    private Matrix<E> matrix;
    private int rowIndex;
    private int columnIndex;

    public RowsIterator(Matrix<E> matrix) {
        this.matrix = matrix;
        this.rowIndex = 0;
        this.columnIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return rowIndex != matrix.getRows();
    }

    @Override
    public E next() {
        if (hasNext()) {
            E tmp = matrix.getItem(rowIndex, columnIndex);
            columnIndex = (columnIndex + 1) % matrix.getColumns();
            if (columnIndex == 0) rowIndex++;
            return tmp;
        } else throw new NoSuchElementException();
    }
}
