/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.diagram.CutFreeTextAction;

/**
 * <p>
 * Set of accuracy tests for CutFreeTextAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutFreeTextActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Cut Free Text";

    /**
     * Constructor under test CutFreeTextAction(GraphNode, Clipboard).
     * @throws Exception wraps all exceptions
     */
    public final void testCutFreeTextAction() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        CutFreeTextAction cutFreeTextAction =
            new CutFreeTextAction(AccuracyTestsHelper.getFreeTextGraphNode(), Toolkit.getDefaultToolkit()
                .getSystemClipboard());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, cutFreeTextAction.getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}