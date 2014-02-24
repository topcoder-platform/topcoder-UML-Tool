/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.failuretests;

import java.awt.Container;
import java.awt.Point;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.gui.sectionlayout.SectionDockContainer;
import com.topcoder.gui.sectionlayout.dock.Dock;

/**
 * <p>
 * Failure test for <code>SectionDockContainer</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class SectionDockContainerFailureTest extends TestCase {
    /**
     * <p>
     * The SectionDockContainer instance for testing.
     * </p>
     */
    private SectionDockContainerSub container = new SectionDockContainerSub(new JFrame());

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the outerContainer is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSectionDockContainerContainer() {
        try {
            new SectionDockContainer(null);
            fail("the outerContainer is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for the constructor.
     * </p>
     *
     * <p>
     * the outerContainer is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testSectionDockContainerContainerBoolean() {
        try {
            new SectionDockContainer(null, true);
            fail("the outerContainer is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>dock(Dock dock)</code>.
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
     * Test for <code>dock(Dock dock, Point location)</code>.
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
     * Test for <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the location is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointNullPoint() {
        try {
            container.dock(new DockImpl(), null);
            fail("the location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the location is with -1 x, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointNegX() {
        try {
            container.dock(new DockImpl(), new Point(-1, 1));
            fail("the location is with -1 x, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>dock(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the location is with -1 y, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointNegY() {
        try {
            container.dock(new DockImpl(), new Point(1, -1));
            fail("the location is with -1 y, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>dock(Dock dock, int index)</code>.
     * </p>
     *
     * <p>
     * the index is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockInt() {
        try {
            container.dock(new DockImpl(), -1);
            fail("the index is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>dock(Dock dock, int index)</code>.
     * </p>
     *
     * <p>
     * the index is -1, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointIntNeg() {
        try {
            container.dock(new DockImpl(), null, -1);
            fail("the index is -1, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>dock(Dock dock, int index)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testDockDockPointInt() {
        try {
            container.dock(null, null, 0);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>undock(Dock dock)</code>.
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
     * Test for <code>markDockGesture(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the location is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testMarkDockGesture() {
        try {
            container.markDockGesture(new DockImpl(), null);
            fail("the location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>markDockGesture(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the location is with -1 x, IllegalArgumentException is expected.
     * </p>
     */
    public void testMarkDockGestureNegX() {
        try {
            container.markDockGesture(new DockImpl(), new Point(-1, 1));
            fail("the location is with -1 x, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>markDockGesture(Dock dock, Point location)</code>.
     * </p>
     *
     * <p>
     * the location is with -1 y, IllegalArgumentException is expected.
     * </p>
     */
    public void testMarkDockGestureNegY() {
        try {
            container.markDockGesture(new DockImpl(), new Point(1, -1));
            fail("the location is with -1 y, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test for <code>undockWithoutRepaint(Dock dock)</code>.
     * </p>
     *
     * <p>
     * the dock is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testUndockWithoutRepaint() {
        try {
            container.undockWithoutRepaint(null);
            fail("the dock is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * A mock sub-class of SectionDockContainer.
     * </p>
     *
     * @author restarter
     * @version 1.0
     */
    private class SectionDockContainerSub extends SectionDockContainer {
        /**
         * Constructor.
         *
         * @param outerContainer the native swing container to dock the other components
         * @throws IllegarlArgumentException if argument is null
         */
        public SectionDockContainerSub(Container outerContainer) {
            super(outerContainer);
        }

        /**
         * A mock implementation.
         *
         * @param location the dock need to dock at
         * @return the index calculated
         */
        public int calculateIndex(Point location) {
            return super.calculateIndex(location);
        }

        /**
         * Undock the dock without repainting current container.
         *
         * @param dock the dock to undock
         * @throws IlleagArgumentException if argument is null
         */
        public void undockWithoutRepaint(Dock dock) {
            super.undockWithoutRepaint(dock);
        }
    }
}
