/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class represents adding of synchronous message. The constructor validates the message type and the
 * class also contains a method to get the description of this action. All the logic are encapsulated in its
 * super class. It extends from <code>AddMessageAction</code>.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class AddSynchronousMessageAction extends AddMessageAction {

    /**
     * <p>
     * Represents human readable description of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Synchronous Message";

    /**
     * <p>
     * Constructs <code>AddSynchronousMessageAction</code> with
     * <code>stimulus, collaboration and manager</code>. It ensures that the given stimulus is of correct
     * message type.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @param collaboration
     *            Collaboration instance, Cannot be <code>null</code>
     * @param manager
     *            UMLModelManager instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the stimulus, collaboration or manager is <code>null</code>.
     * @throws SequenceConfigurationException
     *             when instance of stimulus is incorrect for this action
     */
    public AddSynchronousMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager)
        throws SequenceConfigurationException {
        // null check will be done in the super
        super(stimulus, collaboration, manager);
        // check the message type
        Helper.checkMessage(getMessageUtil(), stimulus, Helper.SYNCHRONOUS_MESSAGE);
    }

    /**
     * <p>
     * Returns "Add Synchronous Message" - Description of this action.
     * </p>
     *
     * @return description of this action.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
