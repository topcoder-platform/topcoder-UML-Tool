/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

import java.awt.Color;
import java.awt.Point;
import java.lang.reflect.Field;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.BasicDockContainer;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DialogFloatContainer;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * Unit test cases for <code>SectionDockContainer</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SectionDockContainerTests extends TestCase {

    /**
     * <p>
     * The Dock instance for helping testing.
     * </p>
     */
    private Dock dock;

    /**
     * <p>
     * The SectionDockContainer instance for helping testing.
     * </p>
     */
    private SectionDockContainer container;

    /**
     * <p>
     * The DialogFloatContainer instance for helping testing.
     * </p>
     */
    private DialogFloatContainer previousContainer;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.configUIManager();

        dock = new DefaultDock(new Section(new JPanel()));
        container = new SectionDockContainer(new JPanel());
        previousContainer = new DialogFloatContainer(dock);
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
        return new TestSuite(SectionDockContainerTests.class);
    }

    /**
     * <p>
     * Tests SectionDockContainer#SectionDockContainer(Container) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#SectionDockContainer(Container) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1() throws Exception {
        assertNotNull("The newly created SectionDockContainer should not be null.", container);
        assertTrue("The container should be dock enabled.", container.isDockEnabled());
        Field field = BasicDockContainer.class.getDeclaredField("dockContainerHandler");
        field.setAccessible(true);
        assertNotNull("The dockContainerHandler should not be null.", field.get(container));
        field = SectionDockContainer.class.getDeclaredField("vertical");
        field.setAccessible(true);
        assertTrue("The vertical should be true.", field.getBoolean(container));
    }

    /**
     * <p>
     * Tests SectionDockContainer#SectionDockContainer(Container) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor1_Null() throws Exception {
        try {
            new SectionDockContainer(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionDockContainer#SectionDockContainer(Container, boolean) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#SectionDockContainer(Container, boolean) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2() throws Exception {
        // vertical
        container = new SectionDockContainer(new JPanel(), true);
        assertNotNull("The newly created SectionDockContainer should not be null.", container);
        assertTrue("The container should be dock enabled.", container.isDockEnabled());
        Field field = BasicDockContainer.class.getDeclaredField("dockContainerHandler");
        field.setAccessible(true);
        assertNotNull("The dockContainerHandler should not be null.", field.get(container));
        field = SectionDockContainer.class.getDeclaredField("vertical");
        field.setAccessible(true);
        assertTrue("The vertical should be true.", field.getBoolean(container));

        // not vertical
        container = new SectionDockContainer(new JPanel(), false);
        assertNotNull("The newly created SectionDockContainer should not be null.", container);
        assertTrue("The container should be dock enabled.", container.isDockEnabled());
        field = BasicDockContainer.class.getDeclaredField("dockContainerHandler");
        field.setAccessible(true);
        assertNotNull("The dockContainerHandler should not be null.", field.get(container));
        field = SectionDockContainer.class.getDeclaredField("vertical");
        field.setAccessible(true);
        assertFalse("The vertical should be false.", field.getBoolean(container));
    }

    /**
     * <p>
     * Tests SectionDockContainer#SectionDockContainer(Container, boolean) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCtor2_Null() throws Exception {
        try {
            new SectionDockContainer(null, false);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionDockContainer#canDock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#canDock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCanDock() throws Exception {
        assertFalse("Null can not be docked.", container.canDock(null));
        assertFalse("The dock can not be docked.",
                container.canDock(new DefaultDock(new DockableWrapper(new JPanel()))));
        container = new SectionDockContainer(new JPanel(), false);
        assertFalse("The dock can not be docked.", container.canDock(dock));
        container = new SectionDockContainer(new JPanel(), true);
        assertTrue("The dock can be docked.", container.canDock(dock));
    }

    /**
     * <p>
     * Tests SectionDockContainer#getDockSize() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#getDockSize() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockSize() throws Exception {
        assertEquals("The dock size should be 0.", 0, container.getDockSize());
        container.dock(dock);
        assertEquals("The dock size should be 1.", 1, container.getDockSize());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock1_Accuracy1() throws Exception {
        // if the dock can't be docked in this container, it will not be docked
        container.dock(new DefaultDock(new DockableWrapper(new JPanel())));
        assertEquals("The container should not be docked.", 0, container.getDockSize());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock1_Accuracy2() throws Exception {
        // dock this dock
        container.dock(dock);
        assertEquals("The container should not be docked.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock) is correct.
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
        assertEquals("The container should not be docked.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock) for failure.
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
     * Tests SectionDockContainer#dock(Dock, Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_Accuracy1() throws Exception {
        // if the dock can't be docked in this container, it will not be docked
        container.dock(new DefaultDock(new DockableWrapper(new JPanel())), new Point(3, 3));
        assertEquals("The container should not be docked.", 0, container.getDockSize());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock2_Accuracy2() throws Exception {
        // dock this dock
        container.dock(dock, new Point(3, 3));
        assertEquals("The container should not be docked.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        // the location is invalid, so it will not be docked
        container.dock(dock, new Point(300, 300));
        assertEquals("The container should not be docked.", 1, container.getDockSize());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, Point) is correct.
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
        container.dock(dock, new Point(3, 3));
        assertEquals("The container should not be docked.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, Point) for failure.
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
     * Tests SectionDockContainer#dock(Dock, Point) for failure.
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
     * Tests SectionDockContainer#dock(Dock, Point) for failure.
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
     * Tests SectionDockContainer#dock(Dock, Point) for failure.
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
     * Tests SectionDockContainer#dock(Dock, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock3_Accuracy1() throws Exception {
        // if the dock can't be docked in this container, it will not be docked
        container.dock(new DefaultDock(new DockableWrapper(new JPanel())), 0);
        assertEquals("The container should not be docked.", 0, container.getDockSize());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock3_Accuracy2() throws Exception {
        // dock this dock
        container.dock(dock, 0);
        assertEquals("The container should not be docked.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        // if dock already in the docks and with same index, it will not be docked
        container.dock(dock, 0);
        assertEquals("The container should not be docked.", 1, container.getDockSize());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, int) is correct.
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
        container.dock(dock, 0);
        assertEquals("The container should not be docked.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, int) for failure.
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
     * Tests SectionDockContainer#dock(Dock, Point, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, Point, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Accuracy1() throws Exception {
        // if the dock can't be docked in this container, it will not be docked
        container.dock(new DefaultDock(new DockableWrapper(new JPanel())), new Point(3, 3), 0);
        assertEquals("The container should not be docked.", 0, container.getDockSize());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, Point, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, Point, int) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Accuracy2() throws Exception {
        // dock this dock
        container.dock(dock, new Point(3, 3), 0);
        assertEquals("The container should not be docked.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        // if dock already in the docks and with same index, it will not be docked
        container.dock(dock, new Point(3, 3), 0);
        assertEquals("The container should not be docked.", 1, container.getDockSize());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, Point, int) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#dock(Dock, Point, int) is correct.
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
        container.dock(dock, new Point(3, 3), 0);
        assertEquals("The container should not be docked.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests SectionDockContainer#dock(Dock, Point, int) for failure.
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
     * Tests SectionDockContainer#dock(Dock, Point, int) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when index is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDock4_Index_Negative() throws Exception {
        try {
            container.dock(dock, new Point(10, 10), -1);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionDockContainer#undock(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#undock(Dock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndock() throws Exception {
        container.undock(dock); // nothing will happen
        assertEquals("The docks' size should be 0.", 0, container.getDockSize());
        container.dock(dock);
        assertEquals("The docks' size should be 1.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        container.undock(dock);
        assertEquals("The docks' size should be 0.", 0, container.getDockSize());
        assertNull("The dock's current dock container should be null.", dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests SectionDockContainer#undock(Dock) for failure.
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
     * Tests SectionDockContainer#getDockTarget() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#getDockTarget() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetDockTarget() throws Exception {
        assertNotNull("The dock target should not be null.", container.getDockTarget());
        assertTrue("The dock target should be a DockContainerPanel.",
                container.getDockTarget() instanceof DockContainerPanel);
    }

    /**
     * <p>
     * Tests SectionDockContainer#getCurrentDocks() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#getCurrentDocks() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetCurrentDocks() throws Exception {
        assertNotNull("The current docks should not be null.", container.getCurrentDocks());
        assertEquals("The current docks' size should be 0.", 0, container.getCurrentDocks().size());
        container.dock(dock, 0);
        assertNotNull("The current docks should not be null.", container.getCurrentDocks());
        assertEquals("The current docks' size should be 1.", 1, container.getCurrentDocks().size());
        assertEquals("The current docks's first element should be dock.", dock, container.getCurrentDocks().get(0));
        container.dock(new DefaultDock(new Section(new JPanel())));
        assertNotNull("The current docks should not be null.", container.getCurrentDocks());
        assertEquals("The current docks' size should be 2.", 2, container.getCurrentDocks().size());
    }

    /**
     * <p>
     * Tests SectionDockContainer#markDockGesture(Dock, Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#markDockGesture(Dock, Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMarkDockGesture() throws Exception {
        Section section1 = new Section(new JPanel());
        section1.setBounds(5, 5, 100, 100);
        Dock dock1 = new DefaultDock(section1);
        Section section2 = new Section(new JPanel());
        section2.setBounds(205, 205, 100, 100);
        Dock dock2 = new DefaultDock(section2);
        Section section3 = new Section(new JPanel());
        section3.setBounds(405, 405, 100, 100);
        Dock dock3 = new DefaultDock(section3);

        container.dock(dock1);
        container.dock(dock2);
        container.dock(dock3);
        container.markDockGesture(dock, new Point(10, 10));
        container.markDockGesture(dock, new Point(210, 210));
        container.markDockGesture(dock, new Point(410, 410));
        container.markDockGesture(dock, new Point(520, 520));
        container.markDockGesture(dock, new Point(610, 610));
        container = new SectionDockContainer(new JPanel(), false);
        section1.setVertical(false);
        section2.setVertical(false);
        section3.setVertical(false);
        container.dock(dock1);
        container.dock(dock2);
        container.dock(dock3);
        container.markDockGesture(dock, new Point(10, 10));
        container.markDockGesture(dock, new Point(210, 210));
        container.markDockGesture(dock, new Point(410, 410));
        container.markDockGesture(dock, new Point(520, 520));
        container.markDockGesture(dock, new Point(410, 520));
        container.markDockGesture(dock, new Point(520, 410));
        container.markDockGesture(dock, new Point(610, 610));
    }

    /**
     * <p>
     * Tests SectionDockContainer#markDockGesture(Dock, Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when dock is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMarkDockGesture_Dock_Null() throws Exception {
        try {
            container.markDockGesture(null, new Point(10, 10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionDockContainer#markDockGesture(Dock, Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when location is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMarkDockGesture_Location_Null() throws Exception {
        try {
            container.markDockGesture(dock, null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionDockContainer#markDockGesture(Dock, Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when x is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMarkDockGesture_X_Negative() throws Exception {
        try {
            container.markDockGesture(dock, new Point(-10, 10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionDockContainer#markDockGesture(Dock, Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when y is negative and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMarkDockGesture_Y_Negative() throws Exception {
        try {
            container.markDockGesture(dock, new Point(10, -10));
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionDockContainer#clearDockGesture() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#clearDockGesture() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testClearDockGesture() throws Exception {
        container.clearDockGesture();
        Field field = SectionDockContainer.class.getDeclaredField("container");
        field.setAccessible(true);
        Object panel = field.get(container);
        field = DockContainerPanel.class.getDeclaredField("gestureRect");
        field.setAccessible(true);
        assertNull("The gesture rectangle shouldbe null.", field.get(panel));
    }

    /**
     * <p>
     * Tests SectionDockContainer#setGestureColor(Color) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#setGestureColor(Color) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetGestureColor() throws Exception {
        Color color = Color.blue;
        container.setGestureColor(color);
        Field field = SectionDockContainer.class.getDeclaredField("container");
        field.setAccessible(true);
        Object panel = field.get(container);
        field = DockContainerPanel.class.getDeclaredField("gestureColor");
        field.setAccessible(true);
        assertEquals("The gesture color shouldbe equal.", color, field.get(panel));
    }

    /**
     * <p>
     * Tests SectionDockContainer#calculateIndex(Point) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#calculateIndex(Point) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCalculateIndex() throws Exception {
        assertEquals("The index should be -1.", -1, container.calculateIndex(new Point(3, 3)));
        container = new SectionDockContainer(new JPanel(), false);
        container.dock(dock);
        assertEquals("The index should be -1.", -1, container.calculateIndex(new Point(3, 3)));
    }

    /**
     * <p>
     * Tests SectionDockContainer#calculateIndex(Point) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when location is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testCalculateIndex_Null() throws Exception {
        try {
            container.calculateIndex(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests SectionDockContainer#undockWithoutRepaint(Dock) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the SectionDockContainer#undock(WithoutRepaintDock) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUndockWithoutRepaint() throws Exception {
        container.undockWithoutRepaint(dock); // nothing will happen
        assertEquals("The docks' size should be 0.", 0, container.getDockSize());
        container.dock(dock);
        assertEquals("The docks' size should be 1.", 1, container.getDockSize());
        assertEquals("The dock's current dock container should be container.",
                container, dock.getCurrentDockContainer());
        container.undockWithoutRepaint(dock);
        assertEquals("The docks' size should be 0.", 0, container.getDockSize());
        assertNull("The dock's current dock container should be null.", dock.getCurrentDockContainer());
    }

    /**
     * <p>
     * Tests SectionDockContainer#undockWithoutRepaint(Dock) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when argument is null and expects IllegalArgumewntException.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUnockWithoutRepaint_Null() throws Exception {
        try {
            container.undockWithoutRepaint(null);
            fail("IAE should be thrown.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}
