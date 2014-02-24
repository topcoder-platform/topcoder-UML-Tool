/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.stubclassgenerator.csharp.TestCSharpGenerator;
import com.topcoder.uml.stubclassgenerator.java.TestJavaGenerator;

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
     * Returns the aggregated unit tests.
     *
     * @return the aggregated unit tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(new TestSuite(TestCodeWriter.class));
        suite.addTest(new TestSuite(TestAbstractGenerator.class));
        suite.addTest(new TestSuite(TestJavaGenerator.class));
        suite.addTest(new TestSuite(TestCSharpGenerator.class));
        suite.addTest(new TestSuite(TestCodeGenerationException.class));
        suite.addTest(new TestSuite(TestGeneratorFileSystemException.class));
        suite.addTest(new TestSuite(TestGeneratorConfigurationException.class));
        suite.addTest(new TestSuite(TestGeneratorFactory.class));
        suite.addTest(new TestSuite(TestCodeGenerator.class));
        suite.addTest(new TestSuite(Demo.class));
        return suite;
    }
}
