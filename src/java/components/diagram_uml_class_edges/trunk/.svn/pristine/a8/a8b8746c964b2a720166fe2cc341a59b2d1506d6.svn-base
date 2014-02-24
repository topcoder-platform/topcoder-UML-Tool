/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;
import com.topcoder.gui.diagramviewer.uml.classedges.DirectedAssociation;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>PopupMenuEndingTrigger</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class PopupMenuEndingTriggerUnitTests extends TestCase {

    /** <code>PopupMenuEndingTrigger</code> instance for testing. */
    private PopupMenuEndingTrigger trigger;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        trigger = new PopupMenuEndingTrigger();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        trigger = null;
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
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);

        trigger.mouseClicked(event);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With not <code>ActiveEdgeEnding</code> event source.
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
     * With <code>ActiveEdgeEnding</code> has null popup menu.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NullPopupMenu() {
        DirectedAssociation edgeEnding = UnitTestsHelper.createDirectedAssociation();
        edgeEnding.setComponentPopupMenu(null);

        MouseEvent event = new MouseEvent(edgeEnding,
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON2);

        trigger.mouseClicked(event);
        //return directly
    }

}
