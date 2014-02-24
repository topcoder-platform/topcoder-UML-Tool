/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style;

/**
 * <p>
 * This class is the event that will be generated when a style change happen.
 * </p>
 *
 * <p>
 * In this component, this will be happen when some changes in the widgets of
 * StylePanel detected. StyleEvent will hold information about the event.
 * </p>
 *
 * <p>
 * The instance of this class' scope is limited to the event handling process.
 * After that, it will usually be diminished, except if there is some use cases
 * which need to save the instance for a longer time.
 * </p>
 *
 * <p>
 * Thread Safety: This class is immutable and so is thread safe.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public class StyleEvent {
    /**
     * <p>
     * The style object corresponds to the style that is changed.
     * </p>
     *
     * <p>
     * Set in the constructor and is immutable. Can not be null.
     * </p>
     *
     * <p>
     * This variable can be accessed by getStyleObject() method.
     * </p>
     */
    private final StyleObject styleObject;

    /**
     * <p>
     * The property key that is changed.
     * </p>
     *
     * <p>
     * Set in the constructor and is immutable. Can not be null or empty string.
     * </p>
     *
     * <p>
     * This variable can be accessed by getChangedKey() method.
     * </p>
     */
    private final String changedKey;

    /**
     * <p>
     * The old value of the style.
     * </p>
     *
     * <p>
     * Set in the constructor and is immutable. Can not be null or empty string.
     * </p>
     *
     * <p>
     * This variable can be accessed by getOldValue() method.
     * </p>
     */
    private final String oldValue;

    /**
     * <p>
     * The new value of the style.
     * </p>
     *
     * <p>
     * Set in the constructor and is immutable. Can not be null or empty string.
     * </p>
     *
     * <p>
     * This variable can be accessed by getNewValue() method.
     * </p>
     */
    private final String newValue;

    /**
     * <p>
     * Constructor of the event.
     * </p>
     *
     * @param styleObject style object
     * @param changedKey the property key
     * @param oldValue old style value
     * @param newValue new style value
     *
     * @throws IllegalArgumentException if any argument is null or string argument is empty(trimmed)
     */
    public StyleEvent(StyleObject styleObject, String changedKey, String oldValue, String newValue) {
        Util.checkNull(styleObject, "styleObject");
        Util.checkString(changedKey, "changedKey");
        Util.checkString(oldValue, "oldValue");
        Util.checkString(newValue, "newValue");

        this.styleObject = styleObject;
        this.changedKey = changedKey;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * <p>
     * Returns styleObject that is changed.
     * </p>
     *
     * @return styleObject that is changed
     */
    public StyleObject getStyleObject() {
        return this.styleObject;
    }

    /**
     * <p>
     * Returns the property key that is changed.
     * </p>
     *
     * @return the property key that is changed
     */
    public String getChangedKey() {
        return this.changedKey;
    }

    /**
     * <p>
     * Returns the old value of the style.
     * </p>
     *
     * @return he old value of the style
     */
    public String getOldValue() {
        return this.oldValue;
    }

    /**
     * <p>
     * Returns the new value of the style.
     * </p>
     *
     * @return the new value of the style
     */
    public String getNewValue() {
        return this.newValue;
    }
}
