/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.awt.datatransfer.DataFlavor;
import java.lang.reflect.Field;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeNodeArrayTransferable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>DocumentTreeNodeArrayTransferable</code>.
 * 
 * @author enefem21
 * @version 1.0
 */
public class DocumentTreeNodeArrayTransferableTest extends TestCase {

    /** Unit under test. */
    private DocumentTreeNodeArrayTransferable documentTreeNodeArrayTransferable;

    /** DataFlavor used in the unit test. */
    private DataFlavor dataFlavor;

    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     * 
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeNodeArrayTransferableTest.class);
    }

    /**
     * Sets the unit test up.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        dataFlavor =
            new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\""
                + DocumentTreeNode[].class.getName() + "\"");

        documentTreeNodeArrayTransferable =
            new DocumentTreeNodeArrayTransferable(new DocumentTreeNode[] {new DocumentTreeNode("test1"),
                new DocumentTreeNode("test2")});

    }

    /**
     * Tears the unit test down.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: All states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testDocumentTreeNodeArrayTransferable() throws Exception {
        DocumentTreeNode[] documentTreeNodes =
            new DocumentTreeNode[] {new DocumentTreeNode("test1"), new DocumentTreeNode("test2")};
        DocumentTreeNodeArrayTransferable documentTreeNodeArrayTransferable =
            new DocumentTreeNodeArrayTransferable(documentTreeNodes);

        // check the transferData fields
        Field transferDataField = DocumentTreeNodeArrayTransferable.class.getDeclaredField("transferData");
        transferDataField.setAccessible(true);
        assertEquals("The field is not set as expected", documentTreeNodes, transferDataField
            .get(documentTreeNodeArrayTransferable));
    }

    /**
     * Test <code>getTransferData</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testGetTransferData() throws Exception {
        documentTreeNodeArrayTransferable.getTransferData(dataFlavor);
    }

    /**
     * Test <code>getTransferDataFlavors</code> for accuracy. Condition: normal. Expect: returned value is as
     * expected.
     */
    public void testGetTransferDataFlavors() {
        assertEquals("Returned value is not as expected", 1, documentTreeNodeArrayTransferable
            .getTransferDataFlavors().length);
        assertEquals("Returned value is not as expected", dataFlavor, documentTreeNodeArrayTransferable
            .getTransferDataFlavors()[0]);
    }

    /**
     * Test <code>isTransferDataFlavorSupported</code> for accuracy. Condition: normal. Expect: returned value is
     * as expected.
     */
    public void testIsDataFlavorSupported() {
        assertTrue("Returned value is not as expected", documentTreeNodeArrayTransferable
            .isDataFlavorSupported(dataFlavor));
    }

}
