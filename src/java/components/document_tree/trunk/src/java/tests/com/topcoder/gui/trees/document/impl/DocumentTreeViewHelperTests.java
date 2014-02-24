/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.TestHelper;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreeViewHelper.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class DocumentTreeViewHelperTests extends TestCase {
    /**
     * <p>
     * The ClassCentricDocumentTreeView instance for testing.
     * </p>
     */
    private ClassCentricDocumentTreeView view;

    /**
     * <p>
     * The DocumentTreePanel instance for helping testing.
     * </p>
     */
    private DocumentTreePanel parent;

    /**
     * <p>
     * The UMLModelManager instance for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * The Package instance for testing.
     * </p>
     */
    private Package umlPackage;

    /**
     * <p>
     * The DefaultMutableTreeNode instance for testing.
     * </p>
     */
    private DefaultMutableTreeNode umlPackageNode;

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
        manager = TestHelper.createUMLModelManager();
        umlPackage = (Package) manager.getModel().getOwnedElements().iterator().next();

        DocumentTreeTabbedPane tabbedPane = new DocumentTreeTabbedPaneImpl(manager, TestHelper.NAMESPACE);

        parent = tabbedPane.createNewPanel();

        view = new ClassCentricDocumentTreeView(parent, TestHelper.NAMESPACE);

        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();
        umlPackageNode = (DefaultMutableTreeNode) root.getChildAt(0);
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
        view = null;
        umlPackage = null;
        umlPackageNode = null;
        parent = null;
        manager = null;

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
        return new TestSuite(DocumentTreeViewHelperTests.class);
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#getPropertyValue(String,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeViewHelper#getPropertyValue(String,String) is correct.
     * </p>
     */
    public void testGetPropertyValue() {
        String property = DocumentTreeViewHelper.getPropertyValue(TestHelper.NAMESPACE, "tree_cell_renderer");
        assertEquals("Failed to get property value correctly.", "cell_render", property);
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#getPropertyValue(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is unknown and expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testGetPropertyValue_UnknownNamespace() {
        try {
            DocumentTreeViewHelper.getPropertyValue("UnknownNamespace", "tree_cell_renderer");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#getPropertyValue(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when property is missing and expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testGetPropertyValue_PropertyMissing() {
        try {
            DocumentTreeViewHelper.getPropertyValue("tree_cell_renderer_missing", "tree_cell_renderer");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#getPropertyValue(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when property is empty and expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testGetPropertyValue_PropertyEmpty() {
        try {
            DocumentTreeViewHelper.getPropertyValue("tree_cell_renderer_empty", "tree_cell_renderer");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#addTreeNode(BaseDocumentTreeView,DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeViewHelper#addTreeNode(BaseDocumentTreeView,DocumentTreeNode) is correct.
     * </p>
     */
    public void testAddTreeNode() {
        Class newClass = new ClassImpl();
        newClass.setName("NewClass");
        umlPackage.addOwnedElement(newClass);

        DocumentTreeNode node = new DocumentTreeNode(newClass);
        DocumentTreeViewHelper.addTreeNode(view, node);

        assertTrue("Failed to add the tree node correctly.", view.documentNodeToTreeNodeMap.containsKey(node));
        MutableTreeNode newNode = view.documentNodeToTreeNodeMap.get(node);

        assertSame("Failed to add the tree node correctly.", newNode,
            umlPackageNode.getChildAt(umlPackageNode.getChildCount() - 1));
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#addTreeNode(BaseDocumentTreeView,DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testAddTreeNode_NullTreeNode() {
        try {
            DocumentTreeViewHelper.addTreeNode(view, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#updateTreeNode(BaseDocumentTreeView,DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeViewHelper#updateTreeNode(BaseDocumentTreeView,DocumentTreeNode) is correct.
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
        DocumentTreeViewHelper.updateTreeNode(view, newClassNode);

        DefaultMutableTreeNode parentTreeNode = (DefaultMutableTreeNode) view.documentNodeToTreeNodeMap.get(
            newClassNode).getParent();
        DocumentTreeNode parentNode = (DocumentTreeNode) parentTreeNode.getUserObject();

        // verify it is removed from the uml package node and added to the new package node
        assertSame("Failed to update the node.", newPackageNode, parentNode);
        assertNotSame("Failed to update the node.", umlPackageNode, parentNode);
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#updateTreeNode(BaseDocumentTreeView,DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testUpdateTreeNode_NullTreeNode() {
        try {
            DocumentTreeViewHelper.updateTreeNode(view, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#removeTreeNode(BaseDocumentTreeView,DocumentTreeNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeViewHelper#removeTreeNode(BaseDocumentTreeView,DocumentTreeNode) is correct.
     * </p>
     */
    public void testRemoveTreeNode() {
        MutableTreeNode root = (MutableTreeNode) view.getTree().getModel().getRoot();

        int oldChildCount = root.getChildCount();

        DocumentTreeViewHelper.removeTreeNode(view, (DocumentTreeNode) umlPackageNode.getUserObject());

        int newChildCount = root.getChildCount();

        assertEquals("Failed to remove the tree node correctly.", oldChildCount - 1, newChildCount);
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#removeTreeNode(BaseDocumentTreeView,DocumentTreeNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testRemoveTreeNode_NullTreeNode() {
        try {
            DocumentTreeViewHelper.removeTreeNode(view, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#createPackageTree(BaseDocumentTreeView,UMLModelManager,String,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeViewHelper#createPackageTree(BaseDocumentTreeView,
     * UMLModelManager,String,String) is correct.
     * </p>
     */
    public void testCreatePackageTree() {
        assertNotNull("Failed to create the package tree correctly.", DocumentTreeViewHelper.createPackageTree(view,
            manager, "activityGraphsCategoryName", "collaborationsCategoryName"));
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#createClassTree(BaseDocumentTreeView,UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeViewHelper#createClassTree(BaseDocumentTreeView,UMLModelManager) is correct.
     * </p>
     */
    public void testCreateClassTree() {
        assertNotNull("Failed to create the class tree correctly.", DocumentTreeViewHelper.createClassTree(view,
            manager));
    }

    /**
     * <p>
     * Tests DocumentTreeViewHelper#createDiagramTree(BaseDocumentTreeView,UMLModelManager,Map) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeViewHelper#createDiagramTree(BaseDocumentTreeView,UMLModelManager,Map) is correct.
     * </p>
     */
    public void testCreateDiagramTree() {
        Map<String, String> diagramCategoryNames = new HashMap<String, String>();
        assertNotNull("Failed to create the diagram tree correctly.", DocumentTreeViewHelper.createDiagramTree(view,
            manager, diagramCategoryNames));
    }

}