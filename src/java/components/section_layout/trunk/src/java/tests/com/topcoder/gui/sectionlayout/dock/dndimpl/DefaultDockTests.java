/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock.dndimpl;

import java.awt.Cursor;
import java.awt.Point;
import java.lang.reflect.Field;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.Dockable;
import com.topcoder.gui.sectionlayout.dock.MockDockListener;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>DefaultDock</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultDockTests extends TestCase {

    /**
     * <p>
     * The MockDockListener instance for helping testing.
     * </p>
     */
    private MockDockListener listener;

    /**
     * <p>
     * The Dockable instance for helping testing.
     * </p>
     */
    private Dockable dockable;

    /**
     * <p>
     * The DefaultDock instance for helping testing.
     * </p>
     */
    private DefaultDock dock;

    /**
     * <p>
     * The BasicDockContainer instance for helping testing.
     * </p>
     */
    private BasicDockContainer container;

    /**
     * <p>
     * The Point instance for helping testing.
     * </p>
     */
    private Point location;

    /**
     * <p>
     * The int value for helping testing.
     * </p>
     */
    private int index;

    /**
     * <p>
     * The DockEvent instance for helping testing.
     * </p>
     */
    private DockEvent event;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        listener = new MockDockListener();
        dockable = new DockableWrapper(new JPanel());
        dock = new DefaultDock(dockable);
        container = new DialogFloatContainer(dock);
        location = new Point(10, 10);
        index = 1;
        event = new DockEvent(dock, container, location, index);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        listener = null;
        dockable = null;
        dock = null;
        container = null;
        location = null;
        index = -1;
        event = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DefaultDockTests.class);
    }

    /**
     * <p>
     * Tests DefaultDock#DefaultDock(Dockable) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#DefaultDock(Dockable) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created DefaultDock should not be null.", dock);
        assertEquals("The dockable should be equal.", dockable, dock.getDockable());
        assertTrue("The dock should be drag enabled.", dock.isDragEnabled());
        Field field = DefaultDock.class.getDeclaredField("dockHandler");
        field.setAccessible(true);
        assertNotNull("The dockHandler should not be null.", field.get(dock));
    }

    /**
     * <p>
     * Tests DefaultDock#DefaultDock(Dockable) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Null() throws Exception {
        try {
            new DefaultDock(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#getDockable() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#getDockable() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockable() throws Exception {
        assertEquals("The dockable should be equal.", dockable, dock.getDockable());
    }

    /**
     * <p>
     * Tests DefaultDock#floatTo(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#floatTo(Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFloatTo() throws Exception {
        dock.setDragStartLocation(new Point(3, 3));
        dock.floatTo(new Point(10, 10));
        Field field = DefaultDock.class.getDeclaredField("floatContainer");
        field.setAccessible(true);
        Object floatContainer = field.get(dock);
        assertNotNull("The floatContainer should not be null.", floatContainer);
        assertEquals("The current container of this dock should be floatContainer.",
                floatContainer, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DefaultDock#floatTo(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFloatTo_Null() throws Exception {
        try {
            dock.setDragStartLocation(new Point(3, 3));
            dock.floatTo(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#floatTo(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when x is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFloatTo_X_Negative() throws Exception {
        try {
            dock.setDragStartLocation(new Point(3, 3));
            dock.floatTo(new Point(-10, 10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#floatTo(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when y is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFloatTo_Y_Negative() throws Exception {
        try {
            dock.setDragStartLocation(new Point(3, 3));
            dock.floatTo(new Point(10, -10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#floatTo(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dragStartLocation is null and expects IllegalStateException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFloatTo_IllegalState() throws Exception {
        try {
            dock.floatTo(new Point(3, 3));
            fail("ISE should be thrown.");
        } catch (IllegalStateException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#setDragEnabled(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#setDragEnabled(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetDragEnabled() throws Exception {
        assertTrue("The dock should be drag enabled.", dock.isDragEnabled());
        Field field = DefaultDock.class.getDeclaredField("dockHandler");
        field.setAccessible(true);
        assertNotNull("The dockHandler should not be null.", field.get(dock));
        dock.setDragEnabled(false);
        assertFalse("The dock should not be drag enabled.", dock.isDragEnabled());
        assertNull("The dockHandler should be null.", field.get(dock));
        dock.setDragEnabled(false);
    }

    /**
     * <p>
     * Tests DefaultDock#isDragEnabled() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#isDragEnabled() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsDragEnabled() throws Exception {
        assertTrue("The dock should be drag enabled.", dock.isDragEnabled());
        Field field = DefaultDock.class.getDeclaredField("dockHandler");
        field.setAccessible(true);
        assertNotNull("The dockHandler should not be null.", field.get(dock));
        dock.setDragEnabled(false);
        assertFalse("The dock should not be drag enabled.", dock.isDragEnabled());
        assertNull("The dockHandler should be null.", field.get(dock));
        dock.setDragEnabled(false);
    }

    /**
     * <p>
     * Tests DefaultDock#getGestureCursor() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#getGestureCursor() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetGestureCursor() throws Exception {
        assertNull("The gesture cursor should be null.", dock.getGestureCursor());
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        dock.setGestureCursor(cursor);
        assertEquals("The gesture cursor should be equal.", cursor, dock.getGestureCursor());
    }

    /**
     * <p>
     * Tests DefaultDock#setGestureCursor(Cursor) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#setGestureCursor(Cursor) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetGestureCursor() throws Exception {
        assertNull("The gesture cursor should be null.", dock.getGestureCursor());
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        dock.setGestureCursor(cursor);
        assertEquals("The gesture cursor should be equal.", cursor, dock.getGestureCursor());
    }

    /**
     * <p>
     * Tests DefaultDock#setFloatable(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#setFloatable(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetFloatable() throws Exception {
        assertTrue("The dock should be floatable.", dock.isFloatable());
        dock.setFloatable(false);
        assertFalse("The dock should not be floatable.", dock.isFloatable());

        dock.setFloatable(true);
        dock.setDragStartLocation(new Point(3, 3));
        dock.floatTo(new Point(10, 10));
        Field field = DefaultDock.class.getDeclaredField("floatContainer");
        field.setAccessible(true);
        Object floatContainer = field.get(dock);
        assertNotNull("The floatContainer should not be null.", floatContainer);
        assertEquals("The current container of this dock should be floatContainer.",
                floatContainer, dock.getCurrentDockContainer());
        dock.setFloatable(false);
        assertNull("The current container of this dock should be null.", dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DefaultDock#isFloatable() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#isFloatable() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsFloatable() throws Exception {
        assertTrue("The dock should be floatable.", dock.isFloatable());
        dock.setFloatable(false);
        assertFalse("The dock should not be floatable.", dock.isFloatable());
    }

    /**
     * <p>
     * Tests DefaultDock#setDragStartLocation(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#setDragStartLocation(Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetDragStartLocation() throws Exception {
        assertNull("The drag start location should be null.", dock.getDragStartLocation());
        dock.setDragStartLocation(location);
        assertEquals("The drag start location should be equal.", location, dock.getDragStartLocation());
    }

    /**
     * <p>
     * Tests DefaultDock#getDragStartLocation() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#getDragStartLocation() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDragStartLocation() throws Exception {
        assertNull("The drag start location should be null.", dock.getDragStartLocation());
        dock.setDragStartLocation(location);
        assertEquals("The drag start location should be equal.", location, dock.getDragStartLocation());
    }

    /**
     * <p>
     * Tests DefaultDock#addDockListener(DockListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#addDockListener(DockListener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddDockListener() throws Exception {
        assertNotNull("The listeners should not be null.", dock.getDockListeners());
        assertEquals("The listeners' size should be 0.", 0, dock.getDockListeners().size());
        dock.addDockListener(listener);
        assertEquals("The listeners' size should be 1.", 1, dock.getDockListeners().size());
    }

    /**
     * <p>
     * Tests DefaultDock#addDockListener(DockListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddDockListener_Null() throws Exception {
        try {
            dock.addDockListener(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#removeDockListener(DockListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#removeDockListener(DockListener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemoveDockListener() throws Exception {
        assertNotNull("The listeners should not be null.", dock.getDockListeners());
        assertEquals("The listeners' size should be 0.", 0, dock.getDockListeners().size());
        dock.addDockListener(listener);
        assertEquals("The listeners' size should be 1.", 1, dock.getDockListeners().size());
        dock.removeDockListener(listener);
        assertEquals("The listeners' size should be 0.", 0, dock.getDockListeners().size());
    }

    /**
     * <p>
     * Tests DefaultDock#removeDockListener(DockListener) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemoveDockListener_Null() throws Exception {
        try {
            dock.removeDockListener(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#getDockListeners() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#getDockListeners() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockListeners() throws Exception {
        assertNotNull("The listeners should not be null.", dock.getDockListeners());
        assertEquals("The listeners' size should be 0.", 0, dock.getDockListeners().size());
        dock.addDockListener(listener);
        assertEquals("The listeners' size should be 1.", 1, dock.getDockListeners().size());
        dock.removeDockListener(listener);
        assertEquals("The listeners' size should be 0.", 0, dock.getDockListeners().size());
    }

    /**
     * <p>
     * Tests DefaultDock#fireDocked(DockEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#fireDocked(DockEvent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireDocked() throws Exception {
        assertFalse("The listener should not be docked.", listener.getDocked());
        dock.addDockListener(listener);
        dock.fireDocked(event);
        assertEquals("The current container should be equal.", container, dock.getCurrentDockContainer());
        assertEquals("The current location in container should be equal.",
                location, dock.getCurrentLocationInContainer());
        assertEquals("The current index in container should be equal.",
                index, dock.getCurrentIndexInContainer());
        assertTrue("The listener should be docked.", listener.getDocked());
        dock.fireUndocked(event);
        assertNull("The current container should be null.", dock.getCurrentDockContainer());
        assertNull("The current location in container should be null.", dock.getCurrentLocationInContainer());
        assertEquals("The current index in container should be -1.", -1, dock.getCurrentIndexInContainer());
        assertFalse("The listener should not be docked.", listener.getDocked());
    }

    /**
     * <p>
     * Tests DefaultDock#fireDocked(DockEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireDocked_Null() throws Exception {
        try {
            dock.fireDocked(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#fireUndocked(DockEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#fireUndocked(DockEvent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireUndocked() throws Exception {
        assertFalse("The listener should not be docked.", listener.getDocked());
        dock.addDockListener(listener);
        dock.fireDocked(event);
        assertEquals("The current container should be equal.", container, dock.getCurrentDockContainer());
        assertEquals("The current location in container should be equal.",
                location, dock.getCurrentLocationInContainer());
        assertEquals("The current index in container should be equal.",
                index, dock.getCurrentIndexInContainer());
        assertTrue("The listener should be docked.", listener.getDocked());
        dock.fireUndocked(event);
        assertNull("The current container should be null.", dock.getCurrentDockContainer());
        assertNull("The current location in container should be null.", dock.getCurrentLocationInContainer());
        assertEquals("The current index in container should be -1.", -1, dock.getCurrentIndexInContainer());
        assertFalse("The listener should not be docked.", listener.getDocked());
    }

    /**
     * <p>
     * Tests DefaultDock#fireUndocked(DockEvent) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireUndocked_Null() throws Exception {
        try {
            dock.fireUndocked(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DefaultDock#getCurrentDockContainer() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#getCurrentDockContainer() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetCurrentDockContainer() throws Exception {
        dock.fireDocked(event);
        assertEquals("The current container should be equal.", container, dock.getCurrentDockContainer());
        dock.fireUndocked(event);
        assertNull("The current container should be null.", dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DefaultDock#getCurrentLocationInContainer() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#getCurrentLocationInContainer() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetCurrentLocationInContainer() throws Exception {
        dock.fireDocked(event);
        assertEquals("The current location in container should be equal.",
                location, dock.getCurrentLocationInContainer());
        dock.fireUndocked(event);
        assertNull("The current location in container should be null.", dock.getCurrentLocationInContainer());
    }

    /**
     * <p>
     * Tests DefaultDock#getCurrentIndexInContainer() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DefaultDock#getCurrentIndexInContainer() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetCurrentIndexInContainer() throws Exception {
        dock.fireDocked(event);
        assertEquals("The current index in container should be equal.",
                index, dock.getCurrentIndexInContainer());
        dock.fireUndocked(event);
        assertEquals("The current index in container should be -1.", -1, dock.getCurrentIndexInContainer());
    }
}
