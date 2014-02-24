/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock.dndimpl;

import java.awt.Point;
import java.lang.reflect.Field;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.MockDockListener;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>BasicDockContainer</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class BasicDockContainerTests extends TestCase {

    /**
     * <p>
     * The MockDockListener instance for helping testing.
     * </p>
     */
    private MockDockListener listener;

    /**
     * <p>
     * The BasicDockContainer instance for helping testing.
     * </p>
     */
    private BasicDockContainer container;

    /**
     * <p>
     * The Dock instance for helping testing.
     * </p>
     */
    private Dock dock;

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
        container = new DialogFloatContainer(new DefaultDock(new DockableWrapper(new JPanel())));
        dock = new DefaultDock(new DockableWrapper(new JPanel()));
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
        container = null;
        dock = null;
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
        return new TestSuite(BasicDockContainerTests.class);
    }

    /**
     * <p>
     * Tests BasicDockContainer#BasicDockContainer() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BasicDockContainer#BasicDockContainer() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created BasicDockContainer should not be null.", container);
        assertTrue("The container should be dock enabled.", container.isDockEnabled());
        Field field = BasicDockContainer.class.getDeclaredField("dockContainerHandler");
        field.setAccessible(true);
        assertNotNull("The dockContainerHandler should not be null.", field.get(container));
    }

    /**
     * <p>
     * Tests BasicDockContainer#addDockListener(DockListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BasicDockContainer#addDockListener(DockListener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testAddDockListener() throws Exception {
        assertNotNull("The listeners should not be null.", container.getDockListeners());
        assertEquals("The listeners' size should be 0.", 0, container.getDockListeners().size());
        container.addDockListener(listener);
        assertEquals("The listeners' size should be 1.", 1, container.getDockListeners().size());
    }

    /**
     * <p>
     * Tests BasicDockContainer#addDockListener(DockListener) for failure.
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
            container.addDockListener(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests BasicDockContainer#removeDockListener(DockListener) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BasicDockContainer#removeDockListener(DockListener) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testRemoveDockListener() throws Exception {
        assertNotNull("The listeners should not be null.", container.getDockListeners());
        assertEquals("The listeners' size should be 0.", 0, container.getDockListeners().size());
        container.addDockListener(listener);
        assertEquals("The listeners' size should be 1.", 1, container.getDockListeners().size());
        container.removeDockListener(listener);
        assertEquals("The listeners' size should be 0.", 0, container.getDockListeners().size());
    }

    /**
     * <p>
     * Tests BasicDockContainer#removeDockListener(DockListener) for failure.
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
            container.removeDockListener(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests BasicDockContainer#getDockListeners() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BasicDockContainer#getDockListeners() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockListeners() throws Exception {
        assertNotNull("The listeners should not be null.", container.getDockListeners());
        assertEquals("The listeners' size should be 0.", 0, container.getDockListeners().size());
        container.addDockListener(listener);
        assertEquals("The listeners' size should be 1.", 1, container.getDockListeners().size());
        container.removeDockListener(listener);
        assertEquals("The listeners' size should be 0.", 0, container.getDockListeners().size());
    }

    /**
     * <p>
     * Tests BasicDockContainer#fireDocked(DockEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BasicDockContainer#fireDocked(DockEvent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireDocked() throws Exception {
        assertFalse("The listener should not be docked.", listener.getDocked());
        container.addDockListener(listener);
        container.fireDocked(event);
        assertTrue("The listener should be docked.", listener.getDocked());
        container.fireUndocked(event);
        assertFalse("The listener should not be docked.", listener.getDocked());
    }

    /**
     * <p>
     * Tests BasicDockContainer#fireDocked(DockEvent) for failure.
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
            container.fireDocked(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests BasicDockContainer#fireUndocked(DockEvent) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BasicDockContainer#fireUndocked(DockEvent) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testFireUndocked() throws Exception {
        assertFalse("The listener should not be docked.", listener.getDocked());
        container.addDockListener(listener);
        container.fireDocked(event);
        assertTrue("The listener should be docked.", listener.getDocked());
        container.fireUndocked(event);
        assertFalse("The listener should not be docked.", listener.getDocked());
    }

    /**
     * <p>
     * Tests BasicDockContainer#fireUndocked(DockEvent) for failure.
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
            container.fireUndocked(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests BasicDockContainer#setDockEnabled(boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BasicDockContainer#setDockEnabled(boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetDockEnabled() throws Exception {
        assertTrue("The container should be dock enabled.", container.isDockEnabled());
        Field field = BasicDockContainer.class.getDeclaredField("dockContainerHandler");
        field.setAccessible(true);
        assertNotNull("The dockContainerHandler should not be null.", field.get(container));
        container.setDockEnabled(false);
        assertFalse("The container should not be dock enabled.", container.isDockEnabled());
        assertNull("The dockContainerHandler should be null.", field.get(container));
        container.setDockEnabled(false);
    }

    /**
     * <p>
     * Tests BasicDockContainer#isDockEnabled() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the BasicDockContainer#isDockEnabled() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsDockEnabled() throws Exception {
        assertTrue("The container should be dock enabled.", container.isDockEnabled());
        Field field = BasicDockContainer.class.getDeclaredField("dockContainerHandler");
        field.setAccessible(true);
        assertNotNull("The dockContainerHandler should not be null.", field.get(container));
        container.setDockEnabled(false);
        assertFalse("The container should not be dock enabled.", container.isDockEnabled());
        assertNull("The dockContainerHandler should be null.", field.get(container));
    }
}
