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
 * Unit test cases for class CopyInterfaceAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyInterfaceActionTest extends TestCase {

    /**
     * The Interface instance for the test.
     */
    private Interface interfacee = new InterfaceImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Test Constructor(Interface), with correct interface.
     */
    public void testCtor1() {
        CopyInterfaceAction copyAction = new CopyInterfaceAction(interfacee);

        assertTrue("Should be a CopyInterfaceAction instance.", copyAction instanceof CopyInterfaceAction);
    }

    /**
     * Test Constructor(Interface), with null interface.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullInterface() {
        try {
            new CopyInterfaceAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Interface, Clipboard), with correct interface and
     * clipboard.
     */
    public void testCtor2() {
        CopyInterfaceAction copyAction = new CopyInterfaceAction(interfacee, clipboard);

        assertTrue("Should be a CopyInterfaceAction instance.", copyAction instanceof CopyInterfaceAction);
    }

    /**
     * Test Constructor(Interface, Clipboard), with null interface.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullInterface() {
        try {
            new CopyInterfaceAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Interface, Clipboard), with null clipboard. Do the same
     * as it is not null, for the constructor will assign the default clipboard.
     */
    public void testCtor2WithNullClipboard() {
        try {
            new CopyInterfaceAction(interfacee, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }
}