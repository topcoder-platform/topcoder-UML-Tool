/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager.accuracytests;

import junit.framework.TestCase;

import com.topcoder.gui.configurationmanager.PropertyType;

/**
 * <p>
 * This class contains a set of tests for {@link PropertyType} class.
 * </p>
 *
 * @author uhmateush
 * @version 1.0
 */
public class PropertyTypeTests extends TestCase {

    /**
     * <p>
     * Tests {@link PropertyType#FREE_TEXT} instantiation.
     * Field multipleChoice should be set to false.
     * </p>
     */
    public void testFreeText() {
        assertFalse("Field multipleChoice should be false for FREE_TEXT.", PropertyType.FREE_TEXT.isMultipleChoice());
    }

    /**
     * <p>
     * Tests {@link PropertyType#CHECK_BOX} instantiation.
     * Field multipleChoice should be set to false.
     * </p>
     */
    public void testCheckBox() {
        assertFalse("Field multipleChoice should be false for CHECK_BOX.", PropertyType.CHECK_BOX.isMultipleChoice());
    }

    /**
     * <p>
     * Tests {@link PropertyType#DROP_DOWN} instantiation.
     * Field multipleChoice should be set to false.
     * </p>
     */
    public void testDropDown() {
        assertTrue("Field multipleChoice should be true for DROP_DOWN.", PropertyType.DROP_DOWN.isMultipleChoice());
    }

    /**
     * <p>
     * Tests {@link PropertyType#RADIO_BUTTONS} instantiation.
     * Field multipleChoice should be set to false.
     * </p>
     */
    public void testRadioButtons() {
        assertTrue("Field multipleChoice should be true for RADIO_BUTTONS.",
            PropertyType.RADIO_BUTTONS.isMultipleChoice());
    }
}