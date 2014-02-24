/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.dock.Dock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DialogFloatContainer;

import junit.framework.TestCase;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JPanel;


/**
 * Accuracy test cases for class <code>DialogFloatContainer </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestDialogFloatContainerAccuracy extends TestCase {
    /** Represents the Dock for testing. */
    private Dock d = null;

    /** Represents the DialogFloatContainer instance for testing. */
    private DialogFloatContainer c = null;

    /**
     * Set up.
     *
     * @throws Exception to junit
     */
    public void setUp() throws Exception {
        AccUtil.configUIManager();

        JPanel panel = new JPanel();
        panel.setFont(new Font("abc", 0, 0));

        d = new DefaultDock(new Section(panel));

        c = new DialogFloatContainer(d);
    }

    /**
     * Test ctor.
     */
    public void testDialogFloatContainer() {
        assertNotNull(c);
    }

    /**
     * Test method <code>boolean canDock(Dock dock) </code>.
     */
    public void testCanDock_1() {
        // first dock the Dock.
        c.dock(d);

        // then check canDock again.
        assertFalse(c.canDock(d));
    }

    /**
     * Test method <code>boolean canDock(Dock dock) </code>.
     */
    public void testCanDock_2() {
        assertTrue(c.canDock(d));
    }

    /**
     * Test method <code>void clearDockGesture()  </code>.
     */
    public void testClearDockGesture() {
        // nothing should happend.
        c.clearDockGesture();
    }

    /**
     * Test method <code>void dock(Dock dock) </code>.
     */
    public void testDockDock() {
        c.dock(d);

        assertTrue(c.isDocked());
    }

    /**
     * Test method <code>dock(Dock dock, Point location) </code>.
     */
    public void testDockDockPoint() {
        Point location = new Point(10, 100);
        c.dock(d, location);
        assertTrue("The dock should be docked.", c.isDocked());
    }

    /**
     * Test method <code>dock(Dock dock, int index) </code>.
     */
    public void testDockDockInt() {
        c.dock(d, 1);

        assertTrue("The dock should be docked.", c.isDocked());
    }

    /**
     * Test method <code>dock(Dock dock, Point location, int index)  </code>.
     */
    public void testDockDockPointInt() {
        c.dock(d, new Point(10, 100), 1);

        assertTrue("The dock should be docked.", c.isDocked());
    }

    /**
     * Test method getCurrentDocks.
     */
    public void testGetCurrentDocks() {
        assertTrue("Should be empty.", c.getCurrentDocks().isEmpty());
    }

    /**
     * Test method getDockTarget.
     */
    public void testGetDockTarget() {
        c.dock(d);

        assertEquals("equal to 1.", 1, c.getDockTarget().getComponentCount());
    }

    /**
     * Test method markDockGesture(Dock dock, Point location).
     */
    public void testMarkDockGesture() {
        c.markDockGesture(null, null);
    }

    /**
     * Test undock.
     */
    public void testUndock() {
        c.dock(d);

        JDialog ret = (JDialog) c.getDockTarget();
        assertEquals("equal to 1.", 1, ret.getContentPane().getComponentCount());

        c.undock(d);
        ret = (JDialog) c.getDockTarget();
        assertEquals("equal to 0.", 0, ret.getContentPane().getComponentCount());
    }

    /**
     * Test method <code>void close() </code>.
     */
    public void testClose() {
        c.dock(d);

        JDialog ret = (JDialog) c.getDockTarget();
        assertEquals("equal to 1.", 1, ret.getContentPane().getComponentCount());

        c.close();
        ret = (JDialog) c.getDockTarget();
        assertEquals("equal to 0.", 0, ret.getContentPane().getComponentCount());
    }

    /**
     * Test method open.
     */
    public void testOpen() {
        c.dock(d);
        c.open();

        assertEquals("Equal to 1.", 1, c.getCurrentDocks().size());
    }

    /**
     * Test method <code> setLocation </code>.
     */
    public void testSetLocation() {
        Point p = new Point(10, 1000);
        c.setLocation(p);

        JDialog ret = (JDialog) c.getDockTarget();

        assertEquals("Equal is expected.", p, ret.getLocation());
    }

    /**
     * Test method <code>boolean isDocked() </code>.
     */
    public void testIsDocked_1() {
        assertFalse("default to false.", c.isDocked());
    }

    /**
     * Test method <code>boolean isDocked() </code>.
     */
    public void testIsDocked_2() {
        c.dock(d);
        assertTrue("Should be true.", c.isDocked());
    }
}
