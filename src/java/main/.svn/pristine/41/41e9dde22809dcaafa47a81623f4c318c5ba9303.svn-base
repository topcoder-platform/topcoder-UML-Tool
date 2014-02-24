/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.panels.documentation.DocumentationPanel;
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
 * Implementation of the ActionEventListener interface. This class is registered to listen to the documentation change
 * of node. Update the node.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ChangeDocumentationHandler implements ActionEventListener {
    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of ChangeDocumentationHandler.
     * </p>
     * @param mainFrame
     *            main frame of uml tool
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public ChangeDocumentationHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
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
        updateDocumentation(event);

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
        updateDocumentation(event);
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
        updateDocumentation(event);
    }

    /**
     * <p>
     * Updates diagram viewer and documentation panel.
     * </p>
     * @param event
     *            the event object
     */
    private void updateDocumentation(EventObject event) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");

        ModelElement modelElement = (ModelElement) event.getSource();
        List<JComponent> jComponents = DeployHelper.getComponent(modelElement, mainFrame);
        for (JComponent jComponent : jComponents) {
            if (jComponent instanceof Node) {
                DeployHelper.nodeNotifyChange((Node) jComponent, "Property changed", mainFrame);
            } else if (jComponent instanceof Edge) {
                DeployHelper.edgeNotifyChange((Edge) jComponent);
            } else if (jComponent instanceof TextField) {
                ((ClassNode) ((TextField) jComponent).getParent().getParent()).notifyPropertiesChange();
            }
        }

//        DocumentationPanel panel = mainFrame.getDocumentationPanel();
//        panel.setTarget(modelElement);
    }

}
