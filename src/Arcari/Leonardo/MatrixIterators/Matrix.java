package Arcari.Leonardo.MatrixIterators;

import java.util.Iterator;

/**
 * Created by leonardoarcari on 23/03/16.
 */
public class Matrix<E> {
    private E[][] data;
    private int rows;
    private int columns;

    public Matrix(E[][] data, int rows, int columns) {
        this.data = data;
        this.rows = rows;
        this.columns = columns;
    }

    public E getItem(int row, int column) {
        if (row < rows && column < columns) {
            return data[row][column];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Iterator<E> rowsIterator() {
        return new RowsIterator<>(this);
    }

    public Iterator<E> columnsIterator() {
        return new ColumnsIterator<>(this);
    }

}
