/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.usecase.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * Aggregates all the stress test cases.
     *
     * @return Test
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(StressTestAddActorAction.class);
        suite.addTestSuite(StressTestCopyActorAction.class);

        suite.addTestSuite(StressTestCutAction.class);
        suite.addTestSuite(StressTestPasteAction.class);
        suite.addTestSuite(StressTestRemoveAction.class);
        return suite;
    }
}