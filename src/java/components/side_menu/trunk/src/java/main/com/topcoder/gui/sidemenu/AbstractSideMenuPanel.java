/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

/**
 * <p>
 * This abstract class (that inherits from JPanel) can serve as the base class for all SideMenu
 * related panels. This class will provide common services to all panels. Currently, the common
 * services include storage and management of the related side menu model and an internal property
 * change listener to that model (which will notify a protected method that can be overridden to
 * process side menu model property change events). This class will fire a property change event
 * whenever the side menu model itself changes.
 * </p>
 * <p>
 * This class cannot be created directly and can be used as a base class for side menu panels.
 * </p>
 * <p>
 * <strong>Note:</strong>A listener is put into the <code>sideMenuModel</code> and it's the
 * callers responsibility to call <code>setMenuModel(null)</code> to remove the listener if
 * needed.
 * </p>
 * <p>
 * This class is NOT thread safe since it has mutable state and provides no locking. The state
 * should only be modified on the AWT event thread.
 * </p>
 *
 * @author Pops, KingStone
 * @version 1.0
 */
public abstract class AbstractSideMenuPanel extends JPanel {
    /**
     * <p>
     * This public constant represents the property name that will be used when the side menu model
     * (itself - not it's properties) has been changed.
     * </p>
     */
    public static final String SIDE_MENU_MODEL = "sideMenuModel";

    /**
     * <p>
     * This variable represents the change listener that will be added to the sideMenuModel
     * variable.
     * </p>
     * <p>
     * This variable is immutable and will never be null.
     * </p>
     * <p>
     * This variable is set to an anonymous PropertyChangeListener that will simply call the
     * protected <code>sideMenuModelPropertyChange()</code>.
     * </p>
     * <p>
     * This variable will only be referenced in the setSideMenuModel method.
     * </p>
     */
    private final PropertyChangeListener propertyChangeListener;

    /**
     * <p>
     * This variable represents the side menu model that is accessible to the panel.
     * </p>
     * <p>
     * This variable is set in the constructor, is mutatable and can be null.
     * </p>
     * <p>
     * This variable is referenced in the associated getter and setter methods.
     * </p>
     */
    private SideMenuModel sideMenuModel;

    /**
     * <p>
     * Constructs the abstract class from the specified side menu model.
     * </p>
     * <p>
     * <strong>Note:</strong>A listener is put into the <code>sideMenuModel</code> and it's the
     * callers responsibility to call <code>setMenuModel(null)</code> to remove the listener if
     * needed.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if sideMenuModel is null
     * @param sideMenuModel
     *            A non-null side menu model to use
     */
    protected AbstractSideMenuPanel(SideMenuModel sideMenuModel) {
        Helper.checkNull(sideMenuModel, "sideMenuModel");

        propertyChangeListener = new PropertyChangeListener() {
            /**
             * Simply call sideMenuModelPropertyChange(event) to deal with the event.
             *
             * @param event the event of property change
             */
            public void propertyChange(PropertyChangeEvent event) {
                sideMenuModelPropertyChange(event);
            }
        };
        this.sideMenuModel = sideMenuModel;
        this.sideMenuModel.addPropertyChangeListener(propertyChangeListener);
    }

    /**
     * <p>
     * Returns the side menu model associated with this class.
     * </p>
     *
     * @return A possibly null side menu model
     */
    public SideMenuModel getSideMenuModel() {
        return sideMenuModel;
    }

    /**
     * <p>
     * Sets the side menu model for this class, a {@link PropertyChangeListener} is added into the
     * new sideMenuModel if it is not null.
     * </p>
     * <p>
     * {@link PropertyChangeListener} will be removed from the old sideMenuModel(if old
     * sideMenuModel is not null) in this method, this can be used to prevent memory leak.
     * </p>
     *
     * @param newValue
     *            A side menu model to use(can be null)
     */
    public void setSideMenuModel(SideMenuModel newValue) {
        if (this.sideMenuModel != null) {
            this.sideMenuModel.removePropertyChangeListener(propertyChangeListener);
        }
        SideMenuModel oldSideMenuModel = this.sideMenuModel;
        this.sideMenuModel = newValue;
        if (newValue != null) {
            newValue.addPropertyChangeListener(propertyChangeListener);
        }
        // notify listeners to the panel
        firePropertyChange(SIDE_MENU_MODEL, oldSideMenuModel, newValue);
        // notify subclasses of the change in menu model
        sideMenuModelPropertyChange(new PropertyChangeEvent(this, SIDE_MENU_MODEL,
                oldSideMenuModel, newValue));
    }

    /**
     * <p>
     * This method will be called from the propertyChangeListener (that has been added to the
     * sideMenuModel) whenever a side menu model property changes.
     * </p>
     * <p>
     * This method will do nothing - but can be overridden to perform process by super classes.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the event is null
     * @param event
     *            A non-null property change event
     */
    protected void sideMenuModelPropertyChange(PropertyChangeEvent event) {
    }
}
