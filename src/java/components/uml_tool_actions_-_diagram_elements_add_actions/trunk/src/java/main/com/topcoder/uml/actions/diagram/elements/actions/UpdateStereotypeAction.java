/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.actions;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.diagram.elements.Util;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class extends UpdateAction and represents Update stereotype Action.
 * </p>
 *
 * <p>
 * This action updates the stereo type of the parent GraphElement wrapped inside a compartment extractor object.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as execute method shares the same compartment object and
 * savedValue object.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class UpdateStereotypeAction extends UpdateAction {

    /**
     * <p>
     * Create Update Stereotype Action with the graph element and the new name specified.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param newStereotype graph element represents new stereo type
     *
     * @throws IllegalArgumentException if any of the argument is null.
     */
    public UpdateStereotypeAction(CompartmentExtractor extractor, GraphElement newStereotype) {
        super(extractor, newStereotype);

        Util.checkNull(newStereotype, "newStereotype");
    }

    /**
     * <p>
     * Execute action represented by this class.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the update stereotype action
     */
    public void execute() throws ActionExecutionException {
        // perform the udpate operation
        CompartmentExtractor extractor = this.getExtractor();
        savedValue = extractor.extractStereotype();
        extractor.updateStereotype((GraphElement) executeValue);

        // identify the action can be undo
        this.executionSuccess();
    }
}