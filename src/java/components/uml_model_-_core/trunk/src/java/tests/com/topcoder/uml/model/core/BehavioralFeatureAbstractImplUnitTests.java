/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import junit.framework.TestCase;
import java.util.List;
import java.util.LinkedList;

/**
 * <p>
 * Unit test for <code>BehavioralFeatureAbstractImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class BehavioralFeatureAbstractImplUnitTests extends TestCase {

    /**
     * This class extends the <code>BehavioralFeatureAbstractImpl</code>. It is only used in unit test.
     */
    private class BehavioralFeatureImpl extends BehavioralFeatureAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public BehavioralFeatureImpl() {
        }
    }

    /**
     * <p>
     * Response the <code>BehavioralFeatureAbstractImpl</code> instance used for tests.
     * </p>
     */
    private BehavioralFeatureAbstractImpl testBehavioralFeatureAbstractImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testBehavioralFeatureAbstractImpl = new BehavioralFeatureImpl();
    }

    /**
     * <p>
     * Accuracy test the <code>BehavioralFeatureAbstractImpl()</code> constructor. BehavioralFeatureAbstractImpl
     * should be created.
     * </p>
     */
    public void testBehavioralFeatureAbstractImplConstructor() {
        assertNotNull("Create BehavioralFeatureAbstractImpl object incorrectly.", new BehavioralFeatureImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setQuery(boolean)</code>, the <code>Query</code> field should be set.
     * </p>
     */
    public void testSetQuery() {
        testBehavioralFeatureAbstractImpl.setQuery(true);
        assertTrue("The Query field should be set.", testBehavioralFeatureAbstractImpl.isQuery());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>isQuery()</code>, the <code>Query</code> field should be returned.
     * </p>
     */
    public void testIsQuery() {
        testBehavioralFeatureAbstractImpl.setQuery(false);
        assertFalse("The Query field should be set.", testBehavioralFeatureAbstractImpl.isQuery());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addParameter(Parameter)</code>.
     * </p>
     */
    public void testAddParameterParameter() {
        Parameter parameter = new ParameterImpl();
        testBehavioralFeatureAbstractImpl.addParameter(parameter);
        assertTrue("Add parameter incorrectly.", testBehavioralFeatureAbstractImpl.removeParameter(parameter));
    }

    /**
     * <p>
     * Test the method of <code>addParameter(Parameter)</code> with null parameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddParameterNullParameter() {
        try {
            testBehavioralFeatureAbstractImpl.addParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>addParameter(int, Parameter)</code>.
     * <p>
     */
    public void testAddParameterIntParameter() {
        Parameter parameter = new ParameterImpl();
        testBehavioralFeatureAbstractImpl.addParameter(0, parameter);
        assertEquals("Add parameter incorrectly.", parameter, testBehavioralFeatureAbstractImpl.removeParameter(0));
    }

    /**
     * <p>
     * Test the method of <code>addParameter(int, Parameter)</code> with negative index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testAddParameterNegativeIntParameter() {
        try {
            testBehavioralFeatureAbstractImpl.addParameter(-1, new ParameterImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>addParameter(int, Parameter)</code> with too large index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testAddParameterTooLargeIntParameter() {
        try {
            testBehavioralFeatureAbstractImpl.addParameter(100000, new ParameterImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>addParameter(int, Parameter)</code> with null parameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddParameterIntNullParameter() {
        try {
            testBehavioralFeatureAbstractImpl.addParameter(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>setParameter(int, Parameter)</code>.
     * </p>
     */
    public void testSetParameter() {
        Parameter parameter1 = new ParameterImpl();
        testBehavioralFeatureAbstractImpl.addParameter(0, parameter1);

        // replace the parameter1 with parameter2.
        Parameter parameter2 = new ParameterImpl();
        testBehavioralFeatureAbstractImpl.setParameter(0, parameter2);
        assertEquals("Set parameter incorrectly.", parameter2, testBehavioralFeatureAbstractImpl.removeParameter(0));
    }

    /**
     * <p>
     * Test the method of <code>setParameter(int, Parameter)</code> with negative index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testSetParameterNegativeInt() {
        try {
            testBehavioralFeatureAbstractImpl.setParameter(-1, new ParameterImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>setParameter(int, Parameter)</code> with too large index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testSetParameterTooLargeInt() {
        try {
            testBehavioralFeatureAbstractImpl.setParameter(10000, new ParameterImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>setParameter(int, Parameter)</code> with null parameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testSetParameterNullParameter() {
        try {
            testBehavioralFeatureAbstractImpl.addParameter(new ParameterImpl());
            testBehavioralFeatureAbstractImpl.setParameter(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeParameter(int)</code>.
     * </p>
     */
    public void testRemoveParameterInt() {
        Parameter parameter = new ParameterImpl();
        testBehavioralFeatureAbstractImpl.addParameter(0, parameter);
        assertEquals("Remove parameter incorrectly.", parameter, testBehavioralFeatureAbstractImpl.removeParameter(0));
    }

    /**
     * <p>
     * Test the method of <code>removeParameter(int)</code> with negative index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testRemoveParameterNegativeInt() {
        try {
            testBehavioralFeatureAbstractImpl.removeParameter(-1);
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>removeParameter(int)</code> with too large index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testRemoveParameterTooLargeInt() {
        try {
            testBehavioralFeatureAbstractImpl.removeParameter(9999);
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeParameter(Parameter)</code>.
     * </p>
     */
    public void testRemoveParameterParameter() {
        Parameter parameter = new ParameterImpl();
        testBehavioralFeatureAbstractImpl.addParameter(parameter);
        assertTrue("Remove parameter incorrectly.", testBehavioralFeatureAbstractImpl.removeParameter(parameter));
    }

    /**
     * <p>
     * Test the method of <code>removeParameter(Parameter)</code> with null parameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveParameterNullParameter() {
        try {
            testBehavioralFeatureAbstractImpl.removeParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearParameters()</code>.
     * <p>
     */
    public void testClearParameters() {
        testBehavioralFeatureAbstractImpl.clearParameters();
        assertEquals("The count of parameter should be 0.", 0, testBehavioralFeatureAbstractImpl.countParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getParameters()</code>.
     * </p>
     */
    public void testGetParameters() {
        testBehavioralFeatureAbstractImpl.clearParameters();
        List<Parameter> parameters = new LinkedList<Parameter>();
        for (int i = 0; i < 3; ++i) {
            Parameter parameter = new ParameterImpl();
            parameters.add(parameter);
            testBehavioralFeatureAbstractImpl.addParameter(parameter);
        }
        assertEquals("Get parameters incorrectly.", parameters, testBehavioralFeatureAbstractImpl.getParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsParameter(Parameter)</code>.
     * </p>
     */
    public void testContainsParameter() {
        Parameter parameter = new ParameterImpl();
        testBehavioralFeatureAbstractImpl.addParameter(parameter);
        assertTrue("Contains parameter incorrectly.", testBehavioralFeatureAbstractImpl.containsParameter(parameter));

        assertFalse("Contains parameter incorrectly.", testBehavioralFeatureAbstractImpl
                .containsParameter(new ParameterImpl()));
    }

    /**
     * <p>
     * Test the method of <code>ContainsParameter(Parameter)</code> with null parameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsParameterNullParameter() {
        try {
            testBehavioralFeatureAbstractImpl.containsParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>indexOfParameter(Parameter)</code>.
     * </p>
     */
    public void testIndexOfParameter() {
        Parameter parameter = new ParameterImpl();
        testBehavioralFeatureAbstractImpl.addParameter(0, parameter);
        assertEquals("Index of parameter incorrectly.", 0, testBehavioralFeatureAbstractImpl
                .indexOfParameter(parameter));

        assertEquals("Index of parameter incorrectly.", -1, testBehavioralFeatureAbstractImpl
                .indexOfParameter(new ParameterImpl()));
    }

    /**
     * <p>
     * Test the method of <code>indexOfParameter(Parameter)</code> with null parameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testIndexOfParameterNullParameter() {
        try {
            testBehavioralFeatureAbstractImpl.indexOfParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countParameters()</code>.
     * </p>
     */
    public void testCountParameters() {
        testBehavioralFeatureAbstractImpl.clearParameters();
        assertEquals("The count of parameters should be 0.", 0, testBehavioralFeatureAbstractImpl.countParameters());

        testBehavioralFeatureAbstractImpl.addParameter(new ParameterImpl());
        assertEquals("The count of parameters should be 1.", 1, testBehavioralFeatureAbstractImpl.countParameters());
    }
}
