/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;

/**
 * <p>
 * AddForkNodeAction class extends AddStateNodeAbstractAction abstract class,
 * and this action is specifically used to add Pseudostate node whose kind
 * attribute equals to PseudostateKind.FORK in activity graph.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base class is
 * not thread-safe, so it is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class AddForkNodeAction extends AddStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Fork Node";

    /**
     * <p>
     * Construct an AddForkNodeAction with the Pseudostate,
     * activity graph and manager specified.
     * </p>
     *
     * @param state the state node to add into activity graph
     * @param activityGraph the ActivityGraph object to add the state node
     * @param manager the UMLModelManager object to apply initial formatting
     *
     * @throws IllegalArgumentException if any argument is null, or state
     * argument's kind attribute doesn't equal to PseudostateKind.FORK
     */
    public AddForkNodeAction(Pseudostate state, ActivityGraph activityGraph, UMLModelManager manager) {
        super(PRESENTATION_NAME, state, activityGraph, manager);

        Util.checkPseudostateKind(state, PseudostateKind.FORK);
    }
}
