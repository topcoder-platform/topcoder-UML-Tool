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
 * Help menu in main menu.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class HelpMenu extends JMenu {

    /**
     * <p>
     * Name string of the menu.
     * <p>
     */
    public static final String ABOUT_MENU_ACTION = "Help/About";

    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = 929175468978450436L;

    /**
     * <p>
     * Creates an instance of <code>HelpMenu</code>.
     * <p>
     */
    public HelpMenu() {
        super("Help");
        this.setMnemonic(KeyEvent.VK_H);

        JMenuItem menuItem = null;

        menuItem = this.add(ActionListenerManager.getInstance().getAction(ABOUT_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_A);
    }
}
