/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveAttributeActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.AddRemoveOperationActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateFirstAssociationEndActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNameActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateNamespaceActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateSecondAssociationEndActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateSizeActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateStereotypeActionTests;
import com.topcoder.uml.actions.diagram.elements.actions.UpdateVisibilityActionTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.AbstractCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityNodeCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ActivityStateCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.AssociationCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ClassifierCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractorFactoryTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentMalformedExceptionTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotFoundExceptionTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotSupportedExceptionTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultEdgeCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.DefaultNodeCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.GeneralizationCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.MessageCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.ObjectCompartmentExtractorTests;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.StructureCompartmentExtractorTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // tests for package com.topcoder.uml.actions.diagram.elements
        suite.addTest(UpdateDiagramElementActionTests.suite());
        suite.addTest(AddDiagramElementActionTests.suite());
        suite.addTest(UtilTests.suite());
        suite.addTest(DiagramElementUndoableActionTests.suite());

        // tests for package com.topcoder.uml.actions.diagram.elements.actions
        suite.addTest(AddRemoveAttributeActionTests.suite());
        suite.addTest(UpdateActionTests.suite());
        suite.addTest(AddRemoveActionTests.suite());
        suite.addTest(UpdateSizeActionTests.suite());
        suite.addTest(UpdateNameActionTests.suite());
        suite.addTest(AddRemoveOperationActionTests.suite());
        suite.addTest(UpdateVisibilityActionTests.suite());
        suite.addTest(UpdateStereotypeActionTests.suite());
        suite.addTest(UpdateNamespaceActionTests.suite());
        suite.addTest(UpdateSecondAssociationEndActionTests.suite());
        suite.addTest(UpdateFirstAssociationEndActionTests.suite());

        // tests for package com.topcoder.uml.actions.diagram.elements.compartmentextraction
        suite.addTest(AssociationCompartmentExtractorTests.suite());
        suite.addTest(CompartmentNotFoundExceptionTests.suite());
        suite.addTest(GeneralizationCompartmentExtractorTests.suite());
        suite.addTest(ClassifierCompartmentExtractorTests.suite());
        suite.addTest(DefaultNodeCompartmentExtractorTests.suite());
        suite.addTest(CompartmentMalformedExceptionTests.suite());
        suite.addTest(AbstractCompartmentExtractorTests.suite());
        suite.addTest(CompartmentExtractorFactoryTests.suite());
        suite.addTest(StructureCompartmentExtractorTests.suite());
        suite.addTest(ObjectCompartmentExtractorTests.suite());
        suite.addTest(ActivityNodeCompartmentExtractorTests.suite());
        suite.addTest(ActivityStateCompartmentExtractorTests.suite());
        suite.addTest(DefaultEdgeCompartmentExtractorTests.suite());
        suite.addTest(CompartmentNotSupportedExceptionTests.suite());
        suite.addTest(MessageCompartmentExtractorTests.suite());

        suite.addTest(DemoTests.suite());

        return suite;
    }

}
