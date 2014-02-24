/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * PasteCommentActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import com.topcoder.uml.actions.auxiliary.comment.model.PasteCommentAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import junit.framework.TestCase;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * Failure tests for <code>PasteCommentAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class PasteCommentActionFailureTest extends TestCase {

    /**Comment that is used for testing.*/
    private Comment comment;

    /**UMLModelManager that is used for testing.*/
    private UMLModelManager modelManager;

    /**Namespace that is used for testing.*/
    private Namespace namespace;

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
        namespace = new NamespaceAbstractImpl() {};
        modelManager = UMLModelManager.getInstance();
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
     * Tests constructor PasteCommentAction(content, modelManager) if content is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfContentNull() {
        try {
            new PasteCommentAction(null, modelManager);
            fail("IllegalArgumentException is expected because content cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentAction(content, modelManager) if content is not instance of Comment.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfContentNonComment() {
        try {
            new PasteCommentAction(new Object(), modelManager);
            fail("IllegalArgumentException is expected because content must be instance of Comment.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentAction(content, modelManager) if modelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfModelManageNull() {
        try {
            new PasteCommentAction(comment, null);
            fail("IllegalArgumentException is expected because modelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentAction(content, namespace, modelManager) if content is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfContentNull() {
        try {
            new PasteCommentAction(null, namespace, modelManager);
            fail("IllegalArgumentException is expected because content cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentAction(content, namespace, modelManager) if content is not instance of Comment.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor12fContentNonComment() {
        try {
            new PasteCommentAction(new Object(), namespace, modelManager);
            fail("IllegalArgumentException is expected because content must be instance of Comment.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentAction(content, namespace, modelManager) if namespace is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfNamespaceNull() {
        try {
            new PasteCommentAction(comment, null, modelManager);
            fail("IllegalArgumentException is expected because modelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor PasteCommentAction(content, namespace, modelManager) if modelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfModelManageNull() {
        try {
            new PasteCommentAction(comment, namespace, null);
            fail("IllegalArgumentException is expected because modelManager cannot be null.");
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
        PasteCommentAction action = new PasteCommentAction(comment, namespace, modelManager);
        action.die();
        try {
            action.undo();
            fail("CannotUndoException is expected because action is already dead.");
        } catch (CannotUndoException e) {
            //success
        }
    }
}