/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.auxiliary.comment.model.AddNoteRelationshipAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
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
public class AddNoteRelationshipActionAccuracyTest extends TestCase {

    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Note Relationship Action";

    /**
     * Instance of NoteRelationship for testing.
     */
    private Comment comment;

    /**
     * Instance of Namespace for testing.
     */
    private ModelElement parent;

    /**
     * Instance of UMLModelManager for testing.
     */
    private UMLModelManager modelManager;

    /**
     * Instance of AddNoteRelationshipAction for testing.
     */
    private AddNoteRelationshipAction addNoteRelationshipAction;

    /**
     * Setting up environment for each test case.
     * @throws Exception wraps all exceptions
     */
    protected void setUp() throws Exception {
        AccuracyTestsHelper.loadConfiguration();
        comment = new CommentImpl();
        parent = new ModelElementAbstractImpl() {
        };
        modelManager = AccuracyTestsHelper.getModelManager();
        addNoteRelationshipAction = new AddNoteRelationshipAction(comment, parent, modelManager);
    }

    /**
     * Constructor under test AddNoteRelationshipAction(NoteRelationship,
     * ModelElement, UMLModelManager). Accuracy testing of correctly assigned
     * values.
     * @throws Exception wraps all exceptions
     */
    public final void testAddNoteRelationshipAction() throws Exception {
        AddNoteRelationshipAction currentAddNoteRelationshipAction =
            new AddNoteRelationshipAction(comment, parent, modelManager);
        assertEquals("presentation names must be equal", PRESENTATION_NAME, currentAddNoteRelationshipAction
            .getPresentationName());
        assertSame("comments must be the same", comment, AccuracyTestsHelper.getFieldValue(
            currentAddNoteRelationshipAction, "comment"));
        assertSame("parents must be the same", parent, AccuracyTestsHelper.getFieldValue(
            currentAddNoteRelationshipAction, "parent"));
        assertSame("model managers must be the same", modelManager, AccuracyTestsHelper.getFieldValue(
            currentAddNoteRelationshipAction, "modelManager"));
    }

    /**
     * Method under test AddNoteRelationshipAction.execute(). Accuracy testing
     * of correct execution.
     * @throws Exception wraps all exceptions
     */
    public final void testExecute() throws Exception {
        // run successfully
        addNoteRelationshipAction.execute();
        assertTrue("parent must own comment", parent.containsComment(comment));
        assertTrue("comment must own parent", comment.containsAnnotatedElement(parent));
    }

    /**
     * Method under test AddNoteRelationshipAction.execute(). Accuracy testing
     * of correct undo.
     */
    public final void testUndo() {
        // run successfully
        addNoteRelationshipAction.undo();
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