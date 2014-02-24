/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CopyFlowFinalNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyFlowFinalNodeActionTests extends TestCase {

    /**
     * <p>
     * The CopyFlowFinalNodeAction instance for testing.
     * </p>
     */
    private CopyFlowFinalNodeAction action;

    /**
     * <p>
     * The FinalState instance for testing.
     * </p>
     */
    private FinalState state;

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
        state = new FinalStateImpl();
        state.addTaggedValue(TestHelper.createTaggedValue("FinalNodeType", "FlowFinalNode"));
        clipboard = new Clipboard("Test");
        action = new CopyFlowFinalNodeAction(state, clipboard);
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
        return new TestSuite(CopyFlowFinalNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CopyFlowFinalNodeAction#CopyFlowFinalNodeAction(FinalState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyFlowFinalNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CopyFlowFinalNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CopyFlowFinalNodeAction#CopyFlowFinalNodeAction(FinalState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyFlowFinalNodeAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CopyFlowFinalNodeAction instance.", new CopyFlowFinalNodeAction(state,
            null));
    }

    /**
     * <p>
     * Tests ctor CopyFlowFinalNodeAction#CopyFlowFinalNodeAction(FinalState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CopyFlowFinalNodeAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CopyFlowFinalNodeAction#CopyFlowFinalNodeAction(FinalState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state doesn't have the tag definition [FinalNodeType]
     * (The data value should be FlowFinalNode) and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NoDefinitionTag() {
        state = new FinalStateImpl();
        try {
            new CopyFlowFinalNodeAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}