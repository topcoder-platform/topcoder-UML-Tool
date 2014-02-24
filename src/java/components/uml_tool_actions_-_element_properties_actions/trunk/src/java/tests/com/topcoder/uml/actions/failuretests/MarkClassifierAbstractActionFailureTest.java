/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.custom.MarkClassifierAbstractAction;

/**
 * Aggregates all failure tests for MarkClassifierAbstractAction class.
 * @author vilain
 * @version 1.0
 */
public class MarkClassifierAbstractActionFailureTest extends TestCase {

    /**
     * Constructor under test MarkClassifierAbstractAction(Classifier, boolean).
     * Failure testing of exception in case classifier is null.
     */
    public final void testMarkClassifierAbstractActionFailureClassifierNull() {
        try {
            new MarkClassifierAbstractAction(null, false);
            fail("IllegalArgumentException is expected since classifier is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}