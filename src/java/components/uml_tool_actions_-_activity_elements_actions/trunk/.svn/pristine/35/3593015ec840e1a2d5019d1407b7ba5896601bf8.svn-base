/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for CopyStateNodeAbstractAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyStateNodeAbstractActionTests extends TestCase {

    /**
     * <p>
     * The CopyStateNodeAbstractAction instance for testing.
     * </p>
     */
    private CopyStateNodeAbstractAction action;

    /**
     * <p>
     * The StateVertex instance for testing.
     * </p>
     */
    private StateVertex state;

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
        state.addTaggedValue(TestHelper.createTaggedValue("AcceptEventAction", "True"));
        clipboard = new Clipboard("Test");
        action = new MockCopyStateNodeAbstractAction(state, clipboard);
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
        return new TestSuite(CopyStateNodeAbstractActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CopyStateNodeAbstractAction#CopyStateNodeAbstractAction(StateVertex,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyStateNodeAbstractAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CopyStateNodeAbstractAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CopyStateNodeAbstractAction#CopyStateNodeAbstractAction(StateVertex,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CopyStateNodeAbstractAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CopyStateNodeAbstractAction instance.",
            new MockCopyStateNodeAbstractAction(state, null));
    }

    /**
     * <p>
     * Tests ctor CopyStateNodeAbstractAction#CopyStateNodeAbstractAction(StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new MockCopyStateNodeAbstractAction(null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CopyStateNodeAbstractAction#execute() for accuracy.
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

        Object content = clipboard.getData(ActivityDataFlavor.ACCEPT_EVENT_ACTION);
        assertTrue("Expects SimpleState type.", content != null && content instanceof SimpleState);
        assertTrue("Expects the content is cloned", content != state);

        assertTrue("Failed to clone the simple state.", Util.checkTagDefinition((SimpleState) content,
            "AcceptEventAction", "True"));
    }

    /**
     * <p>
     * Tests CopyStateNodeAbstractAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the state is not using default construct
     * and expects ActivityObjectCloneException.
     * </p>
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute_ActivityObjectCloneException() throws ActionExecutionException {
        MockObjectFlowState mockObjectFlowState = new MockObjectFlowState("Test");
        action = new MockCopyStateNodeAbstractAction((StateVertex) mockObjectFlowState, clipboard);

        try {
            action.execute();
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests CopyStateNodeAbstractAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the state is unrecognizable and expects ActionExecutionException.
     * </p>
     */
    public void testExecute_ActionExecutionException() {
        CompositeState compositeState = new CompositeStateImpl();
        action = new MockCopyStateNodeAbstractAction(compositeState, clipboard);

        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }
}