/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Absttrract action to open project.
 * </p>
 * @author sempiq
 * @version 1.0
 */
public abstract class OpenProjectAbstractAction extends AbstractAction {
    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -2873752707169317598L;

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    protected final MainFrame mainFrame;

    /**
     * <p>
     * Represents the open type. must be OPEN_PROJECT_TCUML, OPEN_PROJECT_XMI_TC, OPEN_PROJECT_ZUML, or
     * OPEN_PROJECT_XMI_POSEIDON.
     * </p>
     */
    protected int openType;

    /**
     * <p>
     * Represents the file to open.
     * </p>
     */
    private File file;

    /**
     * <p>
     * Constructs an instance of open project action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public OpenProjectAbstractAction(MainFrame mainFrame) {
        super();
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
        if (!mainFrame.querySave()) {
            return;
        }

        file = getFile();
        if(file == null){
        	return;
        }
        // clean the DiagramViewer
        DeployHelper.clearSelected(mainFrame.getDiagramViewer());
        mainFrame.getDocumentTree().updateTree();
        mainFrame.getDiagramViewer().clear();

            LoadThread loadThread = new LoadThread();
            loadThread.start();
            (new ProgressDialog(loadThread)).start();

    }

    /**
     * Abstract method to provide file for loading
     *
     * @return File to open
     */
    protected abstract File getFile();

	/**
     * <p>
     * Thread to open project.
     * </p>
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    class LoadThread extends Thread {
        /**
         * <p>
         * Runs the thread to open project.
         * </p>
         */
        public void run() {
            mainFrame.loadProject(file, openType);
        }
    }

    /**
     * <p>
     * Thread to show progress bar.
     * </p>
     * @author ly, FireIce, ylouis, TCSDEVELOPER
     * @version 1.0
     */
    class ProgressDialog extends Thread {
        /**
         * <p>
         * The dialog to show the progress bar.
         * </p>
         */
        private JDialog clueDialog = null;

        /**
         * <p>
         * The thread attached to the progress bar.
         * </p>
         */
        private Thread currentThread = null;

        /**
         * <p>
         * Creates the process dialog.
         * </p>
         * @param currentThread
         *            the thread to load project
         */
        public ProgressDialog(Thread currentThread) {
            this.currentThread = currentThread;
            clueDialog = new JDialog(mainFrame, "Loading file ...", true);
            clueDialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            JPanel panel = new JPanel();
            JProgressBar pb = new JProgressBar();
            pb.setIndeterminate(true);
            pb.setBackground(Color.white);
            pb.setForeground(Color.BLUE);
            pb.setPreferredSize(new Dimension(300, 20));
            clueDialog.getContentPane().add(panel);
            panel.add(pb);
            clueDialog.pack();
            clueDialog.setLocationRelativeTo(mainFrame);
            (new DisposeDialog()).start();
        }

        /**
         * <p>
         * Shows the process dialog.
         * </p>
         */
        public void run() {
            clueDialog.setVisible(true);
        }

        /**
         * <p>
         * Thread to dispose dialog.
         * </p>
         * @author ly, FireIce, ylouis, TCSDEVELOPER
         * @version 1.0
         */
        private class DisposeDialog extends Thread {
            /**
             * <p>
             * Runs the thread to dispose dialog.
             * </p>
             */
            public void run() {
                try {
                    currentThread.join();
                } catch (InterruptedException e) {
                    DeployHelper.logException(e);
                }
                clueDialog.dispose();
            }
        }
    }
}

