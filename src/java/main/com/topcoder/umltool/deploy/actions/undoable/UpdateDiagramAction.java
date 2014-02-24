/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.Rectangle;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action extends from <code>CompositeUndoableAction</code>. This composite action will resize diagram and move
 * diagram if necessary after all actions in list are finished.
 * </p>
 * @author ly
 * @version 1.0
 */
public class UpdateDiagramAction extends CompositeUndoableAction {

    /**
     * <p>
     * Represents the minimum distance from a graph node and its container.
     * </p>
     */
    protected static int gap = SelectionCorner.DEFAULT_RADIUS * 2;

    /**
     * <p>
     * Represents the diagram view whose diagram will be updated. Can be accessed by getter.
     * </p>
     */
    private final DiagramView view;

    /**
     * <p>
     * Creates an instance of <code>UpdateDiagramAction</code>.
     * </p>
     * @param view
     *            the diagram view where the action happens
     * @param presentationName
     *            the non null, non empty string representing the presentation name
     */
    public UpdateDiagramAction(DiagramView view, String presentationName) {
        super(presentationName);
        this.view = view;
    }

    /**
     * <p>
     * Indicates whether there's no action to do.
     * </p>
     * @return false always
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * <p>
     * The method actually execute this action. It will update diagram after all wrapped actions are finished.
     * </p>
     * @throws ActionExecutionException
     *             if any exception prevents this method from completing successfully
     */
    public void executeAction() throws ActionExecutionException {
        super.executeFrom(0);
        updateDiagram();
    }

    /**
     * <p>
     * Resizes the diagram, and put the actions into the action list.
     * </p>
     * @throws ActionExecutionException
     *             if fail to execute any action
     */
    public void updateDiagram() throws ActionExecutionException {
        Rectangle preferredBound = DeployHelper.getPreferredBound(view);

        int xOff = 0;
        int yOff = 0;
        java.awt.Point position = preferredBound.getLocation();
        if (position.getX() < 0) {
            xOff = (int) Math.ceil(gap - position.getX());
        }
        if (position.getY() < 0) {
            yOff = (int) Math.ceil(gap - position.getY());
        }
        if (xOff != 0 || yOff != 0) {
            MoveDiagramAction moveAction = new MoveDiagramAction(view, -xOff, -yOff);
            put(moveAction, view);
            executeFrom(countActions() - 1);
        }

        Dimension newSize = DeployHelper.createDimension(preferredBound.getSize());
        if (newSize.getWidth() != view.getDiagram().getSize().getWidth()
                || newSize.getHeight() != view.getDiagram().getSize().getHeight()) {
            ChangeSizeAction resizeAction = new ChangeSizeAction(view.getDiagram(), newSize);
            put(resizeAction, view);
            executeFrom(countActions() - 1);
        }

    }

    /**
     * <p>
     * Gets the diagram view.
     * </p>
     * @return the diagram view
     */
    public DiagramView getView() {
        return view;
    }
}
