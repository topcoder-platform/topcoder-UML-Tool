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
 * Unit test cases for class CopyClassAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyClassActionTest extends TestCase {

    /**
     * The Class instance for the test.
     */
    private com.topcoder.uml.model.core.classifiers.Class classs = new ClassImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Test Constructor(Class), with correct class.
     */
    public void testCtor1() {
        CopyClassAction copyAction = new CopyClassAction(classs);

        assertTrue("Should be a CopyClassAction instance.", copyAction instanceof CopyClassAction);
    }

    /**
     * Test Constructor(Class), with null class. IllegalArgumentException is
     * expected.
     */
    public void testCtor1WithNullClass() {
        try {
            new CopyClassAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, Clipboard), with correct class and clipboard.
     */
    public void testCtor2() {
        CopyClassAction copyAction = new CopyClassAction(classs, clipboard);

        assertTrue("Should be a CopyClassAction instance.", copyAction instanceof CopyClassAction);
    }

    /**
     * Test Constructor(Class, Clipboard), with null class.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullClass() {
        try {
            new CopyClassAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Class, Clipboard), with null clipboard. Do the same as
     * it is not null, for the constructor will assign the default clipboard.
     */
    public void testCtor2WithNullClipboard() {
        try {
            new CopyClassAction(classs, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }
}