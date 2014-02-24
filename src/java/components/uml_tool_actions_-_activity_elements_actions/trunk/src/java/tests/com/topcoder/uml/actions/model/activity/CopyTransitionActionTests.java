/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CopyTransitionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyTransitionActionTests extends TestCase {

    /**
     * <p>
     * The CopyTransitionAction instance for testing.
     * </p>
     */
    private CopyTransitionAction action;

    /**
     * <p>
     * The Transition instance for testing.
     * </p>
     */
    private Transition state;

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
        state = new TransitionImpl();
        clipboard = new Clipboard("Test");
        action = new CopyTransitionAction(state, clipboard);
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
        return new TestSuite(CopyTransitionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CopyTransitionAction#CopyTransitionAction(Transition,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyTransitionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CopyTransitionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CopyTransitionAction#CopyTransitionAction(Transition,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyTransitionAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CopyTransitionAction instance.", new CopyTransitionAction(state, null));
    }

    /**
     * <p>
     * Tests ctor CopyTransitionAction#CopyTransitionAction(Transition,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when transition is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullTransition() {
        try {
            new CopyTransitionAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CopyTransitionAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is executed correctly, the state is copy to the clipboard.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        action.execute();

        Object content = clipboard.getData(ActivityDataFlavor.TRANSITION);
        assertTrue("Expects Transition type.", content != null && content instanceof Transition);
        assertTrue("Expects the content is cloned", content != state);
    }

    /**
     * <p>
     * Tests CopyTransitionAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state is not using default construct
     * and expects ActivityObjectCloneException.
     * </p>
     */
    public void testExecute_ActivityObjectCloneException() {
        MockTransition mockTransition = new MockTransition("Test");
        action = new CopyTransitionAction((Transition) mockTransition, clipboard);

        try {
            action.execute();
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }
}