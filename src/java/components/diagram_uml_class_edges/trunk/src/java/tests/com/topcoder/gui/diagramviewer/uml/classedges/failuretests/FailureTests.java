/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author still
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * aggregates all Failure test cases.
     *
     * @return failure test suites
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        AbstractionEdgeFailureTest.suite();
        ActiveEdgeEndingFailureTest.suite();
        AggregationBiDirectionalFailureTest.suite();
        AggregationFailureTest.suite();
        AssociationEdgeFailureTest.suite();
        BaseEdgeFailureTest.suite();
        ClosedArrowFailureTest.suite();
        CompositionBiDirectionalFailureTest.suite();
        CompositionFailureTest.suite();
        DependencyEdgeFailureTest.suite();
        DirectedAssociationFailureTest.suite();
        EdgeEndingSelectionTriggerFailureTest.suite();
        EdgeSelectionTriggerFailureTest.suite();
        TextInputListenerFailureTest.suite();
        TextInputTriggerFailureTest.suite();
        GeneralizationEdgeFailureTest.suite();
        NoArrowFailureTest.suite();
        OpenArrowFailureTest.suite();
        PopupMenuEndingTriggerFailureTest.suite();
        PopupMenuTriggerFailureTest.suite();
        TextChangeEventFailureTest.suite();
        TextFieldFailureTest.suite();

        return suite;
    }

}
