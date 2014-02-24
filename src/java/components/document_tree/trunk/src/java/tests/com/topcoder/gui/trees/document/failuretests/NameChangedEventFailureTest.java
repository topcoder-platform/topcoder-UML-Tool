/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.NameChangedEvent;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link NameChangedEvent} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class NameChangedEventFailureTest extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(NameChangedEventFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link NameChangedEvent#NameChangedEvent(DocumentTreeNode, String)} constructor with
     * treeNode as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureNameChangedEvent() throws Exception {
        try {
            new NameChangedEvent(null, "test");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link NameChangedEvent#NameChangedEvent(DocumentTreeNode, String)} constructor with
     * newName as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureNameChangedEvent1() throws Exception {
        try {
            new NameChangedEvent(new DocumentTreeNode("test"), null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
