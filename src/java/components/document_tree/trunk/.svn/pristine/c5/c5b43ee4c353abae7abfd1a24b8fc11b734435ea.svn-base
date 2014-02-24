/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.impl.IconTreeCellRenderer;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link IconTreeCellRenderer} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class IconTreeCellRendererFailureTest extends TestCase {

    /**
     * <p>
     * Sets up the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        FailureTestHelper.setUp();
    }

    /**
     * <p>
     * Tears down the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.tearDown();
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(IconTreeCellRendererFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link IconTreeCellRenderer#IconTreeCellRenderer(String)} constructor with namespace as
     * null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureIconTreeCellRenderer() throws Exception {
        try {
            new IconTreeCellRenderer(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link IconTreeCellRenderer#IconTreeCellRenderer(String)} constructor with namespace as
     * Empty string.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureIconTreeCellRenderer1() throws Exception {
        try {
            new IconTreeCellRenderer("");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link IconTreeCellRenderer#IconTreeCellRenderer(String)} constructor with namespace as
     * Empty string with only spaces.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureIconTreeCellRenderer2() throws Exception {
        try {
            new IconTreeCellRenderer("  ");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link IconTreeCellRenderer#IconTreeCellRenderer(String)} constructor.
     * </p>
     * <p>
     * Unknown Namespace.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureIconTreeCellRenderer3() throws Exception {
        try {
             new IconTreeCellRenderer("Unknown");
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link IconTreeCellRenderer#IconTreeCellRenderer(String)} constructor.
     * </p>
     * <p>
     * Icons property missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureIconTreeCellRenderer13() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_IconsMissing.xml");
             new IconTreeCellRenderer(FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }
}
