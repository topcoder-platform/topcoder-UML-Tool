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
 * Unit test cases for class CopyEnumerationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyEnumerationActionTest extends TestCase {

    /**
     * The Enumeration instance for the test.
     */
    private Enumeration enumeration = new EnumerationImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Test Constructor(Enumeration), with correct enumeration.
     */
    public void testCtor1() {
        CopyEnumerationAction copyAction = new CopyEnumerationAction(enumeration);

        assertTrue("Should be a CopyEnumerationAction instance.", copyAction instanceof CopyEnumerationAction);
    }

    /**
     * Test Constructor(Enumeration), with null enumeration.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullEnumeration() {
        try {
            new CopyEnumerationAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Enumeration, Clipboard), with correct enumeration and
     * clipboard.
     */
    public void testCtor2() {
        CopyEnumerationAction copyAction = new CopyEnumerationAction(enumeration, clipboard);

        assertTrue("Should be a CopyEnumerationAction instance.", copyAction instanceof CopyEnumerationAction);
    }

    /**
     * Test Constructor(Enumeration, Clipboard), with null enumeration.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullEnumeration() {
        try {
            new CopyEnumerationAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Enumeration, Clipboard), with null clipboard. Do the
     * same as it is not null, for the constructor will assign the default
     * clipboard.
     */
    public void testCtor2WithNullClipboard() {
        try {
            new CopyEnumerationAction(enumeration, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }
}