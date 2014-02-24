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
 * Generate menu in main menu.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class GenerateMenu extends JMenu {
    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = 929175468978450436L;

    /**
     * <p>
     * Name string of the menu.
     * <p>
     */
    public static final String GENERATE_CODE_MENU_ACTION = "Generate/Generate Code";

    /**
     * <p>
     * Creates an instance of <code>GenerateMenu</code>.
     * <p>
     */
    public GenerateMenu() {
        super("Generate");
        this.setMnemonic(KeyEvent.VK_G);

        JMenuItem menuItem = null;

        menuItem = this.add(ActionListenerManager.getInstance().getAction(GENERATE_CODE_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_G);
    }
}
