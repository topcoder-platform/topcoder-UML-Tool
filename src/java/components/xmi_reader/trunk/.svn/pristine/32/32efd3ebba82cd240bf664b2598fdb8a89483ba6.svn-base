/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.reader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * Aggregates all unit test cases and returns a testSuite.
     *
     * @return the test suite.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // tests for the exceptions
        suite.addTestSuite(XMIReaderExceptionUnitTests.class);
        suite.addTestSuite(XMIReaderParseExceptionUnitTests.class);
        suite.addTestSuite(XMIReaderIOExceptionUnitTests.class);
        suite.addTestSuite(XMIReaderConfigExceptionUnitTests.class);

        // tests for abstract class implementation
        suite.addTestSuite(DefaultXMIHandlerUnitTests.class);

        // tests for inner class
        suite.addTestSuite(DelegatingHandlerUnitTests.class);

        // tests for XMIReader class
        suite.addTestSuite(XMIReaderConstructorsUnitTests.class);
        suite.addTestSuite(XMIReaderSimleMethodsUnitTests.class);
        suite.addTestSuite(XMIReaderParseMethodsUnitTests.class);

        // tests for helper class
        suite.addTestSuite(ReaderHelperUnitTests.class);

        // demo
        suite.addTestSuite(Demo.class);

        return suite;
    }
}
