/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.TestHelper;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for IconTreeCellRenderer.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class IconTreeCellRendererTests extends TestCase {
    /**
     * <p>
     * The IconTreeCellRenderer instance for testing.
     * </p>
     */
    private IconTreeCellRenderer renderer;

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

        renderer = new IconTreeCellRenderer(TestHelper.NAMESPACE);
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
        renderer = null;

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
        return new TestSuite(IconTreeCellRendererTests.class);
    }

    /**
     * <p>
     * Tests ctor IconTreeCellRenderer#IconTreeCellRenderer(String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies the newly created IconTreeCellRenderer instance should not be null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create a new IconTreeCellRenderer instance.", renderer);
    }

    /**
     * <p>
     * Tests ctor IconTreeCellRenderer#IconTreeCellRenderer(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_NullNamespace() {
        try {
            new IconTreeCellRenderer(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor IconTreeCellRenderer#IconTreeCellRenderer(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor_EmptyNamespace() {
        try {
            new IconTreeCellRenderer(" ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor IconTreeCellRenderer#IconTreeCellRenderer(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when namespace is unknown and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_UnknownNamespace() {
        try {
            new IconTreeCellRenderer("UnknownNamespace");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor IconTreeCellRenderer#IconTreeCellRenderer(String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when icons property is missing and
     * expects DocumentTreeConfigurationException.
     * </p>
     */
    public void testCtor_IconsMissing() {
        try {
            new IconTreeCellRenderer("icons_missing");
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException e) {
            //good
        }
    }

    /**
     * <p>
     * Tests IconTreeCellRenderer#getTreeCellRendererComponent(JTree,Object,boolean,
     * boolean,boolean,int,boolean) for accuracy.
     * </p>
     *
     * <p>
     * It verifies IconTreeCellRenderer#getTreeCellRendererComponent(JTree,Object,
     * boolean,boolean,boolean,int,boolean) is correct.
     * </p>
     */
    public void testGetTreeCellRendererComponent() {
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode();

        JLabel label = (JLabel) renderer.getTreeCellRendererComponent(new JTree(), treeNode, true, true, true, 1, true);

        assertNotNull("Failed to get the tree cell renderer correctly.", label.getIcon());
    }

    /**
     * <p>
     * Tests IconTreeCellRenderer#getTreeCellRendererComponent(JTree,Object,boolean,
     * boolean,boolean,int,boolean) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when value is null and expects IllegalArgumentException.
     * </p>
     */
    public void testGetTreeCellRendererComponent_NullValue() {
        try {
            renderer.getTreeCellRendererComponent(new JTree(), null, true, true, true, 1, true);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

}