/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.ConfigurationException;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Action to export all diagrams.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ExportAllDiagramsAction extends AbstractAction {
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
	private static final String ACTION_NAME = "Export All Diagrams";

	/**
	 * <p>
	 * Action description.
	 * <p>
	 */
	private static final String SHORT_DESCRIPTION = "Export all diagrams.";

	/**
	 * <p>
	 * Icon file name for menu.
	 * <p>
	 */
	private static final String ICON_FILE_NAME = "/images/ExportImage_16.png";

	/**
	 * <p>
	 * Icon file for tool bar.
	 * <p>
	 */
	private static final String TOOLBAR_ICON_FILE_NAME = "/images/ExportImage_16.png";

	/**
	 * <p>
	 * Mnemonic key.
	 * <p>
	 */
	private static final int MNEMONIC_KEY = KeyEvent.VK_A;

	/**
	 * <p>
	 * Acceleration key.
	 * <p>
	 */
	private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke
			.getKeyStroke('E', Toolkit.getDefaultToolkit()
					.getMenuShortcutKeyMask()
					| Event.SHIFT_MASK);

	/**
	 * <p>
	 * Reference to main frame.
	 * <p>
	 */
	private final MainFrame mainFrame;

	/**
	 * <p>
	 * Constructs an instance of export all diagrams.
	 * <p>
	 *
	 * @param mainFrame
	 *            main frame of uml tool
	 */
	public ExportAllDiagramsAction(MainFrame mainFrame) {
		super(ACTION_NAME, new ImageIcon(ExportAllDiagramsAction.class
				.getResource(ICON_FILE_NAME)));
		this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
		this.putValue(Action.MNEMONIC_KEY, MNEMONIC_KEY);
		this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

		this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(
				ExportAllDiagramsAction.class
						.getResource(TOOLBAR_ICON_FILE_NAME)));

		this.mainFrame = mainFrame;
	}

	/**
	 * <p>
	 * Performing the action.
	 * <p>
	 *
	 * @param actionEvent
	 *            the action event
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		// initializes file chooser
		JFileChooser f = DeployHelper.createExportFileChooser();
		f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		f.setCurrentDirectory(new File(mainFrame.getLastImageExportPath()));

		int returnVal = f.showSaveDialog(mainFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = f.getSelectedFile();

			// gets file path and file extension
			String filePath = selectedFile.getPath();
			if (!(new File(filePath)).exists()) {
				DeployHelper.handleException(mainFrame, null,
						"Directory not exists.");
				return;
			}
			exportAllImages(DeployHelper.getExtension(f), filePath, true);
		}
	}

	public void exportAllImages(String extension, String filePath,
			boolean showProcess) {

		/*
		 * BUGR-108: The aim is to export all the diagrams (along with the
		 * hidden ones) and preview them in a separate JFrame, that will have
		 * JLabels describing the current action.
		 *
		 * To fix that, I will create a JFrame and have its contentPane as a
		 * JPanel that will have 2 JLabels, 1 JProgressBar and the
		 * DiagramViewer. Then, create all the diagrams inside the DiagramViewer
		 * as tabs. Next, export each diagram in it and update the JPanel's
		 * JLabels and JProgressBar. Finally close the frame.
		 */
		UMLModelManager modelManager = UMLModelManager.getInstance();

		JFrame exportingFrame = null;
		JProgressBar bar = null;
		JPanel panel = null;
		JLabel export_num = null;
		JLabel export_name = null;

		exportingFrame = new JFrame("Exporting All Diagrams");
		if (showProcess) {
			exportingFrame.setBounds(100, 100, 500, 500);
			exportingFrame.setAlwaysOnTop(true);
		} else {
			exportingFrame.setBounds(0, 0, 0, 0);
			exportingFrame.setUndecorated(true);
			exportingFrame.setAlwaysOnTop(false);
		}

		exportingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		exportingFrame.setResizable(false);
		exportingFrame.setEnabled(false);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		if (showProcess) {
			export_num = new JLabel("Exporting:");
			export_num.setBounds(10, 10, 200, 20);
			export_num.setVisible(true);
			panel.add(export_num);

			export_name = new JLabel("Current Diagram:");
			export_name.setBounds(10, 30, 480, 20);
			export_name.setVisible(true);
			panel.add(export_name);

			bar = new JProgressBar(0, 0);
			bar.setStringPainted(true);
			bar.setBounds(250, 10, 240, 20);
			bar.setVisible(true);
			panel.add(bar);
		}

		DiagramViewer viewer = null;
		try {
			viewer = new DiagramViewer();
			viewer.setBackgroundGridVisible(false);
			List<Diagram> diagrams = modelManager.getDiagrams();
			int length = diagrams.size();
			for (int i = 0; i < length; i++) {
				Diagram diagram = diagrams.get(i);
				DiagramView view = viewer.openDiagramView(diagram);
				mainFrame.recoverDiagramView(diagram, view,
						mainFrame.isConverted);
			}
			if (showProcess) {
				bar.setMaximum(length);
			}
			viewer.setBounds(0, 50, 500, 450);

			panel.add(viewer);
			exportingFrame.setContentPane(panel);
			exportingFrame.setVisible(true);

			DiagramView[] views = viewer.getCachedDiagramViews();
			for (int i = 0; i < length; i++) {
				DiagramView view = views[i];
				Diagram diagram = view.getDiagram();
				if (showProcess) {
					export_num.setText("Exporting:                 " + (i + 1)
							+ " of " + length);
					export_name.setText("Current Diagram:    "
							+ diagram.getName());
					bar.setValue(i + 1);
				}
				viewer.getTabbedPane().setSelectedIndex(i);

				panel.paintImmediately(0, 0, 500, 500);

				if (diagram.isVisible()) {
					DeployHelper.exportToFile(mainFrame, view, filePath,
							DeployHelper.generateOutputFileName(diagram
									.getName())
									+ "." + extension, extension);
				}
			}
			exportingFrame.dispose();

			mainFrame.setLastImageExportPath(filePath);
		} catch (ConfigurationException e) {
        }
	}
}