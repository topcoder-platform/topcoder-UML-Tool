/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model;

import com.topcoder.xmi.reader.handlers.modelfactory.ConfigurationExceptionTests;
import com.topcoder.xmi.reader.handlers.modelfactory.ElementCreationExceptionTests;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactoryTests;

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

        suite.addTest(XMI2ModelHandlerTests.suite());
        suite.addTest(UtilTests.suite());

        suite.addTest(Demo.suite());

        // tests for model factory
        suite.addTest(ConfigurationExceptionTests.suite());
        suite.addTest(ElementCreationExceptionTests.suite());
        suite.addTest(ModelElementFactoryTests.suite());

        return suite;
    }
}
