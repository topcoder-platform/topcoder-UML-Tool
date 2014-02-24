/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to listen to the namespace change of
 * component. Updates the component in the diagram viewer, property panel and document tree.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ChangeNamespaceHandler implements ActionEventListener {
    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of ChangeNamespaceHandler with the mainframe.
     * </p>
     * @param mainFrame
     *            the mainFrame
     */
    public ChangeNamespaceHandler(MainFrame mainFrame) {
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
        updateNamespace(event);
        PropertiesPanel panel = mainFrame.getPropertiesPanel();
        panel.configurePanel(panel.getConfiguredModelElements());
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
        updateNamespace(event);
        PropertiesPanel panel = mainFrame.getPropertiesPanel();
        panel.configurePanel(panel.getConfiguredModelElements());
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
        updateNamespace(event);
        PropertiesPanel panel = mainFrame.getPropertiesPanel();
        if (panel.getConfiguredModelElements().size() > 0) {
            panel.configurePanel(panel.getConfiguredModelElements());
        }
    }

    /**
     * <p>
     * Updates the node or edge contained in the event object in the diagram viewer.
     * </p>
     * @param event
     *            the event object
     */
    @SuppressWarnings("unchecked")
    private void updateNamespace(EventObject event) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");
        List<JComponent> jComponents = new ArrayList<JComponent>();
        Object object = event.getSource();
        if (object instanceof List) {
            jComponents = (List<JComponent>) object;
        } else {
            jComponents.add((JComponent) object);
        }
        for (JComponent jComponent : jComponents) {
            if (jComponent instanceof Node) {
                Node node = (Node) jComponent;
                DeployHelper.nodeNotifyChange(node, "Namespace changed", mainFrame);
            } else if (jComponent instanceof Edge) {
                DeployHelper.edgeNotifyChange((Edge) jComponent);
            } else if (jComponent instanceof TextField) {
                DeployHelper.nodeNotifyChange((ClassNode) ((TextField) jComponent).getParent().getParent(),
                        "Namespace changed", mainFrame);
            }
        }
        List<JComponent> seletedComponents = new ArrayList<JComponent>(mainFrame.getDiagramViewer()
                .getAllSelectedElements());
        mainFrame.getDocumentTree().updateTree();
        for (JComponent jComponent : seletedComponents) {
            mainFrame.getDiagramViewer().addSelectedElement(jComponent);
        }
        DeployHelper.notifySelectionChanged(mainFrame, mainFrame.getDiagramViewer());
    }
}
