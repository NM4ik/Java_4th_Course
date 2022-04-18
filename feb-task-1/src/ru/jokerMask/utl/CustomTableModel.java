package ru.jokerMask.utl;

import ru.jokerMask.entity.ProductEntity;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class CustomTableModel<T> extends AbstractTableModel {
    private Class<T> cls;
    private List<T> rows;
    private String[] columnNames;

    public CustomTableModel(Class<T> cls, List<T> rows, String[] columnNames) {
        this.cls = cls;
        this.rows = rows;
        this.columnNames = columnNames;
    }

    @Override
    public String getColumnName(int column) {
        return column > columnNames.length ? "Нет названия" : columnNames[column];
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cls.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            T t = rows.get(rowIndex);
            Field field = cls.getDeclaredFields()[columnIndex];
            field.setAccessible(true);
            return field.get(t);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "CustomTableError";
        }
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
