/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreeNodeArrayTransferable.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class DocumentTreeNodeArrayTransferableTests extends TestCase {
    /**
     * <p>
     * The DocumentTreeNodeArrayTransferable instance for testing.
     * </p>
     */
    private DocumentTreeNodeArrayTransferable transferable;

    /**
     * <p>
     * The DocumentTreeNode array for testing.
     * </p>
     */
    private DocumentTreeNode[] transferData;

    /**
     * <p>
     * The DataFlavor instance for testing.
     * </p>
     */
    private DataFlavor dataFlavor;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        super.setUp();
        dataFlavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\""
            + DocumentTreeNode[].class.getName() + "\"");
        transferData = new DocumentTreeNode[] {new DocumentTreeNode("name")};
        transferable = new DocumentTreeNodeArrayTransferable(transferData);

    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        transferable = null;
        transferData = null;
        dataFlavor = null;
        super.tearDown();
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeNodeArrayTransferableTests.class);
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNodeArrayTransferable#DocumentTreeNodeArrayTransferable(DocumentTreeNode[]) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created DocumentTreeNodeArrayTransferable instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new DocumentTreeNodeArrayTransferable instance.", transferable);
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNodeArrayTransferable#DocumentTreeNodeArrayTransferable(DocumentTreeNode[]) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when transferData is null and expects success.
     * </p>
     */
    public void testCtor_NullTransferData() {
        assertNotNull("Failed to create a new DocumentTreeNodeArrayTransferable instance.",
            new DocumentTreeNodeArrayTransferable(null));
    }

    /**
     * <p>
     * Tests ctor DocumentTreeNodeArrayTransferable#DocumentTreeNodeArrayTransferable(DocumentTreeNode[]) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when transferData contains null element and expects success.
     * </p>
     */
    public void testCtor_NullInTransferData() {
        transferData = new DocumentTreeNode[] {null};

        assertNotNull("Failed to create a new DocumentTreeNodeArrayTransferable instance.",
            new DocumentTreeNodeArrayTransferable(transferData));
    }

    /**
     * <p>
     * Tests DocumentTreeNodeArrayTransferable#getTransferData(DataFlavor) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeNodeArrayTransferable#getTransferData(DataFlavor) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTransferData() throws Exception {
        assertSame("Failed to get the transfer data correctly.", transferData,
            transferable.getTransferData(dataFlavor));
    }

    /**
     * <p>
     * Tests DocumentTreeNodeArrayTransferable#getTransferData(DataFlavor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dataFlavor is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetTransferData_NullDataFlavor() throws Exception {
        try {
            transferable.getTransferData(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeNodeArrayTransferable#getTransferData(DataFlavor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dataFlavor is null and expects UnsupportedFlavorException.
     * </p>
     */
    public void testGetTransferData_UnsupportedFlavorException() {
        dataFlavor = new DataFlavor(String.class, "String");
        try {
            transferable.getTransferData(dataFlavor);
            fail("UnsupportedFlavorException expected.");
        } catch (UnsupportedFlavorException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeNodeArrayTransferable#getTransferDataFlavors() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeNodeArrayTransferable#getTransferDataFlavors() is correct.
     * </p>
     */
    public void testGetTransferDataFlavors() {
        assertEquals("Expected the length of the array is one.", 1, transferable.getTransferDataFlavors().length);
        assertEquals("Failed to get the transfer data flavors correctly.", dataFlavor,
            transferable.getTransferDataFlavors()[0]);
    }

    /**
     * <p>
     * Tests DocumentTreeNodeArrayTransferable#isDataFlavorSupported(DataFlavor) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the data flavor is supported and returns true.
     * </p>
     */
    public void testIsDataFlavorSupported_True() {
        assertTrue("Failed to return the value correctly.", transferable.isDataFlavorSupported(dataFlavor));
    }

    /**
     * <p>
     * Tests DocumentTreeNodeArrayTransferable#isDataFlavorSupported(DataFlavor) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case when the data flavor is supported and returns false.
     * </p>
     */
    public void testIsDataFlavorSupported_False() {
        dataFlavor = new DataFlavor(String.class, "String");

        assertFalse("Failed to return the value correctly.", transferable.isDataFlavorSupported(dataFlavor));
    }

    /**
     * <p>
     * Tests DocumentTreeNodeArrayTransferable#isDataFlavorSupported(DataFlavor) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dataFlavor is null and expects IllegalArgumentException.
     * </p>
     */
    public void testIsDataFlavorSupported_NullDataFlavor() {
        try {
            transferable.isDataFlavorSupported(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}