/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for SelectionChangedEvent.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class SelectionChangedEventTests extends TestCase {
    /**
     * <p>
     * The SelectionChangedEvent instance for testing.
     * </p>
     */
    private SelectionChangedEvent event;

    /**
     * <p>
     * The DocumentTreeNode array for testing.
     * </p>
     */
    private DocumentTreeNode[] selectedTreeNodes;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        selectedTreeNodes = new DocumentTreeNode[] {new DocumentTreeNode("name")};
        event = new SelectionChangedEvent(selectedTreeNodes, new boolean[] {true});
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        event = null;
        selectedTreeNodes = null;
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
        return new TestSuite(SelectionChangedEventTests.class);
    }

    /**
     * <p>
     * Tests ctor SelectionChangedEvent#SelectionChangedEvent(DocumentTreeNode[]) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created SelectionChangedEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new SelectionChangedEvent instance.", event);
    }

    /**
     * <p>
     * Tests ctor SelectionChangedEvent#SelectionChangedEvent(DocumentTreeNode[]) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when selectedTreeNodes is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullSelectedTreeNodes() {
        try {
            new SelectionChangedEvent(null, new boolean[0]);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SelectionChangedEvent#SelectionChangedEvent(DocumentTreeNode[]) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when selectedTreeNodes contains null element and
     * expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullInSelectedTreeNodes() {
        selectedTreeNodes = new DocumentTreeNode[] {null};
        try {
            new SelectionChangedEvent(selectedTreeNodes, new boolean[] {true});
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SelectionChangedEvent#getSelectedTreeNodes() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SelectionChangedEvent#getSelectedTreeNodes() is correct.
     * </p>
     */
    public void testGetSelectedTreeNodes() {
        DocumentTreeNode[] nodes = event.getSelectedTreeNodes();

        assertEquals("Expected the length of the nodes is one.", 1, nodes.length);
        assertSame("Failed to get the selected tree nodes correctly.", selectedTreeNodes[0], nodes[0]);

        // check the selectedTreeNodes are cloned
        assertNotSame("Failed to get the selected tree nodes correctly.", selectedTreeNodes, nodes);
    }

    /**
     * <p>
     * Tests getAreNew method.
     * </p>
     */
    public void testGetAreNew() {
        boolean[] areNew = event.getAreNew();
        assertEquals("number of new elements", 1, areNew.length);
        assertTrue("first element is new", areNew[0]);

        // try to change
        areNew[0] = false;
        assertTrue("first element is still true", event.getAreNew()[0]);
    }
}