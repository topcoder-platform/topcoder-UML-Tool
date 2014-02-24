/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentRelationshipGraphEdgeAction;

/**
 * <p>
 * Set of accuracy tests for AddCommentRelationshipGraphEdgeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddCommentRelationshipGraphEdgeActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Add Comment Relationship GraphEdge";

    /**
     * Constructor under test AddCommentRelationshipGraphEdgeAction(). Accuracy
     * testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAddCommentRelationshipGraphEdgeAction() throws Exception {
        // initialization
        AccuracyTestsHelper.loadConfiguration();
        // run successfully
        AddCommentRelationshipGraphEdgeAction addCommentRelationshipGraphEdgeAction =
            new AddCommentRelationshipGraphEdgeAction(AccuracyTestsHelper.getCommentRelationshipGraphEdge(),
                new GraphNode(), AccuracyTestsHelper.getModelManager());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, addCommentRelationshipGraphEdgeAction
            .getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}