/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.configurationmanager;

/**
 * Represent the type of a property definition. Each type is tied to a specific
 * JComponent. It is used to define the related JComponents in the editor panel.
 * Ignore the type of the fields: this is a Java 5 enum, I only shot it for the
 * TC Tool.
 *
 * Thread safety: it's an enum it's thread safe.
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public enum PropertyType {
    /**
     * Represents the FREE_TEXT type. It is tied to the JTextField JComponent.
     */
    FREE_TEXT(false),

    /**
     * Represents the RADIO_BUTTONS type. It is tied to the JPanel JComponent,
     * which contains JRadioButtons and the ButtonGroup
     */
    RADIO_BUTTONS(true),

    /**
     * Represents the DROP_DOWN type. It is tied to the JComboBox.
     */
    DROP_DOWN(true),

    /**
     * Represents the CHECK_BOX type. It is tied to the jCheckBox.
     */
    CHECK_BOX(false);

    /**
     * Indicate if the enum is a multiple choice. Defined in the constructor and
     * doesn't change. All values are possible. the initial value is defined in
     * the constructor of enum.
     */
    private final boolean multipleChoice;

    /**
     * Construct the instance from the boolean flag. Set the flag,
     *
     * @param multipleChoices
     *            the multiple choices flag
     */
    private PropertyType(boolean multipleChoices) {
        this.multipleChoice = multipleChoices;
    }

    /**
     * Return multiple choices.
     *
     * @return multiple choices
     */
    public boolean isMultipleChoice() {
        return multipleChoice;
    }
}
