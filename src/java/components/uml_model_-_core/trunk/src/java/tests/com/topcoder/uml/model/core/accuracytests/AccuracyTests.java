/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 *
 * @author littlebull
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

        suite.addTestSuite(ParameterImplAccuracyTests.class);
        suite.addTestSuite(NamespaceAbstractImplAccuracyTests.class);
        suite.addTestSuite(ModelElementAbstractImplAccuracyTests.class);
        suite.addTestSuite(GeneralizableElementAbstractImplAccuracyTests.class);
        suite.addTestSuite(ClassifierAbstractImplAccuracyTests.class);
        suite.addTestSuite(FeatureAbstractImplAccuracyTests.class);
        suite.addTestSuite(StructuralFeatureAbstractImplAccuracyTests.class);
        suite.addTestSuite(AttributeImplAccuracyTests.class);
        suite.addTestSuite(BehavioralFeatureAbstractImplAccuracyTests.class);
        suite.addTestSuite(OperationImplAccuracyTests.class);
        suite.addTestSuite(MethodImplAccuracyTests.class);

        return suite;
    }
}
