/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * <p>
 * This class provides a customized <code>TableModel</code> to be used by the
 * <code>ParametersListPropertyPanel</code> and <code>StereotypeListPropertyPanel</code>.
 * </p>
 *
 * <p>
 * This class is package-private and it implements <code>AbstractTableModel</code>.
 * </p>
 *
 * <p>
 * Thread-safety: this class is not thread-safe as it is mutable.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
class CustomTableModel extends AbstractTableModel {
    /**
     * <p>
     * The data contained within the table model.
     * </p>
     *
     * <p>
     * Created in the constructor, its reference is never modified afterwards.
     * </p>
     *
     * <p>
     * It will not be null.
     * </p>
     */
    private final List<List<Object>> data = new ArrayList<List<Object>>();

    /**
     * <p>
     * Creates a new <code>CustomTableModel</code>.
     * </p>
     */
    CustomTableModel() {
        // empty
    }

    /**
     * <p>
     * Retrieves the column count of the table model.
     * </p>
     *
     * @return the column count of the table model
     */
    public int getColumnCount() {
        if (data.size() == 0) {
            return 0;
        }

        List<Object> list = data.get(0);
        return (list == null) ? 0 : list.size();
    }

    /**
     * <p>
     * Retrieves the row count of the table model.
     * </p>
     *
     * @return the row count of the table model
     */
    public int getRowCount() {
        return data.size();
    }

    /**
     * <p>
     * Retrieves the value (as an <code>Object</code>) in the given row and column.
     * </p>
     *
     * @param rowIndex the row index of the cell whose value is requested
     * @param columnIndex the column index of the cell whose value is requested
     * @return the value (as an <code>Object</code>) in the given row and column
     *
     * @throws IndexOutOfBoundsException if the row or column index is out of range
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    /**
     * <p>
     * Returns the most specific super class for all the cell values in the column.
     * </p>
     *
     * <p>
     * This is used by the <code>JTable</code> to set up a default renderer and editor for the column.
     * </p>
     *
     * @param columnIndex the column index of the column whose class is requested
     * @return the most specific super class for all the cell values in the column
     *
     * @throws IndexOutOfBoundsException if the column index is out of range
     */
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    /**
     * <p>
     * Adds a row to the table model. The row will be added as the last row.
     * </p>
     *
     * @param row the row to be added to the table model
     */
    void addRow(List<Object> row) {
        data.add(row);

        if (data.size() == 1) {
            fireTableStructureChanged();
        } else {
            fireTableDataChanged();
        }
    }

    /**
     * <p>
     * Removes the specified row from the table model.
     * </p>
     *
     * @param rowIndex the index of the row to be removed
     *
     * @throws IndexOutOfBoundsException if the row index is out of range
     */
    void removeRow(int rowIndex) {
        data.remove(rowIndex);

        fireTableDataChanged();
    }

    /**
     * <p>
     * Removes all row from the table model.
     * </p>
     */
    void removeAllRow() {
        data.clear();

        fireTableDataChanged();
    }

    /**
     * <p>
     * Gets the data contained within the table model.
     * </p>
     *
     * @return the data contained within the table model.
     */
    protected List<List<Object>> getInternalDataStorage() {
        return data;
    }
}
