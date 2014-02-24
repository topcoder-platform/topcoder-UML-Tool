/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.uml.actions.diagram.elements.DemoTests;
import com.topcoder.uml.actions.diagram.elements.actions.TestAddRemoveAttributeActionAccuracy;
import com.topcoder.uml.actions.diagram.elements.actions.TestAddRemoveOperationActionAccuracy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * <p>
     * This test case aggregates all Accuracy test cases.
     * </p>
     *
     * @return all Accuracy test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // test for the public class under package com.topcoder.uml.actions.diagram.elements.actions.
        suite.addTestSuite(TestAddRemoveAttributeActionAccuracy.class);
        suite.addTestSuite(TestAddRemoveOperationActionAccuracy.class);
        suite.addTestSuite(TestUpdateFirstAssociationEndActionAccuracy.class);
        suite.addTestSuite(TestUpdateNameActionAccuracy.class);
        suite.addTestSuite(TestUpdateNamespaceActionAccuracy.class);
        suite.addTestSuite(TestUpdateSecondAssociationEndActionAccuracy.class);
        suite.addTestSuite(TestUpdateSizeActionAccuracy.class);
        suite.addTestSuite(TestUpdateVisibilityActionAccuracy.class);
        suite.addTestSuite(TestUpdateStereotypeActionAccuracy.class);

        // test for the public class under package com.topcoder.uml.actions.diagram.elements.compartmentextraction;
        suite.addTestSuite(TestActivityNodeCompartmentExtractorAccuracy.class);
        suite.addTestSuite(TestActivityStateCompartmentExtractorAccuracy.class);
        suite.addTestSuite(TestAssociationCompartmentExtractorAccuracy.class);
        suite.addTestSuite(TestClassifierCompartmentExtractorAccuracy.class);
        suite.addTestSuite(TestCompartmentExtractorFactoryAccuracy.class);

        suite.addTestSuite(TestDefaultEdgeCompartmentExtractor.class);
        suite.addTestSuite(TestDefaultNodeCompartmentExtractorAccuracy.class);
        suite.addTestSuite(TestGeneralizationCompartmentExtractorAccuracy.class);
        suite.addTestSuite(TestMessageCompartmentExtractorAccuracy.class);
        suite.addTestSuite(TestObjectCompartmentExtractorAccuracy.class);

        // test for the classes under the main package.
        suite.addTestSuite(TestAddDiagramElementActionAccuracy.class);

        return suite;
    }

}