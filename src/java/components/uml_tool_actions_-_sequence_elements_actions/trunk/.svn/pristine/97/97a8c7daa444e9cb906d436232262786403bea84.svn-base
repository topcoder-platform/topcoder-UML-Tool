/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This abstract class provides the main logic for Cut actions for all messages (execute, redo, undo). It
 * extends from {@linkplain MessageUndoableAction}. Provides cutting stimulus from collaboration and copying
 * it to clipboard
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
abstract class CutMessageAction extends MessageUndoableAction {

    /**
     * <p>
     * Represents Clipboard for this action. Cannot be <code>null</code> and it is set in constructor
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Constructs <code>CutMessageAction</code> with the passed <code>stimulus</code> and the clipboard to
     * the system Clipboard.
     * <p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    protected CutMessageAction(Stimulus stimulus) {
        super(stimulus);
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * <p>
     * Constructs <code>CutMessageAction</code> with the passed <code>stimulus</code> and the
     * <code>clipboard</code>.
     * <p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @param clipboard
     *            Clipboard instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus, clipboard</code> is <code>null</code>.
     */
    protected CutMessageAction(Stimulus stimulus, Clipboard clipboard) {
        super(stimulus);
        // check if clipboard is null
        Helper.checkObjectNotNull(clipboard, "clipboard in CutMessageAction#CutMessageAction");
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * This method cuts the stimulus the from the collaboration.
     * </p>
     * <p>
     * This method basically copies the stimulus to the clipboard and then removes the instance from the
     * namespace
     * </p>
     *
     * @throws ActionExecutionException
     *             if the stimulus is not present in the namespace.
     */
    public void execute() throws ActionExecutionException {
        MessageUtil messageUtil = getMessageUtil();
        // copy the stimulus to the clipboard
        messageUtil.addStimulusToClipboard(getMessageUtil().copyStimulus(getStimulus()), clipboard);
        // if it is present remove the stimulus
        if (messageUtil.checkStimulusNamespace(getStimulus())) {
            messageUtil.removeStimulusFromCollaboration(getStimulus());
        } else {
            throw new ActionExecutionException("The message is not present in the namespace.");
        }
    }

    /**
     * <p>
     * This method redo's the cutting of stimulus from collaboration. If the redo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getMessageUtil().removeStimulusFromCollaboration(getStimulus());
            super.redo();
        } else {
            getLog().log(Level.WARN, "Cannot redo 'Cut Message' action");
        }
    }

    /**
     * <p>
     * This method undo's the cutting of stimulus to the collaboration. If the undo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getMessageUtil().addStimulusToCollaboration(getStimulus());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Cannot undo 'Cut Message' action");
        }
    }
}
