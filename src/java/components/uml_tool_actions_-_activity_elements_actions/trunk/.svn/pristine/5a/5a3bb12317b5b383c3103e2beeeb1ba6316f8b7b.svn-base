/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CopySendSignalActionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopySendSignalActionActionTests extends TestCase {

    /**
     * <p>
     * The CopySendSignalActionAction instance for testing.
     * </p>
     */
    private CopySendSignalActionAction action;

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
     */
    protected void setUp() {
        state = new SimpleStateImpl();
        state.addTaggedValue(TestHelper.createTaggedValue("SendSignalAction", "True"));
        clipboard = new Clipboard("Test");
        action = new CopySendSignalActionAction(state, clipboard);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        action = null;
        clipboard = null;
        state = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(CopySendSignalActionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CopySendSignalActionAction#CopySendSignalActionAction(SimpleState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopySendSignalActionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CopySendSignalActionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CopySendSignalActionAction#CopySendSignalActionAction(SimpleState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopySendSignalActionAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CopySendSignalActionAction instance.", new CopySendSignalActionAction(
            state, null));
    }

    /**
     * <p>
     * Tests ctor CopySendSignalActionAction#CopySendSignalActionAction(SimpleState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CopySendSignalActionAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CopySendSignalActionAction#CopySendSignalActionAction(SimpleState,Clipboard) for failure.
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
            new CopySendSignalActionAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}