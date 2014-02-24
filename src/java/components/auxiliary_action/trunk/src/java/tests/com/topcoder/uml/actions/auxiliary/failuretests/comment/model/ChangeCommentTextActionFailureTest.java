/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * ChangeCommentTextActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import junit.framework.TestCase;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.actions.auxiliary.comment.model.ChangeCommentTextAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * Failure tests for <code>ChangeCommentTextAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class ChangeCommentTextActionFailureTest extends TestCase {

    /**Comment that is used for testing.*/
    private Comment comment;

   /**
     * <p>
     * Set up environment.
     * </p>
    *
    * @throws Exception exception
     */
    public void setUp() throws Exception {
       Helper.clearNamespace();
       Helper.initNamespace();

       comment = new CommentImpl();
       comment.setBody("old_text");
    }

    /**
     * <p>
     * Tear down.
     * </p>
     *
     * @throws Exception exception
     */
    public void tearDown() throws Exception {
        Helper.clearNamespace();
    }

    /**
     * <p>
     * Tests constructor ChangeCommentTextAction(comment, newText) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNull() {
        try {
            new ChangeCommentTextAction(null, "new_comment");
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method undo() if action is already dead.
     * CannotUndoException is expected.
     * </p>
     */
    public void testUndoIfDead() {
        ChangeCommentTextAction action = new ChangeCommentTextAction(comment, "text");
        action.die();
        try {
            action.undo();
            fail("CannotUndoException is expected because action is already dead.");
        } catch (CannotUndoException e) {
            //success
        }
    }
}