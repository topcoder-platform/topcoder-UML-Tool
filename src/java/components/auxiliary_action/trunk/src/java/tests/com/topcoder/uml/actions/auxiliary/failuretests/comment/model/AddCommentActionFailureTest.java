/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AddCommentActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests.comment.model;

import com.topcoder.uml.actions.auxiliary.comment.model.AddCommentAction;
import com.topcoder.uml.actions.auxiliary.failuretests.Helper;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import junit.framework.TestCase;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * Failure tests for <code>AddCommentAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AddCommentActionFailureTest extends TestCase {

    /**Comment that is used for testing.*/
    private Comment comment;

    /**Namespace that is used for testing.*/
    private Namespace namespace;

    /**Model manager that is used for testing.*/
    private UMLModelManager umlModelManager;

    /**AddCommentAction instance that will be tested.*/
    private AddCommentAction action;

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
        umlModelManager = UMLModelManager.getInstance();
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
        umlModelManager.setProjectLanguage("Java");

        action = new AddCommentAction(comment, namespace, umlModelManager);
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
     * Tests constructor AddCommentAction(comment, modelManager) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfCommentNull() {
        try {
            new AddCommentAction(null, umlModelManager);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentAction(comment, modelManager) if modelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1IfModelManagerNull() {
        try {
            new AddCommentAction(comment, null);
            fail("IllegalArgumentException is expected because modelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentAction(comment, namespace, modelManager) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfCommentNull() {
        try {
            new AddCommentAction(null, namespace, umlModelManager);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentAction(comment, modelManager) if modelManager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfModelManagerNull() {
        try {
            new AddCommentAction(comment, namespace, null);
            fail("IllegalArgumentException is expected because modelManager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AddCommentAction(comment, modelManager) if namespace is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2IfNamespaceNull() {
        try {
            new AddCommentAction(comment, null, umlModelManager);
            fail("IllegalArgumentException is expected because namespace cannot be null.");
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
        action = new AddCommentAction(comment, namespace, umlModelManager);
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
        action = new AddCommentAction(comment, namespace, umlModelManager);
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