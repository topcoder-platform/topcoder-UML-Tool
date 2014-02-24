/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class StressTests extends TestCase {
    /**
     * Aggregates all Stress test cases
     * 
     * @return the suite for test
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ObjectActionStressTest.class);
        suite.addTestSuite(MessageActionStressTest.class);
        return suite;
    }
}
