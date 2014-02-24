/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class StressTests extends TestCase {
    /**
     * Aggregates all tests.
     *
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // for test
        suite.addTestSuite(XMIHeaderTransformerStressTests.class);
        suite.addTestSuite(XMIWriterStressTests.class);

        return suite;
    }
}
