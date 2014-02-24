/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.failuretests.FailureTestHelper;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link BaseDocumentTreeView} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class BaseDocumentTreeViewFailureTest extends TestCase {

    /**
     * BaseDocumentTreeView for testing.
     */
    private BaseDocumentTreeView baseDocumentTreeView = null;

    /**
     * <p>
     * Sets up the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        FailureTestHelper.setUp();
        baseDocumentTreeView = new MockBaseDocumentTreeView(new DocumentTreePanelImpl(
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE),
            FailureTestHelper.NAMESPACE), DocumentTreeViewType.CLASS_CENTRIC);
    }

    /**
     * <p>
     * Tears down the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.tearDown();
        baseDocumentTreeView = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(BaseDocumentTreeViewFailureTest.class);
    }

    /**
     * <p>
     * Tests the
     * {@link BaseDocumentTreeView#BaseDocumentTreeView(DocumentTreePanel, DocumentTreeViewType)}
     * constructor with parent as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureBaseDocumentTreeView() throws Exception {
        try {
            new MockBaseDocumentTreeView(null, DocumentTreeViewType.CLASS_CENTRIC);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link BaseDocumentTreeView#BaseDocumentTreeView(DocumentTreePanel, DocumentTreeViewType)}
     * constructor with viewType as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureBaseDocumentTreeView1() throws Exception {
        try {
            new MockBaseDocumentTreeView(new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager
                .getInstance(), FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE), null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[])} method with
     * selectedTreeNodes as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuresetSelectedTreeNodes() throws Exception {
        try {
             baseDocumentTreeView.setSelectedTreeNodes(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[])} method with
     * selectedTreeNodes containing null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuresetSelectedTreeNodes1() throws Exception {
        try {
             baseDocumentTreeView.setSelectedTreeNodes(new DocumentTreeNode[]{null});
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[])} method with
     * selectedTreeNodes containing value which are not present in the map.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuresetSelectedTreeNodes2() throws Exception {
        try {
             baseDocumentTreeView.setSelectedTreeNodes(new DocumentTreeNode[]{new DocumentTreeNode(new Diagram())});
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
