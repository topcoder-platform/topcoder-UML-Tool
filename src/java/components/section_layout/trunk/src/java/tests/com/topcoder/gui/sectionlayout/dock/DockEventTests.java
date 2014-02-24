/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock;

import java.awt.Point;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.SectionDockContainer;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>DockEvent</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DockEventTests extends TestCase {

    /**
     * <p>
     * The Dock instance for helping testing.
     * </p>
     */
    private Dock dock;

    /**
     * <p>
     * The DockContainer instance for helping testing.
     * </p>
     */
    private DockContainer container;

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
        dock = new DefaultDock(new DockableWrapper(new JPanel()));
        container = new SectionDockContainer(new JPanel());
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
        return new TestSuite(DockEventTests.class);
    }

    /**
     * <p>
     * Tests DockEvent#DockEvent(Dock, DockContainer, Point, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockEvent#DockEvent(Dock, DockContainer, Point, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created DockEvent should not be null.", event);
        assertEquals("The dock should be equal.", dock, event.getDock());
        assertEquals("The container should be equal.", container, event.getContainer());
        assertEquals("The location should be equal.", location, event.getLocation());
        assertEquals("The index should be equal.", index, event.getIndex());
    }

    /**
     * <p>
     * Tests DockEvent#DockEvent(Dock, DockContainer, Point, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dock is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Dock_Null() throws Exception {
        try {
            new DockEvent(null, container, location, index);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DockEvent#DockEvent(Dock, DockContainer, Point, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when container is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor_Container_Null() throws Exception {
        try {
            new DockEvent(dock, null, location, index);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DockEvent#getDock() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockEvent#getDock() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDock() throws Exception {
        assertEquals("The dock should be equal.", dock, event.getDock());
    }

    /**
     * <p>
     * Tests DockEvent#getContainer() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockEvent#getContainer() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetContainer() throws Exception {
        assertEquals("The container should be equal.", container, event.getContainer());
    }

    /**
     * <p>
     * Tests DockEvent#getLocation() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockEvent#getLocation() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetLocation() throws Exception {
        assertEquals("The location should be equal.", location, event.getLocation());
    }

    /**
     * <p>
     * Tests DockEvent#getIndex() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DockEvent#getIndex() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetIndex() throws Exception {
        assertEquals("The index should be equal.", index, event.getIndex());
    }
}
