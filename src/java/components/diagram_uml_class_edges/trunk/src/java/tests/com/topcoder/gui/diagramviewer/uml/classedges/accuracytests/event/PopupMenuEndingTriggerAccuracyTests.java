/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event;

import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;
import com.topcoder.gui.diagramviewer.uml.classedges.event.PopupMenuEndingTrigger;

import junit.framework.TestCase;

import java.awt.event.MouseEvent;


/**
 * <p>Test the accuracy of PopupMenuEndingTrigger class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class PopupMenuEndingTriggerAccuracyTests extends TestCase {
    /** <code>PopupMenuEndingTrigger</code> instance for testing. */
    private PopupMenuEndingTrigger trigger;

    /**
     * <p>Sets up test environment.</p>
     */
    protected void setUp() {
        trigger = new PopupMenuEndingTrigger();
    }

    /**
     * <p>Tears down test environment.</p>
     */
    protected void tearDown() {
        trigger = null;
    }

    /**
     * <p>Accuracy test of constructor. Should create the instance successfully.</p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", trigger);
    }

    /**
     * <p>Accuracy test of method <code>mouseClicked(MouseEvent)</code>. With not right
     * mouse click <code>event</code>. Should return directly.</p>
     */
    public void testMouseClicked() {
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);

        trigger.mouseClicked(event);

        //return directly
    }
}
