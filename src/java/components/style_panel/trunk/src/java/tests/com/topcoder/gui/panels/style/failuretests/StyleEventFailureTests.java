/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.failuretests;

import com.topcoder.gui.panels.style.StyleEvent;
import com.topcoder.gui.panels.style.StyleObject;
import com.topcoder.gui.panels.style.StylePanel;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>{@link StyleEvent}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class StyleEventFailureTests extends TestCase {

    /**
     * <p>
     * Mock implementation of the <code>{@link StyleObject}</code> interface.
     * </p>
     */
    private class MockStyleObject implements StyleObject {
        /**
         * <p>
         * Returns height of the style object.
         * </p>
         * @return height of the style object
         */
        public double getHeight() {
            return 0.0;
        }

        /**
         * <p>
         * Returns width of the style object.
         * </p>
         * @return width of the style object
         */
        public double getWidth() {
            return 0.0;
        }

        /**
         * <p>
         * Returns x coordinate of the style object.
         * </p>
         * @return x coordinate of the style object
         */
        public double getX() {
            return 0.0;
        }

        /**
         * <p>
         * Returns y coordinate of the style object.
         * </p>
         * @return y coordinate of the style object
         */
        public double getY() {
            return 0.0;
        }

        /**
         * <p>
         * Returns font name of the style object.
         * </p>
         * @return font name of the style object
         */
        public String getFontName() {
            return null;
        }

        /**
         * <p>
         * Returns font size of the style object.
         * </p>
         * @return font size of the style object
         */
        public int getFontSize() {
            return 0;
        }

        /**
         * <p>
         * Returns fill color of the style object.
         * </p>
         * @return fill color of the style object
         */
        public String getFillColor() {
            return null;
        }

        /**
         * <p>
         * Returns outline color of the style object.
         * </p>
         * @return outline color of the style object
         */
        public String getOutlineColor() {
            return null;
        }

        /**
         * <p>
         * Returns text color of the style object.
         * </p>
         * @return text color of the style object
         */
        public String getTextColor() {
            return null;
        }

        /**
         * <p>
         * Sets the style panel.
         * </p>
         * @param stylePanel
         *            stylePanel where this object attached, can be null
         */
        public void setStylePanel(StylePanel stylePanel) {
        }

        /**
         * <p>
         * Gets the style panel.
         * </p>
         * @return stylePanel where this object is attached, null if this object is not attached
         */
        public StylePanel getStylePanel() {
            return null;
        }
    }

    /**
     * <p>
     * Represents the StyleObject instance used in tests.
     * </p>
     */
    private final StyleObject styleObject = new MockStyleObject();

    /**
     * <p>
     * Represents the changed property used in tests.
     * </p>
     */
    private final String changedKey = "Key";

    /**
     * <p>
     * Represents the old value of the style used in tests.
     * </p>
     */
    private final String oldValue = "Old";

    /**
     * <p>
     * Represents the new value of the style used in tests.
     * </p>
     */
    private final String newValue = "New";

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventNullStyleObject() {
        try {
            new StyleEvent(null, changedKey, oldValue, newValue);
            fail("If the style object is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventNullChangedKey() {
        try {
            new StyleEvent(styleObject, null, oldValue, newValue);
            fail("If the changed property is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventEmptyChangedKey() {
        try {
            new StyleEvent(styleObject, "", oldValue, newValue);
            fail("If the changed property is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventTrimmedEmptyChangedKey() {
        try {
            new StyleEvent(styleObject, "  ", oldValue, newValue);
            fail("If the changed property is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventNullOldValue() {
        try {
            new StyleEvent(styleObject, changedKey, null, newValue);
            fail("If the old value of the style is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventEmptyOldValue() {
        try {
            new StyleEvent(styleObject, changedKey, "", newValue);
            fail("If the old value of the style is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventTrimmedEmptyOldValue() {
        try {
            new StyleEvent(styleObject, changedKey, "  ", newValue);
            fail("If the old value of the style is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventNullNewValue() {
        try {
            new StyleEvent(styleObject, changedKey, null, newValue);
            fail("If the new value of the style is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventEmptyNewValue() {
        try {
            new StyleEvent(styleObject, changedKey, "", newValue);
            fail("If the new value of the style is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Failure test for <code>{@link StyleEvent#StyleEvent(StyleObject, String, String, String)}</code> constructor.
     * </p>
     */
    public void testStyleEventTrimmedEmptyNewValue() {
        try {
            new StyleEvent(styleObject, changedKey, "  ", newValue);
            fail("If the new value of the style is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
