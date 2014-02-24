/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.UpdateOperationOrderAction;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.OperationImpl;

/**
 * Aggregates all failure tests for UpdateOperationOrderAction class.
 * @author vilain
 * @version 1.0
 */
public class UpdateOperationOrderActionFailureTest extends TestCase {

    /**
     * Constructor under test UpdateOperationOrderAction(Classifier, Operation,
     * int). Failure testing of exception in case classifier is null.
     */
    public final void testUpdateOperationOrderActionFailureClassifierNull() {
        try {
            new UpdateOperationOrderAction(null, new OperationImpl(), 0);
            fail("IllegalArgumentException is expected since classifier is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateOperationOrderAction(Classifier,
     * Operation,int). Failure testing of exception in case attribute is null.
     */
    public final void testUpdateOperationOrderActionFailureOperationNull() {
        try {
            new UpdateOperationOrderAction(new ClassifierAbstractImpl() {
            }, null, 0);
            fail("IllegalArgumentException is expected since attribute is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateOperationOrderAction(Classifier,
     * Operation,int). Failure testing of exception in case position is less
     * then 0.
     */
    public final void testUpdateOperationOrderActionFailurePositionLessZero() {
        try {
            new UpdateOperationOrderAction(new ClassifierAbstractImpl() {
            }, new OperationImpl(), -1);
            fail("IllegalArgumentException is expected since position is less then 0");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateOperationOrderAction(Classifier,
     * Operation,int). Failure testing of exception in case position is greater
     * than features number.
     */
    public final void testUpdateOperationOrderActionFailurePositionGreaterSize() {
        try {
            new UpdateOperationOrderAction(new ClassifierAbstractImpl() {
            }, new OperationImpl(), 1);
            fail("IllegalArgumentException is expected since position is greater than features number");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}