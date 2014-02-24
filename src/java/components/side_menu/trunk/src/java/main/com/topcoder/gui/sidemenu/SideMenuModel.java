/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.beans.PropertyChangeListener;

/**
 * <p>
 * This interface defines the contract for the side menu model.
 * </p>
 * <p>
 * The side menu model will be used by the SideMenuPanel to manage the business variables for the
 * component.
 * </p>
 * <p>
 * The menu model will be responsible for listener management, storage of the variables,
 * retrieval/setting of the variables and notification to listeners of changes to the variables.
 * </p>
 * <p>
 * The developer should note that this interface contains constants that represent the property
 * names that will be passed in the property change event.
 * </p>
 * <p>
 * This interface will be created by the SideMenuPanel or the application and set into the
 * SideMenuPanel (or any of it's subpanels that wish to work with the model).
 * </p>
 * <p>
 * Any changes to this model will be propagated to all listeners (and likely the SideMenuPanel
 * itself).
 * </p>
 * <p>
 * Implementations of this interface does not need to be thread safe since this is a Swing GUI
 * component.
 * </p>
 *
 * @author Pops, KingStone
 * @version 1.0
 */
public interface SideMenuModel {
    /**
     * <p>
     * This public constant represents the property name that will be used when the expanded
     * property of the model changes.
     * </p>
     */
    public static final String EXPANDED = "expanded";

    /**
     * <p>
     * This public constant represents the property name that will be used when the title property
     * of the model changes.
     * </p>
     */
    public static final String TITLE = "title";

    /**
     * <p>
     * This public constant represents the property name that will be used when the floating
     * property of the model changes.
     * </p>
     */
    public static final String FLOATING = "floating";

    /**
     * <p>
     * This public constant represents the property name that will be used when the absolute width
     * property of the model changes.
     * </p>
     */
    public static final String ABSOLUTE_WIDTH = "absolute width";

    /**
     * <p>
     * This method signature specifies the addition of a property change listener to the model.
     * </p>
     * <p>
     * The listener added will then be notified of any property changes within the model.
     * </p>
     * <p>
     * If the listener has already been added, nothing happens.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the listener is null
     * @param listener
     *            A non-null listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener);

    /**
     * <p>
     * This method signature specifies the removal of a property change listener to the model.
     * </p>
     * <p>
     * The listener removed will no longer be notified of any property changes within the model.
     * </p>
     * <p>
     * If the listener doesn't exist, nothing happens.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the listener is null
     * @param listener
     *            A non-null listener to remove
     */
    public void removePropertyChangeListener(PropertyChangeListener listener);

    /**
     * <p>
     * This method signature specifies the retrieval of the expanded property.
     * </p>
     * <p>
     * True should be returned if the the panel should be expanded, false otherwise.
     * </p>
     *
     * @return True if the panel is expanded, false otherwise
     */
    public boolean isExpanded();

    /**
     * <p>
     * This method signature specifies the setting of the expanded property.
     * </p>
     * <p>
     * True should be set if the panel should be expanded, false otherwise.
     * </p>
     * <p>
     * Listeners should be notified of the old/new value using the property name of EXPANDED.
     * </p>
     *
     * @param expand
     *            true if the side menu should be expanded (false otherwise)
     */
    public void setExpanded(boolean expand);

    /**
     * <p>
     * This method signature specifies the retrieval of the title property.
     * </p>
     *
     * @return A non-null, non-empty (trim'd) variable representing the title
     */
    public String getTitle();

    /**
     * <p>
     * This method signature specifies the setting of the title property.
     * </p>
     * <p>
     * Listeners should be notified of the old/new value using the property name of TITLE.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if title is null or empty (trim'd) string
     * @param title
     *            A non-null, non-empty (trim'd) variable representing the title.(The title will be
     *            trim'd before set to class field)
     */
    public void setTitle(String title);

    /**
     * <p>
     * This method signature specifies the retrieval of the floating property.
     * </p>
     * <p>
     * True should be returned if the the expanded panel should be floating, false otherwise.
     * </p>
     *
     * @return True if the expanded panel should be floating,false otherwise
     */
    public boolean isFloating();

    /**
     * <p>
     * This method signature specifies the setting of the floating property.
     * </p>
     * <p>
     * True should be set if the expanded panel should be floating, false otherwise.
     * </p>
     * <p>
     * Listeners should be notified of the old/new value using the property name of FLOATING.
     * </p>
     *
     * @param floating
     *            True if the expanded panel should be floating,false otherwise
     */
    public void setFloating(boolean floating);

    /**
     * <p>
     * This method signature specifies the retrieval of the absolute width property.
     * </p>
     *
     * @return A > 0 value for the absolute width or -1 for no width specified
     */
    public int getAbsoluteWidth();

    /**
     * <p>
     * This method signature specifies the setting of the title property.
     * </p>
     * <p>
     * The developer should note that the layout manager of the expanded component is free to
     * completely ignore this setting - so this is a best effort setting.
     * </p>
     * <p>
     * Listeners should be notified of the old/new value using the property name of ABSOLUTE_WIDTH.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if absolute value is 0 or < -1
     * @param width
     *            A > 0 value for the absolute width or -1 for no width specified
     */
    public void setAbsoluteWidth(int width);
}
