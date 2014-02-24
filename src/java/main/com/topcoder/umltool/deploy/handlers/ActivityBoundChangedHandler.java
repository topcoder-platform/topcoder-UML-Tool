/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.topcoder.gui.diagramviewer.uml.activityelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.TextField;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.activityelements.event.BoundaryChangedListener;

/**
 * <p>
 * This implementation handles the boundary changed event of Activity component's nodes. It will set the new boundary to
 * the node, and relocate its selection corners.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ActivityBoundChangedHandler implements BoundaryChangedListener {

    /**
     * <p>
     * Handles the boundary changed event. The event parameter could tell which node's bound is changed, and what is the
     * old bound and new bound.
     * </p>
     * @param event
     *            the boundary change event
     */
    public void boundaryChanged(BoundaryChangedEvent event) {
        if (event == null) {
            return;
        }
        BaseNode node = (BaseNode) event.getSource();
        node.setBounds(event.getNewBoundary());
        node.relocateSelectionCorners();
        TextField name = node.getNameCompartment();
        TextField stereotype = node.getStereotypeCompartment();
        removeMouseMotionListener(name);
        removeMouseMotionListener(stereotype);
        addPassBehindListener(name);
        addPassBehindListener(stereotype);
    }

    /**
     * <p>
     * Removes the mouse motion listener for given text field.
     * </p>
     * @param textField
     *            the text field which should not be dragged
     */
    private void removeMouseMotionListener(TextField textField) {
        for (MouseMotionListener listener : textField.getMouseMotionListeners()) {
            textField.removeMouseMotionListener(listener);
        }
    }

    /**
     * <p>
     * Adds a mouse listener to let event pass behind.
     * </p>
     * @param textField
     *            the text field to add listener
     */
    private void addPassBehindListener(TextField textField) {
        boolean isPassBehind = false;
        for (MouseListener listener : textField.getMouseListeners()) {
            if (listener instanceof NodeTextMouseHandler) {
                isPassBehind = true;
                break;
            }
        }
        if (!isPassBehind) {
            textField.addMouseListener(new NodeTextMouseHandler());
        }
        isPassBehind = false;
        for (MouseMotionListener listener : textField.getMouseMotionListeners()) {
            if (listener instanceof NodeTextMouseHandler) {
                isPassBehind = true;
                break;
            }
        }
        if (!isPassBehind) {
            textField.addMouseMotionListener(new NodeTextMouseHandler());
        }
    }

}
