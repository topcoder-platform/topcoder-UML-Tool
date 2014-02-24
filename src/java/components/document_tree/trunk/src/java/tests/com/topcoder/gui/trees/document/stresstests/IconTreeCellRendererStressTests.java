/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.stresstests;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.topcoder.gui.trees.document.impl.IconTreeCellRenderer;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test cases for IconTreeCellRenderer.
 * </p>
 *
 * @author yinzi
 * @author FireIce
 * @version 1.1
 */
public class IconTreeCellRendererStressTests extends TestCase {
    /**
     * <p>
     * Represents the times of stress test.
     * </p>
     */
    private static final int TIMES = 1000;

    /**
     * <p>
     * The IconTreeCellRenderer instance for testing.
     * </p>
     */
    private IconTreeCellRenderer renderer;

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

        renderer = new IconTreeCellRenderer(StressTestHelper.NAMESPACE);
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
        renderer = null;

        StressTestHelper.clearConfig();
    }

    /**
     * <p>
     * Tests IconTreeCellRenderer#getTreeCellRendererComponent(JTree,Object,boolean,
     * boolean,boolean,int,boolean) for accuracy.
     * </p>
     *
     * <p>
     * It verifies IconTreeCellRenderer#getTreeCellRendererComponent(JTree,Object,
     * boolean,boolean,boolean,int,boolean) is correct.
     * </p>
     */
    public void testGetTreeCellRendererComponent() {
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            renderer.getTreeCellRendererComponent(new JTree(), treeNode, true, true, true, 1, true);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The IconTreeCellRenderer#getTreeCellRendererComponent() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
        JLabel label = (JLabel) renderer.getTreeCellRendererComponent(new JTree(), treeNode, true, true, true, 1, true);
        assertNotNull("Failed to get the tree cell renderer correctly.", label.getIcon());
    }

}