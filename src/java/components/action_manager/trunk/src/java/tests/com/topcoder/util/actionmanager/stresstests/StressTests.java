/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.util.actionmanager.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 * @author TopCoder
 * @version 1.0
 */
public class StressTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ActionManagerStressTest.class);
        suite.addTestSuite(CompoundUndoableActionStressTest.class);
        suite.addTestSuite(TransientUndoableActionStressTest.class);
        return suite;
    }
}
