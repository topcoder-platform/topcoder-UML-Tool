/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event;

import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.AccuracyTestHelper;
import com.topcoder.gui.diagramviewer.uml.classedges.event.EdgeEndingSelectionTrigger;

import junit.framework.TestCase;


/**
 * <p>Test the accuracy of EdgeEndingSelectionTrigger class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class EdgeEndingSelectionTriggerAccuracyTests extends TestCase {
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
    public void testMouseClicked1() {
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
    public void testMouseClicked2() {
        MouseEvent event = new MouseEvent(AccuracyTestHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON2);

        trigger.mouseClicked(event);
        //return directly
    }
}
