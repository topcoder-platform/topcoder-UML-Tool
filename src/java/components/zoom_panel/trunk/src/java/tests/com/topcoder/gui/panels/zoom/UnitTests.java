/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.zoom;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.panels.zoom.transform.AffineZoomTransformUnitTest;
import com.topcoder.gui.panels.zoom.transform.NatureZoomTransformUnitTest;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <P>
     * The unit tests for diagram elements actions component.
     * </P>
     *
     * @return the suite contains all unit tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(Demo.class);
        suite.addTestSuite(ZoomPanelUnitTest.class);
        suite.addTestSuite(ZoomPaneUnitTest.class);
        suite.addTestSuite(HelperUnitTest.class);

        suite.addTestSuite(AffineZoomTransformUnitTest.class);
        suite.addTestSuite(NatureZoomTransformUnitTest.class);
        return suite;
    }

}
