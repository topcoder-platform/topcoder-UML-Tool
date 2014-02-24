/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.deploy.handlers;

import javax.swing.JTextArea;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.EditNameEvent;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.EditNameListener;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * Implementation of the EditNameListener interface. This class is registered to listen to the name editing starting
 * action on object node
 * </p>
 * <p>
 * Shows the inputbox and initialize it. connected to it.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ObjectNodeEditNameHandler implements EditNameListener {
    /**
     * <p>
     * Implements actions when the node name editing started.
     * </p>
     * @param event
     *            The instance of the EditNameEvent class.
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public void nameEditStarted(EditNameEvent event) {
        DeployHelper.checkNotNull(event, "event");

        ObjectNode node = event.getNode();
        DiagramView view = (DiagramView) node.getParent();
        DiagramViewer viewer = (DiagramViewer) view.getViewer();
        TextInputBox textInputBox = viewer.getTextInputBox();
        textInputBox.setText(event.getName());
        int x = node.getLocation().x + node.getSelectionBound().x;
        int y = node.getLocation().y + node.getSelectionBound().y;

        ZoomPane zoomPane = (ZoomPane) view.getParent();
        double zoomFactor = zoomPane.getTransform().getZoomFactor();
        x = (int) ((x + view.getX()) * zoomFactor);
        y = (int) ((y + view.getY()) * zoomFactor);

        textInputBox.show(zoomPane, x, y);

        JTextArea textArea = (JTextArea) textInputBox.getComponent(0);
        textArea.requestFocus();
        textArea.selectAll();
    }

}
