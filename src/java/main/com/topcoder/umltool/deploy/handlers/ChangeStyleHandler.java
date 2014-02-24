/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.edges.TextField;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseEdge;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to listen to the style change of node.
 * Change the node to new style.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class ChangeStyleHandler implements ActionEventListener {
    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of ChangeStyleHandler with the mainframe.
     * </p>
     * @param mainFrame
     *            the mainframe
     */
    public ChangeStyleHandler(MainFrame mainFrame) {
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
        updateComponentStyle(event);
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
        updateComponentStyle(event);
        StylePanel stylePanel = mainFrame.getStylePanel();
        stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
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
        updateComponentStyle(event);
        StylePanel stylePanel = mainFrame.getStylePanel();
        if (stylePanel.getStyleObjectList().size() > 0) {
            stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
        }
    }

    /**
     * <p>
     * Updates the style of node or edge contained in the event object.
     * </p>
     * @param event
     *            the event object
     */
    private void updateComponentStyle(EventObject event) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");
        JComponent component = (JComponent) event.getSource();
        if (component instanceof PolylineNode) {
            ((PolylineNode) component).notifyPropertiesChange();
        } else if (component instanceof Node) {
            updateNode((Node) component);
        } else if (component instanceof Edge) {
            updateEdge((Edge) component);
        } else if (component instanceof TextField) {
            updateTextField((TextField) component);
        }
    }

    /**
     * <p>
     * Updates the style of node.
     * </p>
     * @param node
     *            the node
     */
    private void updateNode(Node node) {
        if (node instanceof ObjectNode) {
            ((ObjectNode) node).notifyGraphNodeChange("style changed");
        } else if (node instanceof com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode) {
            ((com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode) node).notifyPropertiesChange();
            ((com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode) node).notifyUpdate();
        } else {
            DeployHelper.nodeNotifyChange(node, "style changed", mainFrame);
        }
    }

    /**
     * <p>
     * Updates the style of edge.
     * </p>
     * @param edge
     *            the edge
     */
    private void updateEdge(Edge edge) {
        edge.notifyPropertiesChange();
        if (edge instanceof BaseEdge) {
            ((BaseEdge) edge).notifyGraphEdgeChange();
        } else if (edge instanceof SequenceEdge) {
            ((SequenceEdge) edge).notifyGraphEdgeChange();
        }
    }

    /**
     * <p>
     * Updates the style of text field.
     * </p>
     * @param textField
     *            the text Field
     */
    private void updateTextField(TextField textField) {
        ((ClassNode) textField.getParent().getParent()).notifyPropertiesChange();
    }
}
