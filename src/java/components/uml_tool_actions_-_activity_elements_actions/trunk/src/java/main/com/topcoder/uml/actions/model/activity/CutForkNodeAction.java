/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;

/**
 * <p>
 * CutForkNodeAction class extends CutStateNodeAbstractAction abstract
 * class. This action is used specially to cut Pseudostate node with
 * kind attribute equal to PseudostateKind.FORK to the clipboard,
 * this node will also be removed from its attached activity graph.
 * </p>
 *
 * <p>
 * The Clipboard object passed in the constructor could be null,
 * if so the system Clipboard is used instead.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base-class is
 * not thread-safe, this class is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class CutForkNodeAction extends CutStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Fork Node";

    /**
     * <p>
     * Construct a CutForkNodeAction with the Pseudostate and Clipboard specified.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param state the state node to copy to clipboard and remove from model.
     * @param clipboard the Clipboard object the state node is copied to, may be null
     *
     * @throws IllegalArgumentException if the state argument or its container is null, or state
     * argument's kind attribute doesn't equal to PseudostateKind.FORK,
     * or fail to get the system clipboard
     */
    public CutForkNodeAction(Pseudostate state, Clipboard clipboard) {
        super(PRESENTATION_NAME, state, clipboard);

        Util.checkPseudostateKind(state, PseudostateKind.FORK);
    }
}
