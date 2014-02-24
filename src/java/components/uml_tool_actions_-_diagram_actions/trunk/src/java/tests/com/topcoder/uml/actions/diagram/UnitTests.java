/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * Returns the test suite of this class.
     * </p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(AdjustDiagramZoomLevelActionTest.suite());

        suite.addTest(ChangeDiagramTitleActionTest.suite());

        suite.addTest(CreateActivityDiagramActionTest.suite());
        suite.addTest(CreateActivityDiagramHelperActionTest.suite());
        suite.addTest(CreateClassDiagramActionTest.suite());
        suite.addTest(CreateDiagramActionTest.suite());
        suite.addTest(CreateSequenceDiagramActionTest.suite());
        suite.addTest(CreateUseCaseDiagramActionTest.suite());

        suite.addTest(HelperTest.suite());

        suite.addTest(RemoveActivityDiagramActionTest.suite());
        suite.addTest(RemoveClassDiagramActionTest.suite());
        suite.addTest(RemoveDiagramActionTest.suite());
        suite.addTest(RemoveSequenceDiagramActionTest.suite());
        suite.addTest(RemoveUseCaseDiagramActionTest.suite());

        suite.addTest(UndoableAbstractActionTest.suite());
        suite.addTest(UndoableActionExceptionTest.suite());

        suite.addTest(ScrollDiagramViewActionTest.suite());

        suite.addTest(DemoTests.suite());
        return suite;
    }

}
