/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.uml.sequenceelements.accuracytests.AccuracyTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.failuretests.FailureTests;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests.StressTests;

/**
 * This test case aggregates all test cases.
 * 
 * @author TopCoder
 * @version 1.1
 */
public class AllTests extends TestCase {

    /**
     * Aggregates all test cases.
     * 
     * @return the aggregated test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(UnitTests.suite());
        suite.addTest(FailureTests.suite());
        suite.addTest(AccuracyTests.suite());
        suite.addTest(StressTests.suite());
        return suite;
    }
}
