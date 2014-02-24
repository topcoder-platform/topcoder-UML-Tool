/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CutActionStateAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutActionStateActionTests extends TestCase {

    /**
     * <p>
     * The CutActionStateAction instance for testing.
     * </p>
     */
    private CutActionStateAction action;

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
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        state = new ActionStateImpl();
        CompositeState container = new CompositeStateImpl();
        state.setContainer(container);

        clipboard = new Clipboard("Test");
        action = new CutActionStateAction(state, clipboard);
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
        return new TestSuite(CutActionStateActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CutActionStateAction#CutActionStateAction(ActionState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutActionStateAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CutActionStateAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CutActionStateAction#CutActionStateAction(ActionState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutActionStateAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CutActionStateAction instance.", new CutActionStateAction(state,
            clipboard));
    }

    /**
     * <p>
     * Tests ctor CutActionStateAction#CutActionStateAction(ActionState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CutActionStateAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutActionStateAction#CutActionStateAction(ActionState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is not set the container
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContainer() {
        state = new ActionStateImpl();
        try {
            new CutActionStateAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}