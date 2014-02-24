/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.TestHelper;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Simple tests for SimpleDocumentTreePanel class.
 *
 * @author Orange_Cloud
 * @version 1.1
 */
public class SimpleDocumentTreePanelTest extends TestCase {
    /**
     * Tree panel to test.
     */
    private SimpleDocumentTreePanel target = null;

    /**
     * This is tabbed pane used to hold tested panel.
     */
    private DocumentTreeTabbedPane parent = null;

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(SimpleDocumentTreePanelTest.class);
    }

    /**
     * <p>Sets up test environment.</p>
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigurations();
        parent = new DocumentTreeTabbedPaneImpl(TestHelper.createUMLModelManager(), TestHelper.NAMESPACE_NEW);
        target = (SimpleDocumentTreePanel) parent.getCurrentPanel();
    }

    /**
     * <p>Tears down test environment.</p>
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * Tests constructor for valid data.
     */
    public void testConstructor() {
        assertNotNull("created instance", new SimpleDocumentTreePanel(parent, TestHelper.NAMESPACE_NEW,
                ClassCentricDocumentTreeView.class.getName()));
    }

    /**
     * Tests constructor for null parameter.
     * IllegalArgumentException expected.
     */
    public void testConstructorForNull() {
        try {
            new SimpleDocumentTreePanel(null, "some_namespace", "class_name");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * Tests constructor for empty string.
     * IllegalArgumentException expected.
     */
    public void testConstructorForEmptyString() {
        try {
            new SimpleDocumentTreePanel(parent, "   ", "class_name");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * Tests constructor for unknown class name.
     * DocumentTreeConfigurationException expected.
     */
    public void testConstructorForBadClass() {
        try {
            new SimpleDocumentTreePanel(parent, TestHelper.NAMESPACE_NEW, "no.such.class");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException ex) {
            // success
        }
    }

    /**
     * Tests constructor for missed namespace.
     * DocumentTreeConfigurationException expected.
     */
    public void testConstructorForBadNamespace() {
        try {
            new SimpleDocumentTreePanel(parent, "no_such_namespace", DiagramCentricDocumentTreeView.class.getName());
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException ex) {
            // success
        }
    }

    /**
     * Checks getParent method.
     */
    public void testGetParent() {
        assertSame("parent tab", parent, target.getParent());
    }

    /**
     * Checks getPanel method.
     */
    public void testGetPanel() {
        assertNotNull("panel storing tree", target.getPanel());
    }

    /**
     * Tests getCurrentView method.
     */
    public void testGetCurrentView() {
        assertTrue("current view type", target.getCurrentView() instanceof ClassCentricDocumentTreeView);
    }

    /**
     * Tests setCurrentView method.
     * UnsupportedOperationException expected.
     */
    public void testSetCurrentView() {
        try {
            target.setCurrentView(DocumentTreeViewType.DIAGRAM_CENTRIC);
            fail("UnsupportedOperationException expected.");
        } catch (UnsupportedOperationException ex) {
            // success
        }
    }

    /**
     * Tests getAllViews method. Only one view expected.
     */
    public void testGetAllViews() {
        DocumentTreeView[] views = target.getAllViews();
        assertEquals("only one view expected", 1, views.length);
        assertSame("view is correct", target.getCurrentView(), views[0]);
    }
}
