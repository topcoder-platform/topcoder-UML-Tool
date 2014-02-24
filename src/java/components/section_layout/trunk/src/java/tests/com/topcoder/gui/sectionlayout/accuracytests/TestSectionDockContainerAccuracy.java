/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionDockContainer;
import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapper;

import junit.framework.TestCase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JPanel;


/**
 * Accuracy test cases for class <code>SectionDockContainer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestSectionDockContainerAccuracy extends TestCase {
    /** Represents the SectionDockContainer instance for testing. */
    private SectionDockContainer container = null;

    /**
     * Set up.
     *
     * @throws Exception to junit
     */
    public void setUp() throws Exception {
        Container c = new Container();
        c.setBounds(1, 1, 100, 1000);

        container = new SectionDockContainer(c);

        AccUtil.configUIManager();
    }

    /**
     * Test ctor <code>SectionDockContainer(Container outerContainer) </code>.
     */
    public void testSectionDockContainerContainer() {
        assertNotNull(container);
    }

    /**
     * Test ctor <code>SectionDockContainer(Container outerContainer, boolean vertical) </code>.
     */
    public void testSectionDockContainerContainerBoolean() {
        Container c = new Container();
        c.setBounds(1, 1, 100, 1000);

        container = new SectionDockContainer(c, true);

        assertNotNull(container);
    }

    /**
     * Test method <code>canDock(Dock dock) </code>.
     */
    public void testCanDock_1() {
        boolean ret = container.canDock(null);

        assertFalse(ret);
    }

    /**
     * Test method <code>canDock(Dock dock) </code>.
     */
    public void testCanDock_2() {
        Dock dock = new DefaultDock(new DockableWrapper(new JPanel()));
        boolean ret = container.canDock(dock);

        assertFalse(ret);
    }

    /**
     * Test method <code>canDock(Dock dock) </code>.
     */
    public void testCanDock_3() {
        container = new SectionDockContainer(new JPanel(), true);

        JPanel panel = new JPanel();
        panel.setFont(new Font("abc", 0, 0));

        Dock dock = new DefaultDock(new Section(panel));
        boolean ret = container.canDock(dock);

        assertTrue(ret);
    }

    /**
     * Test method <code>canDock(Dock dock) </code>.
     */
    public void testCanDock_4() {
        container = new SectionDockContainer(new JPanel(), false);

        JPanel panel = new JPanel();
        panel.setFont(new Font("abc", 0, 0));

        Dock dock = new DefaultDock(new Section(panel));
        boolean ret = container.canDock(dock);

        assertFalse(ret);
    }

    /**
     * Test method <code>int getDockSize() </code>.
     */
    public void testGetDockSize() {
        int ret = container.getDockSize();
        assertEquals("Equal to 0.", 0, ret);
    }

    /**
     * Test method <code>void dock(Dock dock) </code>.
     */
    public void testDockDock_1() {
        container.addDockListener(new MyDockListener());

        Dock dock = new DefaultDock(new DockableWrapper(new JPanel()));

        /*
         * The canDock will return false.
         */
        container.dock(dock);

        assertEquals("Equal to 0.", 0, container.getCurrentDocks().size());
    }

    /**
     * Test method <code>void dock(Dock dock) </code>.
     */
    public void testDockDock_2() {
        container = new SectionDockContainer(new JPanel(), true);

        JPanel panel = new JPanel();
        panel.setFont(new Font("abc", 0, 0));

        Dock dock = new DefaultDock(new Section(panel));
        dock.addDockListener(new MyDockListener());

        container.addDockListener(new MyDockListener());

        /*
         * The canDock will return true and it will be docked.
         */
        container.dock(dock);

        assertEquals("Equal to 1.", 1, container.getCurrentDocks().size());
    }

    /**
     * Test method <code>void dock(Dock dock, Point location) </code>.
     */
    public void testDockDockPoint() {
        container = new SectionDockContainer(new JPanel(), true);

        JPanel panel = new JPanel();
        panel.setFont(new Font("abc", 0, 0));

        Dock dock = new DefaultDock(new Section(panel));
        dock.addDockListener(new MyDockListener());

        container.addDockListener(new MyDockListener());

        container.dock(dock, new Point(10, 1000));
        assertEquals("Equal to 1.", 1, container.getCurrentDocks().size());
    }

    /**
     * Test method <code> dock(Dock dock, int index) </code>.
     */
    public void testDockDockInt() {
        Section section = new Section(new JPanel());
        section.setBounds(5, 5, 100, 100);

        Dock dock = new DefaultDock(section);

        container.dock(dock, 1);
        assertEquals("Equal to 1.", 1, container.getCurrentDocks().size());
    }

    /**
     * Test method <code> dock(Dock dock, Point location, int index) </code>.
     */
    public void testDockDockPointInt() {
        Section section = new Section(new JPanel());
        section.setBounds(5, 5, 100, 100);

        Dock dock = new DefaultDock(section);

        container.dock(dock, new Point(100, 1000), 1);
        assertEquals("Equal to 1.", 1, container.getCurrentDocks().size());
    }

    /**
     * Test method <code>undock(Dock dock) </code>.
     */
    public void testUndock() {
        Section section = new Section(new JPanel());
        section.setBounds(5, 5, 100, 100);

        Dock dock = new DefaultDock(section);

        container.dock(dock);
        assertEquals("Equal to 1.", 1, container.getCurrentDocks().size());

        container.undock(dock);
        assertTrue("Empty.", container.getCurrentDocks().isEmpty());
    }

    /**
     * Test method <code>Container getDockTarget() </code>.
     */
    public void testGetDockTarget() {
        assertNotNull("The dock target should not be null.", container.getDockTarget());
    }

    /**
     * Test method <code> getCurrentDocks() </code>.
     */
    public void testGetCurrentDocks_1() {
        assertTrue("Empty.", container.getCurrentDocks().isEmpty());
    }

    /**
     * Test method <code> getCurrentDocks() </code>.
     */
    public void testGetCurrentDocks_2() {
        Section section = new Section(new JPanel());
        section.setBounds(5, 5, 100, 100);

        Dock dock = new DefaultDock(section);

        container.dock(dock);

        assertEquals("Equal to 1.", 1, container.getCurrentDocks().size());
    }

    /**
     * Test method markDockGesture(Dock dock, Point location).
     */
    public void testMarkDockGesture() {
        Section section = new Section(new JPanel());
        section.setBounds(5, 5, 100, 100);

        Dock dock = new DefaultDock(section);

        container.dock(dock);

        container.markDockGesture(dock, new Point(10, 10));
        container.markDockGesture(dock, new Point(10, 10));
        container.markDockGesture(dock, new Point(210, 210));
        container.markDockGesture(dock, new Point(410, 410));
        container.markDockGesture(dock, new Point(520, 520));
        container.markDockGesture(dock, new Point(410, 520));
        container.markDockGesture(dock, new Point(520, 410));
        container.markDockGesture(dock, new Point(610, 610));
    }

    /**
     * Test method clearDockGesture.
     */
    public void testClearDockGesture() {
        container.clearDockGesture();
    }

    /**
     * Test method <code> setGestureColor(Color gestureColor) </code>.
     */
    public void testSetGestureColor() {
        Color color = new Color(15);
        container.setGestureColor(color);
    }
}
