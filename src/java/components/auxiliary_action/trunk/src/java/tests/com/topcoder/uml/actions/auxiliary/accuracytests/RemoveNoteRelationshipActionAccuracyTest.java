/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import java.util.Collection;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.model.RemoveNoteRelationshipAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

/**
 * <p>
 * Set of accuracy tests for AbstractRemoveGraphElementAction class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveNoteRelationshipActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Note Relationship Action";

    /**
     * Instance of Comment for testing.
     */
    private Comment comment;

    /**
     * Instance of ModelElement for testing.
     */
    private ModelElement modelElement;

    /**
     * Instance of RemoveNoteRelationshipAction for testing.
     */
    private RemoveNoteRelationshipAction removeNoteRelationshipAction;

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
        removeNoteRelationshipAction = new RemoveNoteRelationshipAction(comment);
    }

    /**
     * Constructor under test RemoveNoteRelationshipAction(NoteRelationship,
     * UMLModelManager). Accuracy testing of correctly assigned values.
     * @throws Exception wraps all exceptions
     */
    public final void testRemoveNoteRelationshipAction() throws Exception {
        RemoveNoteRelationshipAction currentRemoveNoteRelationshipAction = new RemoveNoteRelationshipAction(comment);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentRemoveNoteRelationshipAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(
            currentRemoveNoteRelationshipAction, "comment"));
        assertTrue("parents must contain model element", ((Collection<ModelElement>) AccuracyTestsHelper
            .getFieldValue(currentRemoveNoteRelationshipAction, "parents")).contains(modelElement));
    }

    /**
     * Method under test RemoveNoteRelationshipAction.execute(). Accuracy
     * testing of correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExeremovee() throws Exception {
        // run successfully
        removeNoteRelationshipAction.execute();
        assertFalse("model element must not own comment", modelElement.containsComment(comment));
        assertFalse("model element must be removed from comment", comment.containsAnnotatedElement(modelElement));
    }

    /**
     * Method under test RemoveNoteRelationshipAction.undo(). Accuracy testing
     * of correct undo.
     */
    public final void testUndo() {
        // run successfully
        removeNoteRelationshipAction.undo();
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