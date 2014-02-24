/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.diagram.PastePolylineAction;

/**
 * <p>
 * Set of accuracy tests for PastePolylineAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PastePolylineActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Paste Polyline";

    /**
     * Constructor under test PastePolylineAction(). Accuracy testing of
     * correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testPastePolylineAction() throws Exception {
        // initialization
        AccuracyTestsHelper.loadConfiguration();
        // run successfully
        PastePolylineAction addPolylineAction =
            new PastePolylineAction(AccuracyTestsHelper.getPolylineGraphEdge(), new GraphNode());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, addPolylineAction.getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}