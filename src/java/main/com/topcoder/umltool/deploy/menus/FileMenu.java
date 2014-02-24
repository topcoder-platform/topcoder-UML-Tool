/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.menus;

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.ActionListenerManager;
import com.topcoder.umltool.deploy.actions.OpenProjectFileAction;

/**
 * <p>
 * File menu in main menu.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class FileMenu extends JMenu {

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String NEW_PROJECT_MENU_ACTION = "File/New";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String OPEN_PROJECT_MENU_ACTION = "File/Open";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String SAVE_PROJECT_MENU_ACTION = "File/Save";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String SAVE_AS_PROJECT_MENU_ACTION = "File/Save As...";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String EXPORT_CURRENT_DIAGRAM_MENU_ACTION = "File/Export graphics/Export current diagram";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String EXPORT_ALL_DIAGRAMS_MENU_ACTION = "File/Export graphics/Export all diagrams";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String PRINT_CURRENT_DIAGRAM_MENU_ACTION = "File/Print graphics/Print current diagram";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String PRINT_ALL_DIAGRAMS_MENU_ACTION = "File/Print graphics/Print all diagrams";

    public static final String IMPORT_FROM_JAR_MENU_ACTION = "File/Import...";

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    public static final String EXIT_MENU_ACTION = "File/Exit";

    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -2424565265746754016L;

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    private static final int DYNAMIC_MENU_ITEMS_LOCATION = 8;

    /**
     * <p>
     * Name string of sub menu item.
     * <p>
     */
    private static final int DYNAMIC_MENU_ITEMS_MAX_SIZE = 5;

    /**
     * <p>
     * Dynamic menu item list.
     * <p>
     */
    private final List<String> dynamicMenuItems = new ArrayList<String>();

    /**
     * <p>
     * Creates an instance of <code>FileMenu</code>.
     * <p>
     *
     * @param mainFrame
     */
    public FileMenu(MainFrame mainFrame) {
        super("File");

        this.setMnemonic(KeyEvent.VK_F);

        JMenuItem menuItem = null;

        menuItem = this.add(ActionListenerManager.getInstance().getAction(NEW_PROJECT_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_N);

        menuItem = this.add(ActionListenerManager.getInstance().getAction(OPEN_PROJECT_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_O);

        if (mainFrame.getRecentProjects() != null) {
            JMenu openRecentMenu = new JMenu(OpenProjectFileAction.ACTION_NAME);
            openRecentMenu.setIcon(EmptyIcon.ICON_16);
            this.add(openRecentMenu);

            // add recent projects
            for (File file : mainFrame.getRecentProjects()) {
                menuItem = openRecentMenu.add(new OpenProjectFileAction(mainFrame));

                String fileName = file.getName();
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    fileName = parentFile.getName() + File.separatorChar + fileName;

                    parentFile = parentFile.getParentFile();
                    if (parentFile != null) {
                        fileName = parentFile.getName() + File.separatorChar + fileName;
                    }
                }

                menuItem.setText(fileName);
                menuItem.getAction().putValue(OpenProjectFileAction.FILE_PROPERTY_KEY, file);
            }
        }

        this.addSeparator();

        menuItem = this.add(ActionListenerManager.getInstance().getAction(SAVE_PROJECT_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_S);

        menuItem = this.add(ActionListenerManager.getInstance().getAction(SAVE_AS_PROJECT_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_A);

        this.addSeparator();

        JMenu exportMenu = new JMenu("Export Graphics");
        exportMenu.setMnemonic(KeyEvent.VK_G);
        exportMenu.setToolTipText("Export Graphics");
        exportMenu.setIcon(EmptyIcon.ICON_16);
        this.add(exportMenu);

        menuItem =
            exportMenu.add(ActionListenerManager.getInstance().getAction(EXPORT_CURRENT_DIAGRAM_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_E);

        menuItem = exportMenu.add(ActionListenerManager.getInstance().getAction(EXPORT_ALL_DIAGRAMS_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_A);

		
        //menuItem = this.add(ActionListenerManager.getInstance().getAction(IMPORT_FROM_JAR_MENU_ACTION));
        //menuItem.setMnemonic(KeyEvent.VK_I);

        JMenu printMenu = new JMenu("Print");
        printMenu.setMnemonic(KeyEvent.VK_P);
        printMenu.setToolTipText("Print");
        printMenu.setIcon(EmptyIcon.ICON_16);
        this.add(printMenu);

        menuItem = printMenu.add(ActionListenerManager.getInstance().getAction(PRINT_CURRENT_DIAGRAM_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_P);

        menuItem = printMenu.add(ActionListenerManager.getInstance().getAction(PRINT_ALL_DIAGRAMS_MENU_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_A);

        // if running on Mac OS X skip the Exit menu item from the File menu to behave as native OS X appliation
        if (!System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {

            this.addSeparator();
            menuItem = this.add(ActionListenerManager.getInstance().getAction(EXIT_MENU_ACTION));
            menuItem.setMnemonic(KeyEvent.VK_X);
        }
    }

    /**
     * <p>
     * Adds a dynamic menu item to the list.
     * </p>
     *
     * @param menuItemText
     *            name string of menu item
     */
    public void addDynamicMenuItem(String menuItemText) {
        if (dynamicMenuItems.contains(menuItemText)) {
            dynamicMenuItems.remove(menuItemText);
        } else if (dynamicMenuItems.size() == DYNAMIC_MENU_ITEMS_MAX_SIZE) {
            dynamicMenuItems.remove(dynamicMenuItems.size() - 1);
        }
        dynamicMenuItems.add(0, menuItemText);
        refreshDynamicMenuItems();
    }

    /**
     * <p>
     * Removes a dynamic menu item to the list.
     * </p>
     *
     * @param menuItemText
     *            name string of menu item
     */
    public void removeDynamicMenuItem(String menuItemText) {
        if (dynamicMenuItems.contains(menuItemText)) {
            dynamicMenuItems.remove(menuItemText);
        }
        refreshDynamicMenuItems();
    }

    /**
     * <p>
     * Updates the dynamic menu item list.
     * </p>
     */
    private void refreshDynamicMenuItems() {
        if (dynamicMenuItems.size() > 0) {
            this.addSeparator();
        }
        for (int i = 0; i < dynamicMenuItems.size(); i++) {
            this.remove(DYNAMIC_MENU_ITEMS_LOCATION);
        }
        for (int i = 0; i < dynamicMenuItems.size(); i++) {
            String finalText = i + 1 + " " + dynamicMenuItems.get(i);
            JMenuItem jMenuItem = new JMenuItem(finalText);
            jMenuItem.addActionListener(ActionListenerManager.getInstance().getAction("File/Dynamic Menu Items"));
            jMenuItem.setToolTipText("Open file " + dynamicMenuItems.get(i));
            this.insert(jMenuItem, DYNAMIC_MENU_ITEMS_LOCATION + i);
        }

    }
}
