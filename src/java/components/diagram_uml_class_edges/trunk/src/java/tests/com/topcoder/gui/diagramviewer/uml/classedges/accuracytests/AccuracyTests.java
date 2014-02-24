/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests;

import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event.EdgeEndingSelectionTriggerAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event.EdgeSelectionTriggerAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event.TextInputListenerAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event.TextInputTriggerAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event.PopupMenuEndingTriggerAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event.PopupMenuTriggerAccuracyTests;
import com.topcoder.gui.diagramviewer.uml.classedges.accuracytests.event.TextChangeEventAccuracyTests;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * <p>The accuracy test for this component.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class AccuracyTests {
    /**
     * <p>all the accuracy tests for this component.</p>
     *
     * @return all the tests for this component
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        //accuracy tests for package
        //com.topcoder.gui.diagramviewer.uml.classedges
        suite.addTestSuite(AbstractionEdgeAccuracyTests.class);
        suite.addTestSuite(AggregationBiDirectionalAccuracyTests.class);
        suite.addTestSuite(AggregationAccuracyTests.class);
        suite.addTestSuite(AssociationEdgeAccuracyTests.class);
        suite.addTestSuite(ClosedArrowAccuracyTests.class);
        suite.addTestSuite(CompositionAccuracyTests.class);
        suite.addTestSuite(CompositionBiDirectionalAccuracyTests.class);
        suite.addTestSuite(DependencyEdgeAccuracyTests.class);
        suite.addTestSuite(DirectedAssociationAccuracyTests.class);
        suite.addTestSuite(GeneralizationEdgeAccuracyTests.class);
        suite.addTestSuite(NoArrowAccuracyTests.class);
        suite.addTestSuite(OpenArrowAccuracyTests.class);
        suite.addTestSuite(TextFieldAccuracyTests.class);
        //accuracy test for package
        //com.topcoder.gui.diagramviewer.uml.classedges.event
        suite.addTestSuite(EdgeEndingSelectionTriggerAccuracyTests.class);
        suite.addTestSuite(EdgeSelectionTriggerAccuracyTests.class);
        suite.addTestSuite(TextInputListenerAccuracyTests.class);
        suite.addTestSuite(TextInputTriggerAccuracyTests.class);
        suite.addTestSuite(PopupMenuEndingTriggerAccuracyTests.class);
        suite.addTestSuite(PopupMenuTriggerAccuracyTests.class);
        suite.addTestSuite(TextChangeEventAccuracyTests.class);

        return suite;
    }
}
