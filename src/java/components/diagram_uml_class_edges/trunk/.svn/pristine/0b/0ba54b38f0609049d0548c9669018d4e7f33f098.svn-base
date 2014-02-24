/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event;

import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.uml.classedges.AbstractionEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.AccuracyTestHelper;
import com.topcoder.gui.diagramviewer.uml.classedges.event.EdgeSelectionTrigger;

import junit.framework.TestCase;


/**
 * <p>Test the accuracy of EdgeSelectionTrigger class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class EdgeSelectionTriggerAccuracyTests extends TestCase {
    /** <code>EdgeSelectionTrigger</code> instance for testing. */
    private EdgeSelectionTrigger trigger;

    /**
     * <p>Sets up test environment.</p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        BaseEdge edge = new AbstractionEdge(AccuracyTestHelper.createGraphEdgeForAbstractionEdge());
        trigger = new EdgeSelectionTrigger(edge);
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
     * <p>
     * Accuracy test of method <code>mouseClicked(MouseEvent)</code>.
     * With not left mouse click <code>event</code>.
     * Should return directly.
     * </p>
     */
    public void testMouseClicked() {
        MouseEvent event = new MouseEvent(UnitTestsHelper.createDirectedAssociation(),
                MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON2);

        trigger.mouseClicked(event);
        //return directly
    }
}
