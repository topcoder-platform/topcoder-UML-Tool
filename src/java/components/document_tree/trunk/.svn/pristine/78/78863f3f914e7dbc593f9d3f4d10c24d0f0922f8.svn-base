/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.impl.BaseDocumentTreeView;
import com.topcoder.gui.trees.document.impl.ClassCentricDocumentTreeView;
import com.topcoder.gui.trees.document.impl.DocumentTreePanelImpl;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>ClassCentricDocumentTreeView</code>.
 * 
 * @author enefem21
 * @version 1.0
 */
public class ClassCentricDocumentTreeViewTest extends TestCase {

    /** UMLModelManager used in the unit test. */
    private UMLModelManager umlModelManager;

    /** DocumentTreeTabbedPaneImpl used in the unit test. */
    private DocumentTreeTabbedPaneImpl documentTreeTabbedPaneImpl;

    /** ProjectConfigurationManager used in the unit test. */
    private ProjectConfigurationManager projectConfigurationManager;

    /** DocumentTreePanelImpl used in the unit test. */
    private DocumentTreePanelImpl documentTreePanelImpl;

    /** Unit under test. */
    private ClassCentricDocumentTreeView treeView;

    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     * 
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(ClassCentricDocumentTreeViewTest.class);
    }

    /**
     * Sets the unit test up.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator iter = ConfigManager.getInstance().getAllNamespaces(); iter.hasNext();) {
            ConfigManager.getInstance().removeNamespace(iter.next().toString());
        }
        cm.add(new File("test_files/accuracytests/DocumentTreeTabbedPaneImpl.xml").getCanonicalPath());

        
        ConfigManager.getInstance().add("accuracytests" + File.separator + "IconTreeCellRenderer.xml");
        ConfigManager.getInstance().add(
            "accuracytests" + File.separator + "ProjectConfigurationManager.objectfactory.xml");
        ConfigManager.getInstance().add("accuracytests" + File.separator + "standardclassloader.xml");

        umlModelManager = new UMLModelManager();

        projectConfigurationManager = new ProjectConfigurationManager(umlModelManager);

        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);

        Model model = new ModelImpl();
        model.addOwnedElement(umlModelManager.getProjectConfigurationManager().getStandardNamespaces("Java")
            .get(0));

        umlModelManager.setModel(model);

        documentTreeTabbedPaneImpl =
            new DocumentTreeTabbedPaneImpl(umlModelManager,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

        documentTreePanelImpl =
            new DocumentTreePanelImpl(documentTreeTabbedPaneImpl,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

        treeView =
            new ClassCentricDocumentTreeView(documentTreePanelImpl,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");
    }

    /**
     * Tears the unit test down.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager.getInstance().removeNamespace(
            "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");
        ConfigManager.getInstance().removeNamespace("com.topcoder.gui.trees.document.impl.objectfactory");
        ConfigManager.getInstance().removeNamespace("com.topcoder.gui.trees.document.impl.IconTreeCellRenderer");
        ConfigManager.getInstance().removeNamespace(
            "com.topcoder.uml.projectconfiguration.ProjectConfigurationManager.objectfactory");
        ConfigManager.getInstance().removeNamespace("com.topcoder.uml.standardclassloader");
        ConfigManager.getInstance().removeNamespace("classData_objectFactory");

        super.tearDown();
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: all states are as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testClassCentricDocumentTreeView() throws Exception {
        ClassCentricDocumentTreeView treeView =
            new ClassCentricDocumentTreeView(documentTreePanelImpl,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

        // check the parent fields
        Field parentField = BaseDocumentTreeView.class.getDeclaredField("parent");
        parentField.setAccessible(true);
        assertEquals("The field is not set as expected", documentTreePanelImpl, parentField.get(treeView));

        // check the viewType fields
        Field viewTypeField = BaseDocumentTreeView.class.getDeclaredField("viewType");
        viewTypeField.setAccessible(true);
        assertEquals("The field is not set as expected", DocumentTreeViewType.CLASS_CENTRIC, viewTypeField
            .get(treeView));
    }

    /**
     * Test <code>addTreeNode</code> for accuracy. Condition: normal. Expect: All states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testAddTreeNode() throws Exception {
        DocumentTreeNode documentTreeNode = new DocumentTreeNode(new Diagram());
        treeView.addTreeNode(documentTreeNode);

        // check the documentNodeToTreeNodeMap fields
        Field documentNodeToTreeNodeMapField =
            BaseDocumentTreeView.class.getDeclaredField("documentNodeToTreeNodeMap");
        documentNodeToTreeNodeMapField.setAccessible(true);
        HashMap<DocumentTreeNode, DefaultMutableTreeNode> treeNode =
            (HashMap<DocumentTreeNode, DefaultMutableTreeNode>) documentNodeToTreeNodeMapField.get(treeView);

        assertNull("The node should be null", treeNode.get(documentTreeNode));
    }

    /**
     * Test <code>updateTreeNode</code> for accuracy. Condition: normal. Expect: All states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testUpdateTreeNode() throws Exception {

        TreeNode child = ((MutableTreeNode) treeView.getTree().getModel().getRoot()).getChildAt(0).getChildAt(0);

        // check the documentTreeNodeToNodeMap fields
        Field treeNodeToDocumentNodeMapField =
            BaseDocumentTreeView.class.getDeclaredField("treeNodeToDocumentNodeMap");
        treeNodeToDocumentNodeMapField.setAccessible(true);
        HashMap<DefaultMutableTreeNode, DocumentTreeNode> treeNode =
            (HashMap<DefaultMutableTreeNode, DocumentTreeNode>) treeNodeToDocumentNodeMapField.get(treeView);

        treeView.updateTreeNode(treeNode.get(child));

        assertNotNull("Returned value is not as expected", treeNode.get(child));

    }

    /**
     * Test <code>removeTreeNode</code> for accuracy. Condition: normal. Expect: All states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testRemoveTreeNode() throws Exception {
        TreeNode child = ((MutableTreeNode) treeView.getTree().getModel().getRoot()).getChildAt(0).getChildAt(0);

        // check the documentTreeNodeToNodeMap fields
        Field treeNodeToDocumentNodeMapField =
            BaseDocumentTreeView.class.getDeclaredField("treeNodeToDocumentNodeMap");
        treeNodeToDocumentNodeMapField.setAccessible(true);
        HashMap<DefaultMutableTreeNode, DocumentTreeNode> treeNode =
            (HashMap<DefaultMutableTreeNode, DocumentTreeNode>) treeNodeToDocumentNodeMapField.get(treeView);

        treeView.removeTreeNode(treeNode.get(child));

        assertNull("Returned value is not as expected", treeNode.get(child));
    }

    /**
     * Test <code>updateTree</code> for accuracy. Condition: normal. Expect: All states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testUpdateTree() {
        treeView.updateTree();
    }

}
