/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.FinalState;
import java.awt.datatransfer.Clipboard;

/**
 * <p>
 * CutFlowFinalNodeAction class extends CutStateNodeAbstractAction abstract
 * class. This action is used specially to cut FinalState node with a tag
 * definition attached (TagDefinition("FinalNodeType").value="FlowFinalNode")
 * to the clipboard, this node will also be removed from its attached activity
 * graph.
 * </p>
 *
 * <p>
 * The Clipboard object passed in the constructor could be null, if so
 * the system Clipboard is used instead.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base-class is not
 * thread-safe, this class is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class CutFlowFinalNodeAction extends CutStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Flow Final Node";

    /**
     * <p>
     * Construct a CutFlowFinalNodeAction with the FinalState and Clipboard specified.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param state the state node to copy to clipboard and remove from model.
     * @param clipboard the Clipboard object the state node is copied to, may be null
     *
     * @throws IllegalArgumentException if the state argument or its container is null, or state argument's doesn't
     * have the tag definition (TagDefinition("FinalNodeType").value="FlowFinalNode"),
     * or fail to get the system clipboard
     */
    public CutFlowFinalNodeAction(FinalState state, Clipboard clipboard) {
        super(PRESENTATION_NAME, state, clipboard);

        if (!Util.checkTagDefinition(state, "FinalNodeType", "FlowFinalNode")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [FinalNodeType](The data value should be FlowFinalNode).");
        }
    }
}
