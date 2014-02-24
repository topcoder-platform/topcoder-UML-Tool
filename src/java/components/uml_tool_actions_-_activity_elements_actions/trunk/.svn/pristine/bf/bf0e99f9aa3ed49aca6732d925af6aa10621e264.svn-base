/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import javax.swing.undo.CannotUndoException;

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
 * Unit test cases for CutStateNodeAbstractAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutStateNodeAbstractActionTests extends TestCase {

    /**
     * <p>
     * The CutStateNodeAbstractAction instance for testing.
     * </p>
     */
    private CutStateNodeAbstractAction action;

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
     * The CompositeState instance for testing.
     * </p>
     */
    private CompositeState container;

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
        container = new CompositeStateImpl();
        state.addTaggedValue(TestHelper.createTaggedValue("AcceptEventAction", "True"));
        state.setContainer(container);
        clipboard = new Clipboard("Test");
        action = new MockCutStateNodeAbstractAction("Cut", state, clipboard);
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
        return new TestSuite(CutStateNodeAbstractActionTests.class);
    }

    /**
     * <p>
     * Tests ctor CutStateNodeAbstractAction#CutStateNodeAbstractAction(String,StateVertex,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutStateNodeAbstractAction instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new CutStateNodeAbstractAction instance.", action);
    }

    /**
     * <p>
     * Tests ctor CutStateNodeAbstractAction#CutStateNodeAbstractAction(String,StateVertex,Clipboard) for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created CutStateNodeAbstractAction instance should not be null when the clipboard is null.
     * </p>
     */
    public void testCtor_NullClipboard() {
        assertNotNull("Failed to create a new CutStateNodeAbstractAction instance.",
            new MockCutStateNodeAbstractAction("Cut", state, null));
    }

    /**
     * <p>
     * Tests ctor CutStateNodeAbstractAction#CutStateNodeAbstractAction(String,StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullName() {
        try {
            new MockCutStateNodeAbstractAction(null, state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutStateNodeAbstractAction#CutStateNodeAbstractAction(String,StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when name is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyName() {
        try {
            new MockCutStateNodeAbstractAction(" ", state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutStateNodeAbstractAction#CutStateNodeAbstractAction(String,StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullState() {
        try {
            new MockCutStateNodeAbstractAction("Cut", null, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor CutStateNodeAbstractAction#CutStateNodeAbstractAction(String,StateVertex,Clipboard) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when state is not set the container and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullContainer() {
        state = new SimpleStateImpl();
        try {
            new MockCutStateNodeAbstractAction("Cut", state, clipboard);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests CutStateNodeAbstractAction#undo() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Undo is executed correctly, the CompositeState is added.
     * </p>
     * @throws Exception to JUnit
     */
    public void testUndo() throws Exception {
        action.execute();
        action.undo();
        assertTrue("Failed to execute the undo() method.", container.containsSubVertex(state));
    }

    /**
     * <p>
     * Tests CutStateNodeAbstractAction#undo() for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the action can not be undo and expects CannotUndoException.
     * </p>
     */
    public void testUndo_CannotUndoException() {
        action.undo();
        try {
            action.undo();
            fail("CannotUndoException expected.");
        } catch (CannotUndoException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests CutStateNodeAbstractAction#execute() for accuracy.
     * </p>
     *
     * <p>
     * Verify : Execute is executed correctly, the CompositeState is removed.
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

        assertFalse("Failed to execute the Execute() method.", container.containsSubVertex(state));
    }

    /**
     * <p>
     * Tests CutStateNodeAbstractAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the default constructor of the state
     * is not defined and expects ActivityObjectCloneException.
     * </p>
     *
     * @throws ActionExecutionException to JUnit
     */
    public void testExecute_ActivityObjectCloneException() throws ActionExecutionException {
        MockObjectFlowState mockObjectFlowState = new MockObjectFlowState("Test");
        mockObjectFlowState.setContainer(container);
        action = new MockCutStateNodeAbstractAction("Cut", (StateVertex) mockObjectFlowState, clipboard);
        try {
            action.execute();
            fail("ActivityObjectCloneException expected.");
        } catch (ActivityObjectCloneException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests CutStateNodeAbstractAction#execute() for failure.
     * </p>
     *
     * <p>
     * It tests the case when the state is unrecognizable and expects ActionExecutionException.
     * </p>
     */
    public void testExecute_Unrecognizable() {
        MockStateVertex mockStateVertex = new MockStateVertex();
        mockStateVertex.setContainer(container);
        action = new MockCutStateNodeAbstractAction("Cut", mockStateVertex, clipboard);
        try {
            action.execute();
            fail("ActionExecutionException expected.");
        } catch (ActionExecutionException e) {
            //good
        }
    }
}