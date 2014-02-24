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
 * Create diagram menu in main menu.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CreateDiagramMenu extends JMenu {
    /**
     * <p>
     * Name string of the menu.
     * <p>
     */
    public static final String CREATE_CLASS_DIAGRAM_ACTION = "Create Diagram/Class Diagram";

    /**
     * <p>
     * Name string of the menu.
     * <p>
     */
    public static final String CREATE_USE_CASE_DIAGRAM_ACTION = "Create Diagram/Use Case Diagram";

    /**
     * <p>
     * Name string of the menu.
     * <p>
     */
    public static final String CREATE_SEQUENCE_DIAGRAM_ACTION = "Create Diagram/Sequence Diagram";

    /**
     * <p>
     * Name string of the menu.
     * <p>
     */
    public static final String CREATE_ACTIVITY_DIAGRAM_ACTION = "Create Diagram/Activity Diagram";

    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = 929175468978450436L;

    /**
     * <p>
     * Creates an instance of <code>CreateDiagramMenu</code>.
     * <p>
     */
    public CreateDiagramMenu() {
        super("Create Diagram");
        this.setMnemonic(KeyEvent.VK_C);

        JMenuItem menuItem = null;

        menuItem = this.add(ActionListenerManager.getInstance().getAction(CREATE_CLASS_DIAGRAM_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_C);

        menuItem = this.add(ActionListenerManager.getInstance().getAction(CREATE_USE_CASE_DIAGRAM_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_U);

        menuItem = this.add(ActionListenerManager.getInstance().getAction(CREATE_SEQUENCE_DIAGRAM_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_S);

        menuItem = this.add(ActionListenerManager.getInstance().getAction(CREATE_ACTIVITY_DIAGRAM_ACTION));
        menuItem.setMnemonic(KeyEvent.VK_A);
    }
}
