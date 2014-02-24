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
 * Unit test cases for class CutInterfaceAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutInterfaceActionTest extends TestCase {

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
        CutInterfaceAction cutAction = new CutInterfaceAction(interfacee);

        assertEquals("Should return ModelElement instance.", interfacee, cutAction.getModelElement());
    }

    /**
     * Test Constructor(Interface), with null interface.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullInterface() {
        try {
            new CutInterfaceAction(null);
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
        CutInterfaceAction cutAction = new CutInterfaceAction(interfacee, clipboard);

        assertEquals("Should return ModelElement instance.", interfacee, cutAction.getModelElement());
    }

    /**
     * Test Constructor(Interface, Clipboard), with null interface.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullInterface() {
        try {
            new CutInterfaceAction(null, clipboard);
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
            new CutInterfaceAction(interfacee, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        CutInterfaceAction cutAction = new CutInterfaceAction(interfacee);

        assertEquals("Should return PRESENTATION_NAME.", "Cut Interface", cutAction.getPresentationName());
    }
}