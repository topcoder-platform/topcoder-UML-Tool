/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
import com.topcoder.uml.actions.model.activity.CopyStateNodeAbstractAction;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * This class aggregates accuracy tests for CopyStateNodeAbstractAction class.
 *
 * @author ch_music
 * @version 1.0
 */
public class CopyStateNodeAbstractActionAccuracyTests extends TestCase {

    /**
     * A placeholder for CopyStateNodeAbstractAction implementation to be tested.
     */
    private CopyStateNodeAbstractAction test;

    /**
     * The StateVertex to be used for testing.
     */
    private ActionState state = null;

    /**
     * The clipboard object to be used for testing.
     */
    private Clipboard clipboard = null;

    /**
     * Sets up environment for testing.
     */
    public void setUp() {
        state = AccuracyTestHelper.createActionState();
        clipboard = new Clipboard("test");
    }

    /**
     * Tests constructor.
     */
    public void testCopyStateNodeAbstractAction1() {
        assertNotNull("Constructor fails with null clipboard.", new MockCopyStateNodeAbstractAction(state, null));
    }

    /**
     * Tests constructor.
     */
    public void testCopyStateNodeAbstractAction2() {
        assertNotNull("Constructor fails with null clipboard.", new MockCopyStateNodeAbstractAction(state,
                clipboard));
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute1() throws Exception {
        test = new MockCopyStateNodeAbstractAction(state, null);
        test.execute();
        Object content = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(
                ActivityDataFlavor.ACTION_STATE);
        assertNotSame("execute method fails to clone.", state, content);
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute2() throws Exception {
        test = new MockCopyStateNodeAbstractAction(state, clipboard);
        test.execute();
        Object content = clipboard.getContents(null).getTransferData(ActivityDataFlavor.ACTION_STATE);
        assertNotSame("execute method fails to clone.", state, content);
    }

    /**
     * This is a mock class used to test CopyStateNodeAbstractAction class.
     *
     * @author ch_music
     * @version 1.0
     */
    private static class MockCopyStateNodeAbstractAction extends CopyStateNodeAbstractAction {

        /**
         * Constructs an instance of this class.
         *
         * @param state the StateVertex object to be copied to clipboard
         * @param clipboard the Clipboard object to which the StateVertex object is copied
         * @throws IllegalArgumentException if the state argument is null, or system clipboard could not be
         *             retrieved
         */
        public MockCopyStateNodeAbstractAction(StateVertex state, Clipboard clipboard) {
            super(state, clipboard);
        }
    }
}
