/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;
import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * CutSendSignalActionAction class extends CutStateNodeAbstractAction abstract
 * class. This action is used specially to cut SimpleState node with a tag
 * definition attached (TagDefinition("SendSignalAction").value="True") to
 * the clipboard, this node will also be removed from its attached activity
 * graph.
 * </p>
 *
 * <p>
 * The Clipboard object passed in the constructor could be null, if
 * so the system Clipboard is used instead.
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
public class CutSendSignalActionAction extends CutStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Send Signal Action";

    /**
     * <p>
     * Construct a CutSendSignalActionAction with the SimpleState and Clipboard specified.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param state the state node to copy to clipboard and remove from model.
     * @param clipboard the Clipboard object the state node is copied to, may be null
     *
     * @throws IllegalArgumentException if the state argument or its container is null, or state doesn't
     * have the tag definition (TagDefinition("SendSignalAction").value="True"),
     * or fail to get the system clipboard
     */
    public CutSendSignalActionAction(SimpleState state, Clipboard clipboard) {
        super(PRESENTATION_NAME, state, clipboard);

        if (!Util.checkTagDefinition(state, "SendSignalAction", "True")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [SendSignalAction](The data value should be True).");
        }
    }
}
