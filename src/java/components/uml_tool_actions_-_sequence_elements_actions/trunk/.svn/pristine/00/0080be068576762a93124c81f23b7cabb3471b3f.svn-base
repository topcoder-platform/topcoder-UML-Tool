/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This abstract class provides the main logic for Add actions for all messages (execute, redo, undo). It
 * extends from {@linkplain MessageUndoableAction}. Provides adding stimulus to the collaboration and
 * applying its initial formatting by using {@link ProjectConfigurationManager}.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
abstract class AddMessageAction extends MessageUndoableAction {

    /**
     * <p>
     * Represents {@link UMLModelManager} reference for current action. Cannot be <code>null</code>. Set in
     * the constructor.
     * </p>
     */
    private final UMLModelManager manager;

    /**
     * <p>
     * Constructs the add message action using the <code>collaboration</code> and <code>manager</code>.
     * The namespace(collaboration) is added to the <code>stimulus</code> for processing.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @param collaboration
     *            Collaboration instance, Cannot be <code>null</code>
     * @param manager
     *            UMLModelManager instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the stimulus, collaboration, manager is <code>null</code>.
     */
    protected AddMessageAction(Stimulus stimulus, Collaboration collaboration, UMLModelManager manager) {
        super(stimulus);
        // check if collaboration is null
        Helper.checkObjectNotNull(collaboration, "collaboration in AddMessageAction#AddMessageAction");
        // set the namespace for the stimulus
        stimulus.setNamespace(collaboration);
        // check if manager is null
        Helper.checkObjectNotNull(manager, "manager in AddMessageAction#AddMessageAction");
        this.manager = manager;
    }

    /**
     * <p>
     * This method is the main method for adding messages. It first applies formatting using
     * {@link ProjectConfigurationManager} for the stimulus. If the stimulus is not added to the namespace, it
     * is added else exception will be thrown as it is already added.
     * </p>
     *
     * @throws ActionExecutionException
     *             if the message is already added to the namespace or any exception while formatting the
     *             stimulus.
     */
    public void execute() throws ActionExecutionException {
        MessageUtil messageUtil = getMessageUtil();
        // Check if applying formatting runs normal
        try {
            manager.getProjectConfigurationManager().applyInitialFormatting(manager.getProjectLanguage(),
                getStimulus());
        } catch (ProjectConfigurationException ex) {
            throw new ActionExecutionException("Occurred while applying initial formatting to the message", ex);
        } catch (IllegalStateException ex) {
            throw new ActionExecutionException("Occurred while applying initial formatting to the message,"
                    + " configuration manager not set for model manager", ex);
        }
        // Check if given class instance already present in collaboration
        if (messageUtil.checkStimulusNamespace(getStimulus())) {
            throw new ActionExecutionException("The message already exists in the Namespace");
        } else {
            messageUtil.addStimulusToCollaboration(getStimulus());
        }
    }

    /**
     * <p>
     * This method redo's the adding of stimulus to the collaboration. If the redo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getMessageUtil().addStimulusToCollaboration(getStimulus());
            super.redo();
        } else {
            getLog().log(Level.WARN, "Cannot redo the 'Add Message' action");
        }
    }

    /**
     * <p>
     * This method undo's the adding of stimulus to the collaboration. If the undo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getMessageUtil().removeStimulusFromCollaboration(getStimulus());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Cannot undo 'Add Message' action");
        }
    }
}
