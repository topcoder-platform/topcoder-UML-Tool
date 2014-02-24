/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.impl.ClassCentricDocumentTreeView;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link ClassCentricDocumentTreeView} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class ClassCentricDocumentTreeViewFailureTest extends TestCase {

    /**
     * ClassCentricDocumentTreeView for testing.
     */
    private ClassCentricDocumentTreeView classCentricDocumentTreeView = null;

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
        classCentricDocumentTreeView = new ClassCentricDocumentTreeView(FailureTestHelper.getTreePanel(),
            FailureTestHelper.NAMESPACE);
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
        classCentricDocumentTreeView = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ClassCentricDocumentTreeViewFailureTest.class);
    }

    /**
     * <p>
     * Tests the
     * {@link ClassCentricDocumentTreeView#ClassCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor with parent as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureClassCentricDocumentTreeView() throws Exception {
        try {
           new ClassCentricDocumentTreeView(null, FailureTestHelper.NAMESPACE);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link ClassCentricDocumentTreeView#ClassCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor with namespace as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureClassCentricDocumentTreeView1() throws Exception {
        try {
            new ClassCentricDocumentTreeView(FailureTestHelper.getTreePanel(), null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link ClassCentricDocumentTreeView#ClassCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor with namespace as Empty string.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureClassCentricDocumentTreeView2() throws Exception {
        try {
            new ClassCentricDocumentTreeView(FailureTestHelper.getTreePanel(), "");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link ClassCentricDocumentTreeView#ClassCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor with namespace as Empty string with only spaces.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureClassCentricDocumentTreeView3() throws Exception {
        try {
            new ClassCentricDocumentTreeView(FailureTestHelper.getTreePanel(), "   ");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link ClassCentricDocumentTreeView#addTreeNode(DocumentTreeNode)} method with treeNode
     * as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureaddTreeNode() throws Exception {
        try {
             classCentricDocumentTreeView.addTreeNode(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link ClassCentricDocumentTreeView#updateTreeNode(DocumentTreeNode)} method with
     * treeNode as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureupdateTreeNode() throws Exception {
        try {
             classCentricDocumentTreeView.updateTreeNode(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link ClassCentricDocumentTreeView#removeTreeNode(DocumentTreeNode)} method with
     * treeNode as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureremoveTreeNode() throws Exception {
        try {
             classCentricDocumentTreeView.removeTreeNode(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
