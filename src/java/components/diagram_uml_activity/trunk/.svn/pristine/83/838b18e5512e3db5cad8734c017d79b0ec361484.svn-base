/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Test the functionality of <code>IllegalGraphElementException</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class IllegalGraphElementExceptionTest extends TestCase {

    /** An instance of <code>GraphNode</code> for testing. */
    private GraphNode graphNode;

    /** An instance of <code>IllegalGraphElementException</code> for testing. */
    private IllegalGraphElementException exception1;

    /** An instance of <code>IllegalGraphElementException</code> for testing. */
    private IllegalGraphElementException exception2;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        graphNode = TestUtil.createGraphNodeForActivityNode(new PseudostateImpl());
        exception1 = new IllegalGraphElementException(graphNode, "msg");
        exception2 = new IllegalGraphElementException(graphNode, "msg", new IllegalArgumentException());
    }

    /**
     * Test method for 'IllegalGraphElementException(GraphElement, String)'. Null GraphElement is given, the instance
     * should be created successfully.
     */
    public void testIllegalGraphElementExceptionGraphElementString() {
        assertNotNull("Test method for 'IllegalGraphElementException(GraphElement, String)' failed.", exception1);
    }

    /**
     * Test method for 'IllegalGraphElementException(GraphElement, String)'. Null GraphElement is given, the instance
     * should be created successfully.
     */
    public void testIllegalGraphElementExceptionGraphElementString_null() {
        assertNotNull("Test method for 'IllegalGraphElementException(GraphElement, String)' failed.",
                new IllegalGraphElementException(null, "msg"));
    }

    /**
     * Test method for 'IllegalGraphElementException(GraphElement, String, Throwable)'. Null GraphElement is given, the
     * instance should be created successfully.
     */
    public void testIllegalGraphElementExceptionGraphElementStringThrowable() {
        assertNotNull("Test method for 'IllegalGraphElementException(GraphElement, String, Throwable)' failed.",
                exception2);
    }

    /**
     * Test method for 'IllegalGraphElementException(GraphElement, String, Throwable)'. Null GraphElement is given, the
     * instance should be created successfully.
     */
    public void testIllegalGraphElementExceptionGraphElementStringThrowable_null() {
        assertNotNull("Test method for 'IllegalGraphElementException(GraphElement, String, Throwable)' failed.",
                new IllegalGraphElementException(null, "msg", new IllegalArgumentException()));
    }

    /**
     * Test method for 'getGraphElement()'. The graph element should be got correctly.
     */
    public void testGetGraphElement() {
        assertEquals("The graph element should be got correctly.", exception1.getGraphElement(), graphNode);
        assertEquals("The graph element should be got correctly.", exception2.getGraphElement(), graphNode);
    }

}
