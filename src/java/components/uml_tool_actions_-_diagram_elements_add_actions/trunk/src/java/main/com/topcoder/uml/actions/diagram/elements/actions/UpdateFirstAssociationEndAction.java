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
 * This class extends UpdateAction and represents Update First Association End Action.
 * </p>
 *
 * <p>
 * This action updates the first association end of the given Graph Element wrapped
 * inside a compartment extractor object.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as execute method shares the same compartment
 * object and savedValue object.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class UpdateFirstAssociationEndAction extends UpdateAction {
    /**
     * <p>
     * Create Update First AssociationEnd Action with the extractor and
     * the new association end specified.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param newAssociationEnd graph element representing the new first Association end
     *
     * @throws IllegalArgumentException if any of the argument is null.
     */
    public UpdateFirstAssociationEndAction(CompartmentExtractor extractor, GraphElement newAssociationEnd) {
        super(extractor, newAssociationEnd);

        Util.checkNull(newAssociationEnd, "newAssociationEnd");
    }

    /**
     * <p>
     * Execute action represented by this class.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the update first association end action
     */
    public void execute() throws ActionExecutionException {
        // perform the update operation
        CompartmentExtractor extractor = this.getExtractor();
        savedValue = extractor.extractFirstAssociationEnd();
        extractor.updateFirstAssociationEnd((GraphElement) executeValue);

        // identify the action can be undo
        this.executionSuccess();
    }
}
