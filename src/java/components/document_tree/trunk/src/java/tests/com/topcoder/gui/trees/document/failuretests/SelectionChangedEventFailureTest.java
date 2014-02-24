/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.SelectionChangedEvent;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link SelectionChangedEvent} class.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class SelectionChangedEventFailureTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(SelectionChangedEventFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link SelectionChangedEvent#SelectionChangedEvent(DocumentTreeNode[])} constructor with
     * selectedTreeNodes as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureSelectionChangedEvent() throws Exception {
        try {
            new SelectionChangedEvent(null, new boolean[0]);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link SelectionChangedEvent#SelectionChangedEvent(DocumentTreeNode[])} constructor with
     * selectedTreeNodes contains null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureSelectionChangedEvent1() throws Exception {
        try {
            new SelectionChangedEvent(new DocumentTreeNode[] {null}, new boolean[] {true});
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
