/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.lang.reflect.Field;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import junit.framework.TestCase;

/**
 * <p>
 * Defines helper methods used in tests.
 * </p>
 *
 * @author KingStone
 * @version 1.0
 */
final class TestHelper {
    /**
     * <p> The folder of icon used in tests. </p>
     */
    static final String ICON_FOLDER = "test_files" + File.separator + "icon";

    /**
     * <p> The title used in tests. </p>
     */
    static final String TITLE = "Side Menu";

    /**
     * <p> The expandIcon used in tests. </p>
     */
    static final Icon EXPAND_ICON = new ImageIcon(ICON_FOLDER + File.separator + "expandIcon.jpg");

    /**
     * <p> The collapseIcon used in tests. </p>
     */
    static final Icon COLLAPSE_ICON = new ImageIcon(ICON_FOLDER + File.separator
            + "collapseIcon.jpg");

    /**
     * <p> The pinIcon used in tests. </p>
     */
    static final Icon PIN_ICON = new ImageIcon(ICON_FOLDER + File.separator + "pinIcon.jpg");

    /**
     * <p> The content panel used in tests. </p>
     */
    static final JComponent CONTENT = new JPanel();

    /**
     * <p>
     * The private constructor prevents the creation of a new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Gets the value of a private field in the given class. The field has the given name. The value
     * is retrieved from the given instance.
     * </p>
     *
     * @param type
     *            the class which the private field belongs to.
     * @param instance
     *            the instance which the private field belongs to.
     * @param name
     *            the name of the private field to be retrieved.
     *
     * @return the value of the private field or <code>null</code> if any error occurs.
     */
    static final Object getPrivateField(Class<?> type, Object instance, String name) {
        Field field = null;
        Object obj = null;

        try {
            // Get the reflection of the field and get the value
            field = type.getDeclaredField(name);
            field.setAccessible(true);
            obj = field.get(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();

            // ignore
        } catch (NoSuchFieldException e) {
            e.printStackTrace();

            // ignore
        } finally {
            if (field != null) {
                // Reset the accessibility
                field.setAccessible(false);
            }
        }

        return obj;
    }

    /**
     * Check if the event is fired correctly.
     * @param event the event to check
     * @param propertyName expected property name
     * @param oldValue expected old value
     * @param newValue expected new value
     */
    static final void assertEvent(PropertyChangeEvent event, String propertyName, Object oldValue,
            Object newValue) {
        TestCase.assertEquals("propertyName", propertyName, event.getPropertyName());
        TestCase.assertEquals("oldValue", oldValue, event.getOldValue());
        TestCase.assertEquals("newValue", newValue, event.getNewValue());
    }
}
