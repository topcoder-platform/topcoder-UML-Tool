/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.panels.style.stresstests;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class StressTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        suite.addTestSuite(StylePaneStressTest.class);
        suite.addTestSuite(ColorChooserPanelStressTest.class);
        suite.addTestSuite(FontSizeSelectorStressTest.class);
        suite.addTestSuite(FontFamilySelectorStressTest.class);
        
        
        
        //suite.addTest(XXX.suite());
        return suite;
    }
}
