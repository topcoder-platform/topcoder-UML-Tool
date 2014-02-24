/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * Return test suite for stress tests.
     *
     * @return test suite for stress tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(InteractionImplStressTests.class);
        suite.addTestSuite(MessageImplStressTests.class);
        suite.addTestSuite(XMISequenceDiagramConverterUtilStressTests.class);
        return suite;
    }
}
