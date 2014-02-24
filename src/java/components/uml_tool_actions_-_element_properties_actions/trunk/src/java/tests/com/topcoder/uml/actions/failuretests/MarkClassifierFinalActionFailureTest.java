/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.MarkClassifierFinalAction;

/**
 * Aggregates all failure tests for MarkClassifierFinalAction class.
 * @author vilain
 * @version 1.0
 */
public class MarkClassifierFinalActionFailureTest extends TestCase {

    /**
     * Constructor under test MarkClassifierFinalAction(Classifier, boolean).
     * Failure testing of exception in case classifier is null.
     */
    public final void testMarkClassifierFinalActionFailureClassifierNull() {
        try {
            new MarkClassifierFinalAction(null, false);
            fail("IllegalArgumentException is expected since classifier is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}