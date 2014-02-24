/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.diagram.RemoveFreeTextAction;

/**
 * <p>
 * Set of accuracy tests for RemoveFreeTextAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveFreeTextActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Remove Free Text";

    /**
     * Constructor under test RemoveFreeTextAction(GraphNode, Clipboard).
     * @throws Exception wraps all exceptions
     */
    public final void testRemoveFreeTextAction() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        RemoveFreeTextAction cutFreeTextAction = new RemoveFreeTextAction(AccuracyTestsHelper.getFreeTextGraphNode());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, cutFreeTextAction.getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}