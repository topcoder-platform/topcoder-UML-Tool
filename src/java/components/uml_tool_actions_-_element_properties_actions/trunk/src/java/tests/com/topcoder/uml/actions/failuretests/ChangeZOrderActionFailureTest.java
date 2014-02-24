/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.general.ChangeZOrderAction;
import com.topcoder.uml.actions.general.operationtypes.ChangeZOrderOperationType;

/**
 * Aggregates all failure tests for ChangeZOrderAction class.
 * @author vilain
 * @version 1.0
 */
public class ChangeZOrderActionFailureTest extends TestCase {

    /**
     * Constructor under test ChangeZOrderAction(GraphElement,
     * ChangeZOrderOperationType). Failure testing of exception in case element
     * is null.
     */
    public final void testChangeZOrderActionFailureElementNull() {
        try {
            new ChangeZOrderAction(null, ChangeZOrderOperationType.BACKWARD);
            fail("IllegalArgumentException is expected since element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangeZOrderAction(GraphElement ,
     * ChangeZOrderOperationType). Failure testing of exception in case
     * operation type is null.
     */
    public final void testChangeZOrderActionFailureZOrderNull() {
        try {
            new ChangeZOrderAction(new GraphElement() {
            }, null);
            fail("IllegalArgumentException is expected since operation type is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}