/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CopyObjectFlowStateAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyObjectFlowStateActionTests extends TestCase {

    /**
     * <p>
     * The CopyObjectFlowStateAction instance for testing.
     * </p>
     */
    private CopyObjectFlowStateAction action;

    /**
     * <p>
     * The FinalState instance for testing.
     * </p>
     */
    private ObjectFlowState state;

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
        state = new ObjectFlowStateImpl();
        clipboard = new Clipboard("Test");
        action = new CopyObjectFlowStateAction(state, clipboard);
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
        return new TestSuite(CopyObjectFlowStateActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CopyObjectFlowStateAction#CopyObjectFlowStateAction(ObjectFlowState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyObjectFlowStateAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CopyObjectFlowStateAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CopyObjectFlowStateAction#CopyObjectFlowStateAction(ObjectFlowState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyObjectFlowStateAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CopyObjectFlowStateAction instance.", new CopyObjectFlowStateAction(
            state, null));
    }

    /**
     * <p>
     * Tests ctor CopyObjectFlowStateAction#CopyObjectFlowStateAction(ObjectFlowState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CopyObjectFlowStateAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}