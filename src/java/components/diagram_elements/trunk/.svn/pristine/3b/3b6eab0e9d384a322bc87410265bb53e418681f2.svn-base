/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;

import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;

/**
 * Unit test for the <code>LocationEvent</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LocationEventUnitTests extends TestCase {

    /**
     * Represents the mock node used for test.
     */
    private class MockNode extends Node {

        /**
         * The default constructor.
         */
        public MockNode() {
            super(new GraphNode(), new Point(), new Rectangle(), new ArrayList<SelectionCornerType>());
        }

        /**
         * Simply returns false.
         *
         * @param event
         *            ignored
         * @return always false
         */
        protected boolean consumeEvent(MouseEvent event) {
            return false;
        }
    }

    /**
     * Represents the <code>Point</code> used for test.
     */
    private final Point oldLocation = new Point(200, 100);

    /**
     * Represents the <code>Point</code> used for test.
     */
    private final Point newLocation = new Point(100, 200);

    /**
     * Represents the <code>Node</code> used for test.
     */
    private final Node node = new MockNode();

    /**
     * Represents the <code>LocationEvent</code> instance used to test against.
     */
    private LocationEvent le = null;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        le = new LocationEvent(node, oldLocation, newLocation);
    }

    /**
     * Test for the inheritance, <code>LocationEvent</code> class should extend from the <code>EventObject</code>
     * class.
     */
    public void testInheritanceFromEventObject() {
        assertTrue("LocationEvent class should extend from the EventObject class.",
            EventObject.class.isAssignableFrom(LocationEvent.class));
    }

    /**
     * Test the constructor <code>LocationEvent(Node, Point, Point)</code> with null <code>node</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullNode() {
        try {
            new LocationEvent(null, oldLocation, newLocation);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>LocationEvent(Node, Point, Point)</code> with null <code>oldLocation</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullOldLocation() {
        try {
            new LocationEvent(node, null, newLocation);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>LocationEvent(Node, Point, Point)</code> with null <code>newLocation</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullNewLocation() {
        try {
            new LocationEvent(node, oldLocation, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the constructor <code>LocationEvent(Node, Point, Point)</code>, instance should be created,
     * all fields should be set.
     */
    public void testConstructorAccuracy() {
        LocationEvent event = new LocationEvent(node, oldLocation, newLocation);
        assertNotNull("LocationEvent instance should be created.", event);
        assertTrue("The source should be set.", event.getSource().equals(node));
        assertTrue("The oldLocation should be set.",
            TestHelper.getPrivateField(LocationEvent.class, event, "oldLocation").equals(oldLocation));
        assertTrue("The newLocation should be set.",
            TestHelper.getPrivateField(LocationEvent.class, event, "newLocation").equals(newLocation));
    }

    /**
     * Accuracy test for the method <code>getOldLocation()</code>, the value of <code>oldLocation</code> field should
     * be returned.
     */
    public void testGetOldLocationAccuracy() {
        assertTrue("The oldLocation field should be returned.", le.getOldLocation().equals(oldLocation));
    }

    /**
     * Accuracy test for the method <code>getNewLocation()</code>, the value of <code>newLocation</code> field should
     * be returned.
     */
    public void testGetNewLocationAccuracy() {
        assertTrue("The newLocation field should be returned.", le.getNewLocation().equals(newLocation));
    }

    /**
     * Accuracy test for the method <code>getOffset()</code>, the offset should be returned.
     */
    public void testGetOffsetAccuracy() {
        assertTrue("The offset should be returned.", le.getOffset().equals(new Point(-100, 100)));
    }
}
