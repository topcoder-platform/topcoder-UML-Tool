/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 * 
 * @author Achilles_2005
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        suite.addTestSuite(BaseNodeAccuracyTest.class);
        suite.addTestSuite(BoundaryChangeEventAccuracyTest.class);
        suite.addTestSuite(CommentLinkEdgeAccuracyTest.class);
        suite.addTestSuite(CommentNodeAccuracyTest.class);
        suite.addTestSuite(EditBoxListenerAccuracyTest.class);
        suite.addTestSuite(FreeTextNodeAccuracyTest.class);
        suite.addTestSuite(PolylineNodeAccuracyTest.class);
        suite.addTestSuite(PopupMenuTriggerAccuracyTest.class);
        suite.addTestSuite(PropertyMappingAccuracyTest.class);
        suite.addTestSuite(TextChangeEventAccuracyTest.class);
        suite.addTestSuite(TextNodeAccuracyTest.class);
        
        suite.addTestSuite(CommonConnectorAccuracyTest.class);

        return suite;
    }

}
