/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.AddMessageActionImpl;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
/**
 * <p>
 * Failure test for AddMessageAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AddMessageActionFailureTest extends TestCase {
    /**
     * <p>
     * Stimulus instance created for testing.
     * </p>
     */
    private Stimulus stimulus;

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
        stimulus = new StimulusImpl();
        collaboration = new CollaborationImpl();
        manager = new UMLModelManager("failuretest");

        Procedure procedure = new ProcedureImpl();
        CreateObjectAction action = new CreateObjectActionImpl();
        procedure.setAction(action);
        stimulus.setDispatchAction(procedure);

        ProjectConfigurationManager config = new ProjectConfigurationManager(manager, "manager");
        manager.setProjectConfigurationManager(config);
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
     * <code>AddMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullStimulus() {
        try {
            new AddMessageActionImpl(null, collaboration, manager);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * collaboration is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullCollaboration() {
        try {
            new AddMessageActionImpl(stimulus, null, manager);
            fail("collaboration is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * manager is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullUMLModelManager() {
        try {
            new AddMessageActionImpl(stimulus, collaboration, null);
            fail("manager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
