/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.actions.general.ChangePositionAction;

/**
 * Aggregates all failure tests for ChangePositionAction class.
 * @author vilain
 * @version 1.0
 */
public class ChangePositionActionFailureTest extends TestCase {

    /**
     * Constructor under test ChangePositionAction(GraphElement, Point). Failure
     * testing of exception in case element is null.
     */
    public final void testChangePositionActionFailureElementNull() {
        try {
            new ChangePositionAction(null, new Point());
            fail("IllegalArgumentException is expected since element is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test ChangePositionAction(GraphElement , Point).
     * Failure testing of exception in case position is null.
     */
    public final void testChangePositionActionFailurePositionNull() {
        try {
            new ChangePositionAction(new GraphElement() {
            }, null);
            fail("IllegalArgumentException is expected since position is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}