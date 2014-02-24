/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.diagram.AddFreeTextAction;

/**
 * <p>
 * Set of accuracy tests for AddFreeTextAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddFreeTextActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Add Free Text";

    /**
     * Constructor under test AddFreeTextAction(). Accuracy testing of correctly
     * assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAddFreeTextAction() throws Exception {
        // initialization
        AccuracyTestsHelper.loadConfiguration();
        // run successfully
        AddFreeTextAction addFreeTextAction =
            new AddFreeTextAction(AccuracyTestsHelper.getFreeTextGraphNode(), new GraphNode(), AccuracyTestsHelper
                .getModelManager());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, addFreeTextAction.getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}