package org.jumpmyball.util;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class CustomTableModel<T> extends AbstractTableModel {
    List<T> rows;
    Class<T> cls;
    String[] columnNames;


    public CustomTableModel(List<T> rows, Class<T> cls, String[] columnNames) {
        this.rows = rows;
        this.cls = cls;
        this.columnNames = columnNames;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return cls.getDeclaredFields()[columnIndex].getType();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
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
            Field field = cls.getDeclaredFields()[columnIndex];
            field.setAccessible(true);
            return field.get(rows.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "error custom table model";
        }
    }
}
