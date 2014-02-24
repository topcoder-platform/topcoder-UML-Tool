/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all stress test cases.</p>
 *
 * @author icyriver
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

        suite.addTest(BezierPointStressTest.suite());
        suite.addTest(DiagramElementStressTest.suite());
        suite.addTest(GraphElementStressTest.suite());
        suite.addTest(GraphEdgeStressTest.suite());
        suite.addTest(DiagramStressTest.suite());
        suite.addTest(GraphConnectorStressTest.suite());
        suite.addTest(SimpleClassStressTest.suite());

        return suite;
    }
}
