/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to change entity's name. Update the
 * panels and diagram viewer in mainframe.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ChangeCommentTextHandler implements ActionEventListener {
    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of change entity name handler with the mainframe.
     * </p>
     * @param mainFrame
     *            the mainFrame
     */
    public ChangeCommentTextHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is performed.
     * </p>
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        updateNode(event);
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is undone.
     * </p>
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        updateNode(event);
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is redone.
     * </p>
     * @param event
     *            the non null event which has been redone
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        updateNode(event);
    }

    /**
     * <p>
     * Updates the node according to the event object.
     * </p>
     * @param event
     *            the event object
     */
    @SuppressWarnings("unchecked")
    private void updateNode(EventObject event) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");
        List<JComponent> jComponents = new ArrayList<JComponent>();
        Object object = event.getSource();
        if (object instanceof List) {
            jComponents = (List<JComponent>) object;
        } else if (object instanceof JComponent) {
            jComponents.add((JComponent) object);
        }
        for (JComponent jComponent : jComponents) {
            if (jComponent instanceof CommentNode) {
                CommentNode node = (CommentNode) jComponent;
                DeployHelper.nodeNotifyChange(node, "Comment text changed", mainFrame);
            }
        }
    }
}
