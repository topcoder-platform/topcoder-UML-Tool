/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import com.topcoder.uml.model.core.FeatureAbstractImpl;
import com.topcoder.uml.model.datatypes.ScopeKind;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>FeatureAbstractImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class FeatureAbstractImplAccuracyTests extends TestCase {

    /** Represents the <code>FeatureAbstractImpl</code> instance used for testing. */
    private FeatureAbstractImpl feature;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the mocked FeatureAbstractImpl instance
        feature = new MockFeatureImpl();
    }

    /**
     * Accuracy test of method <code>setOwner(Classifier)</code> and <code>getOwner()</code>.
     */
    public void testOwnerSetterAndGetter() {
        //the initial value is null
        assertNull(feature.getOwner());
        //set the owner with valid Classifier
        feature.setOwner(new MockClassifierImpl());
        assertNotNull(feature.getOwner());
        //set the owner with null
        feature.setOwner(null);
        assertNull(feature.getOwner());
    }

    /**
     * Accuracy test of method <code>setOwnerScope(ScopeKind)</code> and <code>getOwnerScope()</code>.
     */
    public void testOwnerScopeSetterAndGetter() {
        //the initial value is null
        assertNull(feature.getOwnerScope());
        //set the owner with valid ScopeKind
        feature.setOwnerScope(ScopeKind.CLASSIFIER);
        assertNotNull(feature.getOwnerScope());
        //set the owner with null
        feature.setOwnerScope(null);
        assertNull(feature.getOwnerScope());
    }
}
