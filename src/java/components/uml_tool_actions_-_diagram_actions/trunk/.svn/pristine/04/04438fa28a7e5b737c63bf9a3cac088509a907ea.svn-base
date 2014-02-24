/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.uml.model.core.Element;

/**
 * <p>
 * This class is a subclass of {@link CreateDiagramAction}.
 * </p>
 *
 * <p>
 * This action will help {@link CreateActivityDiagramAction} to create an activity diagram. It will create a diagram
 * which will be owned by the new activity graph.
 *
 * <p>
 * This class will be created and used by {@link CreateActivityDiagramAction}.
 * </p>
 *
 * <p>
 * Note that this class is package private.
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
class CreateActivityDiagramHelperAction extends CreateDiagramAction {

    /**
     * <p>
     * Represents the type of the diagram.
     * </p>
     */
    /*
     * BugFix: UML-9507
     */
//    public static final String TYPE = "Activity";
    public static final String TYPE = "ActivityDiagram";

    /**
     * <p>
     * Constructor of the create activity graph action.
     * </p>
     *
     * @param owner the possible null owner of the diagram
     * @param name the possible null, possible empty name of the diagram
     *
     * @throws IllegalStateException if the diagram can't be created or can't be formatted
     */
    CreateActivityDiagramHelperAction(Element owner, String name) {
        super(TYPE, owner, name);
    }
}
