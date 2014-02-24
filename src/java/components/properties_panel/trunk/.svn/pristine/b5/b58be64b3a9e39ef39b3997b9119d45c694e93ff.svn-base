/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CustomTableModel.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CustomTableModelTests extends TestCase {
    /**
     * <p>
     * The CustomTableModel instance for testing.
     * </p>
     */
    private CustomTableModel model;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        model = new CustomTableModel();

        List<Object> row = new ArrayList<Object>();
        row.add("test");
        model.addRow(row);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        model = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CustomTableModelTests.class);
    }

    /**
     * <p>
     * Tests CustomTableModel#CustomTableModel() for accuracy
     * </p>
     *
     * <p>
     * It verifies the newly created CustomTableModel instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CustomTableModel instance.", model);
    }

    /**
     * <p>
     * Tests CustomTableModel#getInternalDataStorage() for accuracy.
     * </p>
     *
     * <p>
     * It verifies CustomTableModel#getInternalDataStorage() is correct.
     * </p>
     */
    public void testGetInternalDataStorage() {
        List<List<Object>> data = model.getInternalDataStorage();
        assertEquals("Excepted the size of data is one.", 1, data.size());
        assertEquals("Failed to get the internal data storage correctly.", "test", data.get(0).get(0));
    }

    /**
     * <p>
     * Tests CustomTableModel#getValueAt(int,int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies CustomTableModel#getValueAt(int,int) is correct.
     * </p>
     */
    public void testGetValueAt() {
        assertEquals("Failed to get the value correctly.", "test", model.getValueAt(0, 0));
    }

    /**
     * <p>
     * Tests CustomTableModel#getColumnClass(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies CustomTableModel#getColumnClass(int) is correct.
     * </p>
     */
    public void testGetColumnClass() {
        assertEquals("Failed to get the column class correctly.", String.class, model.getColumnClass(0));
    }

    /**
     * <p>
     * Tests CustomTableModel#getColumnCount() for accuracy.
     * </p>
     *
     * <p>
     * It verifies CustomTableModel#getColumnCount() is correct.
     * </p>
     */
    public void testGetColumnCount() {
        assertEquals("Failed to get the column count correctly.", 1, model.getColumnCount());
    }

    /**
     * <p>
     * Tests CustomTableModel#getRowCount() for accuracy.
     * </p>
     *
     * <p>
     * It verifies CustomTableModel#getRowCount() is correct.
     * </p>
     */
    public void testGetRowCount() {
        assertEquals("Failed to get the row count correctly.", 1, model.getRowCount());
    }

    /**
     * <p>
     * Tests CustomTableModel#addRow(List) for accuracy.
     * </p>
     *
     * <p>
     * It verifies CustomTableModel#addRow(List) is correct.
     * </p>
     */
    public void testAddRow() {
        List<Object> row = new ArrayList<Object>();
        row.add("second");
        model.addRow(row);

        List<List<Object>> data = model.getInternalDataStorage();
        assertEquals("Expected the size of data is two.", 2, data.size());
        assertEquals("Failed to add the row correctly.", "second", data.get(1).get(0));
    }

    /**
     * <p>
     * Tests CustomTableModel#removeRow(int) for accuracy.
     * </p>
     *
     * <p>
     * It verifies CustomTableModel#removeRow(int) is correct.
     * </p>
     */
    public void testRemoveRow() {
        model.removeRow(0);
        List<List<Object>> data = model.getInternalDataStorage();

        assertEquals("Failed to remove the row correctly.", 0, data.size());
    }

    /**
     * <p>
     * Tests CustomTableModel#removeAllRow() for accuracy.
     * </p>
     *
     * <p>
     * It verifies CustomTableModel#removeAllRow() is correct.
     * </p>
     */
    public void testRemoveAllRow() {
        model.removeAllRow();
        List<List<Object>> data = model.getInternalDataStorage();

        assertEquals("Failed to remove all the row correctly.", 0, data.size());
    }
}
