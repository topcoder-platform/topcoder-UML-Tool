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
 * This class extends UpdateAction and represents Update namespace Action.
 * </p>
 *
 * <p>
 * This action updates the namespace of the parent GraphElement wrapped in a
 * compartment extractor object to the given namespace.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as execute method shares the same
 * compartment object and savedValue object.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class UpdateNamespaceAction extends UpdateAction {
    /**
     * <p>
     * Create Update Namespace Action with the extractor and the new namespace specified.
     * </p>
     *
     * @param extractor compartment extractor to be used
     * @param newNamespace graph element corresponds to new namespace
     *
     * @throws IllegalArgumentException if any of the argument is null
     */
    public UpdateNamespaceAction(CompartmentExtractor extractor, GraphElement newNamespace) {
        super(extractor, newNamespace);

        Util.checkNull(newNamespace, "newNamespace");
    }

    /**
     * <p>
     * Execute update namespace action represented by this class.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the update namespace action
     */
    public void execute() throws ActionExecutionException {
        // perform the update operation
        CompartmentExtractor extractor = getExtractor();
        savedValue = extractor.extractNamespace();
        extractor.updateNamespace((GraphElement) executeValue);

        // identify the action can be undo
        this.executionSuccess();
    }
}
