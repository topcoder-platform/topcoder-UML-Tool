/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.AddSendSignalMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
/**
 * <p>
 * Failure test for AddSendSignalMessageAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AddSendSignalMessageActionFailureTest extends TestCase {
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
        CallOperationAction action = new CallOperationActionImpl();
        procedure.setAction(action);
        stimulus.setDispatchAction(procedure);
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
     * <code>AddSendSignalMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullStimulus() {
        try {
            new AddSendSignalMessageAction(null, collaboration, manager);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException se) {
            fail("NO SequenceConfigurationException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddSendSignalMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * collaboration is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullCollaboration() {
        try {
            new AddSendSignalMessageAction(stimulus, null, manager);
            fail("collaboration is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException se) {
            fail("NO SequenceConfigurationException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddSendSignalMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * manager is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullUMLModelManager() {
        try {
            new AddSendSignalMessageAction(stimulus, collaboration, null);
            fail("manager is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException se) {
            fail("NO SequenceConfigurationException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddSendSignalMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * instance of stimulus is incorrect for this action,
     * SequenceConfigurationException is expected.
     * </p>
     */
    public void testCtorInvalidStimulus1() {
        try {
            new AddSendSignalMessageAction(new StimulusImpl(), collaboration, manager);
            fail("instance of stimulus is incorrect for this action, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("NO IllegalArgumentException is expected.");
        } catch (SequenceConfigurationException se) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddSendSignalMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * instance of stimulus is incorrect for this action,
     * SequenceConfigurationException is expected.
     * </p>
     */
    public void testCtorInvalidStimulus2() {
        try {
            Stimulus st = new StimulusImpl();
            Procedure pro = new ProcedureImpl();
            st.setDispatchAction(pro);
            new AddSendSignalMessageAction(st, collaboration, manager);
            fail("instance of stimulus is incorrect for this action, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("NO IllegalArgumentException is expected.");
        } catch (SequenceConfigurationException se) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>AddSendSignalMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)</code>.
     * </p>
     * <p>
     * instance of stimulus is incorrect for this action,
     * SequenceConfigurationException is expected.
     * </p>
     */
    public void testCtorInvalidStimulus3() {
        try {
            Stimulus st = new StimulusImpl();
            Procedure pro = new ProcedureImpl();
            pro.setAction(new CallOperationActionImpl());
            st.setDispatchAction(pro);
            new AddSendSignalMessageAction(st, collaboration, manager);
            fail("instance of stimulus is incorrect for this action, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("NO IllegalArgumentException is expected.");
        } catch (SequenceConfigurationException se) {
            // expect
        }
    }
}
