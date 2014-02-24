/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Date;

import junit.framework.TestCase;

/**
 * Unit test for the <code>DragEventAdapter</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DragEventAdapterUnitTests extends TestCase {

    /**
     * Represents the mock drag event listener class used for test.
     */
    private class MockDragEventListener extends DragEventAdapter {

        /**
         * <p>
         * The default constructor.
         * </p>
         */
        public MockDragEventListener() {
            super();
        }

        /**
         * <p>
         * Handles the <code>MOUSE_DRAGGED</code> event.
         * </p>
         * <p>
         * No restriction on the given value, null is acceptable.
         * </p>
         *
         * @param e
         *            the mouse dragged event
         */
        public void mouseDragged(MouseEvent e) {
        }

        /**
         * <p>
         * Gets the last mouse drag point.
         * </p>
         * <p>
         * The returned value can be null if the <code>lastPoint</code> field has not been set.
         * </p>
         *
         * @return the last mouse drag point
         */
        public Point getLastPoint() {
            return super.getLastPoint();
        }

        /**
         * <p>
         * Sets the last mouse drag point.
         * </p>
         * <p>
         * No restriction on the given value, null is acceptable.
         * </p>
         *
         * @param lastPoint
         *            the new last mouse drag point
         */
        public void setLastPoint(Point lastPoint) {
            super.setLastPoint(lastPoint);
        }
    }

    /**
     * Represents the <code>MockDragEventListener</code> instance used to test against.
     */
    private MockDragEventListener listener = null;

    /**
     * Represents the <code>Point</code> instance used for test.
     */
    private final Point point = new Point();

    /**
     * Represents the <code>MouseEvent</code> instance used for test.
     */
    private final MouseEvent event = new MouseEvent(new SelectionCorner(SelectionCornerType.EAST, new Point(5, 5)), 0,
        new Date().getTime(), 0, 100, 200, 0, false);

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        listener = new MockDragEventListener();
    }

    /**
     * Test for the inheritance, <code>DragEventAdapter</code> class should extend from the <code>MouseAdapter</code>
     * class.
     */
    public void testInheritanceFromMouseAdapter() {
        assertTrue("DragEventAdapter class should extend from the MouseAdapter class.",
            MouseAdapter.class.isAssignableFrom(DragEventAdapter.class));
    }

    /**
     * Test for the inheritance, <code>DragEventAdapter</code> class should implement the
     * <code>MouseMotionListener</code> interface.
     */
    public void testInheritanceFromMouseMotionListener() {
        assertTrue("DragEventAdapter class should implement the MouseMotionListener interface.",
            MouseMotionListener.class.isAssignableFrom(DragEventAdapter.class));
    }

    /**
     * Accuracy test for the constructor <code>DragEventAdapter()</code>, instance should be created.
     */
    public void testConstructor() {
        DragEventAdapter dea = new MockDragEventListener();
        assertNotNull("DragEventAdapter instance should be created.", dea);
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, dea, "lastPoint"));
    }

    /**
     * Accuracy test for the method <code>getLastPoint()</code>, the value of <code>lastPoint</code> field should
     * be returned.
     */
    public void testGetLastPoint() {
        assertNull("The returned last point should be null.", listener.getLastPoint());
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", point);
        assertTrue("The returned last point should be correct.", listener.getLastPoint().equals(point));
    }

    /**
     * Accuracy test for the method <code>setLastPoint(Point)</code>, the value of <code>lastPoint</code> field
     * should be set.
     */
    public void testSetLastPoint() {
        listener.setLastPoint(point);
        assertTrue("The lastPoint field should be set.",
            TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint").equals(point));
        // null is acceptable
        listener.setLastPoint(null);
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint"));
    }

    /**
     * Accuracy test for the method <code>mousePressed(MouseEvent)</code> with null event, nothing should be done.
     */
    public void testMousePressedWithNull() {
        listener.mousePressed(null);
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint"));
    }

    /**
     * Accuracy test for the method <code>mousePressed(MouseEvent)</code> with non-null event, the value of
     * <code>lastPoint</code> field should be set.
     */
    public void testMousePressedWithEvent() {
        listener.mousePressed(event);
        Point lastPoint = (Point) TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint");
        assertTrue("The lastPoint field should be set.", lastPoint.equals(new Point(100, 200)));
    }

    /**
     * Accuracy test for the method <code>mouseMoved(MouseEvent)</code> with null event, nothing should be done.
     */
    public void testMouseMovedWithNull() {
        listener.mouseMoved(null);
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint"));
    }

    /**
     * Accuracy test for the method <code>mouseMoved(MouseEvent)</code> with non-null event, nothing should be done.
     */
    public void testMouseMovedWithEvent() {
        listener.mouseMoved(event);
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, listener, "lastPoint"));
    }
}
