/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.stresstests;

import junit.framework.TestCase;

import com.topcoder.util.actionmanager.CompoundUndoableAction;

/**
 * Stress test for class <code>CompoundUndoableAction</code>.
 * @author fuyun
 * @version 1.0
 */
public class CompoundUndoableActionStressTest extends TestCase {

    /**
     * Represents the <code>CompoundUndoableAction</code> instance to testing.
     */
    private CompoundUndoableAction instance = null;

    /**
     * <p>
     * Sets up the test environment.
     * </p>
     * <p>
     * The instance for test is created.
     * </p>
     */
    protected void setUp() {
        instance = new CompoundUndoableAction("CompoundUndoableAction");
    }

    /**
     * Stress test for method <code>addEdit(UndoableEdit)</code>.
     */
    public void testAddEditStress() {
        for (int i = 0; i < 100; i++) {
            instance.addEdit(new MyUndoableAction());
        }
    }

    /**
     * Stress test for method <code>execute()</code>.
     * @throws Exception if there is any problem.
     */
    public void testExecuteStress() throws Exception {
        for (int i = 0; i < 100; i++) {
            MyUndoableAction action = new MyUndoableAction();
            if (i % 2 == 0) {
                action.setThrowException(true);
            }
            instance.addEdit(action);
        }
        for (int i = 0; i < 10; i++) {
            try {
                instance.execute();
            } catch (Exception e) {
                //success
            }
            assertNotNull("Fails to get last exception.", instance
                    .getLastException());
        }
    }

}
