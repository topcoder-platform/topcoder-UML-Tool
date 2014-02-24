/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all stress test cases.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class StressTests extends TestCase {
    /**
     * <p>The method aggregates all stress test cases.</p>
     *
     * @return the test suite of the stress test.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(CreateDiagramActionStressTest.suite());
        suite.addTest(CreateXXXDiagramActionStressTest.suite());
        suite.addTest(CreateActivityDiagramActionStressTest.suite());
        suite.addTest(RemoveActivityDiagramActionStressTest.suite());
        suite.addTest(RemoveXXXDiagramAction.suite());
        suite.addTest(AdjustDiagramZoomLevelActionStressTest.suite());
        suite.addTest(ChangeDiagramTitleActionStressTest.suite());
        suite.addTest(ScrollDiagramViewActionStressTest.suite());

        return suite;
    }
}
