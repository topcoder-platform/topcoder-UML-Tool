/**
 *
 * Copyright (c) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import com.topcoder.gui.diagramviewer.elements.TestNodeMouseListenerAccuracy;
import com.topcoder.gui.diagramviewer.elements.TestSelectionCornerMouseListenerAccuracy;

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

    /**
     * Aggregates all Accuracy test cases.
     * @return Test.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(TestLocationEventAccuracy.class);
        suite.addTestSuite(TestNodeContainerAccuracy.class);
        suite.addTestSuite(TestSelectionBoundEventAccuracy.class);
        suite.addTestSuite(TestDragEventAdapterAccuracy.class);

        suite.addTestSuite(TestNodeMouseListenerAccuracy.class);
        suite.addTestSuite(TestSelectionCornerAccuracy.class);
        suite.addTestSuite(TestSelectionCornerMouseListenerAccuracy.class);
        suite.addTestSuite(TestNodeAccuracy.class);
        return suite;
    }

}
