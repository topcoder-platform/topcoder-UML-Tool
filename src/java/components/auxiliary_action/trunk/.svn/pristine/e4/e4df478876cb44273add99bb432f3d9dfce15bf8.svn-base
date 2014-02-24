/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.model.PasteNoteRelationshipAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Set of accuracy tests for AbstractPasteGraphElementAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PasteNoteRelationshipActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Note Relationship Action";

    /**
     * Instance of NoteRelationship for testing.
     */
    private Comment comment;

    /**
     * Instance of Namespace for testing.
     */
    private ModelElement parent;

    /**
     * Instance of PasteNoteRelationshipAction for testing.
     */
    private PasteNoteRelationshipAction pasteNoteRelationshipAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        comment = new CommentImpl();
        parent = new ModelElementAbstractImpl() {
        };
        pasteNoteRelationshipAction = new PasteNoteRelationshipAction(comment, parent);
    }

    /**
     * Constructor under test PasteNoteRelationshipAction(NoteRelationship,
     * ModelElement, UMLModelManager). Accuracy testing of correctly assigned
     * values.
     * @throws Exception wraps all exceptions
     */
    public final void testPasteNoteRelationshipAction() throws Exception {
        PasteNoteRelationshipAction currentPasteNoteRelationshipAction =
            new PasteNoteRelationshipAction(comment, parent);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentPasteNoteRelationshipAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(
            currentPasteNoteRelationshipAction, "comment"));
        assertSame("parents must be the same", parent, AccuracyTestsHelper.getFieldValue(
            currentPasteNoteRelationshipAction, "parent"));
    }

    /**
     * Method under test PasteNoteRelationshipAction.execute(). Accuracy testing
     * of correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        pasteNoteRelationshipAction.execute();
        assertTrue("parent must own comment", parent.containsComment(comment));
        assertTrue("comment must own parent", comment.containsAnnotatedElement(parent));
    }

    /**
     * Method under test PasteNoteRelationshipAction.execute(). Accuracy testing
     * of correct undo.
     */
    public final void testUndo() {
        // run successfully
        pasteNoteRelationshipAction.undo();
        assertFalse("parent must not own comment", parent.containsComment(comment));
        assertFalse("comment must not own parent", comment.containsAnnotatedElement(parent));
    }

    /**
     * Tearing down environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void tearDown() throws Exception {
        AccuracyTestsHelper.clearConfiguration();
    }
}