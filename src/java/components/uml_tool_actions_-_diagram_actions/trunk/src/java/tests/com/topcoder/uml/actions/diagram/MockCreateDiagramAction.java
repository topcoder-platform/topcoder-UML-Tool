/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.uml.model.core.Element;

/**
 * <p>
 * This class is the mock extension of CreateDiagramAction used for testing.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class MockCreateDiagramAction extends CreateDiagramAction {

    /**
     * <p>
     * Constructor of the create diagram action.
     * </p>
     *
     * @param type the non null, non empty type of the diagram
     * @param owner the possible null owner of the diagram
     * @param name the possible null, possible empty name of the diagram
     *
     * @throws IllegalStateException if the diagram can't be created
     * @throws IllegalArgumentException if the type is null or empty
     */
    public MockCreateDiagramAction(String type, Element owner, String name) {
        super(type, owner, name);
    }

}
