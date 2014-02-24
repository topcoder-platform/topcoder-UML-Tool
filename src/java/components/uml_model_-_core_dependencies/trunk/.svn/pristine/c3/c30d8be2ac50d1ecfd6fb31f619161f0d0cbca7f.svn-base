/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ UsageImplTest.java
 */

package com.topcoder.uml.model.core.dependencies;

import junit.framework.TestCase;

/**
 * <p>Tests for UsageImpl class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class UsageImplTests extends TestCase {
    /**
     * <p>UsageImpl used for testing. It is instantiated in SetUp.</p>
     */
    private UsageImpl usageImpl;

    /**
     * <p>Sets up test environment, creates object used for test.</p>
     */
    public void setUp() {
        usageImpl = new UsageImpl();
    }

    /**
     * <p>Tears down test environment, disposes object used for test.</p>
     */
    public void tearDown() {
        usageImpl = null;
    }

    /**
     * <p>Tests inheritance of <c>UsageImpl</c>.</p>
     * <p><c>UsageImpl</c> should inherit from <c>Message</c>.</p>
     */
    public void testUsageImplAccuracyInheritUsage() {
        assertEquals("UsageImpl should inherit from Message.", true, usageImpl instanceof Usage);
    }

    /**
     * <p>Tests accuracy of <c>UsageImpl()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testUsageImplAccuracy() {
        assertNotNull("Value should be gotten correctly.", usageImpl);
    }
}
