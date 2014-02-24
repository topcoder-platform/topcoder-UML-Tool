/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This class aggregates all failure test cases for the component Elements Toolbar. The tested version is 1.0.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * <p>
     * Returns a Test object containing all the accuracy tests.
     * </p>
     * 
     * @return a Test object containing all the accuracy tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(new TestSuite(SectionPanelFailureTests.class));
        suite.addTest(new TestSuite(SectionPanelConstructorWithConfigFailureTests.class));
        suite.addTest(new TestSuite(ToolBarMainPanelProducerFailureTests.class));

        return suite;
    }
}
