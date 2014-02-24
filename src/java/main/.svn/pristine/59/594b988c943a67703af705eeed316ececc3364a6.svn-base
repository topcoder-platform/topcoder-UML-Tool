/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.menus;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.topcoder.umltool.deploy.actions.ActionListenerManager;

/**
 * <p>
 * File menu in main menu.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ViewMenu extends JMenu {

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String ZOOM_IN_ACTION = "View/Zoom In";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String ZOOM_OUT_ACTION = "View/Zoom Out";

    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -70609626156707529L;

    /**
     * <p>
     * Creates an instance of <code>ViewMenu</code>.
     * <p>
     */
    public ViewMenu() {
        super("View");
        this.setMnemonic(KeyEvent.VK_V);

        JMenuItem menuItem = null;

        menuItem = this.add(ActionListenerManager.getInstance().getAction(ZOOM_IN_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_I);
        menuItem.setToolTipText("Zoom In Current Diagram View");

        menuItem = this.add(ActionListenerManager.getInstance().getAction(ZOOM_OUT_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_O);
        menuItem.setToolTipText("Zoom Out Current Diagram View");
    }
}
