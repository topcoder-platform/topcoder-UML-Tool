/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.diagram.PasteFreeTextAction;

/**
 * <p>
 * Set of accuracy tests for PasteFreeTextAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteFreeTextActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Paste Free Text";

    /**
     * Constructor under test PasteFreeTextAction(). Accuracy testing of
     * correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testPasteFreeTextAction() throws Exception {
        // initialization
        AccuracyTestsHelper.loadConfiguration();
        // run successfully
        PasteFreeTextAction addFreeTextAction =
            new PasteFreeTextAction(AccuracyTestsHelper.getFreeTextGraphNode(), new GraphNode());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, addFreeTextAction.getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}