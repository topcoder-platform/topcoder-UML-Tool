/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.comment.model.CutCommentAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Set of accuracy tests for AbstractCutGraphElementAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutCommentActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Comment Action";

    /**
     * Instance of Comment for testing.
     */
    private Comment comment;

    /**
     * Instance of Namespace for testing.
     */
    private Namespace namespace;

    /**
     * Instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Instance of CutCommentAction for testing.
     */
    private CutCommentAction cutCommentAction;

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
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        cutCommentAction = new CutCommentAction(comment, clipboard);
    }

    /**
     * Constructor under test CutCommentAction(Comment, UMLModelManager).
     * Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testCutCommentActionCommentUMLModelManager() throws Exception {
        CutCommentAction currentCutCommentAction = new CutCommentAction(comment, clipboard);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentCutCommentAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(currentCutCommentAction,
            "comment"));
        assertSame("namespaces must be the same", namespace, AccuracyTestsHelper.getFieldValue(
            currentCutCommentAction, "namespace"));
        assertSame("clipboards must be the same", clipboard, AccuracyTestsHelper.getFieldValue(
            currentCutCommentAction, "clipboard"));
    }

    /**
     * Method under test CutCommentAction.execute(). Accuracy testing of correct
     * execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        cutCommentAction.execute();
        Object object = clipboard.getData(AuxiliaryElementDataFlavor.COMMENT);
        assertTrue("comment was not successfully copied", object instanceof Comment);
        assertFalse("copied comment was not cloned", ((Comment) object) == comment);
        assertFalse("namespace must not own comment", namespace.containsOwnedElement(comment));
        assertNull("namespace must be removed from comment", comment.getNamespace());
    }

    /**
     * Method under test CutCommentAction.execute(). Accuracy testing of correct
     * undo.
     */
    public final void testUndo() {
        // run successfully
        cutCommentAction.undo();
        assertTrue("namespace must own comment", namespace.containsOwnedElement(comment));
        assertSame("namespace must be cut to comment", namespace, comment.getNamespace());
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}