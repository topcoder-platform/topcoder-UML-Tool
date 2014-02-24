/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComponent;

import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;

/**
 * Unit test for <code>SelectionCornerMouseListener</code> class.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SelectionCornerMouseListenerUnitTests extends TestCase {

    /**
     * Represents the mock node used for test.
     */
    private class MockNode extends Node {

        /**
         * Holds the passed in <code>SelectionBoundEvent</code> instance.
         */
        private SelectionBoundEvent passedinEvent = null;

        /**
         * The default constructor.
         */
        public MockNode() {
            super(new GraphNode(), new Point(), new Rectangle(1, 2, 3, 4), new ArrayList<SelectionCornerType>());
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

        /**
         * Notifies all listeners registered interest for edge drag event.
         *
         * @param e
         *            the selection bound event
         */
        public void fireCornerDrag(SelectionBoundEvent e) {
            passedinEvent = e;
        }

        /**
         * Gets the passed in <code>SelectionBoundEvent</code> instance.
         *
         * @return the passed in <code>SelectionBoundEvent</code> instance
         */
        public SelectionBoundEvent getPassedinEvent() {
            return passedinEvent;
        }
    }

    /**
     * Represents the <code>MouseEvent</code> instance with non-SelectionCorner source used for test.
     */
    private MouseEvent nonCornerEvent = null;

    /**
     * Represents the <code>MockNode</code> instance used for test.
     */
    private MockNode node = null;

    /**
     * Represents the <code>SelectionCornerMouseListener</code> instance used to test against.
     */
    private SelectionCornerMouseListener listener;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        node = new MockNode();
        listener = new SelectionCornerMouseListener(node);
        nonCornerEvent = new MouseEvent(node, 0, new Date().getTime(), 0, 5, 6, 0, false);
    }

    /**
     * Test for the inheritance, <code>SelectionCornerMouseListener</code> class should extend from the
     * <code>DragEventAdapter</code> class.
     */
    public void testInheritanceFromDragEventAdapter() {
        assertTrue("SelectionCornerMouseListener class should extend from the DragEventAdapter class.",
            DragEventAdapter.class.isAssignableFrom(SelectionCornerMouseListener.class));
    }

    /**
     * Test the constructor <code>SelectionCornerMouseListener(Node)</code> with null <code>node</code>,
     * IllegalArgumentException should be thrown.
     */
    public void testConstructorWithNull() {
        try {
            new SelectionCornerMouseListener(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Accuracy test for the constructor <code>SelectionCornerMouseListener(Node)</code>, instance should be created.
     */
    public void testConstructorAccuracy() {
        SelectionCornerMouseListener scml = new SelectionCornerMouseListener(node);
        assertNotNull("SelectionCornerMouseListener instance should be created.", scml);
        assertTrue("The node field should be set.",
            TestHelper.getPrivateField(SelectionCornerMouseListener.class, scml, "node").equals(node));
        assertNull("The lastPoint field should be null.",
            TestHelper.getPrivateField(DragEventAdapter.class, scml, "lastPoint"));
    }

    /**
     * Accuracy test for the <code>mousePressed(MouseEvent)</code> with null event, nothing should happen.
     */
    public void testMousePressedWithNullEventAccuracy() {
        listener.mousePressed(null);
        // nothing should happen
        assertTrue("The cursor should be left as default.",
            ((JComponent) nonCornerEvent.getSource()).getCursor().equals(Cursor.getDefaultCursor()));
    }

    /**
     * Accuracy test for the <code>mousePressed(MouseEvent)</code> with non-SelectionCorner source event, nothing
     * should happen.
     */
    public void testMousePressedWithNonSelectionCornerEventAccuracy() {
        listener.mousePressed(nonCornerEvent);
        // nothing should happen
        assertTrue("The cursor should be left as default.",
            ((JComponent) nonCornerEvent.getSource()).getCursor().equals(Cursor.getDefaultCursor()));
    }

    /**
     * Accuracy test for the <code>mousePressed(MouseEvent)</code> with SelectionCorner source event, the mouse cursor
     * should be changed.
     */
    public void testMousePressedWithSelectionCornerEventAccuracy() {
        // East
        SelectionCorner corner1 = new SelectionCorner(SelectionCornerType.EAST, new Point(100, 200));
        listener.mousePressed(new MouseEvent(corner1, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be set to E_RESIZE_CURSOR.",
            corner1.getCursor().equals(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)));
        // West
        SelectionCorner corner2 = new SelectionCorner(SelectionCornerType.WEST, new Point(100, 200));
        listener.mousePressed(new MouseEvent(corner2, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be set to W_RESIZE_CURSOR.",
            corner2.getCursor().equals(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR)));
        // North
        SelectionCorner corner3 = new SelectionCorner(SelectionCornerType.NORTH, new Point(100, 200));
        listener.mousePressed(new MouseEvent(corner3, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be set to N_RESIZE_CURSOR.",
            corner3.getCursor().equals(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR)));
        // South
        SelectionCorner corner4 = new SelectionCorner(SelectionCornerType.SOUTH, new Point(100, 200));
        listener.mousePressed(new MouseEvent(corner4, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be set to S_RESIZE_CURSOR.",
            corner4.getCursor().equals(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR)));
        // NorthEast
        SelectionCorner corner5 = new SelectionCorner(SelectionCornerType.NORTHEAST, new Point(100, 200));
        listener.mousePressed(new MouseEvent(corner5, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be set to NE_RESIZE_CURSOR.",
            corner5.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR)));
        // NorthWest
        SelectionCorner corner6 = new SelectionCorner(SelectionCornerType.NORTHWEST, new Point(100, 200));
        listener.mousePressed(new MouseEvent(corner6, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be set to NW_RESIZE_CURSOR.",
            corner6.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR)));
        // SouthEast
        SelectionCorner corner7 = new SelectionCorner(SelectionCornerType.SOUTHEAST, new Point(100, 200));
        listener.mousePressed(new MouseEvent(corner7, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be set to SE_RESIZE_CURSOR.",
            corner7.getCursor().equals(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR)));
        // SouthWest
        SelectionCorner corner8 = new SelectionCorner(SelectionCornerType.SOUTHWEST, new Point(100, 200));
        listener.mousePressed(new MouseEvent(corner8, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be set to SW_RESIZE_CURSOR.",
            corner8.getCursor().equals(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR)));
    }

    /**
     * Accuracy test for the <code>mouseReleased(MouseEvent)</code> with null event, nothing should happen.
     */
    public void testMouseReleasedWithNullEventAccuracy() {
        ((JComponent) nonCornerEvent.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        listener.mouseReleased(null);
        // nothing should happen
        assertTrue("The cursor should be left as E_RESIZE_CURSOR.",
            ((JComponent) nonCornerEvent.getSource()).getCursor().equals(
                Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)));
    }

    /**
     * Accuracy test for the <code>mouseReleased(MouseEvent)</code> with non-SelectionCorner source event, nothing
     * should happen.
     */
    public void testMouseReleasedWithNonSelectionCornerEventAccuracy() {
        ((JComponent) nonCornerEvent.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        listener.mouseReleased(nonCornerEvent);
        // nothing should happen
        assertTrue("The cursor should be left as E_RESIZE_CURSOR.",
            ((JComponent) nonCornerEvent.getSource()).getCursor().equals(
                Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)));
    }

    /**
     * Accuracy test for the <code>mouseReleased(MouseEvent)</code> with SelectionCorner source event, the mouse cursor
     * should be reset.
     */
    public void testMouseReleasedWithSelectionCornerEventAccuracy() {
        SelectionCorner corner = new SelectionCorner(SelectionCornerType.EAST, new Point(100, 200));
        corner.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        listener.mouseReleased(new MouseEvent(corner, 0, new Date().getTime(), 0, 100, 200, 0, false));
        assertTrue("The cursor should be reset.", corner.getCursor().equals(Cursor.getDefaultCursor()));
    }

    /**
     * Accuracy test for the <code>mouseDragged(MouseEvent)</code> with null event, nothing should happen.
     */
    public void testMouseDraggedWithNullEventAccuracy() {
        listener.mouseDragged(null);
        // nothing should happen
        assertNull("The event should not be fired.", node.getPassedinEvent());
    }

    /**
     * Accuracy test for the <code>mouseDragged(MouseEvent)</code> with non-SelectionCorner source event, nothing
     * should happen.
     */
    public void testMouseDraggedWithNonSelectionCornerEventAccuracy() {
        listener.mouseDragged(nonCornerEvent);
        // nothing should happen
        assertNull("The event should not be fired.", node.getPassedinEvent());
    }

    /**
     * Accuracy test for the method <code>mouseDragged(MouseEvent)</code> when the last point has not been set, nothing
     * should happen.
     */
    public void testMouseDraggedWithWhenNoLastPointAccuracy() {
        SelectionCorner corner = new SelectionCorner(SelectionCornerType.EAST, new Point(100, 200));
        listener.mouseDragged(new MouseEvent(corner, 0, new Date().getTime(), 0, 5, 6, 0, false));
        // nothing should happen
        assertNull("The event should not be fired.", node.getPassedinEvent());
    }

    /**
     * Accuracy test for the <code>mouseDragged(MouseEvent)</code> with SelectionCorner source event, listeners should
     * be fired.
     */
    public void testMouseDraggedWithSelectionCornerEventAccuracy() {
        // set the last point
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(7, 8));
        // East
        SelectionCorner corner1 = new SelectionCorner(SelectionCornerType.EAST, new Point(5, 5));
        listener.mouseDragged(new MouseEvent(corner1, 0, new Date().getTime(), 0, 5, 6, 0, false, MouseEvent.BUTTON1));
        assertTrue("The old bound should be set.",
            node.getPassedinEvent().getOldBound().equals(node.getSelectionBound()));
        assertTrue("The new bound should be set.",
            node.getPassedinEvent().getNewBound().equals(new Rectangle(1, 2, 1, 4)));
        assertTrue("The cursor should be set to E_RESIZE_CURSOR.",
            corner1.getCursor().equals(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR)));
        // set the last point
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(7, 8));
        // West
        SelectionCorner corner2 = new SelectionCorner(SelectionCornerType.WEST, new Point(5, 5));
        listener.mouseDragged(new MouseEvent(corner2, 0, new Date().getTime(), 0, 5, 6, 0, false, MouseEvent.BUTTON1));
        assertTrue("The old bound should be set.",
            node.getPassedinEvent().getOldBound().equals(node.getSelectionBound()));
        assertTrue("The new bound should be set.",
            node.getPassedinEvent().getNewBound().equals(new Rectangle(-1, 2, 5, 4)));
        assertTrue("The cursor should be set to W_RESIZE_CURSOR.",
            corner2.getCursor().equals(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR)));
        // set the last point
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(7, 8));
        // North
        SelectionCorner corner3 = new SelectionCorner(SelectionCornerType.NORTH, new Point(5, 5));
        listener.mouseDragged(new MouseEvent(corner3, 0, new Date().getTime(), 0, 5, 6, 0, false, MouseEvent.BUTTON1));
        assertTrue("The old bound should be set.",
            node.getPassedinEvent().getOldBound().equals(node.getSelectionBound()));
        assertTrue("The new bound should be set.",
            node.getPassedinEvent().getNewBound().equals(new Rectangle(1, 0, 3, 6)));
        assertTrue("The cursor should be set to N_RESIZE_CURSOR.",
            corner3.getCursor().equals(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR)));
        // set the last point
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(7, 8));
        // South
        SelectionCorner corner4 = new SelectionCorner(SelectionCornerType.SOUTH, new Point(5, 5));
        listener.mouseDragged(new MouseEvent(corner4, 0, new Date().getTime(), 0, 5, 6, 0, false, MouseEvent.BUTTON1));
        assertTrue("The old bound should be set.",
            node.getPassedinEvent().getOldBound().equals(node.getSelectionBound()));
        assertTrue("The new bound should be set.",
            node.getPassedinEvent().getNewBound().equals(new Rectangle(1, 2, 3, 2)));
        assertTrue("The cursor should be set to S_RESIZE_CURSOR.",
            corner4.getCursor().equals(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR)));
        // set the last point
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(7, 8));
        // NorthEast
        SelectionCorner corner5 = new SelectionCorner(SelectionCornerType.NORTHEAST, new Point(5, 5));
        listener.mouseDragged(new MouseEvent(corner5, 0, new Date().getTime(), 0, 5, 6, 0, false, MouseEvent.BUTTON1));
        assertTrue("The old bound should be set.",
            node.getPassedinEvent().getOldBound().equals(node.getSelectionBound()));
        assertTrue("The new bound should be set.",
            node.getPassedinEvent().getNewBound().equals(new Rectangle(1, 0, 1, 6)));
        assertTrue("The cursor should be set to NE_RESIZE_CURSOR.",
            corner5.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR)));
        // set the last point
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(7, 8));
        // NorthWest
        SelectionCorner corner6 = new SelectionCorner(SelectionCornerType.NORTHWEST, new Point(5, 5));
        listener.mouseDragged(new MouseEvent(corner6, 0, new Date().getTime(), 0, 5, 6, 0, false, MouseEvent.BUTTON1));
        assertTrue("The old bound should be set.",
            node.getPassedinEvent().getOldBound().equals(node.getSelectionBound()));
        assertTrue("The new bound should be set.",
            node.getPassedinEvent().getNewBound().equals(new Rectangle(-1, 0, 5, 6)));
        assertTrue("The cursor should be set to NW_RESIZE_CURSOR.",
            corner6.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR)));
        // set the last point
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(7, 8));
        // SouthEast
        SelectionCorner corner7 = new SelectionCorner(SelectionCornerType.SOUTHEAST, new Point(5, 5));
        listener.mouseDragged(new MouseEvent(corner7, 0, new Date().getTime(), 0, 5, 6, 0, false, MouseEvent.BUTTON1));
        assertTrue("The old bound should be set.",
            node.getPassedinEvent().getOldBound().equals(node.getSelectionBound()));
        assertTrue("The new bound should be set.",
            node.getPassedinEvent().getNewBound().equals(new Rectangle(1, 2, 1, 2)));
        assertTrue("The cursor should be set to SE_RESIZE_CURSOR.",
            corner7.getCursor().equals(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR)));
        // set the last point
        TestHelper.setPrivateField(DragEventAdapter.class, listener, "lastPoint", new Point(7, 8));
        // SouthWest
        SelectionCorner corner8 = new SelectionCorner(SelectionCornerType.SOUTHWEST, new Point(5, 5));
        listener.mouseDragged(new MouseEvent(corner8, 0, new Date().getTime(), 0, 5, 6, 0, false, MouseEvent.BUTTON1));
        assertTrue("The old bound should be set.",
            node.getPassedinEvent().getOldBound().equals(node.getSelectionBound()));
        assertTrue("The new bound should be set.",
            node.getPassedinEvent().getNewBound().equals(new Rectangle(-1, 2, 5, 2)));
        assertTrue("The cursor should be set to SW_RESIZE_CURSOR.",
            corner8.getCursor().equals(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR)));
    }
}
