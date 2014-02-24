/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
import com.topcoder.uml.actions.model.activity.CutTransitionAction;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * This class aggregates accuracy tests for CutTransitionAction.
 *
 * @author ch_music
 * @version 1.0
 */
public class CutTransitionActionAccuracyTests extends TestCase {

    /**
     * A placeholder for CutStateNodeAbstractAction implementation to be tested.
     */
    private CutTransitionAction test;

    /**
     * The StateVertex to be used for testing.
     */
    private Transition transition = null;

    /**
     * The container for the ActionState.
     */
    private StateMachine container = null;

    /**
     * The clipboard object to be used for testing.
     */
    private Clipboard clipboard = new Clipboard("test");

    /**
     * Sets up the environment for testing.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);

        transition = AccuracyTestHelper.createTransition();
        container = transition.getStateMachine();
    }

    /**
     * Tears down the environment.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        AccuracyTestHelper.tearConfig();
    }

    /**
     * Tests constructor.
     */
    public void testCutTransitionAction1() {
        test = new CutTransitionAction(transition, null);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Transition", test
                .getPresentationName());
    }

    /**
     * Tests constructor.
     */
    public void testCutTransitionAction2() {
        test = new CutTransitionAction(transition, clipboard);
        assertNotNull("Constructor fails to create instance.", test);
        assertEquals("Constructor fails to set correct presentation name.", "Cut Transition", test
                .getPresentationName());
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute1() throws Exception {
        test = new CutTransitionAction(transition, null);

        test.execute();
        Object content = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(
                ActivityDataFlavor.TRANSITION);
        assertFalse("execute method fails to remove transition from its container.", container
                .containsTransition(transition));
        assertNotSame("execute method fails to clone.", transition, content);
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute2() throws Exception {
        test = new CutTransitionAction(transition, clipboard);

        test.execute();
        Object content = clipboard.getContents(null).getTransferData(ActivityDataFlavor.TRANSITION);
        assertFalse("execute method fails to remove transition from its container.", container
                .containsTransition(transition));
        assertNotSame("execute method fails to clone.", transition, content);
    }

    /**
     * Tests undo method.
     *
     * @throws Exception to JUnit
     */
    public void testUndo1() throws Exception {
        test = new CutTransitionAction(transition, null);

        test.execute();
        test.undo();

        assertTrue("undo method fails to add transition into its container.", container
                .containsTransition(transition));
    }

    /**
     * Tests undo method.
     *
     * @throws Exception to JUnit
     */
    public void testUndo2() throws Exception {
        test = new CutTransitionAction(transition, clipboard);

        test.execute();
        test.undo();

        assertTrue("undo method fails to add transition into its container.", container
                .containsTransition(transition));
    }
}
