/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.failuretests.propertypanel;

import com.topcoder.gui.panels.properties.propertypanel.ModifiersPropertyPanel;

import junit.framework.TestCase;

/**
 * Failure tests for ModifiersPropertyPanel class.
 *
 * @author Yeung
 * @version 1.0
 */
public class ModifiersPropertyPanelFailureTests extends TestCase {
    /**
     * Tests the constructor ModifiersPropertyPanel(PropertiesPanel) with null propertiesPanel, expected
     * IllegalArgumentException.
     *
     * @throws Exception
     *             if any error occurred when set up
     */
    public void testCtor_NullPropertiesPanel() throws Exception {
        try {
            new ModifiersPropertyPanel(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {
            // expect
        }
    }
}