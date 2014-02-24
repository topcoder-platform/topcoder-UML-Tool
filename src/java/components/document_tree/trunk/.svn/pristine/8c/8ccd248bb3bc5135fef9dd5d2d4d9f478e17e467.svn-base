/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.stresstests;

import java.io.File;

import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.impl.ClassCentricDocumentTreeView;
import com.topcoder.gui.trees.document.impl.DocumentTreePanelImpl;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test cases for DocumentTreePanelImpl.
 * </p>
 *
 * @author yinzi
 * @author FireIce
 * @version 1.1
 */
public class DocumentTreePanelImplStressTests extends TestCase {
    /**
     * <p>
     * Represents the times of stress test.
     * </p>
     */
    private static final int TIMES = 10000;

    /**
     * <p>
     * The DocumentTreePanelImpl instance for testing.
     * </p>
     */
    private DocumentTreePanelImpl treePanel;

    /**
     * <p>
     * The DocumentTreeTabbedPane instance for testing.
     * </p>
     */
    private DocumentTreeTabbedPane parent;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        StressTestHelper.clearConfig();

        StressTestHelper.loadConfigurations();

        parent = new DocumentTreeTabbedPaneImpl(StressTestHelper.createUMLModelManager(), StressTestHelper.NAMESPACE);

        treePanel = new DocumentTreePanelImpl(parent, StressTestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void tearDown() throws Exception {
        treePanel = null;
        parent = null;

        StressTestHelper.clearConfig();
    }
/*
    *//**
     * <p>
     * Tests DocumentTreePanelImpl#getCurrentView() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreePanelImpl#getCurrentView() is correct.
     * </p>
     *//*
    public void testGetCurrentView() {
        treePanel.setCurrentView(DocumentTreeViewType.CLASS_CENTRIC);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            treePanel.getCurrentView();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreePanelImpl#getCurrentView() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
    }

    *//**
     * <p>
     * Tests DocumentTreePanelImpl#setCurrentView(DocumentTreeViewType) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreePanelImpl#setCurrentView(DocumentTreeViewType) is correct.
     * </p>
     *//*
    public void testSetCurrentView() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            treePanel.setCurrentView(DocumentTreeViewType.CLASS_CENTRIC);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreePanelImpl#setCurrentView() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
        assertTrue("Failed to set the current view correctly.",
            treePanel.getCurrentView() instanceof ClassCentricDocumentTreeView);
    }*/

    /**
     * <p>
     * Tests DocumentTreePanelImpl#getAllViews() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreePanelImpl#getAllViews() is correct.
     * </p>
     */
    public void testGetAllViews() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            treePanel.getAllViews();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Stress tests: " + "The DocumentTreePanelImpl#getAllViews() in " + TIMES
                + " times takes " + (endTime - startTime) + "ms");
        DocumentTreeView[] views = treePanel.getAllViews();
        // expected the length of views is 3
        assertEquals("Failed to get all the tree views correctly.", 2, views.length);
    }
}