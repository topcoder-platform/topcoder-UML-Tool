/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This abstract class provides all logic for Remove actions for all messages (execute, redo, undo). It
 * extends from {@linkplain MessageUndoableAction}. Provides method for removing stimulus from the
 * collaboration.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
abstract class RemoveMessageAction extends MessageUndoableAction {

    /**
     * <p>
     * Constructs <code>RemoveMessageAction</code> with <code>stimulus</code>.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    protected RemoveMessageAction(Stimulus stimulus) {
        super(stimulus);
    }

    /**
     * <p>
     * Removes the stimulus from the namespace.
     * </p>
     * <p>
     * If the stimulus is not present in the namespace, ActionExecutionException is thrown.
     * </p>
     *
     * @throws ActionExecutionException
     *             If the stimulus is not present in the namespace.
     */
    public void execute() throws ActionExecutionException {
        MessageUtil messageUtil = getMessageUtil();
        // Check if given class instance already present in collaboration
        if (messageUtil.checkStimulusNamespace(getStimulus())) {
            messageUtil.removeStimulusFromCollaboration(getStimulus());
        } else {
            throw new ActionExecutionException("The stimulus is not present in the namespace");
        }
    }

    /**
     * <p>
     * This method redo's the removing of stimulus from the collaboration. If the redo is not possible, a
     * warning message is written to the log file.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getMessageUtil().removeStimulusFromCollaboration(getStimulus());
            super.redo();
        } else {
            getLog().log(Level.WARN, "Cannot redo the 'Remove Message' action");
        }
    }

    /**
     * <p>
     * This method undo's the removing of stimulus from the collaboration. If the undo is not possible, a
     * warning message is written to the log file.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getMessageUtil().addStimulusToCollaboration(getStimulus());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Cannot undo 'Remove Message' action");
        }
    }
}
