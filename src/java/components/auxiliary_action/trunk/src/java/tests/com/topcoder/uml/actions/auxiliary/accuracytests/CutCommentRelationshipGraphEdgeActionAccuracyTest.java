/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentRelationshipGraphEdgeAction;

/**
 * <p>
 * Set of accuracy tests for CutCommentRelationshipGraphEdgeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutCommentRelationshipGraphEdgeActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Cut Comment Relationship GraphEdge";

    /**
     * Constructor under test CutCommentRelationshipGraphEdgeAction(GraphNode,
     * Clipboard).
     * @throws Exception wraps all exceptions
     */
    public final void testCutCommentRelationshipGraphEdgeAction() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        CutCommentRelationshipGraphEdgeAction cutCommentRelationshipGraphEdgeAction =
            new CutCommentRelationshipGraphEdgeAction(AccuracyTestsHelper.getCommentRelationshipGraphEdge(), Toolkit
                .getDefaultToolkit().getSystemClipboard());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, cutCommentRelationshipGraphEdgeAction
            .getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}