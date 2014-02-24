/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.umltool.xmiconverters.poseidon5.ConvertersStressTests;

/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class StressTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ConvertersStressTests.class);
        suite.addTestSuite(XMIConvertersUtilStressTests.class);
        suite.addTestSuite(ZUMLHeaderHandlerStressTests.class);
        return suite;
    }
}
