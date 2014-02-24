/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.Util;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends AddRemoveAction and represents Add/Remove Operation Action.
 * </p>
 *
 * <p>
 * This action will add/remove an operation graphElement to/from a parent node wrapped
 * inside the given compartment extractor object.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as executeAdd and executeRemove might
 * interfere each other.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class AddRemoveOperationAction extends AddRemoveAction {
    /**
     * <p>
     * Private constructor, create AddRemoveOperation with given extractor, operation and type
     * (whether it's a remove or add).
     * </p>
     *
     * <p>
     * Note, client should use the appropriate static method to create Add or Remove action.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param operation operation to be added/removed
     * @param isRemove false for add, true for remove
     *
     * @throws IllegalArgumentException if extractor or operation is null
     */
    private AddRemoveOperationAction(CompartmentExtractor extractor, GraphNode operation, boolean isRemove) {
        super(extractor, operation, isRemove);

        Util.checkNull(operation, "operation");
    }

    /**
     * <p>
     * Create a Remove operation action from the given extractor and operation to be removed.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param operation operation to be removed
     * @return Action to remove operation
     *
     * @throws IllegalArgumentException if extractor or operation is null
     */
    public static AddRemoveAction createRemoveOperationAction(CompartmentExtractor extractor, GraphNode operation) {
        return new AddRemoveOperationAction(extractor, operation, true);
    }

    /**
     * <p>
     * Create an Add operation action from the given extractor and new operation to be added.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param operation operation to be added
     * @return Action to add operation
     *
     * @throws IllegalArgumentException if extractor or operation is null
     */
    public static AddRemoveAction createAddOperationAction(CompartmentExtractor extractor, GraphNode operation) {
        return new AddRemoveOperationAction(extractor, operation, false);
    }

    /**
     * <p>
     * Execute the remove operation action represented by this object.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the remove operation action
     */
    protected void executeRemove() throws ActionExecutionException {
        // get the operation compartment
        GraphElement operationCompartment = getExtractor().extractOperation();

        // remove the operation
        Util.getDelimitedSectionGraphElement(operationCompartment).removeContained(
            (DiagramElement) this.getExecuteValue());
    }

    /**
     * <p>
     * Execute the add operation action represented by this object.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the remove operation action
     */
    protected void executeAdd() throws ActionExecutionException {
        // extract the element that holds all the operation elements
        GraphElement element = Util.getDelimitedSectionGraphElement(getExtractor().extractOperation());

        // the operation element
        GraphNode operation = (GraphNode) this.getExecuteValue();

        // add the operation element
        element.addContained(operation);
        operation.setContainer(element);
    }
}
