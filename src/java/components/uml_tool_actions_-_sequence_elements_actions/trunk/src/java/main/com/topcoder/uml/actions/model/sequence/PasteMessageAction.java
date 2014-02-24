/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This abstract class provides all logic for Paste actions for all messages (execute, redo, undo). It extends
 * from {@linkplain MessageUndoableAction}. Functionality is the same as for <code>AddMessageAction</code>
 * but data is got from {@linkplain Transferable} object and does not apply initial formatting to the object.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
abstract class PasteMessageAction extends MessageUndoableAction {

    /**
     * <p>
     * Constructs <code>PasteMessageAction</code> with <code>transferable, collaboration, dataFlavor</code>.
     * The namespace is added to added to the stimulus instance from the super.
     * </p>
     *
     * @param transferable
     *            Transferable instance, Cannot be <code>null</code>
     * @param collaboration
     *            Collaboration instance, Cannot be <code>null</code>
     * @param dataFlavor
     *            DataFlavor instance, Cannot be <code>null</code>
     * @throws SequenceConfigurationException
     *             any exception while calling the super
     * @throws IllegalArgumentException
     *             if the <code>transferable, collaboration, dataFlavor</code> is <code>null</code>.
     */
    protected PasteMessageAction(Transferable transferable, Collaboration collaboration, DataFlavor dataFlavor)
        throws SequenceConfigurationException {
        super(transferable, dataFlavor);
        // check if collaboration is null
        Helper.checkObjectNotNull(collaboration, "collaboration in PasteMessageAction#PasteMessageAction");
        getStimulus().setNamespace(collaboration);
    }

    /**
     * <p>
     * This method provides adding Stimulus instance to collaboration
     * </p>
     * <p>
     * If the message is already present in the namespace, ActionExecutionException is thrown.
     * </p>
     *
     * @throws ActionExecutionException
     *             If the message is already present in the namespace.
     */
    public void execute() throws ActionExecutionException {
        MessageUtil messageUtil = getMessageUtil();
        // Check if given class instance already present in collaboration
        if (messageUtil.checkStimulusNamespace(getStimulus())) {
            throw new ActionExecutionException("Stimulus already exists in the Namespace");
        } else {
            messageUtil.addStimulusToCollaboration(getStimulus());
        }
    }

    /**
     * <p>
     * This method redo's the pasting of stimulus to the collaboration. If the redo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getMessageUtil().addStimulusToCollaboration(getStimulus());
            super.redo();
        } else {
            getLog().log(Level.WARN, "Cannot redo the 'Paste Message' action");
        }
    }

    /**
     * <p>
     * This method undo's the pasting of stimulus to the collaboration. If the undo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getMessageUtil().removeStimulusFromCollaboration(getStimulus());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Cannot undo 'Paste Message' action");
        }
    }

}
