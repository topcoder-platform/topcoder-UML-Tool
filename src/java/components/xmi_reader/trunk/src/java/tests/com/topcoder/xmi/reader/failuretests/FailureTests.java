/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.xmi.reader.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(XMIReaderTests.class);
        suite.addTestSuite(XMIReaderExceptionTests.class);
        suite.addTestSuite(XMIReaderConfigExceptionTests.class);
        suite.addTestSuite(XMIReaderIOExceptionTests.class);
        suite.addTestSuite(XMIReaderParseExceptionTests.class);
        suite.addTestSuite(DefaultXMIHandlerTests.class);
        suite.addTestSuite(DelegatingHandlerTests.class);
        return suite;
    }

}
