/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class LeafElement. Since LeafElement is an abstract class, A mock concrete class is provided
 * to extend it for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LeafElementTest extends TestCase {

    /**
     * An instance of LeafElement for testing.
     */
    private LeafElement instance;

    /**
     * Sets up the environment. Creates an instance of LeafElement.
     */
    protected void setUp() {
        instance = new MockLeafElement();
    }

    /**
     * Tests the constructor.
     */
    public void testLeafElementCtor() {
        assertNotNull("fail to construct the instance", instance);
    }
}

/**
 * <p>
 * A mock concrete class extends LeafElement for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class MockLeafElement extends LeafElement {
    // empty
}