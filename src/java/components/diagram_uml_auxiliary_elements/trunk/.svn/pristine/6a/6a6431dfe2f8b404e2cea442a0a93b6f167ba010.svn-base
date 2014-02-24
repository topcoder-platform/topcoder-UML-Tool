/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.Polyline;

import com.topcoder.gui.diagramviewer.elements.Node;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.Rectangle;


/**
 * <p>
 * Unit test cases for BoundaryChangeEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BoundaryChangeEventTests extends TestCase {
    /**
     * <p>
     * The Node instance for helping testing.
     * </p>
     */
    private Node node;

    /**
     * <p>
     * The Rectangle instance for helping testing.
     * </p>
     */
    private Rectangle oldBoundary;

    /**
     * <p>
     * The Rectangle instance for helping testing.
     * </p>
     */
    private Rectangle newBoundary;

    /**
     * <p>
     * The String instance for helping testing.
     * </p>
     */
    private String message;

    /**
     * <p>
     * The BoundaryChangeEvent instance for helping testing.
     * </p>
     */
    private BoundaryChangeEvent event;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        node = new PolylineNode(new Polyline(), new PropertyMapping());
        oldBoundary = new Rectangle();
        newBoundary = new Rectangle();
        message = "message";
        event = new BoundaryChangeEvent(node, oldBoundary, newBoundary);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        node = null;
        oldBoundary = null;
        newBoundary = null;
        message = null;
        event = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(BoundaryChangeEventTests.class);
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created BoundaryChangeEvent instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor1() throws Exception {
        assertNotNull("Failed to create a new BoundaryChangeEvent instance.", event);
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor1_NullNode() throws Exception {
        try {
            new BoundaryChangeEvent(null, oldBoundary, newBoundary);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when oldBoundary is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor1_NullOldBoundary() throws Exception {
        try {
            new BoundaryChangeEvent(node, null, newBoundary);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newBoundary is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor1_NullNewBoundary() throws Exception {
        try {
            new BoundaryChangeEvent(node, oldBoundary, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#
     * BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary, String message)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created BoundaryChangeEvent instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2() throws Exception {
        event = new BoundaryChangeEvent(node, oldBoundary, newBoundary, message);
        assertNotNull("Failed to create a new BoundaryChangeEvent instance.", event);
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#
     * BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary, String message)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : the constructor with null message is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_NullMessage() throws Exception {
        event = new BoundaryChangeEvent(node, oldBoundary, newBoundary, null);
        assertNotNull("Failed to create a new BoundaryChangeEvent instance.", event);
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#
     * BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary, String message)
     * for accuracy.
     * </p>
     *
     * <p>
     * Verify : the constructor with empty message is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_EmptyMessage() throws Exception {
        event = new BoundaryChangeEvent(node, oldBoundary, newBoundary, "");
        assertNotNull("Failed to create a new BoundaryChangeEvent instance.", event);
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#
     * BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary, String message)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when node is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_NullNode() throws Exception {
        try {
            new BoundaryChangeEvent(null, oldBoundary, newBoundary, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#
     * BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary, String message)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when oldBoundary is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_NullOldBoundary() throws Exception {
        try {
            new BoundaryChangeEvent(node, null, newBoundary, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests constructor
     * BoundaryChangeEvent#
     * BoundaryChangeEvent(Node node, Rectangle oldBoundary, Rectangle newBoundary, String message)
     * for failure.
     * </p>
     *
     * <p>
     * It tests the case that when newBoundary is null and expects IllegalArgumentException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor2_NullNewBoundary() throws Exception {
        try {
            new BoundaryChangeEvent(node, oldBoundary, null, message);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Tests BoundaryChangeEvent#getOldBoundary() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BoundaryChangeEvent#getOldBoundary() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetOldBoundary() throws Exception {
        assertTrue("The return value of getOldBoundary() should be Rectangle.",
                event.getOldBoundary() instanceof Rectangle);
        assertEquals("The return value of newly created BoundaryChangeEvent's getOldBoundary"
                + "should equal with the oldBoundary parameter of constructor.",
                oldBoundary, event.getOldBoundary());

        event = new BoundaryChangeEvent(node, oldBoundary, newBoundary, message);
        assertTrue("The return value of getOldBoundary() should be Rectangle.",
                event.getOldBoundary() instanceof Rectangle);
        assertEquals("The return value of newly created BoundaryChangeEvent's getOldBoundary"
                + "should equal with the oldBoundary parameter of constructor.",
                oldBoundary, event.getOldBoundary());
    }

    /**
     * <p>
     * Tests BoundaryChangeEvent#getNewBoundary() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BoundaryChangeEvent#getNewBoundary() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetNewBoundary() throws Exception {
        assertTrue("The return value of getNewBoundary() should be Rectangle.",
                event.getNewBoundary() instanceof Rectangle);
        assertEquals("The return value of newly created BoundaryChangeEvent's getNewBoundary"
                + "should equal with the newBoundary parameter of constructor.",
                newBoundary, event.getNewBoundary());

        event = new BoundaryChangeEvent(node, oldBoundary, newBoundary, message);
        assertTrue("The return value of getNewBoundary() should be Rectangle.",
                event.getNewBoundary() instanceof Rectangle);
        assertEquals("The return value of newly created BoundaryChangeEvent's getNewBoundary"
                + "should equal with the newBoundary parameter of constructor.",
                newBoundary, event.getNewBoundary());
    }

    /**
     * <p>
     * Tests BoundaryChangeEvent#getMessage() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BoundaryChangeEvent#getMessage() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetMessage() throws Exception {
        event = new BoundaryChangeEvent(node, oldBoundary, newBoundary, message);
        assertTrue("The return value of getMessage() should be String.",
                event.getMessage() instanceof String);
        assertEquals("The return value of newly created BoundaryChangeEvent's getMessage"
                + "should equal with the message parameter of constructor.",
                message, event.getMessage());

        event = new BoundaryChangeEvent(node, oldBoundary, newBoundary, message);
        assertTrue("The return value of getMessage() should be String.",
                event.getMessage() instanceof String);
        assertEquals("The return value of newly created BoundaryChangeEvent's getMessage"
                + "should equal with the message parameter of constructor.",
                message, event.getMessage());
    }
}
