/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.diagraminterchange.GraphEdge;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <code>IllegalGraphElementException</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class IllegalGraphElementExceptionUnitTests extends TestCase {

    /**
     * <p>
     * Test the constructor <code>IllegalGraphElementException(GraphElement, String)</code>.
     * </p>
     */
    public void testConstructor1() {
        IllegalGraphElementException excp = new IllegalGraphElementException(new GraphEdge(), "Failed");

        assertNotNull("The instance should be created.", excp);
        assertTrue("The message field should be set correctly.", excp.getMessage().startsWith("Failed"));
    }

    /**
     * <p>
     * Test the constructor <code>IllegalGraphElementException(GraphElement, String, Throwable)</code>.
     * </p>
     */
    public void testConstructor2() {
        Throwable e = new Exception();
        IllegalGraphElementException excp = new IllegalGraphElementException(new GraphEdge(), "Failed", e);

        assertNotNull("The instance should be created.", excp);
        assertTrue("The message field should be set correctly.", excp.getMessage().startsWith("Failed"));
        assertTrue("The cause field should be set correctly.", excp.getCause().equals(e));
    }

    /**
     * <p>
     * Test the method <code>getGraphElement()</code>.
     * With null graph element.
     * Should return null.
     * </p>
     */
    public void testGetGraphElement_Null() {
        IllegalGraphElementException excp = new IllegalGraphElementException(null, "Failed");

        assertNull("Should return null.", excp.getGraphElement());
    }

    /**
     * <p>
     * Test the method <code>getGraphElement()</code>.
     * With not null graph element.
     * Should return proper graph element.
     * </p>
     */
    public void testGetGraphElement_NotNull() {
        Throwable e = new Exception();
        IllegalGraphElementException excp = new IllegalGraphElementException(new GraphEdge(), "Failed", e);

        assertNotNull("Should return proper graph element.", excp.getGraphElement());
    }
}
