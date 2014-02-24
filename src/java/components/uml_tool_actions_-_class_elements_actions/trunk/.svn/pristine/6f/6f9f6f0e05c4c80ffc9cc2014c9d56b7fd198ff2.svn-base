/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class InterfaceUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class InterfaceUtilTest extends TestCase {

    /**
     * The InterfaceUtil instance for the test.
     */
    private InterfaceUtil interfaceUtil;

    /**
     * The Interface instance for the test.
     */
    private Interface modelElement = new InterfaceImpl();

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
        interfaceUtil = new InterfaceUtil();
    }

    /**
     * Test addElementToClipboard, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToClipboard() throws Exception {
        interfaceUtil = new InterfaceUtil();

        interfaceUtil.addElementToClipboard(modelElement, clipboard);

        assertTrue("Should add a new modelElement to the clipboard.", clipboard
                .getData(ClassElementsTransfer.INTERFACE_FLAVOR) instanceof InterfaceImpl);
        assertFalse("Should add a new modelElement to the clipboard.", clipboard.getData(
                ClassElementsTransfer.INTERFACE_FLAVOR).equals(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToClipboardWithNullModelElement() {
        interfaceUtil = new InterfaceUtil();

        try {
            interfaceUtil.addElementToClipboard(null, clipboard);
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
        interfaceUtil = new InterfaceUtil();

        try {
            interfaceUtil.addElementToClipboard(modelElement, null);
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
        interfaceUtil = new InterfaceUtil();

        Interface newModleElement = (Interface) interfaceUtil.copyElement(modelElement);

        // the base attributes are test in ClassToolUtilTest
        assertTrue("Copy failed.", newModleElement instanceof InterfaceImpl);
    }

    /**
     * Test copyElement, with null classUtil. IllegalArgumentException is
     * expected.
     */
    public void testCopyElementWithNullModelElement() {
        interfaceUtil = new InterfaceUtil();

        try {
            interfaceUtil.copyElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}