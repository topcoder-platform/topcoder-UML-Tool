/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * RemoveCommentActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import com.topcoder.uml.actions.auxiliary.comment.model.RemoveCommentAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import junit.framework.TestCase;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * Failure tests for <code>RemoveCommentAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class RemoveCommentActionFailureTest extends TestCase {

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
        comment.setNamespace(new NamespaceAbstractImpl() {});
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
     * Tests constructor RemoveCommentAction(comment) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfCommentNull() {
        try {
            new RemoveCommentAction(null);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor RemoveCommentAction(comment) if comment does not contain namespace.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfCommentNotContainNamespace() {
        try {
            new RemoveCommentAction(new CommentImpl());
            fail("IllegalArgumentException is expected because comment must cotain namespace.");
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
        RemoveCommentAction action = new RemoveCommentAction(comment);
        action.die();
        try {
            action.undo();
            fail("CannotUndoException is expected because action is already dead.");
        } catch (CannotUndoException e) {
            //success
        }
    }
}