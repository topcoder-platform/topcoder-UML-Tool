/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.actions.messagingactions.SendSignalAction;
import com.topcoder.uml.model.actions.messagingactions.SendSignalActionImpl;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;

/**
 * <p>
 * Accuracy test helper class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class AccuracyTestHelper {

    /**
     * <p>
     * Private constructor preventing instantiation.
     * </p>
     */
    private AccuracyTestHelper() {
    }

    /**
     * <p>
     * Creates <code>{@link Stimulus}</code> instance for asynchronous
     * message.
     * </p>
     *
     * @return the <code>Stimulus</code> instance
     */
    public static Stimulus createStimulusForAsynchronousMessage() {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setNamespace(new CollaborationImpl());
        stimulus.getNamespace().addOwnedElement(stimulus);
        Procedure dispatchAction = new ProcedureImpl();
        CallOperationAction callOperationAction = new CallOperationActionImpl();
        callOperationAction.setAsynchronous(true);
        dispatchAction.setAction(callOperationAction);
        stimulus.setDispatchAction(dispatchAction);

        return stimulus;
    }

    /**
     * <p>
     * Creates <code>{@link Stimulus}</code> instance for synchronous message.
     * </p>
     *
     * @return the <code>Stimulus</code> instance
     */
    public static Stimulus createStimulusForSynchronousMessage() {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setNamespace(new CollaborationImpl());
        stimulus.getNamespace().addOwnedElement(stimulus);
        Procedure dispatchAction = new ProcedureImpl();
        CallOperationAction callOperationAction = new CallOperationActionImpl();
        callOperationAction.setAsynchronous(false);
        dispatchAction.setAction(callOperationAction);
        stimulus.setDispatchAction(dispatchAction);

        return stimulus;
    }

    /**
     * <p>
     * Creates <code>{@link Stimulus}</code> instance for create message.
     * </p>
     *
     * @return the <code>Stimulus</code> instance
     */
    public static Stimulus createStimulusForCreateMessage() {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setNamespace(new CollaborationImpl());
        stimulus.getNamespace().addOwnedElement(stimulus);
        Procedure dispatchAction = new ProcedureImpl();
        CreateObjectAction createObjectAction = new CreateObjectActionImpl();
        dispatchAction.setAction(createObjectAction);
        stimulus.setDispatchAction(dispatchAction);

        return stimulus;
    }

    /**
     * <p>
     * Creates <code>{@link Stimulus}</code> instance for return message.
     * </p>
     *
     * @return the <code>Stimulus</code> instance
     */
    public static Stimulus createStimulusForReturnMessage() {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setNamespace(new CollaborationImpl());
        stimulus.getNamespace().addOwnedElement(stimulus);
        Procedure dispatchAction = new ProcedureImpl();
        dispatchAction.setAction(null);
        stimulus.setDispatchAction(dispatchAction);

        return stimulus;
    }

    /**
     * <p>
     * Creates <code>{@link Stimulus}</code> instance for send signal message.
     * </p>
     *
     * @return the <code>Stimulus</code> instance
     */
    public static Stimulus createStimulusForSendSignalMessage() {
        Stimulus stimulus = new StimulusImpl();
        stimulus.setNamespace(new CollaborationImpl());
        stimulus.getNamespace().addOwnedElement(stimulus);
        Procedure dispatchAction = new ProcedureImpl();
        SendSignalAction sendSignalAction = new SendSignalActionImpl();
        dispatchAction.setAction(sendSignalAction);
        stimulus.setDispatchAction(dispatchAction);

        return stimulus;
    }
}
