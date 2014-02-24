/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.menus;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Main menu bar in main frame.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class MainMenuBar extends JMenuBar {
    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = 8304050908221867869L;
    
   /**
     * <p>
     * Creates an instance of <code>MainMenuBar</code>.
     * <p>
     * @param frame 
     */
    public MainMenuBar(MainFrame mainFrame) {
        JMenu menu = null;

        menu = new FileMenu(mainFrame);
        this.add(menu);

        menu = new EditMenu();
        this.add(menu);

        menu = new CreateDiagramMenu();
        this.add(menu);

        menu = new ViewMenu();
        this.add(menu);

        menu = new GenerateMenu();
        this.add(menu);

        menu = new HelpMenu();
        this.add(menu);
    }

	public void refreshMenus(MainFrame mainFrame)
	{	
		this.removeAll();
		JMenu menu = null;

	    menu = new FileMenu(mainFrame);
	    this.add(menu);

	    menu = new EditMenu();
	    this.add(menu);

	    menu = new CreateDiagramMenu();
	    this.add(menu);

	    menu = new ViewMenu();
	    this.add(menu);

	    menu = new GenerateMenu();
	    this.add(menu);

	    menu = new HelpMenu();
	    this.add(menu);
		
	}
}
