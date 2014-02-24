/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 *
 * @author KKD
 * @version 1.0
 */
public class StressTests extends TestCase {
    /**
     * Aggregates all testcases for stress purpose.
     *
     * @return test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(InstanceAbstractImplStressTests.class);
        suite.addTestSuite(LinkImplStressTests.class);
        suite.addTestSuite(ProcedureImplStressTests.class);
        return suite;
    }
}
