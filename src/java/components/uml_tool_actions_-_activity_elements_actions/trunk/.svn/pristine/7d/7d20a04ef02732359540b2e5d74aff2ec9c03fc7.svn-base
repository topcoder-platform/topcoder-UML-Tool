/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;

/**
 * <p>
 * CopyForkNodeAction class extends CopyStateNodeAbstractAction abstract
 * class. This action is used specially to copy Pseudostate node with
 * kind attribute equal to PseudostateKind.FORK to the clipboard.
 * </p>
 *
 * <p>
 * Note, the Clipboard object passed in the constructor could be null,
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
public class CopyForkNodeAction extends CopyStateNodeAbstractAction {
    /**
     * <p>
     * Construct a CopyForkNodeAction with the Pseudostate and Clipboard specified.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param state the state node to copy to the clipboard.
     * @param clipboard the Clipboard object the state node is copied to, may be null
     *
     * @throws IllegalArgumentException if the state argument is null, or state
     * argument's kind attribute doesn't equal to PseudostateKind.FORK, or
     * fail to get the system clipboard when the given clipboard is null
     */
    public CopyForkNodeAction(Pseudostate state, Clipboard clipboard) {
        super(state, clipboard);

        Util.checkPseudostateKind(state, PseudostateKind.FORK);
    }
}
