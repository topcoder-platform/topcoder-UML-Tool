/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentRelationshipGraphEdgeAction;

/**
 * <p>
 * Set of accuracy tests for RemoveCommentRelationshipGraphEdgeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveCommentRelationshipGraphEdgeActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Remove Comment Relationship GraphEdge";

    /**
     * Constructor under test RemoveCommentRelationshipGraphEdgeAction().
     * @throws Exception wraps all exceptions
     */
    public final void testRemoveCommentRelationshipGraphEdgeAction() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        RemoveCommentRelationshipGraphEdgeAction cutCommentRelationshipGraphEdgeAction =
            new RemoveCommentRelationshipGraphEdgeAction(AccuracyTestsHelper.getCommentRelationshipGraphEdge());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, cutCommentRelationshipGraphEdgeAction
            .getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}