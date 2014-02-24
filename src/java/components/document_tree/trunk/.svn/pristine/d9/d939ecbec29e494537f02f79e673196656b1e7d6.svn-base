/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import java.util.HashSet;
import java.util.Set;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for DocumentTreePanelImpl.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class DocumentTreePanelImplTests extends TestCase {
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
        super.setUp();
        TestHelper.loadConfigurations();

        parent = new DocumentTreeTabbedPaneImpl(TestHelper.createUMLModelManager(), TestHelper.NAMESPACE);

        // fix: why create new panel???????? how this could even work before???????????????????????????
        //treePanel = new DocumentTreePanelImpl(parent, TestHelper.NAMESPACE);
        treePanel = (DocumentTreePanelImpl) parent.getCurrentPanel();
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

        TestHelper.clearConfig();
        super.tearDown();
    }

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(DocumentTreePanelImplTests.class);
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created DocumentTreePanelImpl instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new DocumentTreePanelImpl instance.", treePanel);
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when parent is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullParent() {
        try {
            new DocumentTreePanelImpl(null, TestHelper.NAMESPACE);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new DocumentTreePanelImpl(parent, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyNamespace() {
        try {
            new DocumentTreePanelImpl(parent, " ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is unknown and expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_UnknownNamespace() {
        try {
            new DocumentTreePanelImpl(parent, "unkonwnNamespace");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when view types property is missing and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_ViewTypesMissing() {
        try {
            new DocumentTreePanelImpl(parent, "view_types_missing");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the type name of view types property is invalid and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_ViewTypesInvalidType() {
        try {
            new DocumentTreePanelImpl(parent, "view_types_invlid_type");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the view class property is missing and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_ViewClassMissing() {
        try {
            new DocumentTreePanelImpl(parent, "view_class_missing");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the view class property is empty and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_ViewClassEmpty() {
        try {
            new DocumentTreePanelImpl(parent, "view_class_empty");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the view class property is invalid and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_ViewClassInvalid() {
        try {
            new DocumentTreePanelImpl(parent, "view_class_invalid");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the view text property is missing and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_ViewTextMissing() {
        try {
            new DocumentTreePanelImpl(parent, "view_text_missing");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the view text property is empty and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_ViewTextEmpty() {
        try {
            new DocumentTreePanelImpl(parent, "view_text_empty");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreePanelImpl#getPanel() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreePanelImpl#getPanel() is correct.
     * </p>
     */
    public void testGetPanel() {
        assertNotNull("Failed to get the panel correctly.", treePanel.getPanel());
    }

    /**
     * <p>
     * Tests DocumentTreePanelImpl#getCurrentView() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreePanelImpl#getCurrentView() is correct.
     * </p>
     */
    public void testGetCurrentView() {
        treePanel.setCurrentView(DocumentTreeViewType.CLASS_CENTRIC);

        assertTrue("Failed to get the current view correctly.",
            treePanel.getCurrentView() instanceof ClassCentricDocumentTreeView);
    }

    /**
     * <p>
     * Tests DocumentTreePanelImpl#setCurrentView(DocumentTreeViewType) for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreePanelImpl#setCurrentView(DocumentTreeViewType) is correct.
     * </p>
     */
    public void testSetCurrentView() {
        treePanel.setCurrentView(DocumentTreeViewType.CLASS_CENTRIC);

        assertTrue("Failed to set the current view correctly.",
            treePanel.getCurrentView() instanceof ClassCentricDocumentTreeView);
    }

    /**
     * <p>
     * Tests DocumentTreePanelImpl#setCurrentView(DocumentTreeViewType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when viewType is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetCurrentView_NullViewType() {
        try {
            treePanel.setCurrentView(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests DocumentTreePanelImpl#setCurrentView(DocumentTreeViewType) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when the view type is not configured for this tree panel
     * and expects IllegalArgumentException.
     * </p>
     */
    public void testSetCurrentView_NoExistViewType() {
        treePanel = new DocumentTreePanelImpl(parent, "class_centric_not_exist");
        try {
            treePanel.setCurrentView(DocumentTreeViewType.CLASS_CENTRIC);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

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
        DocumentTreeView[] views = treePanel.getAllViews();

        // expected the length of views is 3
        assertEquals("Failed to get all the tree views correctly.", 3, views.length);

        // check the elements in views array
        Set<DocumentTreeViewType> expectedViews = new HashSet<DocumentTreeViewType>();

        for (int i = 0; i < views.length; i++) {
            expectedViews.add(views[i].getViewType());
        }

        assertTrue("Failed to get all the tree views correctly.",
            expectedViews.contains(DocumentTreeViewType.DIAGRAM_CENTRIC));
        assertTrue("Failed to get all the tree views correctly.",
            expectedViews.contains(DocumentTreeViewType.CLASS_CENTRIC));
        assertTrue("Failed to get all the tree views correctly.",
            expectedViews.contains(DocumentTreeViewType.PACKAGE_CENTRIC));
    }

    /**
     * <p>
     * Tests DocumentTreePanelImpl#getParent() for accuracy.
     * </p>
     *
     * <p>
     * It verifies DocumentTreePanelImpl#getParent() is correct.
     * </p>
     */
    public void testGetParent() {
        assertSame("Failed to get the parent correctly.", parent, treePanel.getParent());
    }

    /**
     * Tests isConfigured method for different kinds of input.
     */
    public void testIsConfigured() {
        assertFalse("missed namespace", DocumentTreePanelImpl.isConfigured("no_such_namespace"));
        assertTrue("correct namespace", DocumentTreePanelImpl.isConfigured(TestHelper.NAMESPACE));
        assertFalse("missed view_types", DocumentTreePanelImpl.isConfigured("view_types_missing"));
    }
}