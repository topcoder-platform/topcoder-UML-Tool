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
 * Unit test for <code>SelectionBoundEvent</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SelectionBoundEventUnitTests extends TestCase {

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
     * Represents the <code>Rectangle</code> used for test.
     */
    private final Rectangle newBound = new Rectangle(1, 2, 3, 4);

    /**
     * Represents the <code>Rectangle</code> used for test.
     */
    private final Rectangle oldBound = new Rectangle(40, 30, 20, 10);

    /**
     * Represents the <code>Node</code> used for test.
     */
    private final Node node = new MockNode();

    /**
     * Represents the <code>SelectionBoundEvent</code> instance used to test against.
     */
    private SelectionBoundEvent sbe = null;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        sbe = new SelectionBoundEvent(node, oldBound, newBound);
    }

    /**
     * Test for the inheritance, <code>SelectionBoundEvent</code> class should extend from the <code>EventObject</code>
     * class.
     */
    public void testInheritanceFromEventObject() {
        assertTrue("SelectionBoundEvent class should extend from the EventObject class.",
            EventObject.class.isAssignableFrom(SelectionBoundEvent.class));
    }

    /**
     * Test the constructor <code>SelectionBoundEvent(Node, Rectangle, Rectangle)</code> with null <code>node</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullNode() {
        try {
            new SelectionBoundEvent(null, oldBound, newBound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test constructor <code>SelectionBoundEvent(Node, Rectangle, Rectangle)</code> with null <code>oldBound</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullOldBound() {
        try {
            new SelectionBoundEvent(node, null, newBound);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test constructor <code>SelectionBoundEvent(Node, Rectangle, Rectangle)</code> with null <code>newBound</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNullNewBound() {
        try {
            new SelectionBoundEvent(node, oldBound, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the constructor <code>SelectionBoundEvent(Node, Rectangle, Rectangle)</code>, instance should
     * be created, all fields should be set.
     */
    public void testConstructorAccuracy() {
        SelectionBoundEvent event = new SelectionBoundEvent(node, oldBound, newBound);
        assertNotNull("SelectionBoundEvent instance should be created.", event);
        assertTrue("The source should be set.", event.getSource().equals(node));
        assertTrue("The oldBound should be set.",
            TestHelper.getPrivateField(SelectionBoundEvent.class, event, "oldBound").equals(oldBound));
        assertTrue("The newBound should be set.",
            TestHelper.getPrivateField(SelectionBoundEvent.class, event, "newBound").equals(newBound));
    }

    /**
     * Accuracy test for the method <code>getOldBound()</code>, the value of <code>oldBound</code> field should be
     * returned.
     */
    public void testGetOldBoundAccuracy() {
        assertTrue("The oldBound field should be returned.", sbe.getOldBound().equals(oldBound));
    }

    /**
     * Accuracy test for the method <code>getNewBound()</code>, the value of <code>newBound</code> field should be
     * returned.
     */
    public void testGetNewBoundAccuracy() {
        assertTrue("The newBound field should be returned.", sbe.getNewBound().equals(newBound));
    }

    /**
     * Accuracy test for the method <code>getNorthOffset()</code>, the correct offset should be returned.
     */
    public void testGetNorthOffsetAccuracy() {
        assertTrue("The correct offset should be returned.", sbe.getNorthOffset() == -28);
    }

    /**
     * Accuracy test for the method <code>getSouthOffset()</code>, the correct offset should be returned.
     */
    public void testGetSouthOffsetAccuracy() {
        assertTrue("The correct offset should be returned.", sbe.getSouthOffset() == -34);
    }

    /**
     * Accuracy test for the method <code>getWestOffset()</code>, the correct offset should be returned.
     */
    public void testGetWestOffsetAccuracy() {
        assertTrue("The correct offset should be returned.", sbe.getWestOffset() == -39);
    }

    /**
     * Accuracy test for the method <code>getEastOffset()</code>, the correct offset should be returned.
     */
    public void testGetEastOffsetAccuracy() {
        assertTrue("The correct offset should be returned.", sbe.getEastOffset() == -56);
    }
}
