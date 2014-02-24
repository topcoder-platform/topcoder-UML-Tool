/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.accuracytests;

import java.beans.PropertyChangeEvent;

import com.topcoder.gui.sidemenu.AbstractSideMenuPanel;
import com.topcoder.gui.sidemenu.SideMenuModel;

/**
 * This mock class is used to test AbstractSideMenuPanel.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MyAbstractSideMenuPanel extends AbstractSideMenuPanel {
    /**
     * This is a flag used to represent if sideMenuModelPropertyChange(PropertyChangeEvent) is
     * called.
     */
    private boolean isSideMenuModelPropertyChangeCalled = false;

    /**
     * Simply call super(sideMenuModel).
     *
     * @throws IllegalArgumentException
     *             if sideMenuModel is null
     * @param sideMenuModel
     *            A non-null side menu model to use
     */
    public MyAbstractSideMenuPanel(SideMenuModel sideMenuModel) {
        super(sideMenuModel);
    }

    /**
     * Simply call super.sideMenuModelPropertyChange(event).
     *
     * @param event
     *            A non-null property change event
     */
    @Override
    public void sideMenuModelPropertyChange(PropertyChangeEvent event) {
        super.sideMenuModelPropertyChange(event);
        isSideMenuModelPropertyChangeCalled = true;
    }

    /**
     * Simply return isSideMenuModelPropertyChangeCalled field.
     *
     * @return isSideMenuModelPropertyChangeCalled field.
     */
    public boolean isSideMenuModelPropertyChangeCalled() {
        return isSideMenuModelPropertyChangeCalled;
    }

    /**
     * Simply set isSideMenuModelPropertyChangeCalled field.
     *
     * @param isSideMenuModelPropertyChangeCalled
     *            represent if sideMenuModelPropertyChange(PropertyChangeEvent) is called.
     */
    public void setSideMenuModelPropertyChangeCalled(boolean isSideMenuModelPropertyChangeCalled) {
        this.isSideMenuModelPropertyChangeCalled = isSideMenuModelPropertyChangeCalled;
    }

}
