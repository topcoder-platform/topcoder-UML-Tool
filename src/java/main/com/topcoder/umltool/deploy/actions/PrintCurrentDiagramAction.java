/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.swing.print.PrintFormatRetrieveException;
import com.topcoder.swing.print.PrintManager;
import com.topcoder.uml.actions.project.PrintDiagramAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action class defines the print current diagram activity.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class PrintCurrentDiagramAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Print Current Diagram";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Print current diagram.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/Print_16.png";

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/Print.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask());

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of print current diagramaction.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public PrintCurrentDiagramAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(PrintCurrentDiagramAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(PrintCurrentDiagramAction.class
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
            JOptionPane.showMessageDialog(mainFrame, "There is no current diagram opened.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            PrintManager printManager = new PrintManager();
            printManager.setDocumentName(DeployHelper.generateOutputFileName(view.getDiagram().getName()));
            try {
                printManager.specifyPrintFormat();
            } catch (PrintFormatRetrieveException e) {
                DeployHelper.logException(e);
            }
            try {
                printManager.getPrintFormatRetriever().getPageFormat();
            } catch (IllegalStateException ise) {
                // simply return when print format is not set
                return;
            }
            PrintDiagramAction printDiagramAction = new PrintDiagramAction(view, printManager);

            DiagramViewer viewer = view.getViewer();
            boolean isGridVisible = viewer.isBackgroundGridVisible();
            viewer.setBackgroundGridVisible(false);
            try {
                printDiagramAction.execute();
            } catch (ActionExecutionException e) {
                JOptionPane.showMessageDialog(mainFrame, "Fail to print the current diagram.", "Can not print",
                        JOptionPane.ERROR_MESSAGE);
                DeployHelper.logException(e);
            } finally {
                viewer.setBackgroundGridVisible(isGridVisible);
            }
        }

    }

}
