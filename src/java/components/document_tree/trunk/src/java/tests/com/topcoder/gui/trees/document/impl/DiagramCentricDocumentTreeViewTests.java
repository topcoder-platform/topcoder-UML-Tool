/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.TestHelper;

import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DiagramCentricDocumentTreeView.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class DiagramCentricDocumentTreeViewTests extends BaseViewTestCase {
    /**
     * <p>
     * The DiagramCentricDocumentTreeView instance for testing.
     * </p>
     */
    private DiagramCentricDocumentTreeView view;

    /**
     * <p>
     * The Diagram instance for helping testing.
     * </p>
     */
    private Diagram classDiagram;

    /**
     * <p>
     * The DefaultMutableTreeNode instance for helping testing.
     * </p>
     */
    private DefaultMutableTreeNode classDiagramNode;

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

        classDiagram = manager.getDiagrams().get(1);
        view = new DiagramCentricDocumentTreeView(parent, TestHelper.NAMESPACE);

        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        classDiagramNode = (DefaultMutableTreeNode) root.getChildAt(1).getChildAt(0);
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DiagramCentricDocumentTreeViewTests.class);
    }

    /**
     * <p>
     * Tests ctor DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created DiagramCentricDocumentTreeView instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new DiagramCentricDocumentTreeView instance.", view);
    }

    /**
     * <p>
     * Tests ctor DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when parent is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new DiagramCentricDocumentTreeView(null, TestHelper.NAMESPACE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new DiagramCentricDocumentTreeView(parent, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyNamespace() {
        try {
            new DiagramCentricDocumentTreeView(parent, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel,String)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case when the namespace is unknown and expects for DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor1_UnknownNamespace() {
        try {
            new DiagramCentricDocumentTreeView(parent, "unknown-namespace");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel,String)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case when the diagram categories is missing and expects
     * for DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor1_DiagramCategoriesMissing() {
        try {
            new DiagramCentricDocumentTreeView(parent, "diagram_categories_missing");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DiagramCentricDocumentTreeView#DiagramCentricDocumentTreeView(DocumentTreePanel,String)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case when the value of the diagram categories is empty and expects
     * for DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor1_DiagramCategoriesValueEmpty() {
        try {
            new DiagramCentricDocumentTreeView(parent, "diagram_categories_value_empty");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#addTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DiagramCentricDocumentTreeView#addTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testAddTreeNode() {
        GraphNode newGraphNode = new GraphNode();
        newGraphNode.setSemanticModel(TestHelper.createUml1SemanticModelBridge("NewNode"));
        classDiagram.addContained(newGraphNode);
        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        DefaultMutableTreeNode classDiagramNode = (DefaultMutableTreeNode) root.getChildAt(0).getChildAt(0);

        DocumentTreeNode node = new DocumentTreeNode(newGraphNode);
        view.addTreeNode(node);

        assertTrue("Failed to add the tree node correctly.", view.documentNodeToTreeNodeMap.containsKey(node));

        MutableTreeNode newNode = view.documentNodeToTreeNodeMap.get(node);
        assertSame("Failed to add the tree node correctly.", classDiagramNode, newNode.getParent());
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#addTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddTreeNode_NullTreeNode() {
        try {
            view.addTreeNode(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DiagramCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testUpdateTreeNode() {
        Diagram useCaseDiagram = manager.getDiagrams().get(0);
        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        DefaultMutableTreeNode useCaseDiagramNode = (DefaultMutableTreeNode) root.getChildAt(1).getChildAt(0);

        DiagramElement child = useCaseDiagram.getContaineds().get(0);
        DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) useCaseDiagramNode.getChildAt(0);

        // update the namespace of the child element
        useCaseDiagram.removeContained(child);
        classDiagram.addContained(child);

        view.updateTreeNode((DocumentTreeNode) childNode.getUserObject());

        TreeNode parentNode = childNode.getParent();

        classDiagramNode = (DefaultMutableTreeNode) root.getChildAt(0).getChildAt(0);
        // verify it is removed from the use case diagram node and added to the class diagram node
        assertNotSame("Failed to update the node.", useCaseDiagramNode, parentNode);
        assertSame("Failed to update the node.", classDiagramNode, parentNode);
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testUpdateTreeNode_NullTreeNode() {
        try {
            view.updateTreeNode(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode does not exist in the tree and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testUpdateTreeNode_NoExistTreeNode() {
        try {
            view.updateTreeNode(new DocumentTreeNode("NewText"));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DiagramCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testRemoveTreeNode() {
        DocumentTreeNode node = (DocumentTreeNode) ((DefaultMutableTreeNode)
            classDiagramNode.getChildAt(0)).getUserObject();

        int oldChildCount = classDiagramNode.getChildCount();

        view.removeTreeNode(node);

        int newChildCount = classDiagramNode.getChildCount();

        assertEquals("Failed to remove the tree node correctly.", oldChildCount - 1, newChildCount);
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveTreeNode_NullTreeNode() {
        try {
            view.removeTreeNode(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode does not exist in the tree and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveTreeNode_NoExistTreeNode() {
        try {
            view.removeTreeNode(new DocumentTreeNode("NewText"));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DiagramCentricDocumentTreeView#updateTree() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DiagramCentricDocumentTreeView#updateTree() is correct.
     * </p>
     */
    public void testUpdateTree() {
        int oldChildCount = classDiagramNode.getChildCount();

        GraphNode newGraphNode = new GraphNode();
        newGraphNode.setSemanticModel(TestHelper.createUml1SemanticModelBridge("NewNode"));
        classDiagram.addContained(newGraphNode);

        view.updateTree();

        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        classDiagramNode = (DefaultMutableTreeNode) root.getChildAt(0).getChildAt(0);

        int newChildCount = classDiagramNode.getChildCount();

        assertEquals("Failed to update the tree.", oldChildCount + 1, newChildCount);
    }

}