/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sidemenu.accuracytests;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.JComponent;

import com.topcoder.gui.sidemenu.SideMenuPanel;

/**
 * This mock class is used to test SideMenuPanel.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MySideMenuPanel extends SideMenuPanel {
    /**
     * <p>
     * Constructs the side menu panel from the given title, content and icons.
     * </p>
     *
     * @throws IllegalArgumentException
     *             if title is null or an empty (trim'd) string
     * @throws IllegalArgumentException
     *             if the content is null
     * @param pinIcon
     *            A possibly null pin icon
     * @param collapseIcon
     *            A possibly null collapse icon
     * @param title
     *            A non-null, non-empty (trim'd) string representing the title
     * @param content
     *            A non-null content component
     * @param expandIcon
     *            A possibly null expanded icon
     */
    public MySideMenuPanel(String title, JComponent content, Icon expandIcon, Icon collapseIcon,
            Icon pinIcon) {
        super(title, content, expandIcon, collapseIcon, pinIcon);
    }

    /**
     * <p>
     * Processes property change events (in this case, we look for title).
     * </p>
     *
     * @throws IllegalArgumentException
     *             if the event is null, or value type is invalid.
     * @param event
     *            A non-null event to use
     */
    @Override
    public void sideMenuModelPropertyChange(PropertyChangeEvent event) {
        super.sideMenuModelPropertyChange(event);
    }

}
