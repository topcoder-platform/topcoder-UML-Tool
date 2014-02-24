/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.comment.model;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.UnitTestHelper;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * Unit tests on class <code>ChangeCommentTextAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class ChangeCommentTextActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>ChangeCommentTextAction</code> used in this test.
     * </p>
     */
    private ChangeCommentTextAction action;
    /**
     * <p>
     * Instance of <code>Comment</code> used in this test.
     * </p>
     */
    private Comment comment;

    /**
     * <p>
     * Old text.
     * </p>
     */
    private String oldText;

    /**
     * <p>
     * New text.
     * </p>
     */
    private String newText;

    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.oldText = "OldText";
        this.newText = "NewText";
        this.comment = new CommentImpl();
        this.comment.setBody(this.oldText);
        this.action = new ChangeCommentTextAction(this.comment, this.newText);
    }

    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }

    /**
     * <p>
     * Test constructor <code>ChangeCommentTextAction(Comment comment, String newText)</code>
     * for failure with null comment, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullComment() {
        try {
            new ChangeCommentTextAction(null, this.newText);
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test constructor <code>ChangeCommentTextAction(Comment comment, String newText)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Failed to create the action!",
                new ChangeCommentTextAction(this.comment, this.newText));
    }

    /**
     * <p>
     * Test method <code>execute()</code> for accuracy.
     * </p>
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute() throws ActionExecutionException {
        // execute the action
        this.action.execute();
        assertEquals("Failed to execute the action!", this.newText, this.comment.getBody());
    }

    /**
     * <p>
     * Test method <code>undo()</code> for accuracy.
     * </p>
     * @throws ActionExecutionException to JUnit
     */
    public void testUndo() throws ActionExecutionException {
        // execute the action
        this.action.execute();
        assertEquals("Failed to execute the action!", this.newText, this.comment.getBody());

        // undo the action
        this.action.undo();
        assertEquals("Failed to undo the action!", this.oldText, this.comment.getBody());
    }
    /**
     * <p>
     * Test method <code>getPresentationName()</code> for accuracy.
     * </p>
     */
    public void testGetPresentationName() {
        assertEquals("Incorrect name!", "Change Comment Text Action", this.action.getPresentationName());
    }
}
