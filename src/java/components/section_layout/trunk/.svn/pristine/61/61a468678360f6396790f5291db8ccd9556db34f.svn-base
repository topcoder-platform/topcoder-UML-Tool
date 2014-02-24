/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Point;

import javax.swing.JButton;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DialogFloatContainer;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapper;

/**
 * <p>
 * Failure test for <code>DialogFloatContainer</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class DialogFloatContainerFailureTest extends TestCase {

    /**
     * <p>
     * The DialogFloatContainer instance for testing.
     * </p>
     */
    private DialogFloatContainer container;

    /**
     * <p>
     * Set up the testing environment.
     * </p>
     */
    protected void setUp() {
        container =
            new DialogFloatContainer(new DefaultDock(new DockableWrapper(new JButton("Failure Test"))));
    }

    /**
     * <p>
     * Set up the testing environment.
     * </p>
     */
    protected void tearDown() {
        // empty
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDialogFloatContainer() {
        try {
            new DialogFloatContainer(null);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>canDock(Dock dock)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCanDock() {
        try {
            container.canDock(null);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDock() {
        try {
            container.dock(null);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointNull() {
        try {
            container.dock(null, new Point(1, 1));
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointNullDock() {
        try {
            container.dock(null, new Point(1, 1));
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointNullPoint() {
        try {
            container.dock(new DockImpl(), null);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the x of location is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointNegX() {
        try {
            container.dock(new DockImpl(), new Point(-1, 1));
            fail("the x of location is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the y of location is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointNegY() {
        try {
            container.dock(new DockImpl(), new Point(-1, 1));
            fail("the y of location is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, int index)</code>.
     * </p>
     *
     * <p>
     * the index is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockIntNullDock() {
        try {
            container.dock(null, 0);
            fail("the index is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointIntNullPoint() {
        try {
            container.dock(new DockImpl(), null, 1);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the x of location is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointIntNegX() {
        try {
            container.dock(new DockImpl(), new Point(-1, 1), 1);
            fail("the x of location is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the y of location is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointIntNegY() {
        try {
            container.dock(new DockImpl(), new Point(-1, 1), 1);
            fail("the y of location is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>undock(Dock dock)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testUndock() {
        try {
            container.undock(null);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>setLocation(Point location)</code>.
     * </p>
     *
     * <p>
     * the location is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetLocation() {
        try {
            container.setLocation(null);
            fail("the location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>setLocation(Point location)</code>.
     * </p>
     *
     * <p>
     * the x of the point is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetLocationNegX() {
        try {
            container.setLocation(new Point(-1, 1));
            fail("the x of the point is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the <code>setLocation(Point location)</code>.
     * </p>
     *
     * <p>
     * the y of the point is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testSetLocationNegY() {
        try {
            container.setLocation(new Point(1, -1));
            fail("the y of the point is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
