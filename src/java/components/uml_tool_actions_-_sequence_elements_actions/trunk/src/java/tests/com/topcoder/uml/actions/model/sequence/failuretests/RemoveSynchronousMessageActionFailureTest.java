/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.RemoveSynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
/**
 * <p>
 * Failure test for RemoveSynchronousMessageAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class RemoveSynchronousMessageActionFailureTest extends TestCase {

    /**
     * <p>
     * Stimulus instance created for testing.
     * </p>
     */
    private Stimulus stimulus;

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
     * <code>RemoveSynchronousMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorNullStimulus() {
        try {
            new RemoveSynchronousMessageAction(null);
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
     * <code>RemoveSendSignalMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorInvalidStimulus1() {
        try {
            stimulus.setDispatchAction(new ProcedureImpl());
            new RemoveSynchronousMessageAction(stimulus);
            fail("stimulus is invalid, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            fail("NO IllegalArgumentException is expected.");
        } catch (SequenceConfigurationException se) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for the
     * <code>RemoveSendSignalMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorInvalidStimulus2() {
        try {

            Procedure procedure = new ProcedureImpl();
            CreateObjectAction action = new CreateObjectActionImpl();
            procedure.setAction(action);
            stimulus.setDispatchAction(procedure);
            new RemoveSynchronousMessageAction(stimulus);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("NO IllegalArgumentException is expected.");
        } catch (SequenceConfigurationException se) {
            // expect
        }
    }
}
