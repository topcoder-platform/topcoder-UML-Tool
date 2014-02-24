/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentGraphNodeAction;

/**
 * <p>
 * Set of accuracy tests for PasteCommentGraphNodeAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteCommentGraphNodeActionAccuracyTest extends TestCase {

    /**
     * Presentation name.
     */
    private static final String PRESENTATION_NAME = "Paste Comment GraphNode";

    /**
     * Constructor under test PasteCommentGraphNodeAction(). Accuracy testing of
     * correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testPasteCommentGraphNodeAction() throws Exception {
        // initialization
        AccuracyTestsHelper.loadConfiguration();
        // run successfully
        PasteCommentGraphNodeAction addCommentGraphNodeAction =
            new PasteCommentGraphNodeAction(AccuracyTestsHelper.getCommentGraphNode(), new GraphNode());
        assertEquals("presentation names must be equal", PRESENTATION_NAME, addCommentGraphNodeAction
            .getPresentationName());
        AccuracyTestsHelper.clearConfiguration();
    }
}