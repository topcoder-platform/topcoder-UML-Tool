/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.stresstests;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.impl.ClassCentricDocumentTreeView;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test cases for ClassCentricDocumentTreeView.
 * </p>
 *
 * @author yinzi
 * @author FireIce
 * @version 1.1
 */
public class ClassCentricDocumentTreeViewStressTests extends TestCase {
    /**
     * <p>
     * Represents the times of stress test.
     * </p>
     */
    private static final int TIMES = 1000;

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
        StressTestHelper.clearConfig();

        StressTestHelper.loadConfigurations();

        manager = StressTestHelper.createUMLModelManager();
        umlPackage = (Package) manager.getModel().getOwnedElements().iterator().next();

        DocumentTreeTabbedPane tabbedPane = new DocumentTreeTabbedPaneImpl(manager, StressTestHelper.NAMESPACE);

        parent = tabbedPane.createNewPanel();

        view = new ClassCentricDocumentTreeView(parent, StressTestHelper.NAMESPACE);

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

        StressTestHelper.clearConfig();
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

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            view.addTreeNode(node);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The ClassCentricDocumentTreeView#addTreeNode(DocumentTreeNode) in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
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
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            view.updateTreeNode(newClassNode);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The ClassCentricDocumentTreeView#updateTreeNode(DocumentTreeNode) in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
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

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            view.removeTreeNode((DocumentTreeNode) umlPackageNode.getUserObject());
            view = new ClassCentricDocumentTreeView(parent, StressTestHelper.NAMESPACE);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The ClassCentricDocumentTreeView#removeTreeNode(DocumentTreeNode) in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
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

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            view.updateTree();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The ClassCentricDocumentTreeView#updateTree(DocumentTreeNode) in "
                + TIMES + " times takes " + (endTime - startTime) + "ms");
        // The root node should be re-load
        root = (MutableTreeNode) view.getTree().getModel().getRoot();

        int newChildCount = root.getChildCount();

        assertEquals("Failed to update the tree.", oldChildCount + 1, newChildCount);
    }

}