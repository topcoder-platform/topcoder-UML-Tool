/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.BaseEdge;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeListener;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;

/**
 * <p>
 * This implementation class listens to text change event of Class Edges component's edges.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ClassEdgeNameChangedHandler implements TextChangeListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>ClassEdgeNameChangedHandler</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public ClassEdgeNameChangedHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Performs the name changed event and set the new name to the node.
     * </p>
     *
     * @param event
     *            the new value of the name compartment
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public void textChange(TextChangeEvent event) {
        DeployHelper.checkNotNull(event, "event");
        // Retrieve the TextField, and node
        TextField textField = (TextField) event.getSource();
        if (textField.getParent() instanceof BaseEdge) {
            BaseEdge edge = (BaseEdge) textField.getParent();
            // Get the model element
            GraphEdge graphEdge = edge.getGraphEdge();
            ModelElement modelElement = DeployHelper.getElement(graphEdge);
            // Actually change the name
            ChangeEntityNameAction changeNameAction =
                new ChangeEntityNameAction(modelElement, event.getNewText(), false);
            mainFrame.handleActionEvent(changeNameAction, DeployHelper.getComponent(modelElement, mainFrame),
                "Name changed");
        }
    }

}
