/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.Util;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends UpdateAction and represents Update Size Action.
 * </p>
 *
 * <p>
 * This action updates the size of the parent GraphElement to the given Dimension.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as execute method shares the same
 * savedValue object and parent element object.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class UpdateSizeAction extends UpdateAction {
    /**
     * <p>
     * Create Update Size Action with the element and the newSize specified.
     * </p>
     *
     * @param element graph element to be updated
     * @param newSize the new size
     *
     * @throws IllegalArgumentException if any of the argument is null
     */
    public UpdateSizeAction(GraphElement element, Dimension newSize) {
        super(element, newSize);

        Util.checkNull(newSize, "newSize");
    }

    /**
     * <p>
     * Execute the Update Size action.
     * </p>
     *
     * @throws ActionExecutionException if the given graph element is not of GraphNode type
     */
    public void execute() throws ActionExecutionException {
        GraphElement element = this.getElement();
        // check the elemen type
        if (!(element instanceof GraphNode)) {
            throw new ActionExecutionException("The graph element should be of GraphNode type.");
        }

        // update the size
        GraphNode node = (GraphNode) element;
        savedValue = node.getSize();
        node.setSize((Dimension) executeValue);
        this.executionSuccess();
    }
}
