/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for NameChangedEvent.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class NameChangedEventTests extends TestCase {
    /**
     * <p>
     * The NameChangedEvent instance for testing.
     * </p>
     */
    private NameChangedEvent event;

    /**
     * <p>
     * The DocumentTreeNode instance for testing.
     * </p>
     */
    private DocumentTreeNode treeNode;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        treeNode = new DocumentTreeNode("treeNode");
        event = new NameChangedEvent(treeNode, "newName");
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
        treeNode = null;
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
        return new TestSuite(NameChangedEventTests.class);
    }

    /**
     * <p>
     * Tests ctor NameChangedEvent#NameChangedEvent(DocumentTreeNode,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created NameChangedEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new NameChangedEvent instance.", event);
    }

    /**
     * <p>
     * Tests ctor NameChangedEvent#NameChangedEvent(DocumentTreeNode,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when newName is empty and expects success.
     * </p>
     */
    public void testCtor_EmptyNewName() {
        assertNotNull("Failed to create a new NameChangedEvent instance.", new NameChangedEvent(treeNode, " "));
    }

    /**
     * <p>
     * Tests ctor NameChangedEvent#NameChangedEvent(DocumentTreeNode,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when treeNode is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullTreeNode() {
        try {
            new NameChangedEvent(null, "newName");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor NameChangedEvent#NameChangedEvent(DocumentTreeNode,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNewName() {
        try {
            new NameChangedEvent(treeNode, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests NameChangedEvent#getTreeNode() for accuracy.
     * </p>
     *
     * <p>
     * It verifies NameChangedEvent#getTreeNode() is correct.
     * </p>
     */
    public void testGetTreeNode() {
        assertSame("Failed to get the tree node correctly.", treeNode, event.getTreeNode());
    }

    /**
     * <p>
     * Tests NameChangedEvent#getNewName() for accuracy.
     * </p>
     *
     * <p>
     * It verifies NameChangedEvent#getNewName() is correct.
     * </p>
     */
    public void testGetNewName() {
        assertEquals("Failed to get the new name correctly.", "newName", event.getNewName());
    }

}