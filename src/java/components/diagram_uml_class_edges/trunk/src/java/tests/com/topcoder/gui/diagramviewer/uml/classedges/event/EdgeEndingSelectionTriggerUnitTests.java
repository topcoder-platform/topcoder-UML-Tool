/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>EdgeEndingSelectionTrigger</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class EdgeEndingSelectionTriggerUnitTests extends TestCase {

    /** <code>EdgeEndingSelectionTrigger</code> instance for testing. */
    private EdgeEndingSelectionTrigger trigger;

    /** <code>ActiveEdgeEnding</code> instance for testing. */
    private ActiveEdgeEnding edgeEnding;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        edgeEnding = UnitTestsHelper.createDirectedAssociation();
        trigger = new EdgeEndingSelectionTrigger(edgeEnding);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        edgeEnding = null;
        trigger = null;
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>edge</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure() {
        try {
            new EdgeEndingSelectionTrigger(null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
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
     * With not left mouse click <code>event</code>.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_NotLeftClickMouseEvent() {
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON2);

        trigger.mouseClicked(event);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With click count is not 1.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked_ClickCountNot1() {
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 2, false, MouseEvent.BUTTON1);

        trigger.mouseClicked(event);
        //return directly
    }

    /**
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With single left mouse click.
     * Should select the edge ending.
     * </p>
     */
    public void testMouseClicked_Accuracy() {
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);

        trigger.mouseClicked(event);

        assertTrue("Should select the edge ending.", edgeEnding.isSelected());
    }

}
