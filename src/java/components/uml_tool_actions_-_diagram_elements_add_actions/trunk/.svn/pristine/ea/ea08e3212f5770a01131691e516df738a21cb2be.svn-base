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
 * This class extends UpdateAction and represents Update name Action.
 * </p>
 *
 * <p>
 * This action updates the name of the parent GraphElement wrapped in a compartment
 * extractor object to the given name.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as execute method shares the same
 * parent compartment and savedValue object.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class UpdateNameAction extends UpdateAction {
    /**
     * <p>
     * Create Update Name Action with the extractor and the new name specified.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param newName graph element corresponds to the new name
     *
     * @throws IllegalArgumentException if any of the argument is null.
     */
    public UpdateNameAction(CompartmentExtractor extractor, GraphElement newName) {
        super(extractor, newName);

        Util.checkNull(newName, "newName");
    }

    /**
     * <p>
     * Execute update name action represented by this class.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the update name action
     */
    public void execute() throws ActionExecutionException {
        // perform the update operation
        CompartmentExtractor extractor = getExtractor();
        savedValue = extractor.extractName();
        extractor.updateName((GraphElement) executeValue);

        // identify the action can be undo
        this.executionSuccess();
    }
}
