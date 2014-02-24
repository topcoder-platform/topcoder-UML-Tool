/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class CopyGeneralizationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyGeneralizationActionTest extends TestCase {

    /**
     * The Generalization instance for the test.
     */
    private Generalization generalization = new GeneralizationImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Test Constructor(Generalization), with correct generalization.
     */
    public void testCtor1() {
        CopyGeneralizationAction copyAction = new CopyGeneralizationAction(generalization);

        assertTrue("Should be a CopyGeneralizationAction instance.", copyAction instanceof CopyGeneralizationAction);
    }

    /**
     * Test Constructor(Generalization), with null generalization.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullGeneralization() {
        try {
            new CopyGeneralizationAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Generalization, Clipboard), with correct generalization
     * and clipboard.
     */
    public void testCtor2() {
        CopyGeneralizationAction copyAction = new CopyGeneralizationAction(generalization, clipboard);

        assertTrue("Should be a CopyGeneralizationAction instance.", copyAction instanceof CopyGeneralizationAction);
    }

    /**
     * Test Constructor(Generalization, Clipboard), with null generalization.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullGeneralization() {
        try {
            new CopyGeneralizationAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Generalization, Clipboard), with null clipboard. Do the
     * same as it is not null, for the constructor will assign the default
     * clipboard.
     */
    public void testCtor2WithNullClipboard() {
        try {
            new CopyGeneralizationAction(generalization, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }
}