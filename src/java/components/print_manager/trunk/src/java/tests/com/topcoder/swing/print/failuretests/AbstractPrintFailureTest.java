/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.failuretests;

import java.awt.Rectangle;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>AbstractPrint</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class AbstractPrintFailureTest extends TestCase {

    /**
     * <p>
     * Failure test for <code>AbstractPrint(Component component)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAbstractPrintComponent() {
        try {
            new PrintImpl(null);
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>AbstractPrint(Component component, Rectangle rectangle)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testAbstractPrintComponentRectangle() {
        try {
            new PrintImpl(null, new Rectangle());
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
