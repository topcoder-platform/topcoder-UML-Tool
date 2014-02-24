/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author Hacker_QC
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        suite.addTest(new TestSuite(BaseNodeFailureTest.class));
        suite.addTest(new TestSuite(BoundaryChangeEventFailureTest.class));
        suite.addTest(new TestSuite(CommentConnectorFailureTest.class));
        suite.addTest(new TestSuite(CommentLinkEdgeFailureTest.class));
        suite.addTest(new TestSuite(CommentNodeFailureTest.class));
        suite.addTest(new TestSuite(EditBoxListenerFailureTest.class));
        suite.addTest(new TestSuite(FreeTextNodeFailureTest.class));
        suite.addTest(new TestSuite(PolylineNodeFailureTest.class));
        suite.addTest(new TestSuite(PropertyMappingFailureTest.class));
        suite.addTest(new TestSuite(TextChangeEventFailureTest.class));
        suite.addTest(new TestSuite(TextNodeFailureTest.class));
        
        return suite;
    }
}
