/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.failuretests.event;

import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.event.ScrollEvent;

import junit.framework.TestCase;

/**
 * Failure tests for ScrollEvent class.
 *
 * @author Yeung
 * @version 1.0
 */
public class ScrollEventFailureTests extends TestCase {
    /**
     * Tests the constructor ScrollEvent(JViewport, Diagram) with null source,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullSource() throws Exception {
        try {
            new ScrollEvent(null, new Diagram());
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }

    /**
     * Tests the constructor ScrollEvent(JViewport, Diagram) with null diagram,
     * expected IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullDiagram() throws Exception {
        try {
            new ScrollEvent(new JViewport(), null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}