/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link AddObjectAction} class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class AddObjectActionUnitTest extends TestCase {

    /**
     * AddObjectAction instance to be used for the testing.
     */
    private AddObjectAction addObjectAction = null;

    /**
     * Object instance to be used for the testing.
     */
    private Object object = null;

    /**
     * Collaboration instance to be used for the testing.
     */
    private Collaboration collaboration = null;

    /**
     * UMLModelManager instance to be used for the testing.
     */
    private UMLModelManager modelManager = null;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfig();
        object = new ObjectImpl();
        collaboration = new CollaborationImpl();
        modelManager = new UMLModelManager();
        addObjectAction = new AddObjectAction(object, collaboration, modelManager);
        modelManager.setProjectConfigurationManager(new ProjectConfigurationManager(modelManager));
    }

    /**
     * <p>
     * Tears down the environment after the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        addObjectAction = null;
        object = null;
        modelManager = null;
        collaboration = null;
        TestHelper.releaseConfig();
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(AddObjectActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link AddObjectAction#AddObjectAction(Object, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_AddObjectAction() throws Exception {
        // check for null
        assertNotNull("AddObjectAction creation failed", addObjectAction);
        // check for the variable initialization.
        assertEquals("AddObjectAction creation failed", object, addObjectAction.getObject());
        assertEquals("AddObjectAction creation failed", collaboration, object.getNamespace());
    }

    /**
     * <p>
     * Failure test for {@link AddObjectAction#AddObjectAction(Object, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *         Input
     *              Object object : null value
     *              Collaboration collaboration : Valid value
     *              UMLModelManager manager : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddObjectAction() throws Exception {
        try {
            new AddObjectAction(null, collaboration, modelManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test for {@link AddObjectAction#AddObjectAction(Object, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *         Input
     *              Object object : Valid value
     *              Collaboration collaboration : null value
     *              UMLModelManager manager : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddObjectAction1() throws Exception {
        try {
            new AddObjectAction(object, null, modelManager);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "collaboration in AddObjectAction#AddObjectAction should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link AddObjectAction#AddObjectAction(Object, Collaboration, UMLModelManager)}
     * constructor.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *         Input
     *              Object object : Valid value
     *              Collaboration collaboration : Valid value
     *              UMLModelManager manager : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_AddObjectAction2() throws Exception {
        try {
            new AddObjectAction(object, collaboration, null);
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "manager in AddObjectAction#AddObjectAction should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link AddObjectAction#execute()} method.
     * </p>
     * <p>
     * Checks if the message is added to the namespace.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        addObjectAction.execute();
        assertTrue("execute failed", addObjectAction.getObjectUtil().checkObjectNamespace(object));
    }

    /**
     * <p>
     * Failure test for {@link AddObjectAction#execute()} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     * <p>
     * If the message is already added to the namespace.
     * </p>
     * <p>
     * Expected {@link ActionExecutionException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_execute() throws Exception {
        try {
            addObjectAction.execute();
            addObjectAction.execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As expected
        }
    }

    /**
     * <p>
     * Accuracy test for {@link AddObjectAction#redo()} method.
     * </p>
     * <p>
     * Call redo and check whether the object is added to the namespace and canRedo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo() throws Exception {
        addObjectAction.execute();
        addObjectAction.undo();
        addObjectAction.redo();
        assertTrue("redo failed", addObjectAction.getObjectUtil().checkObjectNamespace(object));
        assertFalse("redo failed", addObjectAction.canRedo());
    }

    /**
     * <p>
     * Accuracy test for {@link AddObjectAction#redo()} method.
     * </p>
     * <p>
     * Calls redo before undo to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_redo1() throws Exception {
        addObjectAction.execute();
        addObjectAction.redo();
    }

    /**
     * <p>
     * Accuracy test for {@link AddObjectAction#undo()} method.
     * </p>
     * <p>
     * Call undo and check whether the object is removed from the namespace and canUndo returns false.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo() throws Exception {
        addObjectAction.execute();
        addObjectAction.undo();
        assertTrue("Undo failed", !addObjectAction.getObjectUtil().checkObjectNamespace(object));
        assertFalse("Undo failed", addObjectAction.canUndo());
    }

    /**
     * <p>
     * Accuracy test for {@link AddObjectAction#undo()} method.
     * </p>
     * <p>
     * Calling undo twice to check whether a warning message is written.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_undo1() throws Exception {
        addObjectAction.undo();
        addObjectAction.undo();
    }

    /**
     * <p>
     * Accuracy test for {@link AddObjectAction#getPresentationName()} method.
     * </p>
     * <p>
     * Checks whether the presentation name is correct.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_getPresentationName() throws Exception {
        assertEquals("getPresentationName failed", addObjectAction.getPresentationName(), "Add Object");
    }

}
