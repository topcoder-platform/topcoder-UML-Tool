/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;

/**
 * <p>
 * Mock subClass of {@link RemoveDiagramAction} used for testing it.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockRemoveDiagramAction extends RemoveDiagramAction {

    /**
     * <p>
     * Constructor of the remove diagram action.
     * </p>
     *
     * @param diagram the non null diagram to be removed
     *
     * @throws IllegalArgumentException if the diagram is null
     */
    protected MockRemoveDiagramAction(Diagram diagram) {
        super(diagram);
    }
}
