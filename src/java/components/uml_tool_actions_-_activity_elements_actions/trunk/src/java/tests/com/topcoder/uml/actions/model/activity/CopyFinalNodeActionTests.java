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
 * Unit test cases for CopyFinalNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyFinalNodeActionTests extends TestCase {

    /**
     * <p>
     * The CopyFinalNodeAction instance for testing.
     * </p>
     */
    private CopyFinalNodeAction action;

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
        clipboard = new Clipboard("Test");
        action = new CopyFinalNodeAction(state, clipboard);
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
        return new TestSuite(CopyFinalNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CopyFinalNodeAction#CopyFinalNodeAction(FinalState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyFinalNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CopyFinalNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CopyFinalNodeAction#CopyFinalNodeAction(FinalState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyFinalNodeAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CopyFinalNodeAction instance.", new CopyFinalNodeAction(state, null));
    }

    /**
     * <p>
     * Tests ctor CopyFinalNodeAction#CopyFinalNodeAction(FinalState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CopyFinalNodeAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}