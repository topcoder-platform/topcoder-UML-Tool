/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel.links;

import com.topcoder.gui.panels.properties.propertypanel.links.SupplierLinkPropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for SupplierLinkPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class SupplierLinkPropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor SupplierLinkPropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new SupplierLinkPropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}