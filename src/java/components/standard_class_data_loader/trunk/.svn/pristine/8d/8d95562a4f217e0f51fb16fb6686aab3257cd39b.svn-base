/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import com.topcoder.uml.standardclassloader.implementations.XMLLanguageClassDataLoaderTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // tests for package com.topcoder.uml.standardclassloader
        suite.addTest(UnknownLanguageExceptionTests.suite());
        suite.addTest(ClassDataLoaderStrategyTests.suite());
        suite.addTest(ClassDataLoaderConfigurationExceptionTests.suite());

        // tests for package com.topcoder.uml.standardclassloader.implementations
        suite.addTest(XMLLanguageClassDataLoaderTests.suite());

        // tests for the demo
        suite.addTest(DemoTests.suite());

        return suite;
    }
}
