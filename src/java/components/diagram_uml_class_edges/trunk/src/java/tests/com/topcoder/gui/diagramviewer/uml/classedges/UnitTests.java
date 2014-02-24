/*
 * Copyright (c) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.gui.diagramviewer.uml.classedges.event.EdgeSelectionTriggerUnitTests;
import com.topcoder.gui.diagramviewer.uml.classedges.event.EdgeEndingSelectionTriggerUnitTests;
import com.topcoder.gui.diagramviewer.uml.classedges.event.PopupMenuTriggerUnitTests;
import com.topcoder.gui.diagramviewer.uml.classedges.event.PopupMenuEndingTriggerUnitTests;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextInputTriggerUnitTests;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextInputListenerUnitTests;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeEventUnitTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all unit test cases.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * Test suite of unit test cases.
     * </p>
     *
     * @return the test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        //Demo
        suite.addTestSuite(Demo.class);

        //com.topcoder.gui.diagramviewer.uml.classedges
        suite.addTestSuite(BaseEdgeUnitTests.class);
        suite.addTestSuite(AbstractionEdgeUnitTests.class);
        suite.addTestSuite(AssociationEdgeUnitTests.class);
        suite.addTestSuite(DependencyEdgeUnitTests.class);
        suite.addTestSuite(GeneralizationEdgeUnitTests.class);

		suite.addTestSuite(ActiveEdgeEndingUnitTests.class);
		suite.addTestSuite(DirectedAssociationUnitTests.class);
		suite.addTestSuite(NoArrowUnitTests.class);
		suite.addTestSuite(AggregationUnitTests.class);
		suite.addTestSuite(AggregationBiDirectionalUnitTests.class);
		suite.addTestSuite(CompositionUnitTests.class);
		suite.addTestSuite(CompositionBiDirectionalUnitTests.class);
		
        suite.addTestSuite(ClosedArrowUnitTests.class);
        suite.addTestSuite(OpenArrowUnitTests.class);
        
        suite.addTestSuite(TextFieldUnitTests.class);
        suite.addTestSuite(IllegalGraphElementExceptionUnitTests.class);
        suite.addTestSuite(UtilsUnitTests.class);

        //com.topcoder.gui.diagramviewer.uml.classedges.event
        suite.addTestSuite(EdgeSelectionTriggerUnitTests.class);
        suite.addTestSuite(EdgeEndingSelectionTriggerUnitTests.class);
        suite.addTestSuite(PopupMenuTriggerUnitTests.class);
        suite.addTestSuite(PopupMenuEndingTriggerUnitTests.class);
        suite.addTestSuite(TextInputTriggerUnitTests.class);
        
        suite.addTestSuite(TextInputListenerUnitTests.class);
        suite.addTestSuite(TextChangeEventUnitTests.class);
        
        return suite;
    }

}
