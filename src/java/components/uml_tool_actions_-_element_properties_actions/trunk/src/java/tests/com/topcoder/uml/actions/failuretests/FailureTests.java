/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 * @author vilain
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * Suite.
     * @return suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // general
        suite.addTestSuite(ChangeDocumentationActionFailureTest.class);
        suite.addTestSuite(ChangeEntityNameActionFailureTest.class);
        suite.addTestSuite(ChangeEntityVisibilityActionFailureTest.class);
        suite.addTestSuite(ChangePositionActionFailureTest.class);
        suite.addTestSuite(ChangeRelationshipPathActionFailureTest.class);
        suite.addTestSuite(ChangeSizeActionFailureTest.class);
        suite.addTestSuite(ChangeStyleActionFailureTest.class);
        suite.addTestSuite(ChangeZOrderActionFailureTest.class);
        suite.addTestSuite(SetEntityStereotypesActionFailureTest.class);
        suite.addTestSuite(UndoableAbstractActionFailureTest.class);
        suite.addTestSuite(UpdateDocumentationTagsActionFailureTest.class);
        // classifier
        suite.addTestSuite(AddAttributeActionFailureTest.class);
        suite.addTestSuite(AddOperationActionFailureTest.class);
        suite.addTestSuite(UpdateAttributeActionFailureTest.class);
        suite.addTestSuite(UpdateAttributeOrderActionFailureTest.class);
        suite.addTestSuite(UpdateOperationActionFailureTest.class);
        suite.addTestSuite(UpdateOperationOrderActionFailureTest.class);
        // model
        suite.addTestSuite(MarkClassifierAbstractActionFailureTest.class);
        suite.addTestSuite(MarkClassifierFinalActionFailureTest.class);
        suite.addTestSuite(MarkNestedClassifierStaticActionFailureTest.class);
        suite.addTestSuite(SetTransitionGuardActionFailureTest.class);
        suite.addTestSuite(UpdateAssociationEndActionFailureTest.class);
        return suite;
    }
}