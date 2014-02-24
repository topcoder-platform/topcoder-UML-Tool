/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel;

import com.topcoder.gui.panels.properties.propertypanel.VisibilityPropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for VisibilityPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class VisibilityPropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor VisibilityPropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new VisibilityPropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}