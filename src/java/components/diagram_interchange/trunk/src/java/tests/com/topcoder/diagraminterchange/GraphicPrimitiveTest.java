/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class GraphicPrimitive. Since GraphicPrimitive is an abstract class, A mock concrete class
 * is provided to extend it for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GraphicPrimitiveTest extends TestCase {

    /**
     * An instance of GraphicPrimitive for testing.
     */
    private GraphicPrimitive instance;

    /**
     * Sets up the environment. Creates an instance of GraphicPrimitive.
     */
    protected void setUp() {
        instance = new MockGraphicPrimitive();
    }

    /**
     * Tests the constructor.
     */
    public void testGraphicPrimitiveCtor() {
        assertNotNull("fail to construct the instance", instance);
    }
}

/**
 * <p>
 * A mock concrete class extends GraphicPrimitive for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class MockGraphicPrimitive extends GraphicPrimitive {
    // empty
}