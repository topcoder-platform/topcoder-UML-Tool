/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.diagram.CutPolylineAction;

/**
 * <p>
 * Set of accuracy tests for CutPolylineAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutPolylineActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Cut Polyline";

    /**
     * Constructor under test CutPolylineAction(GraphNode, Clipboard).
     * @throws Exception wraps all exceptions
     */
    public final void testCutPolylineAction() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        CutPolylineAction cutPolylineAction =
            new CutPolylineAction(AccuracyTestsHelper.getPolylineGraphEdge(), Toolkit.getDefaultToolkit()
                .getSystemClipboard());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, cutPolylineAction.getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}