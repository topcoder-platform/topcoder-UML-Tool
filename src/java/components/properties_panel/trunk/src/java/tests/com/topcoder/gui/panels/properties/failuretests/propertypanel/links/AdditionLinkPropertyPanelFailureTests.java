/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel.links;

import com.topcoder.gui.panels.properties.propertypanel.links.AdditionLinkPropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for AdditionLinkPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class AdditionLinkPropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor AdditionLinkPropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new AdditionLinkPropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}