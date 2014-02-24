/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Bloom filter Version 1.1
 *
 * @ StressTests.java
 */
package com.topcoder.gui.trees.document.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class StressTests extends TestCase {
    /**
     * Suite to run the unit tests.
     *
     * @return suite with tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(BaseDocumentTreeViewStressTests.class);
        suite.addTestSuite(ClassCentricDocumentTreeViewStressTests.class);
        suite.addTestSuite(DocumentTreeNodeStressTests.class);
        suite.addTestSuite(IconTreeCellRendererStressTests.class);
        suite.addTestSuite(DocumentTreeTabbedPaneImplStressTests.class);
        suite.addTestSuite(DocumentTreePanelImplStressTests.class);
        return suite;
    }
}
