/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for IllegalGraphElementException.
 * </p>
 * <p>
 * This class is pretty simple. The test cases simply verifies the exception can be instantiated with the Illegal
 * <code>GraphElement</code>, the error message and cause properly propagated, and that it comes with correct
 * inheritance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class IllegalGraphElementExceptionTests extends TestCase {
    /**
     * <p>
     * The illegal graphElement used for testing.
     * </p>
     */
    private static final GraphElement ILLEGAL_GRAPHELEMENT = new GraphNode();

    /**
     * <p>
     * The error message used for testing.
     * </p>
     */
    private static final String ERROR_MESSAGE = "test error message";

    /**
     * <p>
     * An exception instance used to create the IllegalGraphElementException.
     * </p>
     */
    private static final Exception CAUSE_EXCEPTION = new NullPointerException();

    /**
     * <p>
     * Test the constructor.
     * </p>
     * <p>
     * It verifies the newly created exception instance should not be null.
     * </p>
     */
    public void testIllegalGraphElementExceptionCtor1() {
        IllegalGraphElementException exception = new IllegalGraphElementException(ILLEGAL_GRAPHELEMENT, ERROR_MESSAGE);
        assertNotNull("Unable to instantiate IllegalGraphElementException.", exception);
    }

    /**
     * <p>
     * Test the constructor.
     * </p>
     * <p>
     * It verifies the Illegal graphElement and error message are properly propagated.
     * </p>
     */
    public void testIllegalGraphElementExceptionCtor2() {
        IllegalGraphElementException exception = new IllegalGraphElementException(ILLEGAL_GRAPHELEMENT, ERROR_MESSAGE);
        assertNotNull("Unable to instantiate IllegalGraphElementException.", exception);
        assertEquals("Illegal graphElement is not properly propagated.", ILLEGAL_GRAPHELEMENT,
                exception.getGraphElement());
        assertEquals("Error message is not properly propagated to super class.", ERROR_MESSAGE, exception.getMessage());
    }

    /**
     * <p>
     * Test the constructor.
     * </p>
     * <p>
     * It verifies the Illegal graphElement, error message and the cause are properly propagated.
     * </p>
     */
    public void testIllegalGraphElementExceptionCtor3() {
        IllegalGraphElementException exception = new IllegalGraphElementException(ILLEGAL_GRAPHELEMENT, ERROR_MESSAGE,
                CAUSE_EXCEPTION);
        assertNotNull("Unable to instantiate IllegalGraphElementException.", exception);
        assertEquals("Illegal graphElement is not properly propagated.", ILLEGAL_GRAPHELEMENT,
                exception.getGraphElement());
        assertTrue("The error message should match", exception.getMessage().indexOf(ERROR_MESSAGE) >= 0);
        assertEquals("Inner cause is not properly propagated.", CAUSE_EXCEPTION, exception.getCause());
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     * <p>
     * Verifies IllegalGraphElementException subclasses Exception.
     * </p>
     */
    public void testIllegalGraphElementExceptionInheritance1() {
        IllegalGraphElementException exception = new IllegalGraphElementException(ILLEGAL_GRAPHELEMENT, ERROR_MESSAGE);
        assertTrue("IllegalGraphElementException does not subclass Exception.", exception instanceof Exception);
    }

    /**
     * <p>
     * Inheritance test.
     * </p>
     * <p>
     * Verifies IllegalGraphElementException subclasses Exception.
     * </p>
     */
    public void testIllegalGraphElementExceptionInheritance2() {
        IllegalGraphElementException exception = new IllegalGraphElementException(ILLEGAL_GRAPHELEMENT, ERROR_MESSAGE,
                CAUSE_EXCEPTION);
        assertTrue("IllegalGraphElementException does not subclass Exception.", exception instanceof Exception);
    }

    /**
     * <p>
     * Test method for getGraphElement.
     * </p>
     * <p>
     * It verifies the getGraphElement properly return the illegal graphElement.
     * </p>
     */
    public void testGetGraphElement1() {
        IllegalGraphElementException exception = new IllegalGraphElementException(ILLEGAL_GRAPHELEMENT, ERROR_MESSAGE);
        assertEquals("getGraphElement method did not return the properly graphElement", ILLEGAL_GRAPHELEMENT,
                exception.getGraphElement());
    }

    /**
     * <p>
     * Test method for getGraphElement.
     * </p>
     * <p>
     * It verifies the getGraphElement properly return null when assigning null for graphElement.
     * </p>
     */
    public void testGetGraphElement2() {
        IllegalGraphElementException exception = new IllegalGraphElementException(null, ERROR_MESSAGE);
        assertNull("getGraphElement method did not return the properly graphElement", exception.getGraphElement());
    }
}
