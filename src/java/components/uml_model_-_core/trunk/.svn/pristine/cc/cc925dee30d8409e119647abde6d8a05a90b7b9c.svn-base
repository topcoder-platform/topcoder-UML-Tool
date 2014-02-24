/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>ParameterImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class ParameterImplAccuracyTests extends TestCase {

    /** Represents the mocked <code>ParameterImpl</code> instance used for testing. */
    private ParameterImpl parameter;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the ParameterImpl instance
        parameter = new ParameterImpl();
    }

    /**
     * Accuracy test of method <code>setDefaultValue(Expression)</code> and <code>getDefaultValue()</code>.
     */
    public void testDefaultValueSetterAndGetter() {
        //initial value is null
        assertNull(parameter.getDefaultValue());
        //set the DefaultValue with specified Expression
        parameter.setDefaultValue(new ExpressionImpl());
        assertNotNull(parameter.getDefaultValue());
        //set the DefaultValue with null
        parameter.setDefaultValue(null);
        assertNull(parameter.getDefaultValue());
    }

    /**
     * Accuracy test of method <code>setKind(ParameterDirectionKind)</code> and <code>getKind()</code>.
     */
    public void testKindSetterAndGetter() {
        //initial value is null
        assertNull(parameter.getKind());
        //set the Kind with specified ParameterDirectionKind
        parameter.setKind(ParameterDirectionKind.IN);
        assertNotNull(parameter.getKind());
        //set the Kind with null
        parameter.setKind(null);
        assertNull(parameter.getKind());
    }

    /**
     * Accuracy test of method <code>setType(Classifier)</code> and <code>getType()</code>.
     */
    public void testTypeSetterAndGetter() {
        //initial value is null
        assertNull(parameter.getType());
        //set the Type with specified Classifier
        parameter.setType(new MockClassifierImpl());
        assertNotNull(parameter.getType());
        //set the Type with null
        parameter.setType(null);
        assertNull(parameter.getType());
    }

    /**
     * Accuracy test of method <code>setBehavioralFeature(BehavioralFeature)</code> and
     * <code>getBehavioralFeature()</code>.
     */
    public void testBehavioralFeatureSetterAndGetter() {
        //initial value is null
        assertNull(parameter.getBehavioralFeature());
        //set the BehavioralFeature with specified BehavioralFeature
        parameter.setBehavioralFeature(new MockBehavioralFeatureImpl());
        assertNotNull(parameter.getBehavioralFeature());
        //set the BehavioralFeature with null
        parameter.setBehavioralFeature(null);
        assertNull(parameter.getBehavioralFeature());
    }
}
