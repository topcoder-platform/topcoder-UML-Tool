/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.model.CutNoteRelationshipAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Set of accuracy tests for AbstractCutGraphElementAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutNoteRelationshipActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Note Relationship Action";

    /**
     * Instance of Comment for testing.
     */
    private Comment comment;

    /**
     * Instance of ModelElement for testing.
     */
    private ModelElement modelElement;

    /**
     * Instance of Clipboard for testing.
     */
    private Clipboard clipboard;

    /**
     * Instance of CutNoteRelationshipAction for testing.
     */
    private CutNoteRelationshipAction cutNoteRelationshipAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        comment = new CommentImpl();
        modelElement = new ModelElementAbstractImpl() {
        };
        comment.addAnnotatedElement(modelElement);
        modelElement.addComment(comment);
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        cutNoteRelationshipAction = new CutNoteRelationshipAction(comment, clipboard);
    }

    /**
     * Constructor under test CutNoteRelationshipAction(NoteRelationship,
     * UMLModelManager). Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testCutNoteRelationshipActionNoteRelationshipUMLModelManager() throws Exception {
        CutNoteRelationshipAction currentCutNoteRelationshipAction = new CutNoteRelationshipAction(comment, clipboard);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentCutNoteRelationshipAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(
            currentCutNoteRelationshipAction, "comment"));
        assertTrue("parents must contain model element", ((Collection<ModelElement>) AccuracyTestsHelper
            .getFieldValue(currentCutNoteRelationshipAction, "parents")).contains(modelElement));
        assertSame("clipboards must be the same", clipboard, AccuracyTestsHelper.getFieldValue(
            currentCutNoteRelationshipAction, "clipboard"));
    }

    /**
     * Method under test CutNoteRelationshipAction.execute(). Accuracy testing
     * of correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        cutNoteRelationshipAction.execute();
        assertFalse("model element must not own comment", modelElement.containsComment(comment));
        assertFalse("model element must be removed from comment", comment.containsAnnotatedElement(modelElement));
    }

    /**
     * Method under test CutNoteRelationshipAction.execute(). Accuracy testing
     * of correct undo.
     */
    public final void testUndo() {
        // run successfully
        cutNoteRelationshipAction.undo();
        assertTrue("model element must own comment", modelElement.containsComment(comment));
        assertTrue("model element must contains comment", comment.containsAnnotatedElement(modelElement));
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}