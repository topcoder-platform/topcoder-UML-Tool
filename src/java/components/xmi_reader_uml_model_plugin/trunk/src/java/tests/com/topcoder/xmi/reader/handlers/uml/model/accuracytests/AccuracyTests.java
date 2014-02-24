/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all accuracy test cases.
 * </p>
 *
 * @author mittu
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * <p>
     * Accuracy test suite.
     * </p>
     *
     * @return the test suite.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(XMI2ModelHandlerAccuracyTests.suite());
        return suite;
    }

}
