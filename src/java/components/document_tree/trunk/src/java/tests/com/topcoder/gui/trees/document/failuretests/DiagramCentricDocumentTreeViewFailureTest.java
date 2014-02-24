/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.impl.DiagramCentricDocumentTreeView;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link DiagramCentricDocumentTreeView} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class DiagramCentricDocumentTreeViewFailureTest extends TestCase {

    /**
     * DiagramCentricDocumentTreeView for testing.
     */
    private DiagramCentricDocumentTreeView diagramCentricDocumentTreeView = null;

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
        diagramCentricDocumentTreeView = new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(),
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
        diagramCentricDocumentTreeView = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DiagramCentricDocumentTreeViewFailureTest.class);
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor with parent as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView() throws Exception {
        try {
            new DiagramCentricDocumentTreeView(null, FailureTestHelper.NAMESPACE);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor with namespace as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView1() throws Exception {
        try {
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(), null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor with namespace as Empty string.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView2() throws Exception {
        try {
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(), "");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor with namespace as Empty string with only spaces.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView3() throws Exception {
        try {
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(), "  ");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor.
     * </p>
     * <p>
     * Unknown namespace.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView4() throws Exception {
        try {
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(), "Unknown");
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor.
     * </p>
     * <p>
     * Diagram categories property missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView41() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_DiagramActionsMissing.xml");
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(),
                FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor.
     * </p>
     * <p>
     * Diagram categories property values containing null.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView411() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_DiagramCategoriesConatinsEmptytags.xml");
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(),
                FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }
    


    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor.
     * </p>
     * <p>
     * Diagram categories property empty.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView42() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_DiagramCategories_propertyempty.xml");
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(),
                FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor.
     * </p>
     * <p>
     * Diagram categories property missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView43() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_DiagramActionsMissing.xml");
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(),
                FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel, String)}
     * constructor.
     * </p>
     * <p>
     * Diagram categories property missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDiagramCentricDocumentTreeView44() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_DiagramActionsMissing.xml");
            new DiagramCentricDocumentTreeView(FailureTestHelper.getTreePanel(),
                FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DiagramCentricDocumentTreeView#addTreeNode(DocumentTreeNode)} method with
     * treeNode as null value.
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
             diagramCentricDocumentTreeView.addTreeNode(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DiagramCentricDocumentTreeView#updateTreeNode(DocumentTreeNode)} method with
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
             diagramCentricDocumentTreeView.updateTreeNode(null);
            fail("llegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DiagramCentricDocumentTreeView#removeTreeNode(DocumentTreeNode)} method with
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
             diagramCentricDocumentTreeView.removeTreeNode(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
