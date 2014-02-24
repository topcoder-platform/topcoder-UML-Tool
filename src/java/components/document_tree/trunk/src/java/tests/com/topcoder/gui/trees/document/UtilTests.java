/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

import com.topcoder.gui.trees.document.impl.ClassCentricDocumentTreeView;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * @author biotrail, Orange_Cloud
 * @version 1.1
 * @since 1.0
 */
public class UtilTests extends TestCase {
    /**
     * DocumentTreePanel to use in tests (to create tree view).
     */
    private DocumentTreePanel panel = null;

    /**
     * <p>
     * Returns all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UtilTests.class);
    }

    /**
     * <p>Sets up test environment.</p>
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigurations();
        DocumentTreeTabbedPane parent =
                new DocumentTreeTabbedPaneImpl(TestHelper.createUMLModelManager(), TestHelper.NAMESPACE_NEW);
        panel = parent.getCurrentPanel();
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
     * <p>
     * Tests Util#checkNull(Object,String) for accuracy.
     * </p>
     */
    public void testCheckNull() {
        Util.checkNull(" ", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullArg() {
        try {
            Util.checkNull(null, "test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for accuracy.
     * </p>
     */
    public void testCheckString() {
        Util.checkString("test", "test");
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_NullArg() {
        try {
            Util.checkString(null, "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is empty and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_EmptyArg() {
        try {
            Util.checkString(" ", "Test");

            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkArray(Object[],String) for accuracy.
     * </p>
     *
     * <p>
     * It verifies Util#checkArray(Object[],String) is correct.
     * </p>
     */
    public void testCheckArray() {
        Object[] objects = new Object[] {"one"};
        Util.checkArray(objects, "test");
    }

    /**
     * <p>
     * Tests Util#checkArray(Object[],String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckArray_NullArg() {
        try {
            Util.checkArray(null, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests Util#checkArray(Object[],String) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when arg contains null element and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckArray_NullInArg() {
        Object[] objects = new Object[] {"one", null};
        try {
            Util.checkArray(objects, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * Tests createTreeView method for null parameter.
     * IllegalArgumentException expected.
     */
    public void testCreateTreeViewForNull() {
        try {
            Util.createTreeView("class", null, "namespace");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * Tests createTreeView method for empty string parameter.
     * IllegalArgumentException expected.
     */
    public void testCreateTreeViewForEmptyString() {
        try {
            Util.createTreeView("class", panel, "    ");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException ex) {
            // success
        }
    }

    /**
     * Tests createTreeView method for wrong class name.
     * DocumentTreeConfigurationException expected.
     */
    public void testCreateTreeViewForWrongClass() {
        try {
            Util.createTreeView("java.lang.String", panel, TestHelper.NAMESPACE_NEW);
            fail("DocumentTreeConfigurationException expected.");
        } catch (DocumentTreeConfigurationException ex) {
            // success
        }
    }

    /**
     * Tests createTreeView method for valid data (class-centric view).
     */
    public void testCreateTreeView() {
        DocumentTreeView view =
                Util.createTreeView(ClassCentricDocumentTreeView.class.getName(), panel, TestHelper.NAMESPACE_NEW);
        assertTrue("correct view created", view instanceof ClassCentricDocumentTreeView);
    }
}