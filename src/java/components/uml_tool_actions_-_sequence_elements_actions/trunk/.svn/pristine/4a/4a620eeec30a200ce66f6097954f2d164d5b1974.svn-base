/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;

/**
 * <p>
 * This class represents pasting of asynchronous message. The constructor validates the message type and the
 * class also contains a method to get the description of this action. All the logic are encapsulated in its
 * super class. It extends from <code>PasteMessageAction</code>.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class PasteAsynchronousMessageAction extends PasteMessageAction {

    /**
     * <p>
     * Represents human readable description of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Asynchronous Message";

    /**
     * <p>
     * Constructs <code>PasteAsynchronousMessageAction</code> with the provided <code>transferable</code>
     * and <code>collaboration</code>. It ensures that the given stimulus is of correct message type.
     * </p>
     *
     * @param transferable
     *            Transferable instance, Cannot be <code>null</code>
     * @param collaboration
     *            Collaboration instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>transferable, collaboration</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             if the instance of stimulus is incorrect for this action
     */
    public PasteAsynchronousMessageAction(Transferable transferable, Collaboration collaboration)
        throws SequenceConfigurationException {
        super(transferable, collaboration, CollaborationTransfer.ASYNCHRONOUS_MESSAGE_FLAVOR);
        // check the message type
        Helper.checkMessage(getMessageUtil(), getStimulus(), Helper.ASYNCHRONOUS_MESSAGE);
    }

    /**
     * <p>
     * Returns the description of this action.
     * </p>
     *
     * @return the string value describing this action.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }

}
