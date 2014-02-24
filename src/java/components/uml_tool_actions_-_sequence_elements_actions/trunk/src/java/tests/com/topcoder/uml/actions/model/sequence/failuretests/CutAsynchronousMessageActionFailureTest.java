/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.failuretests;

import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.sequence.CutAsynchronousMessageAction;
import com.topcoder.uml.actions.model.sequence.SequenceConfigurationException;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
/**
 * <p>
 * Failure test for CutAsynchronousMessageAction.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class CutAsynchronousMessageActionFailureTest extends TestCase {
    /**
     * <p>
     * Stimulus instance created for testing.
     * </p>
     */
    private Stimulus stimulus;

    /**
     * <p>
     * Clipboard instance created for testing.
     * </p>
     */
    private Clipboard clip = new Clipboard("name");

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
     * Failure Test for
     * <code>CutAsynchronousMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1NullStimulus() {
        try {
            new CutAsynchronousMessageAction(null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("stimulus is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CopyReturnMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1InvalidStimulus1() {
        try {
            new CutAsynchronousMessageAction(stimulus);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutAsynchronousMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1InvalidStimulus2() {
        try {
            stimulus.setDispatchAction(new ProcedureImpl());
            new CutAsynchronousMessageAction(stimulus);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutAsynchronousMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor1InvalidStimulus3() {
        try {
            Procedure procedure = new ProcedureImpl();
            CreateObjectAction action = new CreateObjectActionImpl();
            procedure.setAction(action);
            stimulus.setDispatchAction(procedure);
            new CutAsynchronousMessageAction(stimulus);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutAsynchronousMessageAction(Stimulus stimulus, Clipboard clipboard)
     * </code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2NullStimulus() {
        try {
            new CutAsynchronousMessageAction(null, clip);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("stimulus is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutAsynchronousMessageAction(Stimulus stimulus, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * stimulus is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2NullClipboard() {
        try {
            new CutAsynchronousMessageAction(stimulus, null);
            fail("stimulus is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expect
        } catch (SequenceConfigurationException e) {
            fail("stimulus is null, IllegalArgumentException is expected.");
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutAsynchronousMessageAction(Stimulus stimulus, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2InvalidStimulus1() {
        try {
            new CutAsynchronousMessageAction(stimulus, clip);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutAsynchronousMessageAction(Stimulus stimulus, Clipboard clipboard)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2InvalidStimulus2() {
        try {
            stimulus.setDispatchAction(new ProcedureImpl());
            new CutAsynchronousMessageAction(stimulus, clip);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure Test for
     * <code>CutAsynchronousMessageAction(Stimulus stimulus)</code>.
     * </p>
     * <p>
     * stimulus is invalid, IllegalArgumentException is expected.
     * </p>
     */
    public void testCtor2InvalidStimulus3() {
        try {
            Procedure procedure = new ProcedureImpl();
            CreateObjectAction action = new CreateObjectActionImpl();
            procedure.setAction(action);
            stimulus.setDispatchAction(procedure);
            new CutAsynchronousMessageAction(stimulus, clip);
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (IllegalArgumentException e) {
            fail("stimulus is invalid, SequenceConfigurationException is expected.");
        } catch (SequenceConfigurationException e) {
            // expect
        }
    }
}
