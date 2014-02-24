/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.event;

import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for PopupMenuTrigger.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PopupMenuTriggerTests extends TestCase {
    /**
     * <p>
     * PopupMenuTrigger instance for testing.
     * </p>
     */
    private PopupMenuTrigger trigger;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        trigger = new PopupMenuTrigger();
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
     * Tests PopupMenuTrigger#PopupMenuTrigger() for accuracy.
     * </p>
     * <p>
     * It verifies the newly created PopupMenuTrigger instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a PopupMenuTrigger instance.", trigger);
    }

    /**
     * <p>
     * Tests PopupMenuTrigger#mouseClicked(MouseEvent) for accuracy.
     * </p>
     * <p>
     * It test the case that when e is null and expects success.
     * </p>
     */
    public void testMouseClicked_NullE() {
        trigger.mouseClicked(null);
        // no exception will be thrown
    }

    /**
     * <p>
     * Tests PopupMenuTrigger#mouseClicked(MouseEvent) for accuracy.
     * </p>
     * <p>
     * It test the case that when e is left button click and expects success.
     * </p>
     */
    public void testMouseClicked_MouseEvent() {
        MouseEvent e = new MouseEvent(TestHelper.createSubsystemNodeContainer(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);
        trigger.mouseClicked(e);
        // no exception will be thrown
    }
}
