/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * RemoveNoteRelationshipActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import com.topcoder.uml.actions.auxiliary.comment.model.RemoveNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import junit.framework.TestCase;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * Failure tests for <code>RemoveNoteRelationshipAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class RemoveNoteRelationshipActionFailureTest extends TestCase {

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
        comment.addAnnotatedElement(new ModelElementAbstractImpl() {});
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
     * Tests constructor RemoveNoteRelationshipAction(comment) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNull() {
        try {
            new RemoveNoteRelationshipAction(null);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor RemoveNoteRelationshipAction(comment) if comment does not annotated elements.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNotContainAnnotatedElements() {
        try {
            new RemoveNoteRelationshipAction(new CommentImpl());
            fail("IllegalArgumentException is expected because comment must contain annotated elements.");
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
        RemoveNoteRelationshipAction action = new RemoveNoteRelationshipAction(comment);
        action.die();
        try {
            action.undo();
            fail("CannotUndoException is expected because action is already dead.");
        } catch (CannotUndoException e) {
            //success
        }
    }
}