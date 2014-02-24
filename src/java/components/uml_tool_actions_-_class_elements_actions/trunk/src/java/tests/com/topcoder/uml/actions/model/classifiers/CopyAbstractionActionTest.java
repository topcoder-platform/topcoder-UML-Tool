/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class CopyAbstractionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyAbstractionActionTest extends TestCase {

    /**
     * The Abstraction instance for the test.
     */
    private Abstraction abstraction = new AbstractionImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Test Constructor(Abstraction), with correct abstraction.
     */
    public void testCtor1() {
        CopyAbstractionAction copyAction = new CopyAbstractionAction(abstraction);

        assertTrue("Should be a CopyAbstractionAction instance.", copyAction instanceof CopyAbstractionAction);
    }

    /**
     * Test Constructor(Abstraction), with null abstraction.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullAbstraction() {
        try {
            new CopyAbstractionAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Abstraction, Clipboard), with correct abstraction and
     * clipboard.
     */
    public void testCtor2() {
        CopyAbstractionAction copyAction = new CopyAbstractionAction(abstraction, clipboard);

        assertTrue("Should be a CopyAbstractionAction instance.", copyAction instanceof CopyAbstractionAction);
    }

    /**
     * Test Constructor(Abstraction, Clipboard), with null abstraction.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullAbstraction() {
        try {
            new CopyAbstractionAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Abstraction, Clipboard), with null clipboard. Do the
     * same as it is not null, for the constructor will assign the default
     * clipboard.
     */
    public void testCtor2WithNullClipboard() {
        try {
            new CopyAbstractionAction(abstraction, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }
}