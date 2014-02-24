/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will switch tool panel's state when document tree's tab is switched.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class TreeTabChangedHandler implements ChangeListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * The old document tree view.
     * </p>
     */
    private DocumentTreeView oldView;

    /**
     * <p>
     * Creates an instance of <code>TreeTabChangedHandler</code>.
     * </p>
     * @param mainframe
     *            the main frame window
     */
    public TreeTabChangedHandler(MainFrame mainframe) {
        this.mainFrame = mainframe;
        oldView = mainFrame.getDocumentTree().getCurrentPanel().getCurrentView();
    }

    /**
     * <p>
     * Updates document tree when tab is switched.
     * </p>
     * @param event
     *            a ChangeEvent object
     */
    public void stateChanged(ChangeEvent event) {
        DeployHelper.checkNotNull(event, "event");
        HandlerHelper.treeViewChanged(mainFrame, oldView);
        oldView = mainFrame.getDocumentTree().getCurrentPanel().getCurrentView();
    }
}