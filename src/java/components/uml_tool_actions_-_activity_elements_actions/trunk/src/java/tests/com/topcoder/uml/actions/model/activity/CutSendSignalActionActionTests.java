/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CutSendSignalActionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutSendSignalActionActionTests extends TestCase {
    /**
     * <p>
     * The CutSendSignalActionAction instance for testing.
     * </p>
     */
    private CutSendSignalActionAction action;

    /**
     * <p>
     * The FinalState instance for testing.
     * </p>
     */
    private SimpleState state;

    /**
     * <p>
     * The Clipboard instance for testing.
     * </p>
     */
    private Clipboard clipboard;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        state = new SimpleStateImpl();
        CompositeState container = new CompositeStateImpl();

        state.setContainer(container);
        state.addTaggedValue(TestHelper.createTaggedValue("SendSignalAction", "True"));

        clipboard = new Clipboard("Test");
        action = new CutSendSignalActionAction(state, clipboard);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        action = null;
        clipboard = null;
        state = null;

        TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CutSendSignalActionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CutSendSignalActionAction#CutSendSignalActionAction(SimpleState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutSendSignalActionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CutSendSignalActionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CutSendSignalActionAction#CutSendSignalActionAction(SimpleState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutSendSignalActionAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CutSendSignalActionAction instance.", new CutSendSignalActionAction(
            state, null));
    }

    /**
     * <p>
     * Tests ctor CutSendSignalActionAction#CutSendSignalActionAction(SimpleState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CutSendSignalActionAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutSendSignalActionAction#CutSendSignalActionAction(SimpleState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state doesn't have the tag definition [SendSignalAction]
     * (The data value should be True) and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NoDefinitionTag() {
        state = new SimpleStateImpl();
        try {
            new CutSendSignalActionAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutSendSignalActionAction#CutSendSignalActionAction(SimpleState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is not set the container
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContainer() {
        state = new SimpleStateImpl();
        try {
            new CutSendSignalActionAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}