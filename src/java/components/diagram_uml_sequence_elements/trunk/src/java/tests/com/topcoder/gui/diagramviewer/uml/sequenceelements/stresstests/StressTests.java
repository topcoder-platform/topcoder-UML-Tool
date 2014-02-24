/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.sequenceelements.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Stress test cases.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.1
 * @since 1.0
 */
public class StressTests extends TestCase {
    /**
     * <p>
     * This test case aggregates all Stress test cases.
     * </p>
     *
     * @return all Stress test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // old 1.0
        suite.addTestSuite(ObjectNodeTestStress.class);
        suite.addTestSuite(SequenceEdgeTestStress.class);

        // new in 1.1
        suite.addTestSuite(DefaultEdgeLayoutStrategyTestStress.class);
        suite.addTestSuite(LifelineSegmentTestStress.class);
        suite.addTestSuite(LifelineTestStress.class);

        return suite;
    }

}
