/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;


/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
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

        // tests for package com.topcoder.gui.diagramviewer.uml.auxiliaryelements
        suite.addTest(AuxiliaryElementsHelperTests.suite());
        suite.addTest(BaseNodeTests.suite());
        suite.addTest(BoundaryChangeEventTests.suite());
        suite.addTest(CommentConnectorTests.suite());
        suite.addTest(CommentLinkEdgeTests.suite());
        suite.addTest(CommentNodeTests.suite());
        suite.addTest(ConfigurationExceptionTests.suite());
        suite.addTest(EditBoxListenerTests.suite());
        suite.addTest(FreeTextNodeTests.suite());
        suite.addTest(IllegalGraphNodeExceptionTests.suite());
        suite.addTest(PolylineNodeTests.suite());
        suite.addTest(PopupMenuTriggerTests.suite());
        suite.addTest(PropertyMappingTests.suite());
        suite.addTest(TextChangeEventTests.suite());
        suite.addTest(TextNodeMouseListenerTests.suite());
        suite.addTest(TextNodeTests.suite());

        // tests for the demo
        suite.addTest(DemoTests.suite());

        return suite;
    }
}
