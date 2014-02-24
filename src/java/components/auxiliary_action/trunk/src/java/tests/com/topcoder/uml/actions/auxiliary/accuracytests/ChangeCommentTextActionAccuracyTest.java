/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.model.ChangeCommentTextAction;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Set of accuracy tests for ChangeCommentTextAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ChangeCommentTextActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Change Comment Text Action";

    /**
     * Instance of Comment for testing.
     */
    private Comment comment;

    /**
     * String for testing.
     */
    private String oldText = "oldText";

    /**
     * String for testing.
     */
    private String newText = "newText";

    /**
     * Instance of ChangeCommentTextAction for testing.
     */
    private ChangeCommentTextAction changeCommentTextAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        comment = new CommentImpl();
        comment.setBody(oldText);
        changeCommentTextAction = new ChangeCommentTextAction(comment, newText);
    }

    /**
     * Constructor under test ChangeCommentTextAction(Comment, String). Accuracy
     * testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testChangeCommentTextAction() throws Exception {
        ChangeCommentTextAction currentChangeCommentTextAction = new ChangeCommentTextAction(comment, newText);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentChangeCommentTextAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(
            currentChangeCommentTextAction, "comment"));
        assertSame("old texts must be the same", oldText, AccuracyTestsHelper.getFieldValue(
            currentChangeCommentTextAction, "oldText"));
        assertSame("new texts must be the same", newText, AccuracyTestsHelper.getFieldValue(
            currentChangeCommentTextAction, "newText"));
    }

    /**
     * Method under test ChangeCommentTextAction.execute(). Accuracy testing of
     * correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        changeCommentTextAction.execute();
        assertEquals("comment text must be changed", newText, comment.getBody());
    }

    /**
     * Method under test ChangeCommentTextAction.execute(). Accuracy testing of
     * correct undo.
     */
    public final void testUndo() {
        // run successfully
        changeCommentTextAction.undo();
        assertEquals("comment text must be unchanged", oldText, comment.getBody());
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}