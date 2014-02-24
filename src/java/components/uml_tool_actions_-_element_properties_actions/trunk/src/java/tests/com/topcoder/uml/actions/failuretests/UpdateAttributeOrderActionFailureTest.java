/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.UpdateAttributeOrderAction;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;

/**
 * Aggregates all failure tests for UpdateAttributeOrderAction class.
 * @author vilain
 * @version 1.0
 */
public class UpdateAttributeOrderActionFailureTest extends TestCase {

    /**
     * Constructor under test UpdateAttributeOrderAction(Classifier, Attribute,
     * int). Failure testing of exception in case classifier is null.
     */
    public final void testUpdateAttributeOrderActionFailureClassifierNull() {
        try {
            new UpdateAttributeOrderAction(null, new AttributeImpl(), 0);
            fail("IllegalArgumentException is expected since classifier is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateAttributeOrderAction(Classifier,
     * Attribute,int). Failure testing of exception in case attribute is null.
     */
    public final void testUpdateAttributeOrderActionFailureAttributeNull() {
        try {
            new UpdateAttributeOrderAction(new ClassifierAbstractImpl() {
            }, null, 0);
            fail("IllegalArgumentException is expected since attribute is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateAttributeOrderAction(Classifier,
     * Attribute,int). Failure testing of exception in case position is less
     * then 0.
     */
    public final void testUpdateAttributeOrderActionFailurePositionLessZero() {
        try {
            new UpdateAttributeOrderAction(new ClassifierAbstractImpl() {
            }, new AttributeImpl(), -1);
            fail("IllegalArgumentException is expected since position is less then 0");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateAttributeOrderAction(Classifier,
     * Attribute,int). Failure testing of exception in case position is greater
     * than features number.
     */
    public final void testUpdateAttributeOrderActionFailurePositionGreaterSize() {
        try {
            new UpdateAttributeOrderAction(new ClassifierAbstractImpl() {
            }, new AttributeImpl(), 1);
            fail("IllegalArgumentException is expected since position is greater than features number");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}