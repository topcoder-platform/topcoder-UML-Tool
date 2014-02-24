/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Point;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for EditNameEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class EditNameEventTests extends TestCase {
    /**
     * <p>
     * EditNameEvent instance for testing.
     * </p>
     */
    private EditNameEvent event;

    /**
     * <p>
     * Point instance for testing.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     */
    protected void setUp() {
        position = new Point();
        event = new EditNameEvent(position, "name", TestHelper.createObjectNode());
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        event = null;
        position = null;
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(EditNameEventTests.class);
    }

    /**
     * <p>
     * Tests ctor EditNameEvent#EditNameEvent(ObjectNode,Point,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created EditNameEvent instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new EditNameEvent instance.", event);
    }

    /**
     * <p>
     * Tests ctor EditNameEvent#EditNameEvent(ObjectNode,Point,String) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects success.
     * </p>
     */
    public void testCtor_EmptyName() {
        assertNotNull("Failed to create a new EditNameEvent instance.", new EditNameEvent(position, " ",
            TestHelper.createObjectNode()));
    }

    /**
     * <p>
     * Tests ctor EditNameEvent#EditNameEvent(ObjectNode,Point,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNode() {
        try {
            new EditNameEvent(position, "name", null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor EditNameEvent#EditNameEvent(ObjectNode,Point,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when position is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullPosition() {
        try {
            new EditNameEvent(null, "name", TestHelper.createObjectNode());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor EditNameEvent#EditNameEvent(ObjectNode,Point,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new EditNameEvent(position, null, TestHelper.createObjectNode());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests EditNameEvent#getName() for accuracy.
     * </p>
     *
     * <p>
     * It verifies EditNameEvent#getName() is correct.
     * </p>
     */
    public void testGetName() {
        assertEquals("Failed to get the name correctly.", "name", event.getName());
    }

    /**
     * <p>
     * Tests EditNameEvent#getPosition() for accuracy.
     * </p>
     *
     * <p>
     * It verifies EditNameEvent#getPosition() is correct.
     * </p>
     */
    public void testGetPosition() {
        assertSame("Failed to get the position correctly.", position, event.getPosition());
    }

}