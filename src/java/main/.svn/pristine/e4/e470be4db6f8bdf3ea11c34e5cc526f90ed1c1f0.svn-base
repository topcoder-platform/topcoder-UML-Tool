/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.swing.imageexporter.ImageExporter;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Action to export current diagram.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ExportCurrentDiagramAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Export Current Diagram";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Export current diagram.";

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
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask());

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of export current diagram action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public ExportCurrentDiagramAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(ExportCurrentDiagramAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(ExportCurrentDiagramAction.class
                .getResource(TOOLBAR_ICON_FILE_NAME)));

        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        DiagramView view = DeployHelper.getDiagramView(mainFrame);
        if (view == null) {
            return;
        }

        // initializes file chooser
        JFileChooser f = DeployHelper.createExportFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);

        String exportPath = mainFrame.getLastImageExportPath();
        f
                .setSelectedFile(new File(exportPath + "/"
                        + DeployHelper.generateOutputFileName(view.getDiagram().getName())));

        int returnVal = f.showSaveDialog(mainFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // gets extension in current filter
            String filterExtension = DeployHelper.getExtension(f);

            // gets path and name of the selected file
            File selectedFile = f.getSelectedFile();
            String fileName = selectedFile.getName();
            String filePath = selectedFile.getParent();

            // adjusts extension
            String extension = DeployHelper.getExtension(selectedFile);
            if (extension.equals("")
                    || (!ImageExporter.BMP_FORMAT.equals(extension) && !ImageExporter.GIF_FORMAT.equals(extension)
                            && !ImageExporter.JPEG_FORMAT.equals(extension)
                            && !ImageExporter.PNG_FORMAT.equals(extension)
                            && !ImageExporter.PNM_FORMAT.equals(extension) && !ImageExporter.TIFF_FORMAT
                            .equals(extension))) {
                extension = filterExtension;
                fileName = fileName + "." + extension;
            }

            DeployHelper.exportToFile(mainFrame, view, filePath, fileName, extension);
            mainFrame.setLastImageExportPath(filePath);
        }
    }
}
