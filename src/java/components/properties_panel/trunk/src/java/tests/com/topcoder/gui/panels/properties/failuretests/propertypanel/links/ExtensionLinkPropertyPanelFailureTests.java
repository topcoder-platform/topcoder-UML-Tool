/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel.links;

import com.topcoder.gui.panels.properties.propertypanel.links.ExtensionLinkPropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for ExtensionLinkPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class ExtensionLinkPropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor ExtensionLinkPropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new ExtensionLinkPropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}