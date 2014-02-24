/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.diagram.AddPolylineAction;

/**
 * <p>
 * Set of accuracy tests for AddPolylineAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddPolylineActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Add Polyline";

    /**
     * Constructor under test AddPolylineAction(). Accuracy testing of correctly
     * assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAddPolylineAction() throws Exception {
        // initialization
        AccuracyTestsHelper.loadConfiguration();
        // run successfully
        AddPolylineAction addPolylineAction =
            new AddPolylineAction(AccuracyTestsHelper.getPolylineGraphEdge(), new GraphNode(), AccuracyTestsHelper
                .getModelManager());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, addPolylineAction.getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}