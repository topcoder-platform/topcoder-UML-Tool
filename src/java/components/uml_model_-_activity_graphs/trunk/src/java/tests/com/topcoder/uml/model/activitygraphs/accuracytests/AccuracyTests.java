/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.activitygraphs.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 * @author waits
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * Aggregate all accuracy test cases.
     *
     * @return Test to Junit
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ObjectFlowStateImplAccTests.class);

        return suite;
    }
}
