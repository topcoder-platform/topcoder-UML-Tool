/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 * @author WN
 * @version 1.1
 */
public class StressTests extends TestCase {
    /**
     * <p>
     * Aggregates all stress test suites.
     * </p>
     * @return all stress test suites
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(new TestSuite(
                ActivityDiagramConversionFacadeStressTests.class));
        suite.addTest(new TestSuite(ZUMLActivityDiagramImplStressTest.class));

        return suite;
    }
}
