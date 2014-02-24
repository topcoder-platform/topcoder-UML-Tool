/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.stresstests;

import java.io.File;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.impl.BaseDocumentTreeView;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test cases for BaseDocumentTreeView.
 * </p>
 *
 * @author yinzi
 * @author FireIce
 * @version 1.1
 */
public class BaseDocumentTreeViewStressTests extends TestCase {
    /**
     * <p>
     * Represents the times of stress test.
     * </p>
     */
    private static final int TIMES = 10000;

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
        StressTestHelper.clearConfig();

        StressTestHelper.loadConfigurations();

        tabbedPane = new DocumentTreeTabbedPaneImpl(StressTestHelper.createUMLModelManager(),
                StressTestHelper.NAMESPACE);
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
        treeView = null;
        tabbedPane = null;
        treePanel = null;

        StressTestHelper.clearConfig();
    }

    /**
     * <p>
     * Stress tests BaseDocumentTreeView#getSelectedTreeNodes() for accuracy.
     * </p>
     *
     * <p>
     * It verifies BaseDocumentTreeView#getSelectedTreeNodes() is correct.
     * </p>
     */
    public void testGetSelectedTreeNodes() {
        JTree tree = treeView.getTree();

        tree.setSelectionRow(0);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            treeView.getSelectedTreeNodes();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The BaseDocumentTreeView#getSelectedTreeNodes() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
        DocumentTreeNode[] newNodes = treeView.getSelectedTreeNodes();
        assertEquals("Failed to get the selected tree nodes correctly.", 1, newNodes.length);

    }

    /**
     * <p>
     * Stress tests BaseDocumentTreeView#setSelectedTreeNodes(DocumentTreeNode[]) for accuracy.
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

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            treeView.setSelectedTreeNodes(nodes);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The BaseDocumentTreeView#setSelectedTreeNodes() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
        DocumentTreeNode[] newNodes = treeView.getSelectedTreeNodes();

        assertEquals("Failed to set the selected tree nodes correctly.", root.getChildCount(), newNodes.length);
    }
}