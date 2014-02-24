/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeViewTransferHandler;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for BaseDocumentTreeView.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class BaseDocumentTreeViewTests extends TestCase {
    /**
     * <p>
     * The BaseDocumentTreeView instance for testing.
     * </p>
     */
    private BaseDocumentTreeView treeView;

    /**
     * <p>
     * The DocumentTreeTabbedPane instance for helping testing.
     * </p>
     */
    private DocumentTreeTabbedPane tabbedPane;

    /**
     * <p>
     * The DocumentTreePanel instance for helping testing.
     * </p>
     */
    private DocumentTreePanel treePanel;

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

        tabbedPane = new DocumentTreeTabbedPaneImpl(TestHelper.createUMLModelManager(), TestHelper.NAMESPACE);
        treePanel = tabbedPane.createNewPanel();

        this.treeView = (BaseDocumentTreeView) treePanel.getCurrentView();
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
        return new TestSuite(BaseDocumentTreeViewTests.class);
    }

    /**
     * <p>
     * Tests ctor BaseDocumentTreeView#BaseDocumentTreeView(DocumentTreePanel,DocumentTreeViewType) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created BaseDocumentTreeView instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new BaseDocumentTreeView instance.", treeView);
    }

    /**
     * <p>
     * Tests ctor BaseDocumentTreeView#BaseDocumentTreeView(DocumentTreePanel,DocumentTreeViewType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when parent is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new MockBaseDocumentTreeView(null, DocumentTreeViewType.DIAGRAM_CENTRIC);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor BaseDocumentTreeView#BaseDocumentTreeView(DocumentTreePanel,DocumentTreeViewType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when viewType is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullViewType() {
        try {
            new MockBaseDocumentTreeView(treePanel, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests BaseDocumentTreeView#getSelectedTreeNodes() for accuracy.
     * </p>
     *
     * <p>
     * It verifies BaseDocumentTreeView#getSelectedTreeNodes() is correct.
     * </p>
     */
    public void testGetSelectedTreeNodes() {
        JTree tree = treeView.getTree();

        tree.setSelectionRow(0);

        DocumentTreeNode[] newNodes = treeView.getSelectedTreeNodes();

        assertEquals("Failed to get the selected tree nodes correctly.", 1, newNodes.length);

        assertEquals("Failed to get the selected tree nodes correctly.", "Class Diagram", newNodes[0].getNodeObject());
    }

    /**
     * <p>
     * Tests BaseDocumentTreeView#getTree() for accuracy.
     * </p>
     *
     * <p>
     * It verifies BaseDocumentTreeView#getTree() is correct.
     * </p>
     */
    public void testGetTree() {
        JTree tree = treeView.getTree();

        assertTrue("Failed to get the tree correctly.", tree.getDragEnabled());
        assertTrue("Failed to get the tree correctly.", tree.isEditable());
        assertEquals("Failed to get the tree correctly.", TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION,
            tree.getSelectionModel().getSelectionMode());
        assertNotNull("Failed to get the tree correctly.", tree.getCellRenderer());
        assertEquals("Failed to get the tree correctly.", DocumentTreeViewTransferHandler.class,
            tree.getTransferHandler().getClass());
    }

    /**
     * <p>
     * Tests BaseDocumentTreeView#getViewType() for accuracy.
     * </p>
     *
     * <p>
     * It verifies BaseDocumentTreeView#getViewType() is correct.
     * </p>
     */
    public void testGetViewType() {
        assertEquals("Failed to get the view type correctly.", DocumentTreeViewType.DIAGRAM_CENTRIC,
            treeView.getViewType());
    }

    /**
     * <p>
     * Tests BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[]) for accuracy.
     * </p>
     *
     * <p>
     * It verifies BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[]) is correct.
     * </p>
     */
    public void testSetSelectedTreeNodes() {
        JTree tree = treeView.getTree();

        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
        DocumentTreeNode[] nodes = new DocumentTreeNode[root.getChildCount()];
        for (int i = 0; i < root.getChildCount(); i++) {
            nodes[i] = (DocumentTreeNode) ((DefaultMutableTreeNode) root.getChildAt(i)).getUserObject();
        }

        treeView.setSelectedTreeNodes(nodes);

        DocumentTreeNode[] newNodes = treeView.getSelectedTreeNodes();

        assertEquals("Failed to set the selected tree nodes correctly.", root.getChildCount(), newNodes.length);

        for (int i = 0; i < root.getChildCount(); i++) {
            assertSame("Failed to set the selected tree nodes correctly.", nodes[i], newNodes[i]);
        }
    }

    /**
     * <p>
     * Tests BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[]) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when selectedTreeNodes is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetSelectedTreeNodes_NullSelectedTreeNodes() {
        try {
            treeView.setSelectedTreeNodes(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[]) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when selectedTreeNodes contains null element and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testSetSelectedTreeNodes_NullInSelectedTreeNodes() {
        JTree tree = treeView.getTree();

        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();

        DocumentTreeNode[] nodes = new DocumentTreeNode[] {(DocumentTreeNode) root.getUserObject(), null};
        try {
            treeView.setSelectedTreeNodes(nodes);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[]) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when selectedTreeNodes contains unknown element and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testSetSelectedTreeNodes_UnknownNodeInSelectedTreeNodes() {
        JTree tree = treeView.getTree();

        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();

        DocumentTreeNode[] nodes = new DocumentTreeNode[] {(DocumentTreeNode) root.getUserObject(),
            new DocumentTreeNode("new_node")};
        try {
            treeView.setSelectedTreeNodes(nodes);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests BaseDocumentTreeView#getParent() for accuracy.
     * </p>
     *
     * <p>
     * It verifies BaseDocumentTreeView#getParent() is correct.
     * </p>
     */
    public void testGetParent() {
        assertSame("Failed to get the parent correctly.", treePanel, treeView.getParent());
    }


    /***************************************************************************************************
     * Some tests added in version 1.1 to test new setExpandedTreeNodes method.
     */

    /**
     * Tests setExpandedTreeNodes method for null array.
     * IllegalArgumentException expected.
     */
    public void testSetExpandedTreeNodesWrongArray() {
        try {
            treeView.setExpandedTreeNodes(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // success
        }
    }

    /**
     * Tests setExpandedTreeNodes method for null array.
     * IllegalArgumentException expected.
     */
    public void testSetExpandedTreeNodesUnknownNode() {
        JTree tree = treeView.getTree();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
        DocumentTreeNode[] nodes = new DocumentTreeNode[] {(DocumentTreeNode) root.getUserObject(),
            new DocumentTreeNode("new_node")};

        try {
            treeView.setExpandedTreeNodes(nodes);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * Tests setExpandedTreeNodes method for valid data (root). Root supposed to be expanded after that call.
     */
    public void testSetExpandedTreeNodes() {
        JTree tree = treeView.getTree();

        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
        DocumentTreeNode[] nodes = new DocumentTreeNode[1];
        nodes[0] = (DocumentTreeNode) root.getUserObject();

        treeView.setExpandedTreeNodes(nodes);

        assertTrue("root is expanded", treeView.getTree().isExpanded(new TreePath(root.getPath())));
    }
}