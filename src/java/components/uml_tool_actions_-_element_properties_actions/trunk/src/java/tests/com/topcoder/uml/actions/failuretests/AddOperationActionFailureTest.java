/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.OperationImpl;

/**
 * Aggregates all failure tests for AddAttributeAction class.
 * @author vilain
 * @version 1.0
 */
public class AddOperationActionFailureTest extends TestCase {

    /**
     * Constructor under test AddOperationAction(Classifier, Operation). Failure
     * testing of exception in case classifier is null.
     */
    public final void testAddOperationActionFailureClassifierNull() {
        try {
            new AddOperationAction(null, new OperationImpl());
            fail("IllegalArgumentException is expected since classifier is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test AddOperationAction(Classifier, Operation). Failure
     * testing of exception in case attribute is null.
     */
    public final void testAddOperationActionFailureOperationNull() {
        try {
            new AddOperationAction(new ClassifierAbstractImpl() {
            }, null);
            fail("IllegalArgumentException is expected since attribute is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}