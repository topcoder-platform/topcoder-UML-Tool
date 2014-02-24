/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class ClassUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassUtilTest extends TestCase {

    /**
     * The ClassToolUtil instance for the test.
     */
    private ClassUtil classUtil;

    /**
     * The Class instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class modelElement = new ClassImpl();

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
        classUtil = new ClassUtil();
    }

    /**
     * Test addElementToClipboard, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToClipboard() throws Exception {
        classUtil = new ClassUtil();

        classUtil.addElementToClipboard(modelElement, clipboard);

        assertTrue("Should add a new modelElement to the clipboard.", clipboard
                .getData(ClassElementsTransfer.CLASS_FLAVOR) instanceof ClassImpl);
        assertFalse("Should add a new modelElement to the clipboard.", clipboard.getData(
                ClassElementsTransfer.CLASS_FLAVOR).equals(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToClipboardWithNullModelElement() {
        classUtil = new ClassUtil();

        try {
            classUtil.addElementToClipboard(null, clipboard);
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
        classUtil = new ClassUtil();

        try {
            classUtil.addElementToClipboard(modelElement, null);
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
        classUtil = new ClassUtil();

        com.topcoder.uml.model.core.classifiers.Class newModleElement =
            (com.topcoder.uml.model.core.classifiers.Class) classUtil
                .copyElement(modelElement);

        // the base attributes are test in ClassToolUtilTest
        assertEquals("Copy failed.", modelElement.isActive(), newModleElement.isActive());
    }

    /**
     * Test copyElement, with null classUtil. IllegalArgumentException is
     * expected.
     */
    public void testCopyElementWithNullModelElement() {
        classUtil = new ClassUtil();

        try {
            classUtil.copyElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}