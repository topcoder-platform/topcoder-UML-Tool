/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * This abstract class provides the main logic for Copy actions for all messages (execute) and contains all
 * attributes which are common for them. It implements {@linkplain TransientAction} interface. This class has
 * methods for copying the stimulus to Clipboard and getting the <code>MessageUtil</code> class.
 * </p>
 * <p>
 * <b>Thread Safety :</b> Class is thread safe because it is immutable.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
abstract class CopyMessageAction implements TransientAction {

    /**
     * <p>
     * Represents Stimulus instance for current action. Cannot be <code>null</code> and it is set in constructor.
     * </p>
     */
    private final Stimulus stimulus;

    /**
     * <p>
     * Represents Clipboard for this action. Cannot be <code>null</code> and it is set in constructor.
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Represents {@link MessageUtil} instance for current action.
     * </p>
     */
    private final MessageUtil messageUtil = new MessageUtil();

    /**
     * <p>
     * Constructs <code>CopyMessageAction</code> with the passed <code>stimulus</code> and the clipboard
     * to the system Clipboard.
     * <p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the stimulus is <code>null</code>.
     */
    protected CopyMessageAction(Stimulus stimulus) {
        this(stimulus, Toolkit.getDefaultToolkit().getSystemClipboard());
    }

    /**
     * <p>
     * Constructs <code>CopyMessageAction</code> with the passed <code>stimulus</code> and the
     * <code>clipboard</code>.
     * <p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @param clipboard
     *            Clipboard instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the stimulus, clipboard is <code>null</code>.
     */
    protected CopyMessageAction(Stimulus stimulus, Clipboard clipboard) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in CopyMessageAction#CopyMessageAction");
        // check if clipboard is null
        Helper.checkObjectNotNull(clipboard, "clipboard in CopyMessageAction#CopyMessageAction");
        this.stimulus = messageUtil.copyStimulus(stimulus);
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * This method adds the stimulus to the clipboard instance.
     * </p>
     */
    public void execute() {
        messageUtil.addStimulusToClipboard(stimulus, clipboard);
    }

    /**
     * <p>
     * Returns the messageUtil for this instance. This method is used in the sub classes extending this class.
     * </p>
     *
     * @return messageUtil attribute, Cannot be <code>null</code>
     */
    protected MessageUtil getMessageUtil() {
        return messageUtil;
    }
}
