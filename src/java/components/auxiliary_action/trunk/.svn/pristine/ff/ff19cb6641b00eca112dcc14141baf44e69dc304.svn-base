/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.model.RemoveCommentAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Set of accuracy tests for AbstractRemoveGraphElementAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveCommentActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Comment Action";

    /**
     * Instance of Comment for testing.
     */
    private Comment comment;

    /**
     * Instance of Namespace for testing.
     */
    private Namespace namespace;

    /**
     * Instance of RemoveCommentAction for testing.
     */
    private RemoveCommentAction removeCommentAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        comment = new CommentImpl();
        namespace = new NamespaceAbstractImpl() {
        };
        comment.setNamespace(namespace);
        removeCommentAction = new RemoveCommentAction(comment);
    }

    /**
     * Constructor under test RemoveCommentAction(Comment, UMLModelManager).
     * Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testRemoveCommentAction() throws Exception {
        RemoveCommentAction currentRemoveCommentAction = new RemoveCommentAction(comment);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentRemoveCommentAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(currentRemoveCommentAction,
            "comment"));
        assertSame("namespaces must be the same", namespace, AccuracyTestsHelper.getFieldValue(
            currentRemoveCommentAction, "namespace"));
    }

    /**
     * Method under test RemoveCommentAction.execute(). Accuracy testing of
     * correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        removeCommentAction.execute();
        assertFalse("namespace must not own comment", namespace.containsOwnedElement(comment));
        assertNull("namespace must be removed from comment", comment.getNamespace());
    }

    /**
     * Method under test RemoveCommentAction.execute(). Accuracy testing of
     * correct undo.
     */
    public final void testUndo() {
        // run successfully
        removeCommentAction.undo();
        assertTrue("namespace must own comment", namespace.containsOwnedElement(comment));
        assertSame("namespace must be remove to comment", namespace, comment.getNamespace());
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}