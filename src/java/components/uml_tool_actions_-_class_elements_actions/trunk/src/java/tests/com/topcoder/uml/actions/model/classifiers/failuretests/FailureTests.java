/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        suite.addTestSuite(AddAbstractionActionFailureTests.class);
        suite.addTestSuite(AddAssociationActionFailureTests.class);
        suite.addTestSuite(AddClassActionFailureTests.class);
        suite.addTestSuite(AddDependencyActionFailureTests.class);
        suite.addTestSuite(AddEnumerationActionFailureTests.class);
        suite.addTestSuite(AddExceptionActionFailureTests.class);
        suite.addTestSuite(AddGeneralizationActionFailureTests.class);
        suite.addTestSuite(AddInterfaceActionFailureTests.class);
        suite.addTestSuite(AddPackageActionFailureTests.class);
        
        
        suite.addTestSuite(CopyAbstractionActionFailureTests.class);
        suite.addTestSuite(CopyAssociationActionFailureTests.class);
        suite.addTestSuite(CopyClassActionFailureTests.class);
        suite.addTestSuite(CopyDependencyActionFailureTests.class);
        suite.addTestSuite(CopyEnumerationActionFailureTests.class);
        suite.addTestSuite(CopyExceptionActionFailureTests.class);
        suite.addTestSuite(CopyGeneralizationActionFailureTests.class);
        suite.addTestSuite(CopyInterfaceActionFailureTests.class);
        suite.addTestSuite(CopyPackageActionFailureTests.class);
        
        suite.addTestSuite(CutAbstractionActionFailureTests.class);
        suite.addTestSuite(CutAssociationActionFailureTests.class);
        suite.addTestSuite(CutClassActionFailureTests.class);
        suite.addTestSuite(CutDependencyActionFailureTests.class);
        suite.addTestSuite(CutEnumerationActionFailureTests.class);
        suite.addTestSuite(CutExceptionActionFailureTests.class);
        suite.addTestSuite(CutGeneralizationActionFailureTests.class);
        suite.addTestSuite(CutInterfaceActionFailureTests.class);
        suite.addTestSuite(CutPackageActionFailureTests.class);
        
        suite.addTestSuite(PasteAbstractionActionFailureTests.class);
        suite.addTestSuite(PasteAssociationActionFailureTests.class);
        suite.addTestSuite(PasteClassActionFailureTests.class);
        suite.addTestSuite(PasteDependencyActionFailureTests.class);
        suite.addTestSuite(PasteEnumerationActionFailureTests.class);
        suite.addTestSuite(PasteExceptionActionFailureTests.class);
        suite.addTestSuite(PasteGeneralizationActionFailureTests.class);
        suite.addTestSuite(PasteInterfaceActionFailureTests.class);
        suite.addTestSuite(PastePackageActionFailureTests.class);
        
        suite.addTestSuite(RemoveAbstractionActionFailureTests.class);
        suite.addTestSuite(RemoveAssociationActionFailureTests.class);
        suite.addTestSuite(RemoveClassActionFailureTests.class);
        suite.addTestSuite(RemoveDependencyActionFailureTests.class);
        suite.addTestSuite(RemoveEnumerationActionFailureTests.class);
        suite.addTestSuite(RemoveExceptionActionFailureTests.class);
        suite.addTestSuite(RemoveGeneralizationActionFailureTests.class);
        suite.addTestSuite(RemoveInterfaceActionFailureTests.class);
        suite.addTestSuite(RemovePackageActionFailureTests.class);
        
        suite.addTestSuite(ClassElementsTransferFailureTests.class);
        return suite;
    }

}
