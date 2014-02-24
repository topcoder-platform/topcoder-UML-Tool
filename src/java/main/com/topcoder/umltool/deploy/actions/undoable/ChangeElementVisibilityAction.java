/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This undoable action is used to change visibility of specified graph element.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ChangeElementVisibilityAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the presentation name.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Change graph element's visibility";

    /**
     * <p>
     * Graph element whose visibility to be changed.
     * </p>
     */
    private final GraphElement graphElement;

    /**
     * <p>
     * Represents old visibility.
     * </p>
     */
    private final boolean oldVisibility;

    /**
     * <p>
     * Represents new visibility.
     * </p>
     */
    private final boolean newVisiibility;

    /**
     * <p>
     * Creates an instance of <code>ChangeElementVisibilityAction</code> with specified graph element and new
     * visibility.
     * </p>
     * @param graphElement
     *            the graph element whose visibility is to be changed
     * @param isVisible
     *            the new visibility for graph element
     */
    public ChangeElementVisibilityAction(GraphElement graphElement, boolean isVisible) {
        super(PRESENTATION_NAME);
        this.graphElement = graphElement;
        this.oldVisibility = graphElement.isVisible();
        this.newVisiibility = isVisible;
    }

    /**
     * <p>
     * Undo the action to use old visibility.
     * </p>
     */
    public void undoAction() {
        graphElement.setVisible(oldVisibility);
    }

    /**
     * <p>
     * Redo the action to update graph element's visibility to new visibility.
     * </p>
     */
    public void redoAction() {
        graphElement.setVisible(newVisiibility);
    }

    /**
     * <p>
     * Updates graph element's visibility to new visibility.
     * </p>
     */
    public void executeAction() throws ActionExecutionException {
        redoAction();
    }

}
