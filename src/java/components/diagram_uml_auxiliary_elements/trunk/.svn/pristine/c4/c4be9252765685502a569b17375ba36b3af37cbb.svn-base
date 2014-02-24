/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.util.errorhandling.BaseRuntimeException;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for IllegalGraphNodeException.
 * </p>
 *
 * <p>
 * This class is pretty simple.
 * The test cases simply verifies the exception can be instantiated with the error message
 * and cause properly propagated, and that it comes with correct inheritance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class IllegalGraphNodeExceptionTests extends TestCase {
    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the IllegalGraphNodeException.
     * </p>
     */
    private static final Exception CAUSE_EXCEPTION = new NullPointerException();

    /**
     * <p>
     * The GraphNode instance for helping testing.
     * </p>
     */
    private GraphNode graphNode;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        graphNode = new GraphNode();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        graphNode = null;
    }

    /**
     * <p>
     * Return the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(IllegalGraphNodeExceptionTests.class);
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message is properly propagated.
     * </p>
     */
    public void testIllegalGraphNodeException1() {
        IllegalGraphNodeException exception = new IllegalGraphNodeException(graphNode, ERROR_MESSAGE);
        assertNotNull("Unable to instantiate IllegalGraphNodeException.", exception);
        assertEquals("Error message is not properly propagated to super class.",
                ERROR_MESSAGE, exception.getMessage());
    }

    /**
     * <p>
     * Creation test.
     * </p>
     *
     * <p>
     * Verifies the error message and the cause are properly propagated.
     * </p>
     */
    public void testIllegalGraphNodeException2() {
        IllegalGraphNodeException exception =
            new IllegalGraphNodeException(graphNode, ERROR_MESSAGE, CAUSE_EXCEPTION);
        assertNotNull("Unable to instantiate IllegalGraphNodeException.", exception);
        assertTrue("The error message should match", exception.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("Cause is not properly propagated to super class.", CAUSE_EXCEPTION, exception.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies IllegalGraphNodeException subclasses BaseRuntimeException.
     * </p>
     */
    public void testIllegalGraphNodeExceptionInheritance1() {
        IllegalGraphNodeException exception = new IllegalGraphNodeException(graphNode, ERROR_MESSAGE);
        assertTrue("IllegalGraphNodeException does not subclass BaseRuntimeException.",
                exception instanceof BaseRuntimeException);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     *
     * <p>
     * Verifies IllegalGraphNodeException subclasses BaseRuntimeException.
     * </p>
     */
    public void testIllegalGraphNodeExceptionInheritance2() {
        IllegalGraphNodeException exception =
            new IllegalGraphNodeException(graphNode, ERROR_MESSAGE, CAUSE_EXCEPTION);
        assertTrue("IllegalGraphNodeException does not subclass BaseRuntimeException.",
                exception instanceof BaseRuntimeException);
    }

    /**
     * <p>
     * Tests IllegalGraphNodeException#getGraphNode() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the IllegalGraphNodeException#getGraphNode() is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testGetGraphNode() throws Exception {
        IllegalGraphNodeException exception = new IllegalGraphNodeException(graphNode, ERROR_MESSAGE);
        assertTrue("The return value of getGraphNode() should be GraphNode.",
                exception.getGraphNode() instanceof GraphNode);
        assertEquals("The return value of newly created IllegalGraphNodeException's getGraphNode"
                + "should equal with the graphNode parameter of constructor.",
                graphNode, exception.getGraphNode());

        exception = new IllegalGraphNodeException(graphNode, ERROR_MESSAGE, CAUSE_EXCEPTION);
        assertTrue("The return value of getGraphNode() should be GraphNode.",
                exception.getGraphNode() instanceof GraphNode);
        assertEquals("The return value of newly created IllegalGraphNodeException's getGraphNode"
                + "should equal with the graphNode parameter of constructor.",
                graphNode, exception.getGraphNode());
    }
}
