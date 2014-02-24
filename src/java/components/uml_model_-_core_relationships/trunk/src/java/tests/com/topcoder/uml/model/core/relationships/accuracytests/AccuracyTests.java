/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * Accuracy Tests for all tests.
     *
     * @return Test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(AssociationClassImplAccuracyTest.suite());
        suite.addTest(AssociationEndImplAccuracyTest.suite());
        suite.addTest(AssociationImplAccuracyTest.suite());
        suite.addTest(GeneralizationImplAccuracyTest.suite());
        suite.addTest(RelationshipAbstractImplAccuracyTest.suite());
        return suite;
    }
}
