/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import java.util.HashMap;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.UpdateOperationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * Aggregates all failure tests for UpdateOperationAction class.
 * @author vilain
 * @version 1.0
 */
public class UpdateOperationActionFailureTest extends TestCase {

    /**
     * Constructor under test UpdateOperationAction(Operation, VisibilityKind,
     * String, Map, Classifier, CallConcurrencyKind, ChangeableKind, boolean,
     * ScopeKind). Failure testing of exception in case attribute is null.
     */
    public final void testUpdateOperationActionFailureOperationNull() {
        try {
            new UpdateOperationAction(null, VisibilityKind.PACKAGE, "name", new HashMap<String,Classifier>(),
                new ClassifierAbstractImpl() {
                }, CallConcurrencyKind.CONCURRENT, false, ScopeKind.CLASSIFIER);
            fail("IllegalArgumentException is expected since attribute is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateOperationAction(Operation, VisibilityKind,
     * String, Map, Classifier, CallConcurrencyKind, ChangeableKind, boolean,
     * ScopeKind). Failure testing of exception in case attribute is null.
     */
    public final void testUpdateOperationActionFailureNameNull() {
        try {
            new UpdateOperationAction(new OperationImpl(), VisibilityKind.PACKAGE, null,
                new HashMap<String,Classifier>(), new ClassifierAbstractImpl() {
                }, CallConcurrencyKind.CONCURRENT, false, ScopeKind.CLASSIFIER);
            fail("IllegalArgumentException is expected since name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}