/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentGraphNodeAction;

/**
 * <p>
 * Set of accuracy tests for AddCommentGraphNodeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddCommentGraphNodeActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Add Comment GraphNode";

    /**
     * Constructor under test AddCommentGraphNodeAction(). Accuracy testing of
     * correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAddCommentGraphNodeAction() throws Exception {
        // initialization
        AccuracyTestsHelper.loadConfiguration();
        // run successfully
        AddCommentGraphNodeAction addCommentGraphNodeAction =
            new AddCommentGraphNodeAction(AccuracyTestsHelper.getCommentGraphNode(), new GraphNode(),
                AccuracyTestsHelper.getModelManager());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, addCommentGraphNodeAction
            .getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}