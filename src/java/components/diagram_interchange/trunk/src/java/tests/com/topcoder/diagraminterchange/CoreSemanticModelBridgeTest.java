/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.TestCase;

/**
 * <p>
 * Unit tests for class CoreSemanticModelBridge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CoreSemanticModelBridgeTest extends TestCase {

    /**
     * An instance of CoreSemanticModelBridge for testing.
     */
    private CoreSemanticModelBridge instance;

    /**
     * Sets up the environment. Creates an instance of CoreSemanticModelBridge.
     */
    protected void setUp() {
        instance = new CoreSemanticModelBridge();
    }

    /**
     * Tests the constructor.
     */
    public void testCoreSemanticModelBridgeCtor() {
        assertNotNull("fail to construct the instance", instance);
    }
}