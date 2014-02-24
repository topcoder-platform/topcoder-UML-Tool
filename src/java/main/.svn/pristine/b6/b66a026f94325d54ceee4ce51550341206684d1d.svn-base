/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.SequenceEdge;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TextChangedListener;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.TextField;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This implementation class listens to text change event of UseCase component's nodes.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class SequenceEdgeNameChangedHandler implements TextChangedListener {
    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of SequenceEdgeNameChangedHandler.
     * </p>
     * @param mainFrame
     *            reference to main frame
     */
    public SequenceEdgeNameChangedHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Handles the text change event.
     * </p>
     * @param e
     *            the text change event
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void textChanged(TextChangedEvent e) {
        DeployHelper.checkNotNull(e, "event");
        if (!e.getNewValue().equals(e.getOldValue())) {
            // Retrieve the TextField, and node
            TextField textField = (TextField) e.getSource();
            if (textField.getParent() instanceof SequenceEdge) {
                SequenceEdge edge = (SequenceEdge) textField.getParent();
                GraphEdge graphEdge = edge.getGraphEdge();
                ModelElement modelElement = DeployHelper.getElement(graphEdge);
                // Actually change the name
                modelElement.setName(e.getNewValue());
                edge.notifyGraphEdgeChange();

                HandlerHelper.updatePanels(edge, mainFrame);
            }
        }
    }

}
