/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.edges;

import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnectorTests;

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
     * Return all unit tests.
     * </p>
     *
     * @return all unit tests.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // tests for package com.topcoder.gui.diagramviewer.edges
        suite.addTest(UtilTests.suite());
        suite.addTest(EdgeTests.suite());
        suite.addTest(TextFieldTests.suite());
        suite.addTest(EdgeMouseListenerTests.suite());
        suite.addTest(AnchorTypeTests.suite());
        suite.addTest(SelectionCornerTests.suite());
        suite.addTest(LineStyleTests.suite());
        suite.addTest(EdgeEndingTests.suite());
        suite.addTest(WayPointMouseListenerTests.suite());
        suite.addTest(WayPointEventTests.suite());
        suite.addTest(TextFieldMouseListenerTests.suite());

        // tests for package com.topcoder.gui.diagramviewer.edges.connectors
        suite.addTest(RectangleConnectorTests.suite());

        //  tests for demo
        suite.addTest(DemoTests.suite());

        return suite;
    }
}
