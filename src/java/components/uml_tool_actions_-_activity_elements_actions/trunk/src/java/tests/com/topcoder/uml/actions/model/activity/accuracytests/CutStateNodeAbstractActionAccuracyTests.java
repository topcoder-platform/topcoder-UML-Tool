/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
import com.topcoder.uml.actions.model.activity.CutStateNodeAbstractAction;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * This class aggregates accuracy tests for CutStateNodeAbstractAction.
 *
 * @author ch_music
 * @version 1.0
 */
public class CutStateNodeAbstractActionAccuracyTests extends TestCase {

    /**
     * A placeholder for CutStateNodeAbstractAction implementation to be tested.
     */
    private CutStateNodeAbstractAction test;

    /**
     * The StateVertex to be used for testing.
     */
    private ActionState state = null;

    /**
     * The container for the ActionState.
     */
    private CompositeState container = null;

    /**
     * The clipboard object to be used for testing.
     */
    private Clipboard clipboard = null;

    /**
     * Sets up environment for testing.
     *
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        AccuracyTestHelper.loadConfig(AccuracyTestHelper.LOG_NAMESPACE, AccuracyTestHelper.LOG_CONFIGPATH);

        state = AccuracyTestHelper.createActionState();
        container = state.getContainer();
        clipboard = new Clipboard("test");
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
    public void testCutStateNodeAbstractAction1() {
        test = new MockCutStateNodeAbstractAction(state, null);
        assertNotNull("Constructor fails with null clipboard.", test);
        assertEquals("Constructor fails to set presentation name.", "Test Presentation Name", test
                .getPresentationName());
    }

    /**
     * Tests constructor.
     */
    public void testCutStateNodeAbstractAction2() {
        test = new MockCutStateNodeAbstractAction(state, clipboard);
        assertNotNull("Constructor fails with non-null clipboard.", test);
        assertEquals("Constructor fails to set presentation name.", "Test Presentation Name", test
                .getPresentationName());
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute1() throws Exception {
        test = new MockCutStateNodeAbstractAction(state, null);

        test.execute();
        Object content = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(
                ActivityDataFlavor.ACTION_STATE);
        assertFalse("execute method fails to remove state from container.", container.containsSubVertex(state));
        assertNotSame("execute method fails to clone.", state, content);
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute2() throws Exception {
        test = new MockCutStateNodeAbstractAction(state, clipboard);

        test.execute();
        Object content = clipboard.getContents(null).getTransferData(ActivityDataFlavor.ACTION_STATE);
        assertFalse("execute method fails to remove state from container.", container.containsSubVertex(state));
        assertNotSame("execute method fails to clone.", state, content);
    }

    /**
     * Tests undo method.
     *
     * @throws Exception to JUnit
     */
    public void testUndo1() throws Exception {
        test = new MockCutStateNodeAbstractAction(state, null);

        test.execute();
        test.undo();

        assertTrue("undo method fails to add transition into its container.", container.containsSubVertex(state));
    }

    /**
     * Tests undo method.
     *
     * @throws Exception to JUnit
     */
    public void testUndo2() throws Exception {
        test = new MockCutStateNodeAbstractAction(state, clipboard);

        test.execute();
        test.undo();

        assertTrue("undo method fails to add transition into its container.", container.containsSubVertex(state));
    }

    /**
     * This is a mock class used to test CutStateNodeAbstractAction class.
     *
     * @author ch_music
     * @version 1.0
     */
    private static class MockCutStateNodeAbstractAction extends CutStateNodeAbstractAction {

        /**
         * Constructs an instance of this class.
         *
         * @param state the StateVertex object to be copied to clipboard
         * @param clipboard the Clipboard object to which the StateVertex object is copied
         * @throws IllegalArgumentException if the state argument is null, or system clipboard could not be
         *             retrieved
         */
        public MockCutStateNodeAbstractAction(StateVertex state, Clipboard clipboard) {
            super("Test Presentation Name", state, clipboard);
        }
    }
}
