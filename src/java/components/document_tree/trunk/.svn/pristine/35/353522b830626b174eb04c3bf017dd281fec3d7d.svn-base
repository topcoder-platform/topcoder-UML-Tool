/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;

import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.impl.BaseDocumentTreeView;
import com.topcoder.gui.trees.document.impl.DocumentTreePanelImpl;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>BaseDocumentTreeView</code>.
 * 
 * @author enefem21
 * @version 1.0
 */
public class BaseDocumentTreeViewTest extends TestCase {

    /** UMLModelManager used in the unit test. */
    private UMLModelManager umlModelManager;

    /** DocumentTreeTabbedPaneImpl used in the unit test. */
    private DocumentTreeTabbedPaneImpl documentTreeTabbedPaneImpl;

    /** ProjectConfigurationManager used in the unit test. */
    private ProjectConfigurationManager projectConfigurationManager;

    /** DocumentTreePanelImpl used in the unit test. */
    private DocumentTreePanelImpl documentTreePanelImpl;

    /** Unit under test. */
    private MockBaseDocumentTreeView treeView;

    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     * 
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(BaseDocumentTreeViewTest.class);
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

        documentTreeTabbedPaneImpl =
            new DocumentTreeTabbedPaneImpl(umlModelManager,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

        documentTreePanelImpl =
            new DocumentTreePanelImpl(documentTreeTabbedPaneImpl,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

        treeView = new MockBaseDocumentTreeView(documentTreePanelImpl, DocumentTreeViewType.CLASS_CENTRIC);
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
    public void testBaseDocumentTreeView() throws Exception {
        MockBaseDocumentTreeView treeView =
            new MockBaseDocumentTreeView(documentTreePanelImpl, DocumentTreeViewType.CLASS_CENTRIC);

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
     * Test <code>getParent</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetParent() {
        assertEquals("Returned value is not as expected", documentTreePanelImpl, treeView.getParent());
    }

    /**
     * Test <code>getTree</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetTree() {
        JTree tree = treeView.getTree();
        assertNotNull("Returned value is not as expected", tree);
        assertEquals(true, tree.getDragEnabled());
        assertEquals(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION, tree.getSelectionModel().getSelectionMode());
    }

    /**
     * Test <code>getViewType</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetViewType() {
        assertEquals("Returned value is not as expected", DocumentTreeViewType.CLASS_CENTRIC, treeView
            .getViewType());
    }

    /**
     * Test <code>getSelectedTreeNodes</code> and <code>setSelectedTreeNodes</code> for accuracy. Condition:
     * normal. Expect: returned value is as expected.
     */
    public void testGetSelectedTreeNodes() {
        DocumentTreeNode[] documentTreeNodes = new DocumentTreeNode[0];
        treeView.setSelectedTreeNodes(documentTreeNodes);
        assertNotSame("Returned value is not as expected", documentTreeNodes, treeView.getSelectedTreeNodes());
        assertEquals("Returned value is not as expected", 0, treeView.getSelectedTreeNodes().length);
    }

}
