/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.failuretests;

import java.awt.Rectangle;

import junit.framework.TestCase;

import com.topcoder.swing.print.FitInPagePrint;

/**
 * <p>
 * Failure test for <code>FitInPagePrint</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class FitInPagePrintFailureTest extends TestCase {

    /**
     * <p>
     * Failure test for <code>FitInPagePrint(Component component)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testFitInPagePrintComponent() {
        try {
            new FitInPagePrint(null);
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Failure test for <code>FitInPagePrint(Component component)</code>.
     * </p>
     * <p>
     * component is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testFitInPagePrintComponentRectangle() {
        try {
            new FitInPagePrint(null, new Rectangle());
            fail("component is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

}
