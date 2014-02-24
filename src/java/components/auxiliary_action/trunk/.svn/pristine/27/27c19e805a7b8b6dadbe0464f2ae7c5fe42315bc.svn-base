/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.model.PasteCommentAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Set of accuracy tests for PasteCommentAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteCommentActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Comment Action";

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
     * Instance of PasteCommentAction for testing.
     */
    private PasteCommentAction pasteCommentAction;

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
        pasteCommentAction = new PasteCommentAction(comment, modelManager);
    }

    /**
     * Constructor under test PasteCommentAction(Comment, UMLModelManager).
     * Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testPasteCommentActionCommentUMLModelManager() throws Exception {
        PasteCommentAction currentPasteCommentAction = new PasteCommentAction(comment, modelManager);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentPasteCommentAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(currentPasteCommentAction,
            "comment"));
        assertSame("namespaces must be the same", namespace, AccuracyTestsHelper.getFieldValue(
            currentPasteCommentAction, "namespace"));
        assertSame("model managers must be the same", modelManager, AccuracyTestsHelper.getFieldValue(
            currentPasteCommentAction, "modelManager"));
    }

    /**
     * Constructor under test PasteCommentAction(Comment, Namespace,
     * UMLModelManager). Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testPasteCommentActionCommentNamespaceUMLModelManager() throws Exception {
        PasteCommentAction currentPasteCommentAction = new PasteCommentAction(comment, namespace, modelManager);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentPasteCommentAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(currentPasteCommentAction,
            "comment"));
        assertSame("namespaces must be the same", namespace, AccuracyTestsHelper.getFieldValue(
            currentPasteCommentAction, "namespace"));
        assertSame("model managers must be the same", modelManager, AccuracyTestsHelper.getFieldValue(
            currentPasteCommentAction, "modelManager"));
    }

    /**
     * Method under test PasteCommentAction.execute(). Accuracy testing of
     * correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        pasteCommentAction.execute();
        assertTrue("namespace must own comment", namespace.containsOwnedElement(comment));
        assertSame("namespace must be pasted to comment", namespace, comment.getNamespace());
    }

    /**
     * Method under test PasteCommentAction.execute(). Accuracy testing of
     * correct undo.
     */
    public final void testUndo() {
        // run successfully
        pasteCommentAction.undo();
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