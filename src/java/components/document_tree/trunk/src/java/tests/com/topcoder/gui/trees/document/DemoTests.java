/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.gui.trees.document.impl.SimpleDocumentTreeEventListener;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The unit test class is used for component demonstration.
 * </p>
 *
 * <p>
 * There is another swing demonstration provided, please refer to class <code>FrameDemo</code>.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class DemoTests extends TestCase {
    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigurations();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DemoTests.class);
    }

    /**
     * <p>
     * This test case demonstrates the usage of the document tree component.
     * </p>
     *
     * <p>
     * Note, for the related swing functions, please see <code>FrameDemo</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDemo() throws Exception {
        UMLModelManager model = TestHelper.createUMLModelManager();

        // Create a new tabbed pane object
        DocumentTreeTabbedPane treeTabbedPane = new DocumentTreeTabbedPaneImpl(model, TestHelper.NAMESPACE);

        // Get the tabbed pane and add it onto a container
        JPanel panel = new JPanel();
        panel.add(treeTabbedPane.getTabbedPane());

        // We may programmatically add/remove panes, get/set the chosen view as well as set the selected nodes
        // In the beginning, we start with three tabs
        // There is already a default tab, so we add two
        treeTabbedPane.createNewPanel().setCurrentView(DocumentTreeViewType.PACKAGE_CENTRIC);
        treeTabbedPane.createNewPanel().setCurrentView(DocumentTreeViewType.DIAGRAM_CENTRIC);
        treeTabbedPane.createNewPanel().setCurrentView(DocumentTreeViewType.CLASS_CENTRIC);

        // select a tree node
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)
            treeTabbedPane.getCurrentPanel().getCurrentView().getTree().getModel().getRoot();
        treeTabbedPane.setSelectedTreeNodes(new DocumentTreeNode[] {(DocumentTreeNode) root.getUserObject()});

        // we may also add a listener to listen to events
        DocumentTreeEventListener myListener = new SimpleDocumentTreeEventListener();
        treeTabbedPane.addDocumentTreeEventListener(myListener);
    }

    /**
     * <p>
     * This test case demonstrates the usage of the document tree component with new panel style.
     * </p>
     *
     * <p>
     * Note, for the related swing functions, please see <code>FrameDemo</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDemoNew() throws Exception {
        UMLModelManager model = TestHelper.createUMLModelManager();

        // Create a new tabbed pane object
        DocumentTreeTabbedPane treeTabbedPane = new DocumentTreeTabbedPaneImpl(model, TestHelper.NAMESPACE_NEW);

        // Get the tabbed pane and add it onto a container
        JPanel panel = new JPanel();
        panel.add(treeTabbedPane.getTabbedPane());

        // We may can't programmatically add/remove tabs, but can set
        // In the beginning (with sample configuration), we start with three tabs
        treeTabbedPane.getTabbedPane().setSelectedIndex(0);
        treeTabbedPane.getTabbedPane().setSelectedIndex(1);
        treeTabbedPane.getTabbedPane().setSelectedIndex(2);

        // select a tree node
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)
            treeTabbedPane.getCurrentPanel().getCurrentView().getTree().getModel().getRoot();
        treeTabbedPane.setSelectedTreeNodes(new DocumentTreeNode[] {(DocumentTreeNode) root.getUserObject()});

        // we may also add a listener to listen to events
        DocumentTreeEventListener myListener = new SimpleDocumentTreeEventListener();
        treeTabbedPane.addDocumentTreeEventListener(myListener);
    }
}
