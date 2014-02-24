/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.model.AddCommentAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Set of accuracy tests for AbstractAddGraphElementAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AddCommentActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Comment Action";

    /**
     * Instance of Comment for testing.
     */
    private Comment comment;

    /**
     * Instance of Namespace for testing.
     */
    private Namespace namespace;

    /**
     * Instance of UMLModelManager for testing.
     */
    private UMLModelManager modelManager;

    /**
     * Instance of AddCommentAction for testing.
     */
    private AddCommentAction addCommentAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        comment = new CommentImpl();
        namespace = new NamespaceAbstractImpl() {
        };
        modelManager = AccuracyTestsHelper.getModelManager();
        modelManager.getModel().setNamespace(namespace);
        addCommentAction = new AddCommentAction(comment, modelManager);
    }

    /**
     * Constructor under test AddCommentAction(Comment, UMLModelManager).
     * Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAddCommentActionCommentUMLModelManager() throws Exception {
        AddCommentAction currentAddCommentAction = new AddCommentAction(comment, modelManager);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentAddCommentAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(currentAddCommentAction,
            "comment"));
        assertSame("namespaces must be the same", namespace, AccuracyTestsHelper.getFieldValue(
            currentAddCommentAction, "namespace"));
        assertSame("model managers must be the same", modelManager, AccuracyTestsHelper.getFieldValue(
            currentAddCommentAction, "modelManager"));
    }

    /**
     * Constructor under test AddCommentAction(Comment, Namespace,
     * UMLModelManager). Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testAddCommentActionCommentNamespaceUMLModelManager() throws Exception {
        AddCommentAction currentAddCommentAction = new AddCommentAction(comment, namespace, modelManager);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentAddCommentAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(currentAddCommentAction,
            "comment"));
        assertSame("namespaces must be the same", namespace, AccuracyTestsHelper.getFieldValue(
            currentAddCommentAction, "namespace"));
        assertSame("model managers must be the same", modelManager, AccuracyTestsHelper.getFieldValue(
            currentAddCommentAction, "modelManager"));
    }

    /**
     * Method under test AddCommentAction.execute(). Accuracy testing of correct
     * execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        addCommentAction.execute();
        assertTrue("namespace must own comment", namespace.containsOwnedElement(comment));
        assertSame("namespace must be added to comment", namespace, comment.getNamespace());
    }

    /**
     * Method under test AddCommentAction.execute(). Accuracy testing of correct
     * undo.
     */
    public final void testUndo() {
        // run successfully
        addCommentAction.undo();
        assertFalse("namespace must not own comment", namespace.containsOwnedElement(comment));
        assertNull("namespace must be removed from comment", comment.getNamespace());
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}