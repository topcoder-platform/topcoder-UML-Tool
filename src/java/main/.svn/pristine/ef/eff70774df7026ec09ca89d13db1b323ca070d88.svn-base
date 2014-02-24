/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Toolkit;
import java.io.File;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Action to open project.
 * </p>
 * 
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class OpenProjectAction extends OpenProjectAbstractAction {
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
	private static final String ACTION_NAME = "Open";

	/**
	 * <p>
	 * Action description.
	 * <p>
	 */
	private static final String SHORT_DESCRIPTION = "Open a project.";

	/**
	 * <p>
	 * Icon file name for menu.
	 * <p>
	 */
	private static final String ICON_FILE_NAME = "/images/Open_16.png";

	/**
	 * <p>
	 * Acceleration key.
	 * <p>
	 */
	private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke
			.getKeyStroke('O', Toolkit.getDefaultToolkit()
					.getMenuShortcutKeyMask());

	/**
	 * <p>
	 * Icon file for tool bar.
	 * <p>
	 */
	private static final String TOOLBAR_ICON_FILE_NAME = "/images/Open.png";

	/**
	 * <p>
	 * Constructs an instance of open project action.
	 * <p>
	 * 
	 * @param mainFrame
	 *            main frame of uml tool
	 */
	public OpenProjectAction(MainFrame mainFrame) {
		super(mainFrame);
		this.putValue(Action.NAME, ACTION_NAME);
		this.putValue(Action.SMALL_ICON, new ImageIcon(OpenProjectAction.class
				.getResource(ICON_FILE_NAME)));
		this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
		this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

		this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(
				OpenProjectAction.class.getResource(TOOLBAR_ICON_FILE_NAME)));

	}

	@Override
	protected File getFile() {
		File file = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setSelectedFile(mainFrame.getLastOpenFile());
		fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
		fileChooser.addChoosableFileFilter(new ExtensionFileFilter(
				"TopCoder UML Files", "tcuml"));
		fileChooser.addChoosableFileFilter(new ExtensionFileFilter(
				"Poseidon UML Files", "zuml"));
		fileChooser.addChoosableFileFilter(new ExtensionFileFilter(
				"TopCoder XMI Files", "xmi"));
		fileChooser.addChoosableFileFilter(new ExtensionFileFilter(
				"Poseidon XMI Files", "xmi"));
		fileChooser.setFileFilter(fileChooser.getChoosableFileFilters()[0]);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fileChooser.showOpenDialog(mainFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// clean the DiagramViewer
			DeployHelper.clearSelected(mainFrame.getDiagramViewer());
			mainFrame.getDocumentTree().updateTree();
			mainFrame.getDiagramViewer().clear();

			file = fileChooser.getSelectedFile();
			String extension = DeployHelper.getExtension(file);

			if ("tcuml".equals(extension)) {
				openType = MainFrame.OPEN_PROJECT_TCUML;
			} else if ("zuml".equals(extension)) {
				openType = MainFrame.OPEN_PROJECT_ZUML;
			} else if ("xmi".equals(extension)) {
				String desc = fileChooser.getFileFilter().getDescription();
				if (desc.indexOf("TopCoder") >= 0) {
					openType = MainFrame.OPEN_PROJECT_XMI_TC;
				} else if (desc.indexOf("Poseidon") >= 0) {
					openType = MainFrame.OPEN_PROJECT_XMI_POSEIDON;
				}
			} else {
				String desc = fileChooser.getFileFilter().getDescription();
				if (desc.indexOf("*.tcuml") > 0) {
					openType = MainFrame.OPEN_PROJECT_TCUML;
					extension = ".tcuml";
				} else if (desc.indexOf("*.zuml") > 0) {
					openType = MainFrame.OPEN_PROJECT_ZUML;
					extension = ".zuml";
				} else if (desc.indexOf("TopCoder") >= 0) {
					openType = MainFrame.OPEN_PROJECT_XMI_TC;
					extension = ".xmi";
				} else if (desc.indexOf("Poseidon") >= 0) {
					openType = MainFrame.OPEN_PROJECT_XMI_POSEIDON;
					extension = ".xmi";
				}
				file = new File(file.getPath() + extension);
			}
		}
		return file;

	}
}
