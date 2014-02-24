/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapper;

import junit.framework.TestCase;

import java.awt.Component;

import javax.swing.JPanel;


/**
 * Accuracy test cases for class <code>DockableWrapper </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestDockableWrapperAccuracy extends TestCase {
    /** Represents the DockableWrapper instance for testing. */
    private DockableWrapper t = null;

    /**
     * Set up.
     */
    public void setUp() {
        Component c = new JPanel();
        t = new DockableWrapper(c);
    }

    /**
     * Test the ctor.
     */
    public void testDockableWrapper() {
        assertNotNull(t);
    }

    /**
     * Test method <code>Component getDockableComponent() </code>.
     */
    public void testGetDockableComponent() {
        assertEquals(t, t.getDockableComponent());
    }

    /**
     * Test method <code> setDragInitListener(DragInitListener listener) </code>.
     */
    public void testSetDragInitListener() {
        t.setDragInitListener(new MyDragInitListener());
    }

    /**
     * Test method <code>String getDockType() </code>.
     */
    public void testGetDockType() {
        assertEquals("DockableWrapper", t.getDockType());
    }

    /**
     * Test method setFloating(boolean floating) .
     */
    public void testSetFloating() {
        t.setFloating(true);

        assertTrue(t.isFloating());
    }

    /**
     * Test method isFloating.
     */
    public void testIsFloating() {
        assertFalse(t.isFloating());
    }
}
