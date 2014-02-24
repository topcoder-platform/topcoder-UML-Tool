/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This class extends from <code>ObjectUndoableAction</code>. It provides the same functionality as
 * {@linkplain AddObjectAction} but it gets data from {@linkplain Transferable} instance and does not provide
 * initial formatting for the object.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class PasteObjectAction extends ObjectUndoableAction {

    /**
     * <p>
     * Represents human readable description of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Object";

    /**
     * <p>
     * Constructs <code>PasteObjectAction</code> with <code>transferable, collaboration</code>. The
     * namespace is set to the object retrieved from the Transferable.
     * </p>
     *
     * @param transferable
     *            Transferable instance, Cannot be <code>null</code>
     * @param collaboration
     *            Collaboration instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>transferable, collaboration</code> is <code>null</code>.
     * @throws SequenceConfigurationException
     *             if transferable contains incorrect data for this action (not Object instance)
     */
    public PasteObjectAction(Transferable transferable, Collaboration collaboration)
        throws SequenceConfigurationException {
        super(transferable);
        // check if collaboration is null
        Helper.checkObjectNotNull(collaboration, "collaboration in PasteObjectAction#PasteObjectAction");
        getObject().setNamespace(collaboration);
    }

    /**
     * <p>
     * This method provides adding Object instance to collaboration
     * </p>
     * <p>
     * If the Object is already present in the namespace, ActionExecutionException is thrown.
     * </p>
     *
     * @throws ActionExecutionException
     *             If the Object is already present in the namespace.
     */
    public void execute() throws ActionExecutionException {
        ObjectUtil objectUtil = getObjectUtil();
        // Check if given class instance already present in collaboration
        if (objectUtil.checkObjectNamespace(getObject())) {
            throw new ActionExecutionException("Object is already present in the namespace");
        } else {
            objectUtil.addObjectToCollaboration(getObject());
        }
    }

    /**
     * <p>
     * This method redo's the pasting of object to the collaboration. If the redo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getObjectUtil().addObjectToCollaboration(getObject());
            super.redo();
        } else {
            getLog().log(Level.WARN, "Cannot redo the 'Paste object' action");
        }
    }

    /**
     * <p>
     * This method undo's the pasting of object to the collaboration. If the undo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getObjectUtil().removeObjectFromCollaboration(getObject());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Cannot undo 'Paste Object' action");
        }
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
