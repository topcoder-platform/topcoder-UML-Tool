/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.actions.diagram.CreateActivityDiagramActionFailureTest;
import com.topcoder.uml.actions.diagram.CreateDiagramActionFailureTest;
import com.topcoder.uml.actions.diagram.RemoveDiagramActionFailureTest;
import com.topcoder.uml.actions.diagram.UndoableAbstractActionFailureTest;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * <p>
     * Aggregates all the failure tests.
     * </p>
     * 
     * @return the aggregated failure test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(AdjustDiagramZoomLevelActionFailureTest.suite());
        suite.addTest(ChangeDiagramTitleActionFailureTest.suite());
        suite.addTest(CreateActivityDiagramActionFailureTest.suite());
        suite.addTest(CreateClassDiagramActionFailureTest.suite());
        suite.addTest(CreateDiagramActionFailureTest.suite());
        suite.addTest(CreateSequenceDiagramActionFailureTest.suite());
        suite.addTest(CreateUseCaseDiagramActionFailureTest.suite());
        suite.addTest(RemoveActivityDiagramActionFailureTest.suite());
        suite.addTest(RemoveClassDiagramActionFailureTest.suite());
        suite.addTest(RemoveDiagramActionFailureTest.suite());
        suite.addTest(RemoveSequenceDiagramActionFailureTest.suite());
        suite.addTest(RemoveUseCaseDiagramActionFailureTest.suite());
        suite.addTest(ScrollDiagramViewActionFailureTest.suite());
        suite.addTest(UndoableAbstractActionFailureTest.suite());
        return suite;
    }

}
