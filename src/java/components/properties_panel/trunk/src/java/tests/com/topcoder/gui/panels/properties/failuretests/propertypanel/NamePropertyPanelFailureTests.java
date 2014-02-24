/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel;

import com.topcoder.gui.panels.properties.propertypanel.NamePropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for NamePropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class NamePropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor NamePropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new NamePropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}