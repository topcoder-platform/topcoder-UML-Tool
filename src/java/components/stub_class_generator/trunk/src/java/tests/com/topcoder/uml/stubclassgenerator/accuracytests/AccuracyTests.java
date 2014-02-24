/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.stubclassgenerator.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all accuracy test cases for the <i>Stub Class Generator</i> package.</p>
 *
 * @author RachaelLCook
 * @version 1.0
 */

public class AccuracyTests extends TestCase {
    /**
     * Returns all accuracy test cases for the <i>Stub Class Generator</i> package.
     *
     * @return all accuracy test cases for the <i>Stub Class Generator</i> package
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(JavaGeneratorAccuracyTests.class);
        suite.addTestSuite(CSharpGeneratorAccuracyTests.class);
        return suite;
    }
}
