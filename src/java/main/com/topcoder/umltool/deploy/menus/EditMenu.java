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
 * Edit menu in main menu.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class EditMenu extends JMenu {

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String CUT_ELEMENT_MENU_ACTION = "Edit/Cut Element";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String CUT_REPRESENTATION_MENU_ACTION = "Edit/Cut Representation";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String COPY_ELEMENT_MENU_ACTION = "Edit/Copy Element";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String COPY_REPRESENTATION_MENU_ACTION = "Edit/Copy Representation";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String PASTE_MENU_ACTION = "Edit/Paste";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String DELETE_ELEMENT_MENU_ACTION = "Edit/Delete Element";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String DELETE_REPRESENTATION_MENU_ACTION = "Edit/Delete Representation";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String UNDO_CHANGES_MENU_ACTION = "Edit/Undo";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String REDO_CHANGES_MENU_ACTION = "Edit/Redo";

    /**
     * <p>
     * Name string of the menu item.
     * <p>
     */
    public static final String SETTINGS_MENU_ACTION = "Edit/Settings";

    public static final String SELECT_ALL_ELEMENTS_MENU_ACTION = "Select All";

    public static final String RENAME_ELEMENT_ACTION = "Rename Element";

    public static final String SHORTCUT_MENU_ACTION = "Shortcut Menu";

    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = 929175468978450436L;

    /**
     * <p>
     * Creates an instance of <code>EditMenu</code>.
     * <p>
     */
    public EditMenu() {
        super("Edit");
        this.setMnemonic(KeyEvent.VK_E);

        JMenuItem menuItem = null;

        menuItem = this.add(ActionListenerManager.getInstance().getAction(CUT_ELEMENT_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_T);

        this.add(ActionListenerManager.getInstance().getAction(CUT_REPRESENTATION_MENU_ACTION));

        menuItem = this.add(ActionListenerManager.getInstance().getAction(COPY_ELEMENT_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_C);

        this.add(ActionListenerManager.getInstance().getAction(COPY_REPRESENTATION_MENU_ACTION));

        menuItem = this.add(ActionListenerManager.getInstance().getAction(PASTE_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_P);

        menuItem = this.add(ActionListenerManager.getInstance().getAction(SELECT_ALL_ELEMENTS_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_A);

        this.add(ActionListenerManager.getInstance().getAction(RENAME_ELEMENT_ACTION));

        this.addSeparator();

        menuItem = this.add(ActionListenerManager.getInstance().getAction(DELETE_ELEMENT_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_D);

        this.add(ActionListenerManager.getInstance().getAction(DELETE_REPRESENTATION_MENU_ACTION));

        this.addSeparator();

        menuItem = this.add(ActionListenerManager.getInstance().getAction(UNDO_CHANGES_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_U);

        menuItem = this.add(ActionListenerManager.getInstance().getAction(REDO_CHANGES_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_R);

        this.addSeparator();

        menuItem = this.add(ActionListenerManager.getInstance().getAction(SETTINGS_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_S);

    }
}
