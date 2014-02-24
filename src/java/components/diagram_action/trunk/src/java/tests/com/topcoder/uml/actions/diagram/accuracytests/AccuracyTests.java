/*
 *
 * Copyright (c) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        //suite.addTest(XXX.suite());
        // suite.addTest(RemoveUseCaseDiagramActionAccuracyTests.suite());
        suite.addTest(AdjustDiagramZoomLevelActionAccuracyTests.suite());
        suite.addTest(ChangeDiagramTitleActionAccuracyTests.suite());

        suite.addTest(CreateActivityDiagramActionAccuracyTests.suite());
        suite.addTest(CreateClassDiagramActionAccuracyTests.suite());
        suite.addTest(CreateDiagramActionAccuracyTests.suite());
        suite.addTest(CreateSequenceDiagramActionAccuracyTests.suite());
        suite.addTest(CreateUseCaseDiagramActionAccuracyTests.suite());

        suite.addTest(RemoveActivityDiagramActionAccuracyTests.suite());
        suite.addTest(RemoveClassDiagramActionAccuracyTests.suite());
        suite.addTest(RemoveDiagramActionAccuracyTests.suite());
        suite.addTest(RemoveSequenceDiagramActionAccuracyTests.suite());
        suite.addTest(RemoveUseCaseDiagramActionAccuracyTests.suite());

        suite.addTest(ScrollDiagramViewActionAccuracyTests.suite());

        suite.addTest(UndoableAbstractActionAccuracyTests.suite());
        return suite;
    }

}
