/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

import junit.framework.TestCase;

/**
 * This is unit test for PropertyType enum.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PropertyTypeTest extends TestCase {
    /**
     * Tests PropertyType.FREE_TEXT.
     *
     * Verify multipleChoice is correctly set.
     */
    public void testFreeText() {
        assertFalse("MultipleChoice should be false for FREE_TEXT.", PropertyType.FREE_TEXT.isMultipleChoice());
    }

    /**
     * Tests PropertyType.CHECK_BOX.
     *
     * Verify multipleChoice is correctly set.
     */
    public void testCheckBox() {
        assertFalse("MultipleChoice should be false for CHECK_BOX.", PropertyType.CHECK_BOX.isMultipleChoice());
    }

    /**
     * Tests PropertyType.DROP_DOWN.
     *
     * Verify multipleChoice is correctly set.
     */
    public void testDropDown() {
        assertTrue("MultipleChoice should be true for DROP_DOWN.", PropertyType.DROP_DOWN.isMultipleChoice());
    }

    /**
     * Tests PropertyType.RADIO_BUTTONS.
     *
     * Verify multipleChoice is correctly set.
     */
    public void testRadioButtons() {
        assertTrue("MultipleChoice should be true for RADIO_BUTTONS.", PropertyType.RADIO_BUTTONS.isMultipleChoice());
    }
}
