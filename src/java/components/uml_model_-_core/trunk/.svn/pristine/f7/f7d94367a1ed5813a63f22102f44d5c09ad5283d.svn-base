/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.failuretests;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.BehavioralFeatureAbstractImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;

/**
 * Aggregates all failure tests for BehavioralFeatureAbstractImpl class.
 * @author vilain
 * @version 1.0
 */
public class BehavioralFeatureAbstractImplFailureTest extends TestCase {

    /**
     * Index for testing.
     */
    private int index = 0;

    /**
     * Instance of BehavioralFeatureAbstractImpl for testing.
     */
    private Parameter parameter;

    /**
     * Instance of BehavioralFeatureAbstractImpl for testing.
     */
    private BehavioralFeatureAbstractImpl behavioralFeatureAbstractImpl;

    /**
     * Setting up environment for each test case.
     */
    protected void setUp() {
        parameter = new ParameterImpl();
        behavioralFeatureAbstractImpl = new BehavioralFeatureAbstractImpl() {
        };
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.addParameter(Parameter).
     * Failure testing of exception in case parameter is null.
     */
    public final void testAddParameterParameterNull() {
        try {
            behavioralFeatureAbstractImpl.addParameter(null);
            fail("IllegalArgumentException is expected since parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.addParameter(int,
     * Parameter). Failure testing of exception in case index is out of bounds.
     */
    public final void testAddParameterIntParameterIndexLess() {
        try {
            behavioralFeatureAbstractImpl.addParameter(-1, parameter);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.addParameter(int,
     * Parameter). Failure testing of exception in case index is out of bounds.
     */
    public final void testAddParameterIntParameterIndexGreater() {
        try {
            behavioralFeatureAbstractImpl.addParameter(1, parameter);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.addParameter(int,
     * Parameter). Failure testing of exception in case parameter is null.
     */
    public final void testAddParameterIntParameterNull() {
        try {
            behavioralFeatureAbstractImpl.addParameter(index, null);
            fail("IllegalArgumentException is expected since parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.setParameter(int,
     * Parameter). Failure testing of exception in case index is out of bounds.
     */
    public final void testSetParameterIndexLess() {
        try {
            behavioralFeatureAbstractImpl.setParameter(-1, parameter);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.setParameter(int,
     * Parameter). Failure testing of exception in case index is out of bounds.
     */
    public final void testSetParameterIndexGreater() {
        try {
            behavioralFeatureAbstractImpl.setParameter(0, parameter);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.setParameter(int,
     * Parameter). Failure testing of exception in case parameter is null.
     */
    public final void testSetParameterIntParameterNull() {
        behavioralFeatureAbstractImpl.addParameter(parameter);
        try {
            behavioralFeatureAbstractImpl.setParameter(index, null);
            fail("IllegalArgumentException is expected since parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.removeParameter(int).
     * Failure testing of exception in case index is out of bounds.
     */
    public final void testRemoveParameterIntIndexLess() {
        try {
            behavioralFeatureAbstractImpl.removeParameter(-1);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }
    }

    /**
     * Method under test BehavioralFeatureAbstractImpl.removeParameter(int).
     * Failure testing of exception in case index is out of bounds.
     */
    public final void testRemoveParameterIntIndexGreater() {
        behavioralFeatureAbstractImpl.addParameter(parameter);
        try {
            behavioralFeatureAbstractImpl.removeParameter(1);
            fail("IndexOutOfBoundsException is expected since index is out of bounds");
        } catch (IndexOutOfBoundsException e) {
            // good
        }

    }

    /**
     * Method under test
     * BehavioralFeatureAbstractImpl.removeParameter(Parameter). Failure testing
     * of exception in case parameter is null.
     */
    public final void testRemoveParameterParameterNull() {
        try {
            behavioralFeatureAbstractImpl.removeParameter(null);
            fail("IllegalArgumentException is expected since parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * BehavioralFeatureAbstractImpl.containsParameter(Parameter). Failure
     * testing of exception in case parameter is null.
     */
    public final void testContainsParameterNull() {
        try {
            behavioralFeatureAbstractImpl.containsParameter(null);
            fail("IllegalArgumentException is expected since parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Method under test
     * BehavioralFeatureAbstractImpl.indexOfParameter(Parameter). Failure
     * testing of exception in case parameter is null.
     */
    public final void testIndexOfParameterNull() {
        try {
            behavioralFeatureAbstractImpl.indexOfParameter(null);
            fail("IllegalArgumentException is expected since parameter is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}