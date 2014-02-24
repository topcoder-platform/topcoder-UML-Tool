/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.stresstests;

import com.topcoder.uml.actions.model.usecase.CopyActorAction;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;

import junit.framework.TestCase;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

/**
 * Stress test cases for class <code>CopyAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class StressTestCopyActorAction extends TestCase {
    /**
     * Stress test case for method <code> execute() </code>.
     *
     * @throws Exception
     *             to junit.
     *
     */
    public void testCopyActionExecute() throws Exception {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        Actor actor = new ActorImpl();

        for (int i = 0; i < 100; i++) {
            CopyActorAction action = new CopyActorAction(actor, clipboard);

            // invoke execute.
            action.execute();
            // after execute , we check the clipboard if execute successfully.
            assertNotNull("The contents should not be null.", clipboard.getContents(null));
        }
    }
}