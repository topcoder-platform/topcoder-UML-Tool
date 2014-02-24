/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements;

import junit.framework.TestCase;

/**
 * <p>
 * This class aggregates failure tests for SelectionCornerMouseListener class.
 * </p>
 * 
 * @author ch_music
 * @version 1.0
 */
public class SelectionCornerMouseListenerFailureTests extends TestCase {

    /**
     * Tests constructor with null node argument. IllegalArgumentException is expected.
     */
    public void testSelectionCornerMouseListener() {
        try {
            new SelectionCornerMouseListener(null);
            fail("Did not throw IAE with null node argument.");
        } catch (IllegalArgumentException e) {
            // Expected case.
            assertNotNull("Exception message must not be null.", e.getMessage());
            assertNotSame("Exception message must not be empty string.", "", e.getMessage());
        }
    }
}
