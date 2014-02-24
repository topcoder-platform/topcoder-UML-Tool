/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;
import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * CopyAcceptEventActionAction class extends CopyStateNodeAbstractAction abstract
 * class. This action is used specially to copy SimpleState node with a tag
 * definition attached (TagDefinition("AcceptEventAction").value="True") to
 * the clipboard.
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
public class CopyAcceptEventActionAction extends CopyStateNodeAbstractAction {
    /**
     * <p>
     * Construct a CopyAcceptEventActionAction with the SimpleState and Clipboard specified.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param state the state node to copy to the clipboard.
     * @param clipboard the Clipboard object the state node is copied to, may be null.
     *
     * @throws IllegalArgumentException if the state argument is null, or state doesn't
     * have the tag definition (TagDefinition("AcceptEventAction").value="True"), or
     * fail to get the system clipboard when the given clipboard is null
     */
    public CopyAcceptEventActionAction(SimpleState state, Clipboard clipboard) {
        super(state, clipboard);

        if (!Util.checkTagDefinition(state, "AcceptEventAction", "True")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [AcceptEventAction](The data value should be True).");
        }
    }
}
