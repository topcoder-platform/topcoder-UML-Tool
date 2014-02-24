/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
 package com.topcoder.gui.trees.document.failuretests;

import com.topcoder.gui.trees.document.impl.BaseDocumentTreeViewFailureTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class FailureTests extends TestCase {

    /**
     * <p>
     * Aggregates all the failure test cases.
     * </p>
     * @return the suite containing all the failure test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(DocumentTreeNodeFailureTest.suite());
        suite.addTest(BaseDocumentTreeViewFailureTest.suite());
        suite.addTest(ClassCentricDocumentTreeViewFailureTest.suite());
        suite.addTest(DiagramCentricDocumentTreeViewFailureTest.suite());
        suite.addTest(DocumentTreePanelImplFailureTest.suite());
        suite.addTest(DocumentTreeTabbedPaneImplFailureTest.suite());
        suite.addTest(IconTreeCellRendererFailureTest.suite());
        suite.addTest(NameChangedEventFailureTest.suite());
        suite.addTest(SelectionChangedEventFailureTest.suite());
        return suite;
    }

}
