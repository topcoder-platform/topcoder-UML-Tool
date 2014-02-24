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
 * Unit test cases for class CutAbstractionAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutAbstractionActionTest extends TestCase {

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
        CutAbstractionAction cutAction = new CutAbstractionAction(abstraction);

        assertEquals("Should return ModelElement instance.", abstraction, cutAction.getModelElement());
    }

    /**
     * Test Constructor(Abstraction), with null abstraction.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullAbstraction() {
        try {
            new CutAbstractionAction(null);
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
        CutAbstractionAction cutAction = new CutAbstractionAction(abstraction, clipboard);

        assertEquals("Should return ModelElement instance.", abstraction, cutAction.getModelElement());
    }

    /**
     * Test Constructor(Abstraction, Clipboard), with null abstraction.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullAbstraction() {
        try {
            new CutAbstractionAction(null, clipboard);
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
            new CutAbstractionAction(abstraction, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        CutAbstractionAction cutAction = new CutAbstractionAction(abstraction);

        assertEquals("Should return PRESENTATION_NAME.", "Cut Abstraction", cutAction.getPresentationName());
    }
}