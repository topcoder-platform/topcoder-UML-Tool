/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel.links;

import com.topcoder.gui.panels.properties.propertypanel.links.ClientLinkPropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for ClientLinkPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class ClientLinkPropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor ClientLinkPropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new ClientLinkPropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}