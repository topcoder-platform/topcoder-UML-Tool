/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author Xuchen
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * Aggregate all failure test cases.
     *
     * @return Test instance.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AddDiagramElementActionFailureTest.class);
        suite.addTestSuite(DiagramElementUndoableActionFailureTest.class);
        suite.addTestSuite(UpdateDiagramElementActionFailureTest.class);
        
        suite.addTestSuite(AbstractCompartmentExtractorFailureTest.class);
        suite.addTestSuite(ActivityNodeCompartmentExtractorFailureTest.class);
        suite.addTestSuite(ActivityStateCompartmentExtractorFailureTest.class);
        suite.addTestSuite(AssociationCompartmentExtractorFailureTest.class);
        suite.addTestSuite(ClassifierCompartmentExtractorFailureTest.class);
        suite.addTestSuite(DefaultEdgeCompartmentExtractorFailureTest.class);
        suite.addTestSuite(DefaultNodeCompartmentExtractorFailureTest.class);
        suite.addTestSuite(GeneralizationCompartmentExtractorFailureTest.class);
        suite.addTestSuite(MessageCompartmentExtractorFailureTest.class);
        suite.addTestSuite(ObjectCompartmentExtractorFailureTest.class);
        suite.addTestSuite(CompartmentExtractorFactoryFailureTest.class);
        
        suite.addTestSuite(AddRemoveActionFailureTest.class);
        suite.addTestSuite(AddRemoveAttributeActionFailureTest.class);
        suite.addTestSuite(AddRemoveOperationActionFailureTest.class);
        suite.addTestSuite(UpdateActionFailureTest.class);
        suite.addTestSuite(UpdateFirstAssociationEndActionFailureTest.class);
        suite.addTestSuite(UpdateNameActionFailureTest.class);
        suite.addTestSuite(UpdateNamespaceActionFailureTest.class);
        suite.addTestSuite(UpdateSecondAssociationEndActionFailureTest.class);
        suite.addTestSuite(UpdateSizeActionFailureTest.class);
        suite.addTestSuite(UpdateStereotypeActionFailureTest.class);
        suite.addTestSuite(UpdateVisibilityActionFailureTest.class);
        return suite;
    }
}
