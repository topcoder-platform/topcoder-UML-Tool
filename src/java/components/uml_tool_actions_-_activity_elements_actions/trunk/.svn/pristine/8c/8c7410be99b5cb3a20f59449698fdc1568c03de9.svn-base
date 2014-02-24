/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.activity.ActivityDataFlavor;
import com.topcoder.uml.actions.model.activity.CopyTransitionAction;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * This class aggregates accuracy tests for CopyTransitionAction class.
 *
 * @author ch_music
 * @version 1.0
 */
public class CopyTransitionActionAccuracyTests extends TestCase {

    /**
     * A placeholder for CopyStateNodeAbstractAction implementation to be tested.
     */
    private CopyTransitionAction test;

    /**
     * The StateVertex to be used for testing.
     */
    private Transition transition = null;

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
        transition = AccuracyTestHelper.createTransition();
    }

    /**
     * Tests constructor.
     */
    public void testCopyTransitionAction1() {
        assertNotNull("Constructor fails with null clipboard.", new CopyTransitionAction(transition, null));
    }

    /**
     * Tests constructor.
     */
    public void testCopyTransitionAction2() {
        assertNotNull("Constructor fails with non-null clipboard.",
                new CopyTransitionAction(transition, clipboard));
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute1() throws Exception {
        test = new CopyTransitionAction(transition, null);
        test.execute();
        Object content = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(
                ActivityDataFlavor.TRANSITION);
        assertNotSame("execute method fails to clone.", transition, content);
    }

    /**
     * Tests execute method.
     *
     * @throws Exception to JUnit
     */
    public void testExecute2() throws Exception {
        test = new CopyTransitionAction(transition, clipboard);
        test.execute();
        Object content = clipboard.getContents(null).getTransferData(ActivityDataFlavor.TRANSITION);
        assertNotSame("execute method fails to clone.", transition, content);
    }
}
