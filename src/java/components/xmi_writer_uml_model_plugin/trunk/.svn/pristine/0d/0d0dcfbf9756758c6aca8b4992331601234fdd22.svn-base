/**
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * <p>
     * Test suite of accuracy test cases.
     * </p>
     * 
     * @return the test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ReflectedXMIDescriptionAccuracyTests.class);
        suite.addTestSuite(AttributeDescriptionAccuracyTests.class);
        suite.addTestSuite(ChildDescriptionAccuracyTests.class);
        suite.addTestSuite(XMIElementDescriptionAccuracyTests.class);
        suite.addTestSuite(Model2XMITransformerAccuracyTests.class);
        return suite;
    }

}
