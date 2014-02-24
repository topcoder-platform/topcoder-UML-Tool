/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions;

import com.topcoder.uml.actions.general.ChangeDocumentationActionUnitTests;
import com.topcoder.uml.actions.general.HelperUnitTests;
import com.topcoder.uml.actions.general.ChangeEntityNameActionUnitTests;
import com.topcoder.uml.actions.general.ChangeEntityVisibilityActionUnitTests;
import com.topcoder.uml.actions.general.ChangePositionActionUnitTests;
import com.topcoder.uml.actions.general.ChangeRelationshipPathActionUnitTests;
import com.topcoder.uml.actions.general.ChangeSizeActionUnitTests;
import com.topcoder.uml.actions.general.ChangeStyleActionUnitTests;
import com.topcoder.uml.actions.general.ChangeZOrderActionUnitTests;
import com.topcoder.uml.actions.general.SetEntityStereotypesActionUnitTests;
import com.topcoder.uml.actions.general.UndoableAbstractActionUnitTests;
import com.topcoder.uml.actions.general.UpdateDocumentationTagsActionUnitTests;
import com.topcoder.uml.actions.model.classifier.feature.AddAttributeActionUnitTests;
import com.topcoder.uml.actions.model.classifier.feature.AddOperationActionUnitTests;
import com.topcoder.uml.actions.model.classifier.feature.UpdateAttributeActionUnitTests;
import com.topcoder.uml.actions.model.classifier.feature.UpdateAttributeOrderActionUnitTests;
import com.topcoder.uml.actions.model.classifier.feature.UpdateOperationActionUnitTests;
import com.topcoder.uml.actions.model.classifier.feature.UpdateOperationOrderActionUnitTests;
import com.topcoder.uml.actions.model.custom.MarkClassifierAbstractActionUnitTests;
import com.topcoder.uml.actions.model.custom.MarkClassifierFinalActionUnitTests;
import com.topcoder.uml.actions.model.custom.MarkNestedClassifierStaticActionUnitTests;
import com.topcoder.uml.actions.model.custom.SetTransitionGuardActionUnitTests;
import com.topcoder.uml.actions.model.custom.UpdateAssociationEndActionUnitTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This test case aggregates all unit test cases.
 *
 * @author rainday
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * Aggregates all unit test cases.
     *
     * @return the aggregated unit test cases
     */
    public static Test suite() {
        TestSuite suite = new TestSuite("Unit test for com.topcoder.uml.actions");
        suite.addTestSuite(UndoableAbstractActionUnitTests.class);
        suite.addTestSuite(ChangeDocumentationActionUnitTests.class);
        suite.addTestSuite(ChangeEntityVisibilityActionUnitTests.class);
        suite.addTestSuite(ChangeEntityNameActionUnitTests.class);
        suite.addTestSuite(ChangePositionActionUnitTests.class);
        suite.addTestSuite(ChangeRelationshipPathActionUnitTests.class);
        suite.addTestSuite(ChangeSizeActionUnitTests.class);
        suite.addTestSuite(ChangeStyleActionUnitTests.class);
        suite.addTestSuite(ChangeZOrderActionUnitTests.class);
        suite.addTestSuite(SetEntityStereotypesActionUnitTests.class);
        suite.addTestSuite(UpdateDocumentationTagsActionUnitTests.class);

        suite.addTestSuite(AddAttributeActionUnitTests.class);
        suite.addTestSuite(AddOperationActionUnitTests.class);
        suite.addTestSuite(UpdateAttributeActionUnitTests.class);
        suite.addTestSuite(UpdateAttributeOrderActionUnitTests.class);
        suite.addTestSuite(UpdateOperationActionUnitTests.class);
        suite.addTestSuite(UpdateOperationOrderActionUnitTests.class);

        suite.addTestSuite(MarkClassifierAbstractActionUnitTests.class);
        suite.addTestSuite(MarkClassifierFinalActionUnitTests.class);
        suite.addTestSuite(MarkNestedClassifierStaticActionUnitTests.class);
        suite.addTestSuite(SetTransitionGuardActionUnitTests.class);
        suite.addTestSuite(UpdateAssociationEndActionUnitTests.class);
        suite.addTestSuite(HelperUnitTests.class);
        return suite;
    }
}
