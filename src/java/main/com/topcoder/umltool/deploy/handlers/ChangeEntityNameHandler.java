/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to change entity's name. Update
 * the panels and diagram viewer in mainframe.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeEntityNameHandler implements ActionEventListener {
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
     *
     * @param mainFrame
     *            the mainFrame
     */
    public ChangeEntityNameHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is performed.
     * </p>
     *
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        updatePanels(event);
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is undone.
     * </p>
     *
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        updatePanels(event);
    }

    /**
     * <p>
     * This method is called to inform the handler that the event is redone.
     * </p>
     *
     * @param event
     *            the non null event which has been redone
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        updatePanels(event);
    }

    /**
     * <p>
     * Updates the panels according to the event object.
     * </p>
     *
     * @param event
     *            the event object
     */
    @SuppressWarnings("unchecked")
    private void updatePanels(EventObject event) {
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
            HandlerHelper.updatePanels(jComponent, mainFrame);
        }
        traverse(DeployHelper.getDiagramView(mainFrame).getDiagram());
        mainFrame.getDocumentTree().updateTree();
    }

    private void traverse(GraphElement element) {

        if (element instanceof GraphNode) {
            ModelElement modelElement = DeployHelper.getElement(element);
            DeployHelper.notifyModelElementChange(modelElement, "", mainFrame);
        }
        for (DiagramElement diagramElement : element.getContaineds()) {
            // traverses all the contained GraphElement instances
            if (diagramElement instanceof GraphElement) {
                traverse((GraphElement) diagramElement);
            }
        }
    }
}
