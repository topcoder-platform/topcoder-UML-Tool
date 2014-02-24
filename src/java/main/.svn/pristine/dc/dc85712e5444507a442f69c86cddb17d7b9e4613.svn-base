/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.TextChangeListener;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;

/**
 * <p>
 * This implementation class listens to text change event of UseCase component's nodes.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class UsecaseNameChangedHandler implements TextChangeListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>UsecaseNameChangedHandler</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public UsecaseNameChangedHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the text change event.
     * </p>
     *
     * @param e
     *            the text change event
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void textChange(TextChangeEvent e) {
        DeployHelper.checkNotNull(e, "event");
        if (!e.getNewText().equals(e.getOldText())) {
            // Retrieve the TextField, and node
            TextField textField = (TextField) e.getSource();
            if (textField.getParent() instanceof Node) {
                Node node = (Node) textField.getParent();
                // Get the model element
                GraphNode graphNode = node.getGraphNode();
                ModelElement modelElement = DeployHelper.getElement(graphNode);
                // Actually change the name
                ChangeEntityNameAction changeNameAction =
                    new ChangeEntityNameAction(modelElement, e.getNewText(), false);
                mainFrame.handleActionEvent(changeNameAction, DeployHelper.getComponent(modelElement, mainFrame),
                    "Name changed");
            } else if (textField.getParent() instanceof Edge) {
                BaseEdge edge = (BaseEdge) textField.getParent();
                GraphEdge graphEdge = edge.getGraphEdge();
                ModelElement modelElement = DeployHelper.getElement(graphEdge);
                // Actually change the name
                ChangeEntityNameAction changeNameAction =
                    new ChangeEntityNameAction(modelElement, e.getNewText(), false);
                mainFrame.handleActionEvent(changeNameAction, DeployHelper.getComponent(modelElement, mainFrame),
                    "Name changed");
            }
        }
    }

}
