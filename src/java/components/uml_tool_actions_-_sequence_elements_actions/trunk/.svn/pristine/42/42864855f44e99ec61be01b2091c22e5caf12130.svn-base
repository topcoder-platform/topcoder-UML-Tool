/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.AddObjectAction;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
/**
 * <p>
 * Failure test for AddObjectAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AddObjectActionFailureTest extends TestCase {
    /**
     * <p>
     * Object instance created for testing.
     * </p>
     */
    private Object object;

    /**
     * <p>
     * Collaboration instance created for testing.
     * </p>
     */
    private Collaboration collaboration;

    /**
     * <p>
     * UMLModelManager instance created for testing.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Loads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfig();
        object = new ObjectImpl();
        collaboration = new CollaborationImpl();
        manager = new UMLModelManager("failuretest");
    }

    /**
     * <p>
     * Unloads the configuration files.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddObjectAction(Object object, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * object is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullStimulus() {
        try {
            new AddObjectAction(null, collaboration, manager);
            fail("object is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddObjectAction(Object object, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * collaboration is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullCollaboration() {
        try {
            new AddObjectAction(object, null, manager);
            fail("collaboration is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddObjectAction(Object object, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * manager is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullUMLModelManager() {
        try {
            new AddObjectAction(object, collaboration, null);
            fail("manager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
