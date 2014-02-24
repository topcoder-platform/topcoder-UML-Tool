/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy tests for the UI component tab closed.
 *
 * @author knuthocean
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    /**
     * all acc tests.
     *
     * @return suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ClosableTabbedPaneAccuracyTests.class);
        suite.addTestSuite(ClosableTabbedPaneEventAccuracyTests.class);
        suite.addTestSuite(DirectionalActiveTabSelectorAccuracyTests.class);
        suite.addTestSuite(PreviousActiveTabSelectorAccuracyTests.class);
        return suite;
    }
}