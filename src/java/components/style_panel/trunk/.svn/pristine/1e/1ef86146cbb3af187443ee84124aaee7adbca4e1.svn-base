/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

import com.topcoder.gui.panels.style.styleobject.AbstractStyleObjectTests;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapterTests;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapterTests;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapterTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(StylePanelV11Tests.suite());

        suite.addTest(ColorChooserPanelTests.suite());
        suite.addTest(FontFamilySelectorTests.suite());
        suite.addTest(FontSizeSelectorTests.suite());
        suite.addTest(UtilTests.suite());
        suite.addTest(StyleEventTests.suite());
        suite.addTest(StylePanelConfigurationExceptionTests.suite());
        suite.addTest(ColorPalettePanelTests.suite());
        suite.addTest(StyleNotSupportedExceptionTests.suite());
        suite.addTest(StylePanelExceptionTests.suite());
        suite.addTest(StylePanelTests.suite());

        suite.addTest(AbstractStyleObjectTests.suite());
        suite.addTest(PolylineStyleObjectAdapterTests.suite());
        suite.addTest(GraphEdgeStyleObjectAdapterTests.suite());
        suite.addTest(GraphNodeStyleObjectAdapterTests.suite());

        suite.addTest(DemoTests.suite());

        return suite;
    }

}
