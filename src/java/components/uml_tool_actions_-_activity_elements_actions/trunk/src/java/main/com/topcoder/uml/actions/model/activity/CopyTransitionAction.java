/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;
import com.topcoder.util.actionmanager.TransientAction;
import com.topcoder.uml.model.statemachines.Transition;

/**
 * <p>
 * CopyTransitionAction class implements the TransientAction interface.
 * It is used to copy the Transition object to the clipboard.
 * </p>
 *
 * <p>
 * Note, the Clipboard object passed in the constructor could be null,
 * if so the system Clipboard is used instead.
 * </p>
 *
 * <p>
 * Thread-safety: this class is immutable, but as the internal state
 * of state attribute could be changed externally, this class is not
 * guaranteed to be thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class CopyTransitionAction implements TransientAction {
    /**
     * <p>
     * Represents the Transition object to copy to clipboard in the execute method.
     * </p>
     *
     * <p>
     * Initialized in the constructor and never changed afterwards.
     * It must be non-null.
     * </p>
     */
    private final Transition transition;

    /**
     * <p>
     * Represents the Clipboard object the Transition object is copied to in the execute method.
     * </p>
     *
     * <p>
     * Initialized in constructor, and never changed afterwards.
     * It must be non-null.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * constructs the CopyTransitionAction with the given transition and clipboard.
     * </p>
     *
     * <p>
     * Note, if the given clipboard is null then the system Clipboard is used instead.
     * </p>
     *
     * @param transition the Transition object to copy to clipboard
     * @param clipboard the Clipboard object the Transition object is copied to, may be null
     *
     * @throws IllegalArgumentException if the transition argument is null,
     * or fail to get the system clipboard
     */
    public CopyTransitionAction(Transition transition, Clipboard clipboard) {
        Util.checkNull(transition, "transition");

        this.transition = transition;
        this.clipboard = clipboard == null ? Util.getSystemClipboard() : clipboard;
    }

    /**
     * <p>
     * Copy the Transition object to the clipboard.
     * </p>
     *
     * @throws ActivityObjectCloneException if the clone operation fails.
     */
    public void execute() throws ActivityObjectCloneException {
        ActivityObjectClipboardUtility.copyTransition(transition, clipboard);
    }
}
