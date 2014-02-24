/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AddNoteRelationshipActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import com.topcoder.uml.actions.auxiliary.comment.model.AddNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import junit.framework.TestCase;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * Failure tests for <code>AddNoteRelationshipAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AddNoteRelationshipActionFailureTest extends TestCase {

    /**Comment that is used for testing.*/
    private Comment comment;

    /**Model manager that is used for testing.*/
    private UMLModelManager umlModelManager;

    /**Model element that is used for testing.*/
    private ModelElement parent;

    /**AddNoteRelationshipAction instance that will be tested.*/
    private AddNoteRelationshipAction action;

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
       umlModelManager = UMLModelManager.getInstance();
       parent = new ModelElementAbstractImpl() {};
       umlModelManager.setProjectLanguage("Java");
       umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));

       action = new AddNoteRelationshipAction(comment, parent, umlModelManager);
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
     * Tests constructor AddNoteRelationshipAction(comment, parent, modelManager) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfCommentNull() {
        try {
            new AddNoteRelationshipAction(null, parent, umlModelManager);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddNoteRelationshipAction(comment, parent, modelManager) if parent is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfParentNull() {
        try {
            new AddNoteRelationshipAction(comment, null, umlModelManager);
            fail("IllegalArgumentException is expected because parent cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddNoteRelationshipAction(comment, parent, modelManager) if modelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfModelManagerNull() {
        try {
            new AddNoteRelationshipAction(comment, parent, null);
            fail("IllegalArgumentException is expected because modelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method execute() if language is not set (null).
     * ActionExecutionException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testExecuteIfNoLanguage() throws Exception {
        umlModelManager = new UMLModelManager();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        action = new AddNoteRelationshipAction(comment, parent, umlModelManager);
        try {
            action.execute();
            fail("ActionExecutionException is expected because language cannot not be null.");
        } catch (ActionExecutionException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method execute() if modelManager's ProjectConfigurationManager is not set (null).
     * ActionExecutionException is expected.
     * </p>
     */
    public void testExecuteIfNoProjectConfigurationManager() {
        umlModelManager = new UMLModelManager();
        umlModelManager.setProjectLanguage("Java");
        action = new AddNoteRelationshipAction(comment, parent, umlModelManager);
        try {
            action.execute();
            fail("ActionExecutionException is expected because language cannot not be null.");
        } catch (ActionExecutionException e) {
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
        action.die();
        try {
            action.undo();
            fail("CannotUndoException is expected because action is already dead.");
        } catch (CannotUndoException e) {
            //success
        }
    }
}