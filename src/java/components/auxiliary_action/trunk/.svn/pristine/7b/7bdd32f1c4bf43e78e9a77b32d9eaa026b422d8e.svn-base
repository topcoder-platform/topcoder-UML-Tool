/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AbstractAddGraphElementActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests;

import junit.framework.TestCase;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.actions.auxiliary.failuretests.impls.AbstractAddGraphElementActionImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;

import javax.swing.undo.CannotUndoException;

/**
 * <p>
 * This is a failure tests for <code>AbstractAddGraphElementAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AbstractAddGraphElementActionFailureTest extends TestCase {

    /**Name.*/
    private static final String NAME = "name";

    /**GraphElement that is used for testing.*/
    private GraphElement child;

    /**GraphNode that is used for testing.*/
    private GraphNode parent;

    /**UMLModelManager that is used for testing.*/
    private UMLModelManager modelManager;

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

        child = new GraphElement() {};
        parent = new GraphNode();
        modelManager = UMLModelManager.getInstance();
        modelManager.setProjectConfigurationManager(new ProjectConfigurationManager(modelManager));
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
     * Tests constructor AbstractAddGraphElementAction(name, child, parent, modelmanager) if name is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameNull() {
        try {
            new AbstractAddGraphElementActionImpl(null, child, parent, modelManager);
            fail("IllegalArgumentException is expected because name cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AbstractAddGraphElementAction(name, child, parent, modelmanager) if name is empty.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameEmpty() {
        try {
            new AbstractAddGraphElementActionImpl("   ", child, parent, modelManager);
            fail("IllegalArgumentException is expected because name cannot be empty.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AbstractAddGraphElementAction(name, child, parent, modelmanager) if child is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfChildNull() {
        try {
            new AbstractAddGraphElementActionImpl(NAME, null, parent, modelManager);
            fail("IllegalArgumentException is expected because child cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AbstractAddGraphElementAction(name, child, parent, modelmanager) if parent is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfParentNull() {
        try {
            new AbstractAddGraphElementActionImpl(NAME, child, null, modelManager);
            fail("IllegalArgumentException is expected because parent cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AbstractAddGraphElementAction(name, child, parent, modelmanager) if modelmanager is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfModelManagerNull() {
        try {
            new AbstractAddGraphElementActionImpl(NAME, child, parent, null);
            fail("IllegalArgumentException is expected because modelmanager cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method execute() if language is not set (null).
     * ActionExecutionException is expected.
     * </p>
     */
    public void testExecuteIfNoLanguage() {
        AbstractAddGraphElementActionImpl action =
                new AbstractAddGraphElementActionImpl(NAME, child, parent, modelManager);
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
        AbstractAddGraphElementActionImpl action =
                new AbstractAddGraphElementActionImpl(NAME, child, parent, new UMLModelManager());
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
        AbstractAddGraphElementActionImpl action =
                new AbstractAddGraphElementActionImpl(NAME, child, parent, modelManager);
        action.die();
        try {
            action.undo();
            fail("CannotUndoException is expected because action is already dead.");
        } catch (CannotUndoException e) {
            //success
        }
    }
}