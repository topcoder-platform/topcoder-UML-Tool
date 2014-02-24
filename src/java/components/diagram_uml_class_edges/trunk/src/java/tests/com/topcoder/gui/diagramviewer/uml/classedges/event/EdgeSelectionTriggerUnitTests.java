/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.event;

import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>EdgeSelectionTrigger</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class EdgeSelectionTriggerUnitTests extends TestCase {

    /** <code>EdgeSelectionTrigger</code> instance for testing. */
    private EdgeSelectionTrigger trigger;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        BaseEdge edge = new AbstractionEdge(UnitTestsHelper.createGraphEdgeForAbstractionEdge());
        trigger = new EdgeSelectionTrigger(edge);
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
     * Failure test of constructor.
     * With null <code>edge</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure() {
        try {
            new EdgeSelectionTrigger(null);
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

}
