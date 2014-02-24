/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 *
 * @author justforplay
 * @version 1.0
 */
public class AccuracyTests extends TestCase {
    /**
     * Get the test suite.
     *
     * @return Test.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(ChangeDocumentationActionAccuracyTest.class);
        suite.addTestSuite(ChangeEntityNameActionAccuracyTest.class);
        suite.addTestSuite(ChangeEntityVisibilityActionAccuracyTest.class);
        suite.addTestSuite(ChangePositionActionAccuracyTest.class);
        suite.addTestSuite(ChangeRelationshipPathActionAccuracyTest.class);
        suite.addTestSuite(ChangeSizeActionAccuracyTest.class);
        suite.addTestSuite(ChangeStyleActionAccuracyTest.class);
        suite.addTestSuite(ChangeZOrderActionAccuracyTest.class);
        suite.addTestSuite(SetEntityStereotypesActionAccuracyTest.class);
        suite.addTestSuite(UndoableAbstractActionAccuracyTest.class);
        suite.addTestSuite(UpdateDocumentationTagsActionAccuracyTest.class);

        suite.addTestSuite(AddAttributeActionAccuracyTest.class);
        suite.addTestSuite(AddOperationActionAccuracyTests.class);
        suite.addTestSuite(UpdateAttributeActionAccuracyTests.class);
        suite.addTestSuite(UpdateAttributeOrderActionAccuracyTests.class);
        suite.addTestSuite(UpdateOperationActionAccuracyTest.class);
        suite.addTestSuite(UpdateOperationOrderActionAccuracyTest.class);

        suite.addTestSuite(MarkClassifierAbstractActionAccuracyTest.class);
        suite.addTestSuite(MarkClassifierFinalActionAccuracyTests.class);
        suite.addTestSuite(MarkNestedClassifierStaticActionAccuracyTests.class);
        suite.addTestSuite(SetTransitionGuardActionAccuracyTests.class);
        suite.addTestSuite(UpdateAssociationEndActionAccuracyTests.class);

        return suite;
    }
}
