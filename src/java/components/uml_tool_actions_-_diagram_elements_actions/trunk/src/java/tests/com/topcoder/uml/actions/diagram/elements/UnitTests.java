/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TopCoder
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
        //suite.addTest(XXX.suite());
        suite.addTestSuite(TestArgumentCheckHelper.class);
        suite.addTestSuite(TestCopiedElement.class);
        suite.addTestSuite(TestCopyDiagramElementAction.class);
        suite.addTestSuite(TestDiagramElementDataFlavorManager.class);
        suite.addTestSuite(TestRemoveDiagramElementAction.class);
        suite.addTestSuite(TestPasteDiagramElementAction.class);
        suite.addTestSuite(TestCutDiagramElementAction.class);
        suite.addTestSuite(Demo.class);
        return suite;
    }

}
