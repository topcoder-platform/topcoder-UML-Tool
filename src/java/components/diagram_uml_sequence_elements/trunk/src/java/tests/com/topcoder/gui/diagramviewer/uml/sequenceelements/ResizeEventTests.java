/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ResizeEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class ResizeEventTests extends TestCase {
    /**
     * <p>
     * ResizeEvent instance for testing.
     * </p>
     */
    private ResizeEvent event;

    /**
     * <p>
     * ObjectNode instance for testing.
     * </p>
     */
    private ObjectNode node;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        node = TestHelper.createObjectNode();
        event = new ResizeEvent(node, "reason");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        event = null;
        node = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ResizeEventTests.class);
    }

    /**
     * <p>
     * Tests ctor ResizeEvent#ResizeEvent(ObjectNode,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created ResizeEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new ResizeEvent instance.", event);
    }

    /**
     * <p>
     * Tests ctor ResizeEvent#ResizeEvent(ObjectNode,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNode() {
        try {
            new ResizeEvent(null, "reason");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ResizeEvent#ResizeEvent(ObjectNode,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when reason is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullReason() {
        try {
            new ResizeEvent(node, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ResizeEvent#ResizeEvent(ObjectNode,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when reason is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyReason() {
        try {
            new ResizeEvent(node, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ResizeEvent#getNode() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ResizeEvent#getNode() is correct.
     * </p>
     */
    public void testGetNode() {
        assertSame("Failed to get the node correctly.", node, event.getNode());
    }

    /**
     * <p>
     * Tests ResizeEvent#getReason() for accuracy.
     * </p>
     *
     * <p>
     * It verifies ResizeEvent#getReason() is correct.
     * </p>
     */
    public void testGetReason() {
        assertEquals("Failed to get the reason correctly.", "reason", event.getReason());
    }

}