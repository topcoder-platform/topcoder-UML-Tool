/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentGraphNodeAction;

/**
 * <p>
 * Set of accuracy tests for RemoveCommentGraphNodeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveCommentGraphNodeActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Remove Comment GraphNode";

    /**
     * Constructor under test RemoveCommentGraphNodeAction(GraphNode,
     * Clipboard).
     * @throws Exception wraps all exceptions
     */
    public final void testRemoveCommentGraphNodeAction() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        RemoveCommentGraphNodeAction cutCommentGraphNodeAction =
            new RemoveCommentGraphNodeAction(AccuracyTestsHelper.getCommentGraphNode());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, cutCommentGraphNodeAction
            .getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}