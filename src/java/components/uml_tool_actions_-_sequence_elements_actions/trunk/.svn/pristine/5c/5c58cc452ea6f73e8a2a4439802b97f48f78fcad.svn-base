/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.actions.messagingactions.SendSignalAction;
import com.topcoder.uml.model.actions.messagingactions.SendSignalActionImpl;
import com.topcoder.uml.model.actions.objectactions.CreateObjectAction;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.actions.objectactions.DestroyObjectAction;
import com.topcoder.uml.model.actions.objectactions.DestroyObjectActionImpl;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;

/**
 * <p>
 * This class is base for implementation logic of each {@linkplain MessageUndoableAction} and
 * <code>CopyMessageAction</code> instance. It contains methods which provides ability to encapsulate all
 * operation with collaboration and clipboard. Its instance contains each action of component.
 * </p>
 * <p>
 * <b>Thread Safety :</b> Class is thread safe because it is immutable
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
final class MessageUtil {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public MessageUtil() {
        // Empty constructor
    }

    /**
     * <p>
     * Adds the stimulus to the collaboration.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public void addStimulusToCollaboration(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#addStimulusToCollaboration");
        // get the namespace of the stimulus
        Collaboration collaboration = (Collaboration) stimulus.getNamespace();
        // add the stimulus to the collaboration owned element
        collaboration.addOwnedElement(stimulus);
        // set communication link of the stimulus as the participating link for the instance sets in the
        // collaboration
        for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
            set.addParticipatingLink(stimulus.getCommunicationLink());
        }
    }

    /**
     * <p>
     * Removes the stimulus from the collaboration.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public void removeStimulusFromCollaboration(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#removeStimulusFromCollaboration");
        // get the namespace of the stimulus
        Collaboration collaboration = (Collaboration) stimulus.getNamespace();
        // remove the owned element stimulus from the namespace
        collaboration.removeOwnedElement(stimulus);
        // remove communication link of the stimulus as the participating link for the instance sets in the
        // collaboration
        for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
            set.removeParticipatingLink(stimulus.getCommunicationLink());
        }

    }

    /**
     * <p>
     * This method copies the stimulus to the given clipboard.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @param clipboard
     *            Clipboard instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus, clipboard</code> is <code>null</code>.
     */
    public void addStimulusToClipboard(Stimulus stimulus, Clipboard clipboard) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#addStimulusToClipboard");
        // check if clipboard is null
        Helper.checkObjectNotNull(clipboard, "clipboard in MessageUtil#addStimulusToClipboard");
        CollaborationTransfer transfer = new CollaborationTransfer(stimulus);
        clipboard.setContents(transfer, transfer);
    }

    /**
     * <p>
     * This method copies the given <code>stimulus</code> into a new instance and all the attributes would
     * be copied into it. There are some specific attributes to the relating to the owner which is not copied.
     * Below is the list of attributes that are not copied.
     * </p>
     * <p>
     * <ol>
     * <li>namespace</li>
     * <li>supplierDependencies</li>
     * <li>clientDependencies</li>
     * <li>comments</li>
     * <li>sender</li>
     * <li>receiver</li>
     * <li>communicationLink</li>
     * </ol>
     * <p>
     * And also should not be copied stimuli list from Procedure instance for this Stimulus. Note: it should
     * be deep copying. For each attribute should have separate object but not reference. See algorithm part
     * of specification
     * </p>
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @return created Stimulus instance
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public Stimulus copyStimulus(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#copyStimulus");
        Stimulus copyStimulus = new StimulusImpl();
        // copy the basic attributes
        Helper.copyBasicAttributes(stimulus, copyStimulus);
        // if there is a dispatch action, do a Bi directional aggregation
        if (stimulus.getDispatchAction() != null) {
            Procedure oldProcedure = stimulus.getDispatchAction();
            Procedure newProcedure = copyProcedure(oldProcedure);

            copyStimulus.setDispatchAction(newProcedure);
            newProcedure.addStimulus(copyStimulus);
        }

        // FIXME 10572
        Link link = stimulus.getCommunicationLink();
        Link copyLink = new LinkImpl();
        Helper.copyBasicAttributes(link, copyLink);
        copyStimulus.setCommunicationLink(copyLink);
        copyLink.addStimulus(copyStimulus);

        return copyStimulus;
    }

    /**
     * <p>
     * Copies given procedure to a new procedure.
     * </p>
     *
     * @param oldProcedure the old procedure
     * @return the new procedure
     */
    private Procedure copyProcedure(Procedure oldProcedure) {
        Procedure newProcedure = new ProcedureImpl();

        newProcedure.setLanguage(oldProcedure.getLanguage());
        newProcedure.setBody(oldProcedure.getBody());
        newProcedure.setList(oldProcedure.isList());
        newProcedure.setExpression(oldProcedure.getExpression());
        newProcedure.setMethod(oldProcedure.getMethod());

        Action oldAction = oldProcedure.getAction();
        if (oldAction != null) {
            Action newAction = copyAction(oldAction);
            newAction.setProcedure(newProcedure);
            newProcedure.setAction(newAction);
        }

        Helper.copyBasicAttributes(oldProcedure, newProcedure);
        return newProcedure;
    }

    /**
     * <p>
     * Copies given action to a new action.
     * </p>
     *
     * @param oldAction the old action
     * @return the new action
     */
    private Action copyAction(Action oldAction) {
        Action newAction = null;
        if (oldAction != null) {
            if (oldAction instanceof CreateObjectAction) {
                newAction = new CreateObjectActionImpl();
            } else if (oldAction instanceof DestroyObjectAction) {
                newAction = new DestroyObjectActionImpl();
            } else if (oldAction instanceof SendSignalAction) {
                newAction = new SendSignalActionImpl();
            } else if (oldAction instanceof CallOperationAction) {
                CallOperationAction oldCallOperationAction = (CallOperationAction) oldAction;
                CallOperationAction newCallOperationAction = new CallOperationActionImpl();
                newCallOperationAction.setOperation(oldCallOperationAction.getOperation());
                newCallOperationAction.setAsynchronous(oldCallOperationAction.isAsynchronous());
                newAction = newCallOperationAction;
            }
            Helper.copyBasicAttributes(oldAction, newAction);
        }
        return newAction;
    }

    /**
     * <p>
     * This method checks if Stimulus instance present in collaboration(namespace).
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @return true - if Stimulus instance present in collaboration, otherwise - false
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public boolean checkStimulusNamespace(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#checkStimulusNamespace");
        return stimulus.getNamespace().containsOwnedElement(stimulus);
    }

    /**
     * <p>
     * This method checks if Stimulus instance is &quot;Create Message&quot; message type. Create Message type
     * is given as a Stimulus with a Procedure that has a CreateObjectAction as the Action
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @return true if Stimulus is "Create Message" message type, otherwise false
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public boolean checkCreateMessage(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#checkCreateMessage");
        // return true, if the stimulus has a Dispatch Action and its action is of type CreateObjectAction
        return stimulus.getDispatchAction() != null
                && stimulus.getDispatchAction().getAction() instanceof CreateObjectAction;
    }

    /**
     * <p>
     * This method checks if Stimulus instance is &quot;Synchronous Message&quot; message type. Synchronous
     * Message type is given as a Stimulus with a Procedure that has a synchronous CallOperationAction as the
     * Action
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @return true if Stimulus is "Synchronous Message" message type, otherwise false
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public boolean checkSynchronousMessage(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#checkSynchronousMessage");
        // return true, if the stimulus has a Dispatch Action and its action is of type CallOperationAction
        // and CallOperationAction is synchronous
        return stimulus.getDispatchAction() != null
                && stimulus.getDispatchAction().getAction() instanceof CallOperationAction
                && !((CallOperationAction) stimulus.getDispatchAction().getAction()).isAsynchronous();
    }

    /**
     * <p>
     * This method checks if Stimulus instance is &quot;Asynchronous Message&quot; message type. Asynchronous
     * Message type is given as a Stimulus with a Procedure that has a asynchronous CallOperationAction as the
     * Action
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @return true if Stimulus is "Asynchronous Message" message type, otherwise false
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public boolean checkAsynchronousMessage(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#checkAsynchronousMessage");
        // return true, if the stimulus has a Dispatch Action and its action is of type CallOperationAction
        // and CallOperationAction is Asynchronous
        return stimulus.getDispatchAction() != null
                && stimulus.getDispatchAction().getAction() instanceof CallOperationAction
                && ((CallOperationAction) stimulus.getDispatchAction().getAction()).isAsynchronous();
    }

    /**
     * <p>
     * This method checks if Stimulus instance is &quot;Send Signal Message&quot; message type. Send Signal
     * Message type is give as a Stimulus with a Procedure that has a SendSignalAction as the Action.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @return true if Stimulus is "Send Signal Message" message type, otherwise false
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public boolean checkSendSignalMessage(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#checkSendSignalMessage");
        // return true, if the stimulus has a Dispatch Action and its action is of type SendSignalAction
        return stimulus.getDispatchAction() != null
                && stimulus.getDispatchAction().getAction() instanceof SendSignalAction;
    }

    /**
     * <p>
     * This method checks if Stimulus instance is &quot;Return Message&quot; message type. Return Message type
     * is give as a Stimulus with a Procedure that has no Action..
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @return true if Stimulus is "Return Message" message type, otherwise false
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public boolean checkReturnMessage(Stimulus stimulus) {
        // check if stimulus is null
        Helper.checkObjectNotNull(stimulus, "stimulus in MessageUtil#checkReturnMessage");
        // return true, if the stimulus has a Dispatch Action and its action is not null
        return stimulus.getDispatchAction() != null && stimulus.getDispatchAction().getAction() == null;
    }
}
