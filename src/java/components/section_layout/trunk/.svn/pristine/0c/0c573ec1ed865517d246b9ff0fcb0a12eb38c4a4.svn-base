/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.dock.dndimpl;

import java.awt.Point;
import java.lang.reflect.Field;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionDockContainer;
import com.topcoder.gui.sectionlayout.dock.Dock;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>DialogFloatContainer</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DialogFloatContainerTests extends TestCase {

    /**
     * <p>
     * The Dock instance for helping testing.
     * </p>
     */
    private Dock dock;

    /**
     * <p>
     * The DialogFloatContainer instance for helping testing.
     * </p>
     */
    private DialogFloatContainer container;

    /**
     * <p>
     * The SectionDockContainer instance for helping testing.
     * </p>
     */
    private SectionDockContainer previousContainer;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        dock = new DefaultDock(new Section(new JPanel()));
        container = new DialogFloatContainer(dock);
        previousContainer = new SectionDockContainer(new JPanel());
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
        previousContainer = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DialogFloatContainerTests.class);
    }

    /**
     * <p>
     * Tests DialogFloatContainer#DialogFloatContainer(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#DialogFloatContainer(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor() throws Exception {
        assertNotNull("The newly created DialogFloatContainer should not be null.", container);
        assertTrue("The container should be dock enabled.", container.isDockEnabled());
        Field field = BasicDockContainer.class.getDeclaredField("dockContainerHandler");
        field.setAccessible(true);
        assertNotNull("The dockContainerHandler should not be null.", field.get(container));
        field = DialogFloatContainer.class.getDeclaredField("dock");
        field.setAccessible(true);
        assertEquals("The dock should be equal.", dock, field.get(container));
    }

    /**
     * <p>
     * Tests DialogFloatContainer#DialogFloatContainer(Dock) for failure.
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
            new DialogFloatContainer(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#canDock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#canDock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCanDock() throws Exception {
        assertTrue("The dock can be docked.", container.canDock(dock));
        assertFalse("The dock can not be docked.",
                container.canDock(new DefaultDock(new DockableWrapper(new JPanel()))));
        container.dock(dock);
        assertFalse("The dock can not be docked.", container.canDock(dock));
        container.undock(dock);
        assertTrue("The dock can be docked.", container.canDock(dock));
    }

    /**
     * <p>
     * Tests DialogFloatContainer#canDock(Dock) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCanDock_Null() throws Exception {
        try {
            container.canDock(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#clearDockGesture() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#clearDockGesture() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testClearDockGesture() throws Exception {
        container.clearDockGesture();
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock1_Accuracy1() throws Exception {
        // if the dock can't be docked in this container, it will not be docked
        container.dock(new DefaultDock(new DockableWrapper(new JPanel())));
        assertFalse("The container should not be docked.", container.isDocked());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock1_Accuracy2() throws Exception {
        // dock this dock
        container.dock(dock);
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock1_Accuracy3() throws Exception {
        // dock the dock in previousContainer
        previousContainer.dock(dock);
        assertEquals("The dock's current dock container should be previousContainer.",
                previousContainer, dock.getCurrentDockContainer());
        // dock this dock
        container.dock(dock);
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        Field field = DialogFloatContainer.class.getDeclaredField("previousContainer");
        field.setAccessible(true);
        assertEquals("The dock's previous container should be previousContainer.",
                previousContainer, field.get(container));
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock1_Null() throws Exception {
        try {
            container.dock(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_Accuracy1() throws Exception {
        // if the dock can't be docked in this container, it will not be docked
        container.dock(new DefaultDock(new DockableWrapper(new JPanel())), new Point(10, 10));
        assertFalse("The container should not be docked.", container.isDocked());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_Accuracy2() throws Exception {
        // dock this dock
        container.dock(dock, new Point(10, 10));
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_Accuracy3() throws Exception {
        // dock the dock in previousContainer
        previousContainer.dock(dock);
        assertEquals("The dock's current dock container should be previousContainer.",
                previousContainer, dock.getCurrentDockContainer());
        // dock this dock
        container.dock(dock, new Point(10, 10));
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        Field field = DialogFloatContainer.class.getDeclaredField("previousContainer");
        field.setAccessible(true);
        assertEquals("The dock's previous container should be previousContainer.",
                previousContainer, field.get(container));
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dock is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_Dock_Null() throws Exception {
        try {
            container.dock(null, new Point(10, 10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when location is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_Location_Null() throws Exception {
        try {
            container.dock(dock, null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when x is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_X_Negative() throws Exception {
        try {
            container.dock(dock, new Point(-10, 10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when y is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_Y_Negative() throws Exception {
        try {
            container.dock(dock, new Point(10, -10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock3_Accuracy1() throws Exception {
        // if the dock can't be docked in this container, it will not be docked
        container.dock(new DefaultDock(new DockableWrapper(new JPanel())), 1);
        assertFalse("The container should not be docked.", container.isDocked());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock3_Accuracy2() throws Exception {
        // dock this dock
        container.dock(dock, 1);
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock3_Accuracy3() throws Exception {
        // dock the dock in previousContainer
        previousContainer.dock(dock);
        assertEquals("The dock's current dock container should be previousContainer.",
                previousContainer, dock.getCurrentDockContainer());
        // dock this dock
        container.dock(dock, 1);
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        Field field = DialogFloatContainer.class.getDeclaredField("previousContainer");
        field.setAccessible(true);
        assertEquals("The dock's previous container should be previousContainer.",
                previousContainer, field.get(container));
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock3_Null() throws Exception {
        try {
            container.dock(null, 1);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, Point, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Accuracy1() throws Exception {
        // if the dock can't be docked in this container, it will not be docked
        container.dock(new DefaultDock(new DockableWrapper(new JPanel())), new Point(10, 10), 1);
        assertFalse("The container should not be docked.", container.isDocked());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, Point, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Accuracy2() throws Exception {
        // dock this dock
        container.dock(dock, new Point(10, 10), 1);
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#dock(Dock, Point, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Accuracy3() throws Exception {
        // dock the dock in previousContainer
        previousContainer.dock(dock);
        assertEquals("The dock's current dock container should be previousContainer.",
                previousContainer, dock.getCurrentDockContainer());
        // dock this dock
        container.dock(dock, new Point(10, 10), 1);
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        Field field = DialogFloatContainer.class.getDeclaredField("previousContainer");
        field.setAccessible(true);
        assertEquals("The dock's previous container should be previousContainer.",
                previousContainer, field.get(container));
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dock is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Dock_Null() throws Exception {
        try {
            container.dock(null, new Point(10, 10), 1);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when location is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Location_Null() throws Exception {
        try {
            container.dock(dock, null, 1);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when x is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_X_Negative() throws Exception {
        try {
            container.dock(dock, new Point(-10, 10), 1);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#dock(Dock, Point, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when y is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Y_Negative() throws Exception {
        try {
            container.dock(dock, new Point(10, -10), 1);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#getCurrentDocks() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#getCurrentDocks() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetCurrentDocks() throws Exception {
        assertNotNull("The current docks should not be null.", container.getCurrentDocks());
        assertEquals("The current docks' size should be 0.", 0, container.getCurrentDocks().size());
        container.open();
        assertNotNull("The current docks should not be null.", container.getCurrentDocks());
        assertEquals("The current docks' size should be 1.", 1, container.getCurrentDocks().size());
        assertEquals("The current docks's first element should be dock.", dock, container.getCurrentDocks().get(0));
    }

    /**
     * <p>
     * Tests DialogFloatContainer#getDockTarget() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#getDockTarget() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockTarget() throws Exception {
        assertNotNull("The dock target should not be null.", container.getDockTarget());
        assertTrue("The dock target should be a JDialog.", container.getDockTarget() instanceof JDialog);
    }

    /**
     * <p>
     * Tests DialogFloatContainer#markDockGesture(Dock, Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#markDockGesture(Dock, Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMarkDockGesture() throws Exception {
        container.markDockGesture(dock, new Point(10, 10));
    }

    /**
     * <p>
     * Tests DialogFloatContainer#undock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#undock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndock() throws Exception {
        container.undock(dock); // nothing will happen
        container.dock(dock);
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        container.undock(dock);
        assertFalse("The container should not be docked.", container.isDocked());
        assertNull("The dock's current dock container should be null.", dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#undock(Dock) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUnock_Null() throws Exception {
        try {
            container.undock(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#close() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#close() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testClose() throws Exception {
        container.close(); // nothing will happen
        previousContainer.dock(dock);
        assertEquals("The dock's current dock container should be previousContainer.",
                previousContainer, dock.getCurrentDockContainer());
        // dock this dock
        container.dock(dock);
        assertTrue("The container should be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        // we have to set the index to non-negative value, because now the MockDockListener not really work well
        Field field = DialogFloatContainer.class.getDeclaredField("previousIndexInContainer");
        field.setAccessible(true);
        field.setInt(container, 0);
        container.close();
        assertFalse("The container should not be docked.", container.isDocked());
        assertEquals("The dock's current dock container should be previousContainer.",
                previousContainer, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#open() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#open() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testOpen() throws Exception {
        assertFalse("The dock target should not be visible.", container.getDockTarget().isVisible());
        container.open();
        assertTrue("The dock target should be visible.", container.getDockTarget().isVisible());
    }

    /**
     * <p>
     * Tests DialogFloatContainer#setLocation(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#setLocation(Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetLocation() throws Exception {
        container.setLocation(new Point(10, 10));
        assertEquals("The location should be equal.", 10, container.getDockTarget().getLocation().x);
        assertEquals("The location should be equal.", 10, container.getDockTarget().getLocation().y);
    }

    /**
     * <p>
     * Tests DialogFloatContainer#setLocation(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetLocation_Null() throws Exception {
        try {
            container.setLocation(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#setLocation(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when x is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetLocation_X_Negative() throws Exception {
        try {
            container.setLocation(new Point(-10, 10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#setLocation(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when y is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetLocation_Y_Negative() throws Exception {
        try {
            container.setLocation(new Point(10, -10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests DialogFloatContainer#isDocked() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the DialogFloatContainer#isDocked() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testIsDocked() throws Exception {
        assertFalse("The container should not be docked.", container.isDocked());
        container.dock(dock);
        assertTrue("The container should be docked.", container.isDocked());
    }
}
