/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.Util;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends AddRemoveAction and represent Add/Remove Attribute Action.
 * </p>
 *
 * <p>
 * This action will add/remove an attribute graphElement to/from a parent node
 * wrapped in a CompartmentExtractor object.
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
public class AddRemoveAttributeAction extends AddRemoveAction {
    /**
     * <p>
     * Private constructor, create AddRemoveAttribute with given extractor, attribute and type
     * (whether it's a remove or add).
     * </p>
     *
     * <p>
     * Note, client should use the appropriate static method to create Add or Remove action.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param attribute the attribute to be added/removed
     * @param isRemove false for add, true for remove
     *
     * @throws IllegalArgumentException if extractor or attribute is null
     */
    private AddRemoveAttributeAction(CompartmentExtractor extractor, GraphNode attribute, boolean isRemove) {
        super(extractor, attribute, isRemove);

        Util.checkNull(attribute, "attribute");
    }

    /**
     * <p>
     * Create a Remove attribute action from the given extractor and attribute to be removed.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param attribute attribute to be removed
     * @return action to remove attribute
     *
     * @throws IllegalArgumentException if extractor or attribute is null
     */
    public static AddRemoveAction createRemoveAttributeAction(CompartmentExtractor extractor, GraphNode attribute) {
        return new AddRemoveAttributeAction(extractor, attribute, true);
    }

    /**
     * <p>
     * Create an Add attribute action from the given extractor and new attribute to be added.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param attribute attribute to be added
     * @return action to add attribute
     *
     * @throws IllegalArgumentException if extractor or attribute is null
     */
    public static AddRemoveAction createAddAttributeAction(CompartmentExtractor extractor, GraphNode attribute) {
        return new AddRemoveAttributeAction(extractor, attribute, false);
    }

    /**
     * <p>
     * Execute the remove operation action represented by this object.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the remove attribute action
     */
    protected void executeRemove() throws ActionExecutionException {
        // remove the attribute
        GraphElement delimitedGraphElement = Util.getDelimitedSectionGraphElement(getExtractor().extractAttribute());
        delimitedGraphElement.removeContained((GraphNode) this.getExecuteValue());
    }

    /**
     * <p>
     * Execute the add operation action represented by this object.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the add attribute action
     */
    protected void executeAdd() throws ActionExecutionException {
        // the attribute to be added
        GraphNode attribute = (GraphNode) this.getExecuteValue();

        // extract the graph element for holding all the attribute elements
        GraphElement delimitedGraphElement = Util.getDelimitedSectionGraphElement(getExtractor().extractAttribute());

        // add the attribute
        delimitedGraphElement.addContained(attribute);
        attribute.setContainer(delimitedGraphElement);
    }
}
