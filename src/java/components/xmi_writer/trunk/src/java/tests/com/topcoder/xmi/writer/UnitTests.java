/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import com.topcoder.xmi.writer.transformers.xmiheader.XMIHeaderTransformerUnitTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * Aggregates all tests.
     *
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(XMIWriterExceptionUnitTest.class);
        suite.addTestSuite(ElementAlreadyExistsExceptionUnitTest.class);
        suite.addTestSuite(UnknownElementExceptionUnitTest.class);
        suite.addTestSuite(XMITransformExceptionUnitTest.class);
        suite.addTestSuite(HelperUnitTest.class);
        suite.addTestSuite(AbstractXMITransformerUnitTest.class);
        suite.addTestSuite(XMIHeaderTransformerUnitTest.class);
        suite.addTestSuite(XMIWriterUnitTest.class);
        suite.addTestSuite(Demo.class);
        return suite;
    }

}
