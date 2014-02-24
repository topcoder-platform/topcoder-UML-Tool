/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.io.File;

import javax.swing.Action;

import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Action to open project from file.
 * </p>
 * 
 * @author sempiq
 * @version 1.0
 */
public class OpenProjectFileAction extends OpenProjectAbstractAction {
	/**
	 * <p>
	 * The version id.
	 * <p>
	 */
	private static final long serialVersionUID = -2873752707169317598L;

	/**
	 * <p>
	 * Action name.
	 * <p>
	 */
	public static final String ACTION_NAME = "Open recent";
	
	/**
	 * <p>
	 * Action description.
	 * <p>
	 */
	private static final String SHORT_DESCRIPTION = "Open a project";

	/**
	 * <p>
	 * Key for property holding file
	 * <p>
	 */
	public static final String FILE_PROPERTY_KEY = "OpenProjectFileAction.FILE";

	/**
	 * <p>
	 * Constructs an instance of open project from file action.
	 * <p>
	 * 
	 * @param mainFrame
	 *            main frame of uml tool
	 */
	public OpenProjectFileAction(MainFrame mainFrame) {
		super(mainFrame);
		this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
	}

	@Override
	protected File getFile() {
		File file = (File) getValue(FILE_PROPERTY_KEY);
		String extension = DeployHelper.getExtension(file);

		if ("tcuml".equals(extension)) {
			openType = MainFrame.OPEN_PROJECT_TCUML;
		} else if ("zuml".equals(extension)) {
			openType = MainFrame.OPEN_PROJECT_ZUML;
		} else if ("xmi".equals(extension)) {
			openType = MainFrame.OPEN_PROJECT_XMI_TC;
		}

		return file;
	}
}
