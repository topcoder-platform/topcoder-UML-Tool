/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class EnumerationUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationUtilTest extends TestCase {

    /**
     * The ClassToolUtil instance for the test.
     */
    private EnumerationUtil enumerationUtil;

    /**
     * The Enumeration instance for the test.
     */
    private Enumeration modelElement = new EnumerationImpl();

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
        enumerationUtil = new EnumerationUtil();
    }

    /**
     * Test addElementToClipboard, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToClipboard() throws Exception {
        enumerationUtil = new EnumerationUtil();

        enumerationUtil.addElementToClipboard(modelElement, clipboard);

        assertTrue("Should add a new modelElement to the clipboard.", clipboard
                .getData(ClassElementsTransfer.ENUMERATION_FLAVOR) instanceof EnumerationImpl);
        assertFalse("Should add a new modelElement to the clipboard.", clipboard.getData(
                ClassElementsTransfer.ENUMERATION_FLAVOR).equals(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToClipboardWithNullModelElement() {
        enumerationUtil = new EnumerationUtil();

        try {
            enumerationUtil.addElementToClipboard(null, clipboard);
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
        enumerationUtil = new EnumerationUtil();

        try {
            enumerationUtil.addElementToClipboard(modelElement, null);
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
        enumerationUtil = new EnumerationUtil();

        Enumeration newModleElement = (Enumeration) enumerationUtil.copyElement(modelElement);

        // the base attributes are test in ClassToolUtilTest
        assertEquals("Copy failed.", modelElement.getLiterals(), newModleElement.getLiterals());
    }

    /**
     * Test copyElement, with null classUtil. IllegalArgumentException is
     * expected.
     */
    public void testCopyElementWithNullModelElement() {
        enumerationUtil = new EnumerationUtil();

        try {
            enumerationUtil.copyElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}