/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;

/**
 * <p>
 * RemoveMergeNodeAction class extends RemoveStateNodeAbstractAction abstract
 * class, it is used to remove the Pseudostate node with kind attribute equal
 * to PseudostateKind.JUNCTION.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base class is not thread-safe,
 * so it is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveMergeNodeAction extends RemoveStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Merge Node";

    /**
     * <p>
     * Construct a RemoveMergeNodeAction with the Pseudostate specified.
     * </p>
     *
     * @param state the state node to remove from its activity graph it attached to.
     *
     * @throws IllegalArgumentException if the argument is null, or state
     * argument's kind attribute doesn't equal to PseudostateKind.JUNCTION.
     */
    public RemoveMergeNodeAction(Pseudostate state) {
        super(PRESENTATION_NAME, state);

        Util.checkPseudostateKind(state, PseudostateKind.JUNCTION);
    }
}
