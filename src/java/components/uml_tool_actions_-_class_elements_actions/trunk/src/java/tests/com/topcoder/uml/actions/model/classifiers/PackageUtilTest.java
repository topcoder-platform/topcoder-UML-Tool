/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.modelmanagement.PackageImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class PackageUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PackageUtilTest extends TestCase {

    /**
     * The PackageUtil instance for the test.
     */
    private PackageUtil packageUtil;

    /**
     * The Package instance for the test.
     */
    private com.topcoder.uml.model.modelmanagement.Package modelElement = new PackageImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard;

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Test constructor.
     */
    public void testCtor() {
        packageUtil = new PackageUtil();
    }

    /**
     * Test addElementToClipboard, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToClipboard() throws Exception {
        packageUtil = new PackageUtil();

        packageUtil.addElementToClipboard(modelElement, clipboard);

        assertTrue("Should add a new modelElement to the clipboard.", clipboard
                .getData(ClassElementsTransfer.PACKAGE_FLAVOR) instanceof PackageImpl);
        assertFalse("Should add a new modelElement to the clipboard.", clipboard.getData(
                ClassElementsTransfer.PACKAGE_FLAVOR).equals(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToClipboardWithNullModelElement() {
        packageUtil = new PackageUtil();

        try {
            packageUtil.addElementToClipboard(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test addElementToClipboard, with null classUtil. IllegalArgumentException
     * is expected.
     */
    public void testAddElementToClipboardWithNullClassUtil() {
        packageUtil = new PackageUtil();

        try {
            packageUtil.addElementToClipboard(modelElement, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test copyElement, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCopyElement() throws Exception {
        packageUtil = new PackageUtil();

        com.topcoder.uml.model.modelmanagement.Package newModleElement =
            (com.topcoder.uml.model.modelmanagement.Package) packageUtil.copyElement(modelElement);

        // the base attributes are test in ClassToolUtilTest
        assertEquals("Copy failed.", modelElement.isLeaf(), newModleElement.isLeaf());
        assertEquals("Copy failed.", modelElement.isRoot(), newModleElement.isRoot());
        assertEquals("Copy failed.", modelElement.isAbstract(), newModleElement.isAbstract());
    }

    /**
     * Test copyElement, with null classUtil. IllegalArgumentException is
     * expected.
     */
    public void testCopyElementWithNullModelElement() {
        packageUtil = new PackageUtil();

        try {
            packageUtil.copyElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}