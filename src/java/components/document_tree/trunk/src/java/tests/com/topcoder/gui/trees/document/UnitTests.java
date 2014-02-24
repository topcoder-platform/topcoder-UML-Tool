/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.gui.trees.document.impl.BaseDocumentTreeViewTests;
import com.topcoder.gui.trees.document.impl.ClassCentricDocumentTreeViewTests;
import com.topcoder.gui.trees.document.impl.DiagramCentricDocumentTreeViewTests;
import com.topcoder.gui.trees.document.impl.DocumentTreePanelImplTests;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImplTests;
import com.topcoder.gui.trees.document.impl.DocumentTreeViewHelperTests;
import com.topcoder.gui.trees.document.impl.IconTreeCellRendererTests;
import com.topcoder.gui.trees.document.impl.PackageCentricDocumentTreeViewTests;
import com.topcoder.gui.trees.document.impl.SimpleDocumentTreePanelTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
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

        // tests for package com.topcoder.gui.trees.document
        suite.addTest(DocumentTreeNodeTypeTests.suite());
        suite.addTest(NameChangedEventTests.suite());
        suite.addTest(DocumentTreeViewTypeTests.suite());
        suite.addTest(DocumentTreeNodeTests.suite());
        suite.addTest(SelectionChangedEventTests.suite());
        suite.addTest(DocumentTreeNodeArrayTransferableTests.suite());
        suite.addTest(DocumentTreeViewTransferHandlerTests.suite());
        suite.addTest(DocumentTreeConfigurationExceptionTests.suite());
        suite.addTest(ViewChangedEventTest.suite());
        suite.addTest(UtilTests.suite());

        // tests for package com.topcoder.gui.trees.document.impl
        suite.addTest(IconTreeCellRendererTests.suite());
        suite.addTest(PackageCentricDocumentTreeViewTests.suite());
        suite.addTest(DiagramCentricDocumentTreeViewTests.suite());
        suite.addTest(DocumentTreePanelImplTests.suite());
        suite.addTest(SimpleDocumentTreePanelTest.suite());
        suite.addTest(BaseDocumentTreeViewTests.suite());
        suite.addTest(DocumentTreeTabbedPaneImplTests.suite());
        suite.addTest(ClassCentricDocumentTreeViewTests.suite());
        suite.addTest(DocumentTreeViewHelperTests.suite());

        // tests for the demo
        suite.addTest(DemoTests.suite());

        return suite;
    }
}
