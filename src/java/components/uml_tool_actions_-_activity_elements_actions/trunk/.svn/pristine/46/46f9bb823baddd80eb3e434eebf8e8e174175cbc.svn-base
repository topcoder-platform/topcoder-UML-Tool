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
 * Unit test cases for CutAcceptEventActionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutAcceptEventActionActionTests extends TestCase {

    /**
     * <p>
     * The CutAcceptEventActionAction instance for testing.
     * </p>
     */
    private CutAcceptEventActionAction action;

    /**
     * <p>
     * The SimpleState instance for testing.
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
        state.addTaggedValue(TestHelper.createTaggedValue("AcceptEventAction", "True"));

        clipboard = new Clipboard("Test");
        action = new CutAcceptEventActionAction(state, clipboard);
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
        return new TestSuite(CutAcceptEventActionActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CutAcceptEventActionAction#CutAcceptEventActionAction(SimpleState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutAcceptEventActionAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CutAcceptEventActionAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CutAcceptEventActionAction#CutAcceptEventActionAction(SimpleState,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutAcceptEventActionAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CutAcceptEventActionAction instance.", new CutAcceptEventActionAction(
            state, null));
    }

    /**
     * <p>
     * Tests ctor CutAcceptEventActionAction#CutAcceptEventActionAction(SimpleState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {

        try {
            new CutAcceptEventActionAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutAcceptEventActionAction#CutAcceptEventActionAction(SimpleState,Clipboard) for failure.
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
            new CutAcceptEventActionAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutAcceptEventActionAction#CutAcceptEventActionAction(SimpleState,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state doesn't have the tag definition [AcceptEventAction]
     * (The data value should be True) and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NoDefinitionTag() {
        state = new SimpleStateImpl();
        try {
            new CutAcceptEventActionAction(state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}