/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This class represents copying of send signal message. The constructor validates the message type. All the
 * logic are encapsulated in its super class. It extends from <code>CopyMessageAction</code>.
 * </p>
 * <p>
 * <b>Thread Safety :</b> Class is thread safe because it is immutable
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class CopySendSignalMessageAction extends CopyMessageAction {

    /**
     * <p>
     * Constructs <code>CopySendSignalMessageAction</code> with the provided <code>stimulus</code>. It
     * ensures that the given stimulus is of correct message type. System Clipboard is used by default.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             when instance of stimulus is incorrect for this action
     */
    public CopySendSignalMessageAction(Stimulus stimulus) throws SequenceConfigurationException {
        super(stimulus);
        // check the message type
        Helper.checkMessage(getMessageUtil(), stimulus, Helper.SEND_SIGNAL_MESSAGE);
    }

    /**
     * <p>
     * Constructs <code>CopySendSignalMessageAction</code> with the provided
     * <code>stimulus and clipboard</code>. It ensures that the given stimulus is of correct message type.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @param clipboard
     *            Clipboard clipboard, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus, clipboard</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             when instance of stimulus is incorrect for this action
     */
    public CopySendSignalMessageAction(Stimulus stimulus, Clipboard clipboard)
        throws SequenceConfigurationException {
        super(stimulus, clipboard);
        // check the message type
        Helper.checkMessage(getMessageUtil(), stimulus, Helper.SEND_SIGNAL_MESSAGE);
    }
}
