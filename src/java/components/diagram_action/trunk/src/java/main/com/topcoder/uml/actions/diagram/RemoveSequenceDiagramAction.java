/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;

/**
 * <p>
 * This class is a subclass of {@link RemoveDiagramAction}.
 * </p>
 *
 * <p>
 * This action will simply remove the sequence diagram.
 * </p>
 *
 * <p>
 * This class will be created by application directly.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b>
 * This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveSequenceDiagramAction extends RemoveDiagramAction {

    /**
     * <p>
     * Constructor of the remove sequence diagram action.
     * </p>
     *
     * @param diagram the non null diagram to be removed
     *
     * @throws IllegalArgumentException if the diagram is null
     */
    public RemoveSequenceDiagramAction(Diagram diagram) {
        super(diagram);
    }
}
