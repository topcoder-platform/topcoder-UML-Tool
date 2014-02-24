/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;

import junit.framework.TestCase;
/**
 * <p>
 * Unit tests on class <code>AuxiliaryElementSelection</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class AuxiliaryElementSelectionTest extends TestCase {

    /**
     * <p>
     * Instance of <code>AuxiliaryElementSelection</code> used in this test.
     * </p>
     */
    private AuxiliaryElementSelection selection;
    /**
     * <p>
     * Serializable object.
     * </p>
     */
    private Serializable obj;

    /**
     * <p>
     * Instance of <code>DataFlavor</code> used in this test.
     * </p>
     */
    private DataFlavor dataFlavor;
    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        this.obj = "a string";
        this.dataFlavor = AuxiliaryElementDataFlavor.COMMENT;
        this.selection = new AuxiliaryElementSelection(this.obj, this.dataFlavor);
    }

    /**
     * <p>
     * Test constructor <code>AuxiliaryElementSelection(Serializable obj, DataFlavor dataFlavor)</code>
     * for failure with null obj, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullObj() {
        try {
            new AuxiliaryElementSelection(null, this.dataFlavor);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AuxiliaryElementSelection(Serializable obj, DataFlavor dataFlavor)</code>
     * for failure with null dataFlavor, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullDataFlavor() {
        try {
            new AuxiliaryElementSelection(this.obj, null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>AuxiliaryElementSelection(Serializable obj, DataFlavor dataFlavor)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create AuxiliaryElementSelection!", this.selection);
    }

    /**
     * <p>
     * Test method <code>getTransferDataFlavors()</code> for accuracy.
     * </p>
     */
    public void testGetTransferDataFlavors() {
        DataFlavor[] dataFlavors = this.selection.getTransferDataFlavors();
        assertEquals("Incorrect data flavors.", 1, dataFlavors.length);
        assertEquals("Incorrect data flavors.", this.dataFlavor, dataFlavors[0]);
    }

    /**
     * <p>
     * Test method <code>isDataFlavorSupported(DataFlavor flavor)</code> for failure
     * with null flavor, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testIsDataFlavorSupported_NullFlavor() {
        try {
            this.selection.isDataFlavorSupported(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>isDataFlavorSupported(DataFlavor flavor)</code> for accuracy
     * with other flavor, <code>false</code> should be returned.
     * </p>
     */
    public void testIsDataFlavorSupported_OtherFlavor() {
        assertFalse("Incorrect result.",
                this.selection.isDataFlavorSupported(AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE));
    }

    /**
     * <p>
     * Test method <code>isDataFlavorSupported(DataFlavor flavor)</code> for accuracy
     * with the same flavor, <code>true</code> should be returned.
     * </p>
     */
    public void testIsDataFlavorSupported_SameFlavor() {
        assertTrue("Incorrect result.",
                this.selection.isDataFlavorSupported(AuxiliaryElementDataFlavor.COMMENT));
    }

    /**
     * <p>
     * Test method <code>getTransferData</code> for failure with null flavor,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     * @throws UnsupportedFlavorException to JUnit
     * @throws IOException to JUnit
     */
    public void testGetTransferData_NullFlavor() throws UnsupportedFlavorException, IOException {
        try {
            this.selection.getTransferData(null);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>getTransferData</code> for failure with unsupported flavor,
     * <code>UnsupportedFlavorException</code> is expected.
     * </p>
     * @throws IOException to JUnit
     */
    public void testGetTransferData_UnsupportedFlavor() throws IOException {
        try {
            this.selection.getTransferData(AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE);
            fail("UnsupportedFlavorException is expected!");
        } catch (UnsupportedFlavorException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>getTransferData</code> for accuracy with supported flavor.
     * </p>
     * @throws UnsupportedFlavorException to JUnit
     * @throws IOException to JUnit
     */
    public void testGetTransferData_Accuracy() throws UnsupportedFlavorException, IOException {
        assertEquals("Incorrect transfer data!", this.obj,
                this.selection.getTransferData(AuxiliaryElementDataFlavor.COMMENT));
    }
}
