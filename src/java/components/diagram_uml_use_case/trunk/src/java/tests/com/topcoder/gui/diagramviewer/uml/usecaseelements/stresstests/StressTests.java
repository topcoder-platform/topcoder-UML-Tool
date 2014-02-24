/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.stresstests;

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

        suite.addTest(BaseNodeStressTest.suite());
        suite.addTest(BaseEdgeStressTest.suite());
        suite.addTest(SubsystemNodeContainerStressTest.suite());
        suite.addTest(ActorNodeStressTest.suite());
        suite.addTest(UseCaseNodeStressTest.suite());

        return suite;
    }
}
