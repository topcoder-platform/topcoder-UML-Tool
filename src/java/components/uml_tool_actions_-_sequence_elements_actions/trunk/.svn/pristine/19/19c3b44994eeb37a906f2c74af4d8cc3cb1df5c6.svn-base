/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This class represents removing of create message. The constructor validates the message type and the class
 * also contains a method to get the description of this action. All the logic are encapsulated in its super
 * class. It extends from <code>RemoveMessageAction</code>.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class RemoveCreateMessageAction extends RemoveMessageAction {

    /**
     * <p>
     * Represents human readable description of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Create Message";

    /**
     * <p>
     * Constructs <code>RemoveCreateMessageAction</code> with <code>stimulus</code>. It ensures that the
     * given stimulus is of correct message type.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             when instance of stimulus is incorrect for this action
     */
    public RemoveCreateMessageAction(Stimulus stimulus) throws SequenceConfigurationException {
        super(stimulus);
        // check the message type
        Helper.checkMessage(getMessageUtil(), stimulus, Helper.CREATE_MESSAGE);
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
