/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.stresstests;

import com.topcoder.gui.trees.document.DocumentTreeNode;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test cases for DocumentTreeNode.
 * </p>
 *
 * @author yinzi
 * @author FireIce
 * @version 1.1
 */
public class DocumentTreeNodeStressTests extends TestCase {
    /**
     * <p>
     * Represents the times of stress test.
     * </p>
     */
    private static final int TIMES = 1000000;

    /**
     * <p>
     * The DocumentTreeNode instance for testing.
     * </p>
     */
    private DocumentTreeNode node;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        node = new DocumentTreeNode("name");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        node = null;

        super.tearDown();
    }

    /**
     * <p>
     * Stress tests DocumentTreeNode#toString() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreeNode#toString() is correct.
     * </p>
     */
    public void testToString() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            node.toString();
        }
        long endTime = System.currentTimeMillis();
        assertEquals("Failed to return the value correctly.", "name", node.toString());
        System.out.println("Stress tests: " + "The DocumentTreeNode#toString() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

}