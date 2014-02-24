/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.accuracytests;

import com.topcoder.gui.panels.style.styleobject.accuracytests.GraphEdgeStyleObjectAdapterTests;
import com.topcoder.gui.panels.style.styleobject.accuracytests.GraphNodeStyleObjectAdapterTests;
import com.topcoder.gui.panels.style.styleobject.accuracytests.PolylineStyleObjectAdapterTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return test suite aggregating all tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ColorChooserPanelTests.class);
        suite.addTestSuite(FontFamilySelectorTests.class);
        suite.addTestSuite(FontSizeSelectorTests.class);
        suite.addTestSuite(StyleEventTests.class);
        suite.addTestSuite(StylePanelTests.class);
        suite.addTestSuite(GraphEdgeStyleObjectAdapterTests.class);
        suite.addTestSuite(GraphNodeStyleObjectAdapterTests.class);
        suite.addTestSuite(PolylineStyleObjectAdapterTests.class);
        return suite;
    }

}
