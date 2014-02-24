/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.TestHelper;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ClassCentricDocumentTreeView.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class ClassCentricDocumentTreeViewTests extends BaseViewTestCase {
    /**
     * <p>
     * The ClassCentricDocumentTreeView instance for testing.
     * </p>
     */
    private ClassCentricDocumentTreeView view;

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

        view = new ClassCentricDocumentTreeView(parent, TestHelper.NAMESPACE);

        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        umlPackageNode = (DefaultMutableTreeNode) root.getChildAt(0);
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ClassCentricDocumentTreeViewTests.class);
    }

    /**
     * <p>
     * Tests ctor ClassCentricDocumentTreeView#ClassCentricDocumentTreeView(DocumentTreePanel,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ClassCentricDocumentTreeView instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ClassCentricDocumentTreeView instance.", view);
    }

    /**
     * <p>
     * Tests ctor ClassCentricDocumentTreeView#ClassCentricDocumentTreeView(DocumentTreePanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when parent is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new ClassCentricDocumentTreeView(null, TestHelper.NAMESPACE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassCentricDocumentTreeView#ClassCentricDocumentTreeView(DocumentTreePanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new ClassCentricDocumentTreeView(parent, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ClassCentricDocumentTreeView#ClassCentricDocumentTreeView(DocumentTreePanel,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyNamespace() {
        try {
            new ClassCentricDocumentTreeView(parent, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassCentricDocumentTreeView#addTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ClassCentricDocumentTreeView#addTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testAddTreeNode() {
        Class newClass = new ClassImpl();
        newClass.setName("NewClass");
        umlPackage.addOwnedElement(newClass);

        DocumentTreeNode node = new DocumentTreeNode(newClass);
        view.addTreeNode(node);

        assertTrue("Failed to add the tree node correctly.", view.documentNodeToTreeNodeMap.containsKey(node));
        MutableTreeNode newNode = view.documentNodeToTreeNodeMap.get(node);

        assertSame("Failed to add the tree node correctly.", newNode,
            umlPackageNode.getChildAt(umlPackageNode.getChildCount() - 1));
    }

    /**
     * <p>
     * Tests ClassCentricDocumentTreeView#addTreeNode(DocumentTreeNode) for failure.
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
     * Tests ClassCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ClassCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testUpdateTreeNode() {
        Class newClass = new ClassImpl();
        newClass.setName("NewClass");
        umlPackage.addOwnedElement(newClass);

        DocumentTreeNode newClassNode = new DocumentTreeNode(newClass);
        view.addTreeNode(newClassNode);

        Package newPackage = new PackageImpl();
        newPackage.setName("Hello");
        umlPackage.addOwnedElement(newPackage);

        DocumentTreeNode newPackageNode = new DocumentTreeNode(newPackage);
        view.addTreeNode(newPackageNode);

        // update the namespace of the new class
        umlPackage.removeOwnedElement(newClass);
        newPackage.addOwnedElement(newClass);

        // update the new class node
        view.updateTreeNode(newClassNode);

        DefaultMutableTreeNode parentTreeNode = (DefaultMutableTreeNode) view.documentNodeToTreeNodeMap.get(
            newClassNode).getParent();
        DocumentTreeNode parentNode = (DocumentTreeNode) parentTreeNode.getUserObject();

        // verify it is removed from the uml package node and added to the new package node
        assertSame("Failed to update the node.", newPackageNode, parentNode);
        assertNotSame("Failed to update the node.", umlPackageNode, parentNode);
    }

    /**
     * <p>
     * Tests ClassCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) for failure.
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
     * Tests ClassCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode does not exist in the tree and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testUpdateTreeNode_NoExistTreeNode() {
        try {
            view.updateTreeNode(new DocumentTreeNode("New"));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies ClassCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) is correct.
     * </p>
     */
    public void testRemoveTreeNode() {
        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();

        int oldChildCount = root.getChildCount();

        view.removeTreeNode((DocumentTreeNode) umlPackageNode.getUserObject());

        int newChildCount = root.getChildCount();

        assertEquals("Failed to remove the tree node correctly.", oldChildCount - 1, newChildCount);
    }

    /**
     * <p>
     * Tests ClassCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) for failure.
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
     * Tests ClassCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode does not exist in the tree and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveTreeNode_NoExistTreeNode() {
        try {
            view.removeTreeNode(new DocumentTreeNode("New"));
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ClassCentricDocumentTreeView#updateTree() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ClassCentricDocumentTreeView#updateTree() is correct.
     * </p>
     */
    public void testUpdateTree() {
        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();

        int oldChildCount = root.getChildCount();

        // The model contains one more package
        Model model = manager.getModel();
        Package newPackage = new PackageImpl();
        newPackage.setName("Hello");
        model.addOwnedElement(newPackage);

        view.updateTree();

        // The root node should be re-load
        root = (MutableTreeNode) view.getTree().getModel().getRoot();

        int newChildCount = root.getChildCount();

        assertEquals("Failed to update the tree.", oldChildCount + 1, newChildCount);
    }

}