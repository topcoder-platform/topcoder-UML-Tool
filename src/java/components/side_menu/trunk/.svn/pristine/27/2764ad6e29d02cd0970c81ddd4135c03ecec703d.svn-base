/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * <p>
 * Helper class for this component.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so thread safe.
 * </p>
 *
 * @author KingStone
 * @version 1.0
 */
final class Helper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private Helper() {
    }

    /**
     * <p>
     * Checks whether the given Object is null.
     * </p>
     *
     * @param arg
     *            the argument to check
     * @param name
     *            the name of the argument to check
     * @throws IllegalArgumentException
     *             if the given object is null
     */
    static final void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the given String is null or empty.
     * </p>
     * <p>
     * Here empty means the length of the given string is zero after trimmed.
     * </p>
     *
     * @param arg
     *            the String to check
     * @param name
     *            the name of the String argument to check
     *
     * @throws IllegalArgumentException
     *             if the given string is null or empty
     */
    static final void checkString(String arg, String name) {
        checkNull(arg, name);

        if (arg.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
    }

    /**
     * <p>
     * Checks whether the given Object is 0 or < -1.
     * </p>
     *
     * @param absoluteWidth
     *            the absoluteWidth to check
     * @throws IllegalArgumentException
     *             if the given absoluteWidth is 0 or < -1.
     */
    static final void checkAbsoluteWidth(int absoluteWidth) {
        if (absoluteWidth == 0 || absoluteWidth < -1) {
            throw new IllegalArgumentException("'absoluteWidth' should not be 0 or < -1.");
        }
    }

    /**
     * <p>
     * Checks whether the given Object is null, or the new component contains different
     * sideMenuModel.
     * </p>
     * 
     * @param component
     *            the component to check
     * @param sideMenuModel
     *            the sideMenuModel of original component
     * @param name
     *            the name of component
     * @throws IllegalArgumentException
     *             if the given component is null, or if the new component contains different
     *             sideMenuModel.
     */
    static final void checkComponent(JComponent component, SideMenuModel sideMenuModel, String name) {
        checkNull(component, name);
        if (component instanceof AbstractSideMenuPanel) {
            if (((AbstractSideMenuPanel) component).getSideMenuModel() != sideMenuModel) {
                throw new IllegalArgumentException("The new " + name
                        + " should contains the same sideMenuModel" + " as the old one.");
            }
        }
    }

    /**
     * <p>
     * Check if the sideMenuModel is not null.
     * </p>
     * 
     * @param sideMenuModel
     *            the sideMenuModel of panel
     * @throws IllegalStateException
     *             if sideMenuModel is null
     */
    static final void checkState(SideMenuModel sideMenuModel) {
        if (sideMenuModel == null) {
            throw new IllegalStateException("'sideMenuModel' is removed.");
        }
    }

    /**
     * <p>
     * Set Button using given arguments.
     * </p>
     *
     * @param button
     *            the button to set
     * @param icon
     *            the icon to be set to button
     * @param buttonListener
     *            the ActionListener to be set to button
     */
    static final void setButton(AbstractButton button, Icon icon, ActionListener buttonListener) {
        // set icon or set invisible
        button.setIcon(icon);
        button.addActionListener(buttonListener);
        // set the content to not filled
        button.setContentAreaFilled(false);
    }
}
