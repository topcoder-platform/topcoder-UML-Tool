/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentGraphNodeAction;

/**
 * <p>
 * Set of accuracy tests for CutCommentGraphNodeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutCommentGraphNodeActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Cut Comment GraphNode";

    /**
     * Constructor under test CutCommentGraphNodeAction(GraphNode, Clipboard).
     * @throws Exception wraps all exceptions
     */
    public final void testCutCommentGraphNodeAction() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        CutCommentGraphNodeAction cutCommentGraphNodeAction =
            new CutCommentGraphNodeAction(AccuracyTestsHelper.getCommentGraphNode(), Toolkit.getDefaultToolkit()
                .getSystemClipboard());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, cutCommentGraphNodeAction
            .getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}