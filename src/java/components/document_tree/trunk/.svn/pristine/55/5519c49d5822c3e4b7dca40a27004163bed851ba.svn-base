/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import java.awt.datatransfer.DataFlavor;

import javax.swing.JComponent;
import javax.swing.JLabel;

import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreeViewTransferHandler.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class DocumentTreeViewTransferHandlerTests extends TestCase {
    /**
     * <p>
     * The DocumentTreeViewTransferHandler instance for testing.
     * </p>
     */
    private DocumentTreeViewTransferHandler handler;

    /**
     * <p>
     * The DocumentTreeTabbedPane instance for testing.
     * </p>
     */
    private DocumentTreeTabbedPane documentTreeTabbedPane;

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
        TestHelper.loadConfigurations();

        UMLModelManager manager = TestHelper.createUMLModelManager();

        documentTreeTabbedPane = new DocumentTreeTabbedPaneImpl(manager, TestHelper.NAMESPACE);
        handler = new DocumentTreeViewTransferHandler(documentTreeTabbedPane);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        handler = null;
        documentTreeTabbedPane = null;

        TestHelper.clearConfig();
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
        return new TestSuite(DocumentTreeViewTransferHandlerTests.class);
    }

    /**
     * <p>
     * Tests ctor DocumentTreeViewTransferHandler#DocumentTreeViewTransferHandler(DocumentTreeTabbedPane) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created DocumentTreeViewTransferHandler instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new DocumentTreeViewTransferHandler instance.", handler);
    }

    /**
     * <p>
     * Tests ctor DocumentTreeViewTransferHandler#DocumentTreeViewTransferHandler(DocumentTreeTabbedPane) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when documentTreeTabbedPane is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullDocumentTreeTabbedPane() {
        try {
            new DocumentTreeViewTransferHandler(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeViewTransferHandler#createTransferable(JComponent) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeViewTransferHandler#createTransferable(JComponent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateTransferable() throws Exception {
        DataFlavor flavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\""
            + DocumentTreeNode[].class.getName() + "\"");
        JComponent component = new JLabel("test");

        assertTrue("Failed to create the transferable correctly.",
            handler.createTransferable(component).isDataFlavorSupported(flavor));
    }

}