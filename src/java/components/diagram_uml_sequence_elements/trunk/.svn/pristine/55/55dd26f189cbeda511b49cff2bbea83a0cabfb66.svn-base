/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for SetNameEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class SetNameEventTests extends TestCase {
    /**
     * <p>
     * SetNameEvent instance for testing.
     * </p>
     */
    private SetNameEvent event;

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
        event = new SetNameEvent("oldName", "newName", node);
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
        return new TestSuite(SetNameEventTests.class);
    }

    /**
     * <p>
     * Tests ctor SetNameEvent#SetNameEvent(String,String,ObjectNode) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created SetNameEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new SetNameEvent instance.", event);
    }

    /**
     * <p>
     * Tests ctor SetNameEvent#SetNameEvent(String,String,ObjectNode) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when oldName is empty and expects success.
     * </p>
     */
    public void testCtor_EmptyOldName() {
        assertNotNull("Failed to create a new SetNameEvent instance.", new SetNameEvent(" ", "newName", node));
    }

    /**
     * <p>
     * Tests ctor SetNameEvent#SetNameEvent(String,String,ObjectNode) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when newName is empty and expects success.
     * </p>
     */
    public void testCtor_EmptyNewName() {
        assertNotNull("Failed to create a new SetNameEvent instance.", new SetNameEvent("oldName", " ", node));
    }

    /**
     * <p>
     * Tests ctor SetNameEvent#SetNameEvent(String,String,ObjectNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when oldName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullOldName() {
        try {
            new SetNameEvent(null, "newName", node);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SetNameEvent#SetNameEvent(String,String,ObjectNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newName is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNewName() {
        try {
            new SetNameEvent("oldName", null, node);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor SetNameEvent#SetNameEvent(String,String,ObjectNode) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNode() {
        try {
            new SetNameEvent("oldName", "newName", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests SetNameEvent#getOldName() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SetNameEvent#getOldName() is correct.
     * </p>
     */
    public void testGetOldName() {
        assertEquals("Failed to get the old name correctly.", "oldName", event.getOldName());
    }

    /**
     * <p>
     * Tests SetNameEvent#getNewName() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SetNameEvent#getNewName() is correct.
     * </p>
     */
    public void testGetNewName() {
        assertEquals("Failed to get the new name correctly.", "newName", event.getNewName());
    }

    /**
     * <p>
     * Tests SetNameEvent#getNode() for accuracy.
     * </p>
     *
     * <p>
     * It verifies SetNameEvent#getNode() is correct.
     * </p>
     */
    public void testGetNode() {
        assertSame("Failed to get the node correctly.", node, event.getNode());
    }

}