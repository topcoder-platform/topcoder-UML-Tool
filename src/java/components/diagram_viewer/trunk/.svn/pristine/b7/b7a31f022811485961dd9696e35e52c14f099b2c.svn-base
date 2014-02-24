/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This test case aggregates all stress test cases.
 * 
 * @author CoInitialize
 * @version 1.0
 */
public class StressTests extends TestCase {

    /**
     * This method aggregates all stress test cases.
     * 
     * @return A test suite of all stress test case.
     */
    public static Test suite() {

        final TestSuite suite = new TestSuite();

        suite.addTestSuite(DiagramViewerStressTest.class);
        suite.addTestSuite(DiagramViewStressTest.class);
        suite.addTestSuite(SimpleGridRendererStressTest.class);
        suite.addTestSuite(MouseDragHandlerStressTest.class);
        suite.addTestSuite(SelectionHandlerStressTest.class);

        return suite;
    }
}