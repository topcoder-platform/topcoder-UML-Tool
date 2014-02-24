/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.stresstests;

import junit.framework.TestCase;

import com.topcoder.util.actionmanager.TransientAction;
import com.topcoder.util.actionmanager.TransientUndoableAction;

/**
 * Stress test case for <code>TransientUndoableAction</code>.
 * @author fuyun
 * @version 1.0
 */
public class TransientUndoableActionStressTest extends TestCase {

    /**
     * Tests the efficiency of <code>Execute()</code> method.
     * @throws Exception if there is any problem.
     */
    public void testExecuteStress() throws Exception {
        TransientAction action = new MyTransientAction();
        String presentationName = "TransientUndoableAction";
        TransientUndoableAction instance = new TransientUndoableAction(action,
                presentationName);
        for (int i = 0; i < 100; i++) {
            instance.execute();
        }
    }

}
