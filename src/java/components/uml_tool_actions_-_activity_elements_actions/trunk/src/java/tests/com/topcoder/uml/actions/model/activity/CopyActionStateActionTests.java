/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CopyActionStateAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyActionStateActionTests extends TestCase {

    /**
     * <p>
     * The CopyActionStateAction instance for testing.
     * </p>
     */
    private CopyActionStateAction action;

    /**
     * <p>
     * The ActionState instance for testing.
     * </p>
     */
    private ActionState state;

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
        state = new ActionStateImpl();
        clipboard = new Clipboard("Test");
        action = new CopyActionStateAction(state, clipboard);
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
        return new TestSuite(CopyActionStateActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CopyActionStateAction#CopyActionStateAction(ActionState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyActionStateAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CopyActionStateAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CopyActionStateAction#CopyActionStateAction(ActionState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyActionStateAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CopyActionStateAction instance.", new CopyActionStateAction(state,
            clipboard));
    }

    /**
     * <p>
     * Tests ctor CopyActionStateAction#CopyActionStateAction(ActionState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CopyActionStateAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}