/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.AddAttributeAction;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;

/**
 * Aggregates all failure tests for AddAttributeAction class.
 * @author vilain
 * @version 1.0
 */
public class AddAttributeActionFailureTest extends TestCase {

    /**
     * Constructor under test AddAttributeAction(Classifier, Attribute). Failure
     * testing of exception in case classifier is null.
     */
    public final void testAddAttributeActionFailureClassifierNull() {
        try {
            new AddAttributeAction(null, new AttributeImpl());
            fail("IllegalArgumentException is expected since classifier is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test AddAttributeAction(Classifier, Attribute). Failure
     * testing of exception in case attribute is null.
     */
    public final void testAddAttributeActionFailureAttributeNull() {
        try {
            new AddAttributeAction(new ClassifierAbstractImpl() {
            }, null);
            fail("IllegalArgumentException is expected since attribute is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}