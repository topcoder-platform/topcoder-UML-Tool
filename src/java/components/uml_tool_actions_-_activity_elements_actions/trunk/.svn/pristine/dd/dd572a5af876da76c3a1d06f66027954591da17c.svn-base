/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CutFinalNodeAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutFinalNodeActionTests extends TestCase {

    /**
     * <p>
     * The CutFinalNodeAction instance for testing.
     * </p>
     */
    private CutFinalNodeAction action;

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
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        state = new FinalStateImpl();
        CompositeState container = new CompositeStateImpl();
        state.setContainer(container);

        clipboard = new Clipboard("Test");
        action = new CutFinalNodeAction(state, clipboard);
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
        return new TestSuite(CutFinalNodeActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CutFinalNodeAction#CutFinalNodeAction(FinalState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutFinalNodeAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CutFinalNodeAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CutFinalNodeAction#CutFinalNodeAction(FinalState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutFinalNodeAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CutFinalNodeAction instance.", new CutFinalNodeAction(state, null));
    }

    /**
     * <p>
     * Tests ctor CutFinalNodeAction#CutFinalNodeAction(FinalState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new CutFinalNodeAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutFinalNodeAction#CutFinalNodeAction(FinalState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is not set the container
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContainer() {
        state = new FinalStateImpl();
        try {
            new CutFinalNodeAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }
}