/*
 * Copyright (c) 2008, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.importer.jarimporter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.importer.jarimporter.impl.UnitTestDefaultJarImporter;

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
     * Contain all unit test.
     *
     * @return all unit test
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(UnitTestJarImporterException.class);
        suite.addTestSuite(UnitTestJarImporter.class);
        suite.addTestSuite(UnitTestDefaultJarImporter.class);

        suite.addTestSuite(Demo.class);

        return suite;
    }

}
