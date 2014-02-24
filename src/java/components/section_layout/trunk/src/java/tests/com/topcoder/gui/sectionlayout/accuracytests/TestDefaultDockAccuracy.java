/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import java.awt.Cursor;
import java.awt.Point;
import java.lang.reflect.Field;

import javax.swing.JPanel;

import com.topcoder.gui.sectionlayout.dock.DockEvent;
import com.topcoder.gui.sectionlayout.dock.DockListener;
import com.topcoder.gui.sectionlayout.dock.Dockable;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DefaultDock;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DialogFloatContainer;
import com.topcoder.gui.sectionlayout.dock.dndimpl.DockableWrapper;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>DefaultDock </code>.
 * @author Chenhong
 * @version 1.0
 *
 */
public class TestDefaultDockAccuracy extends TestCase {
    
    /**
     * Represents the Dockable instance for testing.
     */
    private Dockable dockable = null;
    
    /**
     * Represents the DefaultDock instance for testing.
     */
    private DefaultDock dock = null;
    
    /**
     * Represents the DockEvent.
     */
    private DockEvent event = null;
    
    /**
     * Set up.
     */
    public void setUp() {
        JPanel panel = new JPanel();
        dockable = new DockableWrapper(panel);
        
        dock = new DefaultDock(dockable);
        
        dock.setDragStartLocation(new Point(10, 100));
        
        event = new DockEvent(dock, new DialogFloatContainer(dock), new Point(10, 100), 1);
    }

    /**
     * Test the ctor.
     */
    public void testDefaultDock() {
        assertNotNull(dock);
    }

    /**
     * Test method Dockable getDockable().
     */
    public void testGetDockable() {
        assertEquals(dockable, dock.getDockable());
    }

    /**
     * Test method <code>floatTo(Point location) </code>.
     */
    public void testFloatTo_1() {
        dock.setFloatable(false);
        
        dock.floatTo(new Point(10, 100));
        // nothing happended.
    }

    /**
     * Test method <code>floatTo(Point location) </code>.
     * 
     * @throws Exception to junit
     */
    public void testFloatTo_2() throws Exception {
        dock.setFloatable(true);
        
        dock.floatTo(new Point(10, 100));
        
        Field field = DefaultDock.class.getDeclaredField("floatContainer");
        field.setAccessible(true);
        Object floatContainer = field.get(dock);
        assertNotNull("The floadContainer should be created.", floatContainer);
    }

    /**
     * Test method void setDragEnabled(boolean enable) </code>.
     */
    public void testSetDragEnabled() {
        dock.setDragEnabled(true);
        
        assertTrue("True is expected.", dock.isDragEnabled());
    }

    /**
     * Test method isDragEnabled.
     */
    public void testIsDragEnabled() {
        dock.setDragEnabled(false);
        assertFalse("false is expected.", dock.isDragEnabled());
    }

    /**
     * Test method get and set GestureCursor.
     */
    public void testGetAndGestureCursor() {
        Cursor cursor = new Cursor(0);
        
        dock.setGestureCursor(cursor);
        
        assertEquals("Equal is expected.", cursor, dock.getGestureCursor());
    }


    /**
     * Test method set and get floatable.
     */
    public void testGetAndSetFloatable() {
        dock.setFloatable(false);
        
        assertFalse("The floatable is set to false.", dock.isFloatable());
    }

    /**
     * Test method set and get start location.
     */
    public void testSetDragStartLocation() {
        Point p = new Point(10, 100);
        
        dock.setDragStartLocation(p);
        
        assertEquals("Equal is expected.", p, dock.getDragStartLocation());
    }

    /**
     * Test method addDockListener.
     */
    public void testAddDockListener() {
        dock.addDockListener(new MyDockListener());
       assertEquals("Equal to 1.", 1, dock.getDockListeners().size());
    }

    /**
     * Test method removeDockListener.
     */
    public void testRemoveDockListener() {
        DockListener listener = new MyDockListener();
        dock.addDockListener(listener);
        
        assertEquals("Equal to 1.", 1, dock.getDockListeners().size());
        
        dock.removeDockListener(listener);
        
        assertEquals("Equal to 0.", 0, dock.getDockListeners().size());
    }

    /**
     * Test method getDockListeners.
     */
    public void testGetDockListeners() {
        assertEquals("No listener added.", 0, dock.getDockListeners().size());
    }

    /**
     * Test method <code>fireDocked(DockEvent event) </code>.
     */
    public void testFireDocked() {
        MyDockListener listener = new MyDockListener();
        dock.addDockListener(listener);
        
        dock.fireDocked(event);
        
        assertTrue("True is expected.", listener.isDockCalled());
        
    }

    /**
     * Test method fireUndocked.
     */
    public void testFireUndocked() {
        MyDockListener listener = new MyDockListener();
        dock.addDockListener(listener);
        
        dock.fireUndocked(event);
        
        assertTrue("True is expected.", listener.isUndockCalled());
    }

    /**
     * Test method <code>DockContainer getCurrentDockContainer() </code>.
     */
    public void testGetCurrentDockContainer_1() {
        assertNull("should  be null.", dock.getCurrentDockContainer());
    }

    /**
     * Test method <code>DockContainer getCurrentDockContainer() </code>.
     */
    public void testGetCurrentDockContainer_2() {
        dock.floatTo(new Point(100, 1000));
        assertNotNull("should  not be null.", dock.getCurrentDockContainer());
    }

    /**
     * Test method <code>Point getCurrentLocationInContainer() </code>.
     */
    public void testGetCurrentLocationInContainer() {
        assertNull("should be null.", dock.getCurrentLocationInContainer());
    }


    /**
     * Test method <code>int getCurrentIndexInContainer() </code>.
     */
    public void testGetCurrentIndexInContainer() {
        assertEquals(-1, dock.getCurrentIndexInContainer());
    }

}
