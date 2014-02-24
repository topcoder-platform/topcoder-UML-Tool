/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.topcoder.diagraminterchange.Diagram;
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
 * Action to print all diagrams.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class PrintAllDiagramsAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Print All Diagrams";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Print all diagrams.";

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
     * Constructs an instance of print all diagrams action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public PrintAllDiagramsAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(PrintAllDiagramsAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(PrintAllDiagramsAction.class
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
        DiagramViewer viewer = mainFrame.getDiagramViewer();
        DiagramView[] views = viewer.getCachedDiagramViews();
        if (views.length == 0) {
            JOptionPane.showMessageDialog(mainFrame, "There is no diagram cached.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        List<DiagramView> diagramViews = new ArrayList<DiagramView>();
        for (DiagramView view : views) {
            diagramViews.add(view);
        }

        PrintManager printManager = new PrintManager();
        try {
            printManager.specifyPrintFormat();
        } catch (PrintFormatRetrieveException e1) {
            DeployHelper.logException(e1);
        }
        try {
            printManager.getPrintFormatRetriever().getPageFormat();
        } catch (IllegalStateException ise) {
            // simply return when print format is not set
            return;
        }

        boolean isGridVisible = viewer.isBackgroundGridVisible();
        viewer.setBackgroundGridVisible(false);
        boolean isDialogDisplayed = false;

        try {
            for (DiagramView view : views) {
                Diagram diagram = view.getDiagram();
                if (diagram.isVisible()) {
                    if (isDialogDisplayed) {
                        // only show one print dialog
                        printManager.setHasPrintDialog(false);
                    }
                    printManager.setDocumentName(DeployHelper.generateOutputFileName(diagram.getName()));
                    PrintDiagramAction printDiagramAction = new PrintDiagramAction(view, printManager);

                    printDiagramAction.execute();
                    isDialogDisplayed = true;
                }
            }

        } catch (ActionExecutionException e) {
            JOptionPane.showMessageDialog(mainFrame, "Fail to print the diagram.", "Can not print",
                    JOptionPane.ERROR_MESSAGE);
            DeployHelper.logException(e);
        } finally {
            viewer.setBackgroundGridVisible(isGridVisible);
            printManager.setHasPrintDialog(true);
        }
    }
}
