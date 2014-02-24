/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ScopeKind;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>ModelElementAbstractImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class StructuralFeatureAbstractImplAccuracyTests extends TestCase {

    /** Represents the mocked <code>StructuralFeatureAbstractImpl</code> instance used for testing. */
    private StructuralFeatureAbstractImpl feature;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the mocked StructuralFeatureAbstractImpl instance
        feature = new MockStructuralFeatureImpl();
    }

    /**
     * Accuracy test of method <code>setMultiplicity(Multiplicity)</code> and <code>getMultiplicity()</code>.
     */
    public void testMultiplicitySetterAndGetter() {
        //initial value is null
        assertNull(feature.getMultiplicity());
        //set the Multiplicity with specified Multiplicity
        feature.setMultiplicity(new MultiplicityImpl());
        assertNotNull(feature.getMultiplicity());
        //set the Multiplicity with null
        feature.setMultiplicity(null);
        assertNull(feature.getMultiplicity());
    }

    /**
     * Accuracy test of method <code>setChangeablilty(ChangeableKind)</code> and <code>getChangeablilty()</code>.
     */
    public void testChangeabliltySetterAndGetter() {
        //initial value is null
        assertNull(feature.getChangeability());
        //set the Changeability with specified ChangeableKind
        feature.setChangeability(ChangeableKind.CHANGEABLE);
        assertNotNull(feature.getChangeability());
        //set the Changeability with null
        feature.setChangeability(null);
        assertNull(feature.getChangeability());
    }

    /**
     * Accuracy test of method <code>setTargetScope(ScopeKind)</code> and <code>getTargetScope()</code>.
     */
    public void testTargetScopeSetterAndGetter() {
        //initial value is null
        assertNull(feature.getTargetScope());
        //set the TargetScope with specified ScopeKind
        feature.setTargetScope(ScopeKind.CLASSIFIER);
        assertNotNull(feature.getTargetScope());
        //set the TargetScope with null
        feature.setTargetScope(null);
        assertNull(feature.getTargetScope());
    }

    /**
     * Accuracy test of method <code>setType(Classifier)</code> and <code>getType()</code>.
     */
    public void testTypeSetterAndGetter() {
        //initial value is null
        assertNull(feature.getType());
        //set the Type with specified Classifier
        feature.setType(new MockClassifierImpl());
        assertNotNull(feature.getType());
        //set the Type with null
        feature.setType(null);
        assertNull(feature.getType());
    }
}
