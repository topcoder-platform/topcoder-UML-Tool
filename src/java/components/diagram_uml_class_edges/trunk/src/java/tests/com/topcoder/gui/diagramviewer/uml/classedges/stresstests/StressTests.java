/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.stresstests;

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

        suite.addTest(AbstractionEdgeStressTest.suite());
        suite.addTest(AggregationBiDirectionalStressTest.suite());
        suite.addTest(AggregationStressTest.suite());
        suite.addTest(AssociationEdgeStressTest.suite());
        suite.addTest(ClosedArrowStressTest.suite());
        suite.addTest(CompositionBiDirectionalStressTest.suite());
        suite.addTest(CompositionStressTest.suite());
        suite.addTest(DependencyEdgeStressTest.suite());
        suite.addTest(DirectedAssociationStressTest.suite());
        suite.addTest(GeneralizationEdgeStressTest.suite());
        suite.addTest(NoArrowStressTest.suite());
        suite.addTest(OpenArrowStressTest.suite());
        suite.addTest(PaintComponentStressTest.suite());
        return suite;
    }
}
