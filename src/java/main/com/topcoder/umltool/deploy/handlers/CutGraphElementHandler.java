/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to listen to the cut of graph element
 * in a diagram.
 * </p>
 * <p>
 * Removes a component from the diagram view.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CutGraphElementHandler implements ActionEventListener {
    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * the component to be cut.
     * </p>
     */
    private JComponent component = null;

    /**
     * <p>
     * the diagram view to be cut from.
     * </p>
     */
    private DiagramView diagramView;

    /**
     * <p>
     * Creates an instance of <code>CutGraphElementHandler</code>.
     * </p>
     * @param mainFrame
     *            main frame window
     */
    public CutGraphElementHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is performed.
     * </p>
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");
        DeployHelper.checkNotNull(eventValidation, "eventValidation");

        if (event.getSource() instanceof JComponent) {
            component = (JComponent) event.getSource();
            diagramView = (DiagramView) component.getParent();

            mainFrame.getDocumentTree().updateTree();
            diagramView.remove(component);
        }
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is undone.
     * </p>
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(undoableAction, "undoableAction");
        DeployHelper.checkNotNull(event.getSource(), "source");

        if (component != null) {
            mainFrame.getDocumentTree().updateTree();
            diagramView.add(component);
        }
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is redone.
     * </p>
     * @param event
     *            the non null event which has been redone
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");
        DeployHelper.checkNotNull(undoableAction, "undoableAction");

        if (component != null) {
            mainFrame.getDocumentTree().updateTree();
            diagramView.remove(component);
        }
    }
}
