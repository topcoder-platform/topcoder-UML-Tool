/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class GraphNode.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphNodeTest extends TestCase {

    /**
     * An instance of GraphNode for testing.
     */
    private GraphNode instance;

    /**
     * Sets up the environment. Creates an instance of GraphNode.
     */
    protected void setUp() {
        instance = new GraphNode();
    }

    /**
     * Tests the constructor. All the fields should be initiated properly.
     */
    public void testGraphNodeCtor() {
        assertNotNull("fail to construct the instance", instance);

        assertNull("null expected", instance.getSize());
    }

    /**
     * Tests method getSize. The correspond field should be returned properly.
     */
    public void testGetSize() {
        Dimension size = new Dimension();
        instance.setSize(size);
        assertEquals("incorrect Size", size, instance.getSize());
    }

    /**
     * Tests method setSize. The correspond field should be updated properly.
     */
    public void testSetSize() {
        Dimension size = new Dimension();
        instance.setSize(size);
        assertEquals("incorrect Size", size, instance.getSize());
    }

    /**
     * Tests method setSize with null value. Null value should be allowed.
     */
    public void testSetSizeNull() {
        instance.setSize(null);
        assertNull("null value should be allowed", instance.getSize());
    }
}