/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import java.util.List;

import com.topcoder.uml.model.core.BehavioralFeatureAbstractImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy tests for <code>BehavioralFeatureAbstractImpl</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class BehavioralFeatureAbstractImplAccuracyTests extends TestCase {

    /** Represents the mocked <code>BehavioralFeatureAbstractImpl</code> instance used for testing. */
    private BehavioralFeatureAbstractImpl feature;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        //creates the mocked BehavioralFeatureAbstractImpl instance
        feature = new MockBehavioralFeatureImpl();
    }

    /**
     * Accuracy test of method <code>setQuery(boolean)</code> and <code>isQuery()</code>.
     */
    public void testQuerySetterAndGetter() {
        //initial value is false
        assertFalse(feature.isQuery());
        //sets the Query with true
        feature.setQuery(true);
        assertTrue(feature.isQuery());
        //sets the Query with false
        feature.setQuery(false);
        assertFalse(feature.isQuery());
    }

    /**
     * Accuracy test of method <code>addParameter(Parameter)</code>,
     * <code>addParameter(int, Parameter)</code>,
     * <code>setParameter(int, Parameter)</code>,
     * <code>removeParameter(Parameter)</code>,
     * <code>removeParameter(int)</code>,
     * <code>containsParameter(Parameter)</code>,
     * <code>indexOfParameter(Parameter)</code>,
     * <code>clearParameters()</code>,
     * <code>getParameters()</code> and <code>countParameters()</code>.
     */
    public void testParameterOperations() {
        //initial value is empty LinkedList
        assertEquals(0, feature.countParameters());
        //add a Parameter
        Parameter parameter0 = new ParameterImpl();
        feature.addParameter(parameter0);
        assertEquals(1, feature.countParameters());
        //add another Parameter
        Parameter parameter1 = new ParameterImpl();
        feature.addParameter(0, parameter1);
        assertEquals(2, feature.countParameters());
        assertEquals(1, feature.indexOfParameter(parameter0));
        assertEquals(0, feature.indexOfParameter(parameter1));
        //set a new Parameter
        Parameter parameter2 = new ParameterImpl();
        feature.setParameter(1, parameter2);
        assertEquals(2, feature.countParameters());
        assertEquals(1, feature.indexOfParameter(parameter2));
        assertEquals(0, feature.indexOfParameter(parameter1));
        assertFalse(feature.containsParameter(parameter0));
        //remove a Parameter
        assertFalse(feature.removeParameter(parameter0));
        assertEquals(parameter2, feature.removeParameter(1));
        assertEquals(1, feature.countParameters());
        //get all the Parameter
        List<Parameter> parameters = feature.getParameters();
        assertEquals(1, parameters.size());
        //clear all the Parameter
        feature.clearParameters();
        assertEquals(0, feature.countParameters());
    }
}
