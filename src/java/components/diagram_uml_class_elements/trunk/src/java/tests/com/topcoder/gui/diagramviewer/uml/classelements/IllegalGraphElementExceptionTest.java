/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.Point;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;

/**
 * <p>
 * Test the functionality of <code>IllegalGraphElementException</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class IllegalGraphElementExceptionTest extends TestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

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
        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        exception1 = new IllegalGraphElementException(graphNode, "");
        exception2 = new IllegalGraphElementException(graphNode, "", new IllegalArgumentException());
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
