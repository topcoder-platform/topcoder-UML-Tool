/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.MarkNestedClassifierStaticAction;

/**
 * Aggregates all failure tests for MarkNestedClassifierStaticAction class.
 * @author vilain
 * @version 1.0
 */
public class MarkNestedClassifierStaticActionFailureTest extends TestCase {

    /**
     * Constructor under test MarkNestedClassifierStaticAction(Classifier,
     * boolean). Failure testing of exception in case classifier is null.
     */
    public final void testMarkNestedClassifierActionFailureClassifierNull() {
        try {
            new MarkNestedClassifierStaticAction(null, false);
            fail("IllegalArgumentException is expected since classifier is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}