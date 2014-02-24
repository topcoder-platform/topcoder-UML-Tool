/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;
import com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>PopupMenuTrigger</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class PopupMenuTriggerUnitTests extends TestCase {

    /** <code>PopupMenuTrigger</code> instance for testing. */
    private PopupMenuTrigger trigger;

    /** <code>BaseEdge</code> instance for testing. */
    private BaseEdge edge;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        trigger = new PopupMenuTrigger();
        edge = new AbstractionEdge(UnitTestsHelper.createGraphEdgeForAbstractionEdge());
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        trigger = null;
        edge = null;
    }

    /**
     * <p>
     * Accuracy test of constructor.
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", trigger);
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With null <code>event</code>.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NullEvent() {
        MouseEvent event = null;

        trigger.mouseClicked(event);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With not right mouse click <code>event</code>.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NotRightClickMouseEvent() {
        MouseEvent event = new MouseEvent(edge,
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);

        trigger.mouseClicked(event);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With not <code>BaseEdge</code> event source.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NotActiveEdgeEnding() {
        MouseEvent event = new MouseEvent(new JLabel("not ActiveEdgeEnding"),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON2);

        trigger.mouseClicked(event);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With <code>BaseEdge</code> has null popup menu.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NullPopupMenu() {
        edge.setComponentPopupMenu(null);

        MouseEvent event = new MouseEvent(edge,
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON2);

        trigger.mouseClicked(event);
        //return directly
    }

}
