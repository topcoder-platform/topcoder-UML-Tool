/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This test case aggregates all stress test cases.
 *
 * @author vividmxx
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * Aggregates all stress test cases.
     *
     * @return the aggregated stress test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(EdgeStressTests.class);
        suite.addTestSuite(RectangleConnectorStressTests.class);
        suite.addTestSuite(LineStyleStressTests.class);
        suite.addTestSuite(SelectionCornerStressTests.class);
        suite.addTestSuite(TextFieldStressTests.class);
        suite.addTestSuite(EdgeEndingStressTests.class);
        return suite;
    }
}
