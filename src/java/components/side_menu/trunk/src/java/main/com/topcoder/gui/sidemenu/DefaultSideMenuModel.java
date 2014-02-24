/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.topcoder.event.manager.EventManager;
import com.topcoder.event.manager.EventManagerUtils;

/**
 * <p>
 * This class provides a default implementation of the SideMenuModel interface.
 * </p>
 * <p>
 * This model will use the event manager component to manage the property change listeners, will
 * provide the storage and management of the business variables that will be utilized by the
 * SideMenuPanel (including notification of listeners whenever a variable changes).
 * </p>
 * <p>
 *
 * This class can be used by the application to provide the model implementation used by the
 * SideMenuPanel.
 * </p>
 * <p>
 * This class can be used by the application to change the business (non-gui) variables used by the
 * application.
 *
 * </p>
 * <p>
 * This class is NOT thread safe since it has mutable state and provides no locking. The state
 * should only be modified on the awt event thread.
 * </p>
 *
 * @author Pops, KingStone
 * @version 1.0
 */
public class DefaultSideMenuModel implements SideMenuModel {
    /**
     * <p>
     * This variable represents the change listeners that have been added to this model.
     * </p>
     * <p>
     * The generic event manager is utilized to create, manager and fire events to the listeners.
     * </p>
     * <p>
     * This variable is created by calling
     * EventManagerUtils.getEventManager(PropertyChangeListener.class), is immutable (the reference
     * only) and will never be null.
     * </p>
     * <p>
     * This variable can be cast to EventManager to manage the listeners contained within it.
     * </p>
     * <p>
     * Please see generic event manager documentation for additional details.
     * </p>
     * <p>
     * This variable is used in the various 'setter' methods to notify listeners.
     * </p>
     */
    private final PropertyChangeListener listeners;

    /**
     * <p>
     * This variable represents whether the SideMenu panel is expanded (true) or not (false).
     * </p>
     * <p>
     * This variable is set in the constructor and is mutable.
     * </p>
     * <p>
     * This variable is only referenced in the associated getter and setter.
     * </p>
     */
    private boolean expanded;

    /**
     * <p>
     * A non-null, non-empty (trim'd) variable representing the title.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable and will never be null or empty(trim'd).
     * </p>
     * <p>
     * This variable is only referenced in the associated getter and setter.
     * </p>
     */
    private String title;

    /**
     * <p>
     * This variable represents whether the expanded SideMenu panel is floating (true) over panels
     * or not (false).
     * </p>
     * <p>
     * This variable is set in the constructor and is mutable.
     * </p>
     * <p>
     * This variable is only referenced in the associated getter and setter.
     * </p>
     */
    private boolean floating;

    /**
     * <p>
     * This variable represents the *requested* absolute width of the expanded panel.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutable and will never be 0 nor a negative value
     * (except for -1). -1 indicates no absolute width has been specified (letting the expanded
     * panel be set to it's preferred size).
     * </p>
     * <p>
     * The developer should not that best efforts are made to enforce this width - but, depending on
     * the layout manager used, may be ignored.
     * </p>
     * <p>
     * This variable is only referenced in the associated getter and setter.
     * </p>
     */
    private int absoluteWidth;

    /**
     * <p>
     * Constructs the model using the title and default values (non-expanded, the specified title,
     * non-floating, and no absolute width).
     * </p>
     *
     * @throws IllegalArgumentException
     *             if title is null or an empty (trim'd) string
     * @param title
     *            A non null, non empty [trim'd] string specifying the title(The title will be
     *            trim'd before set to class field)
     */
    public DefaultSideMenuModel(String title) {
        this(title, false, false, -1);
    }

    /**
     * <p>
     * Constructs the model using the specified variables.
     * </p>
     *
     * Simply copies the arguments to the like named variable
     *
     * @throws IllegalArgumentException
     *             if absoluteWidth is 0 or < -1
     * @throws IllegalArgumentException
     *             if title is null or an empty (trim'd) string
     * @param floating
     *            True if the expanded panel should be floating,false otherwise
     * @param title
     *            A non null, non empty [trim'd] string specifying the title(The title will be
     *            trim'd before set to class field)
     * @param expanded
     *            True if the panel starts expanded, false otherwise
     * @param absoluteWidth
     *            A > 0 value for the absolute width or -1 for no width specified
     */
    public DefaultSideMenuModel(String title, boolean expanded, boolean floating, int absoluteWidth) {
        Helper.checkAbsoluteWidth(absoluteWidth);
        Helper.checkString(title, "title");
        this.title = title.trim();
        this.expanded = expanded;
        this.floating = floating;
        this.absoluteWidth = absoluteWidth;
        this.listeners = (PropertyChangeListener) EventManagerUtils
                .getEventManager(PropertyChangeListener.class);
    }

    /**
     * <p>
     * Adds the specified listener.
     * </p>
     * This method simply casts listeners to EventManager then adds the listener.
     *
     * @throws IllegalArgumentException
     *             if listener is null
     * @param listener
     *            A non-null listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        Helper.checkNull(listener, "listener");
        ((EventManager) listeners).addListener(listener);
    }

    /**
     * <p>
     * Removes the specified listener if it has been added (does nothing if the listener is not
     * found).
     * </p>
     *
     * @throws IllegalArgumentException
     *             if listener is null
     * @param listener
     *            A non-null listener to remove
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        Helper.checkNull(listener, "listener");
        ((EventManager) listeners).removeListener(listener);
    }

    /**
     * <p>
     * Returns true if the side menu is expanded.
     * </p>
     *
     * @return True if the panel is expanded, false otherwise
     */
    public boolean isExpanded() {
        return expanded;
    }

    /**
     * <p>
     * Sets the side menu expanded (true) or not (false).
     * </p>
     *
     * @param expanded
     *            true if the side menu should be expanded (false otherwise)
     */
    public void setExpanded(boolean expanded) {
        PropertyChangeEvent event = new PropertyChangeEvent(this, EXPANDED, this.expanded, expanded);
        this.expanded = expanded;
        listeners.propertyChange(event);
    }

    /**
     * <p>
     * Returns the title for the side menu.
     * </p>
     *
     * @return A non-null, non-empty (trim'd) variable representing the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>
     * Sets the title of the side menu.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if title is null or an empty (trim'd) string
     * @param title
     *            A non-null, non-empty (trim'd) variable representing the title(The title will be
     *            trim'd before set to class field)
     */
    public void setTitle(String title) {
        Helper.checkString(title, "title");
        PropertyChangeEvent event = new PropertyChangeEvent(this, TITLE, this.title, title.trim());
        this.title = title.trim();
        listeners.propertyChange(event);
    }

    /**
     * <p>
     * Returns true if the side menu expansion panel should be floating.
     * </p>
     *
     * @return True if the expanded panel should be floating,false otherwise
     */
    public boolean isFloating() {
        return floating;
    }

    /**
     * <p>
     * Sets the side menu expanded panel is floating(true) or not (false).
     * <p>
     *
     * @param floating
     *            True if the expanded panel should be floating, false otherwise
     */
    public void setFloating(boolean floating) {
        PropertyChangeEvent event = new PropertyChangeEvent(this, FLOATING, this.floating, floating);
        this.floating = floating;
        listeners.propertyChange(event);
    }

    /**
     * <p>
     * Returns the requested absolute width for the expanded panel.
     * </p>
     *
     * @return A > 0 value for the absolute width or -1 for no width specified
     */
    public int getAbsoluteWidth() {
        return absoluteWidth;
    }

    /**
     * <p>
     * Sets the title of the side menu.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if absolute value is 0 or < -1
     * @param absoluteWidth
     *            A > 0 value for the absolute width or -1 for no width specified
     */
    public void setAbsoluteWidth(int absoluteWidth) {
        Helper.checkAbsoluteWidth(absoluteWidth);
        PropertyChangeEvent event = new PropertyChangeEvent(this, ABSOLUTE_WIDTH,
                this.absoluteWidth, absoluteWidth);
        this.absoluteWidth = absoluteWidth;
        listeners.propertyChange(event);
    }

}
