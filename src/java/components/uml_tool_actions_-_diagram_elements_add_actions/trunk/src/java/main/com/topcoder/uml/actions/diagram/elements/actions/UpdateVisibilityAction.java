/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.GraphElement;

/**
 * <p>
 * This class extends UpdateAction and represents Update Visibility Action.
 * </p>
 *
 * <p>
 * This action updates the visibility of the parent GraphElement to the given visibility.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as execute method shares the same
 * GraphElement object and savedValue object.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class UpdateVisibilityAction extends UpdateAction {
    /**
     * <p>
     * Create Update Visibility Action with the graph element and the newSize specified.
     * </p>
     *
     * @param element graph element to be updated
     * @param isVisible the new visibility
     *
     * @throws IllegalArgumentException if any of the argument is null.
     */
    public UpdateVisibilityAction(GraphElement element, boolean isVisible) {
        super(element, isVisible);
    }

    /**
     * <p>
     * Execute the Update Visibility action.
     * </p>
     */
    public void execute() {
        // update the visibility
        GraphElement element = this.getElement();
        savedValue = element.isVisible();
        element.setVisible((Boolean) executeValue);
        this.executionSuccess();
    }
}
