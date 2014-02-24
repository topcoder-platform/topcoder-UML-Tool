/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.accuracytests;

import com.topcoder.util.actionmanager.TransientAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Mock of TransientAction class used for testing.
 *
 * @author hackerzhut
 * @version 1.0
 */
public class MockTransientAction implements TransientAction {
    /** The AtomicInteger instance.*/
    private AtomicInteger integer = null;

    /**
     * Mock implementation.
     */
    public MockTransientAction() {
    }

    /**
     * Mock implementation.
     *
     * @param integer the AtomicInteger.
     */
    public MockTransientAction(AtomicInteger integer) {
        this.integer = integer;
    }

    /**
     * Mock implementation.
     */
    public void execute() {
        if (integer != null) {
            integer.incrementAndGet();
        }
    }
}
