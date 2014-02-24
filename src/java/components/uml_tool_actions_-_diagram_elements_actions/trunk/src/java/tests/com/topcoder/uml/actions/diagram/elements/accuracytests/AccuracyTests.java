/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(CopiedElementAccuracyTest.class);
        suite.addTestSuite(CopyDiagramElementActionAccuracyTest.class);
        suite.addTestSuite(CutDiagramElementActionAccuracyTest.class);
        suite.addTestSuite(DiagramElementDataFlavorManagerAccuracyTest.class);
        suite.addTestSuite(PasteDiagramElementActionAccuracyTest.class);
        suite.addTestSuite(RemoveDiagramElementActionAccuracyTest.class);
        //suite.addTest(XXX.suite());
        return suite;
    }

}
