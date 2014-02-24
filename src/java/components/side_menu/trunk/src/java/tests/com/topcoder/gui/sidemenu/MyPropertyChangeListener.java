/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * <p>
 * This is a mock class of {@link PropertyChangeListener} used in tests.
 * </p>
 * <p>
 * This class will offer a mechanism to save/get the {@link PropertyChangeEvent} object.
 * </p>
 *
 * @author KingStone
 * @version 1.0
 */
public class MyPropertyChangeListener implements PropertyChangeListener {
    /**
     * This field save the {@link PropertyChangeEvent} object received by
     * propertyChange(PropertyChangeEvent).
     */
    private PropertyChangeEvent evt = null;

    /**
     * This method simply save received {@link PropertyChangeEvent} object.
     *
     * @param evt
     *            PropertyChangeEvent fired into this method
     */
    public void propertyChange(PropertyChangeEvent evt) {
        this.evt = evt;

    }

    /**
     * Simply return {@link PropertyChangeEvent} object saved.
     *
     * @return {@link PropertyChangeEvent} object saved.
     */
    public PropertyChangeEvent getEvent() {
        return this.evt;
    }

}
