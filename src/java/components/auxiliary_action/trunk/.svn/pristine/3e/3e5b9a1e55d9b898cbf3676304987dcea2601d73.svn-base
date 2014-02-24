/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.diagram.RemovePolylineAction;

/**
 * <p>
 * Set of accuracy tests for RemovePolylineAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemovePolylineActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Remove Polyline";

    /**
     * Constructor under test RemovePolylineAction().
     * @throws Exception wraps all exceptions
     */
    public final void testRemovePolylineAction() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        RemovePolylineAction cutPolylineAction = new RemovePolylineAction(AccuracyTestsHelper.getPolylineGraphEdge());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, cutPolylineAction.getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}