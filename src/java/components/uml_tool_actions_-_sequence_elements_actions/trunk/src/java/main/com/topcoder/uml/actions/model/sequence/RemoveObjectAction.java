/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This class extends from <code>ObjectUndoableAction</code> and provides functionality to remove Object
 * instance from collaboration. It also provides the functionality to do redo and undo of removing.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class RemoveObjectAction extends ObjectUndoableAction {

    /**
     * <p>
     * Represents human readable description of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove Object";

    /**
     * <p>
     * Constructs <code>RemoveObjectAction</code> with the given <code>object</code>.
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>object</code> is <code>null</code>.
     */
    public RemoveObjectAction(Object object) {
        super(object);
    }

    /**
     * <p>
     * Removes the object from the namespace.
     * </p>
     * <p>
     * If the object is not present in the namespace, ActionExecutionException is thrown.
     * </p>
     *
     * @throws ActionExecutionException
     *             If the object is not present in the namespace.
     */
    public void execute() throws ActionExecutionException {
        ObjectUtil objectUtil = getObjectUtil();
        // Check if given class instance already present in collaboration
        if (objectUtil.checkObjectNamespace(getObject())) {
            objectUtil.removeObjectFromCollaboration(getObject());
        } else {
            throw new ActionExecutionException("The given object is not present in the namespace");
        }
    }

    /**
     * <p>
     * This method redo's the removing of object from the collaboration. If the redo is not possible, a
     * warning message is written to the log file.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getObjectUtil().removeObjectFromCollaboration(getObject());
            super.redo();
        } else {
            getLog().log(Level.WARN, "Cannot undo 'Remove Object' action");
        }
    }

    /**
     * <p>
     * This method undo's the removing of object from the collaboration. If the undo is not possible, a
     * warning message is written to the log file.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getObjectUtil().addObjectToCollaboration(getObject());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Cannot redo the 'Remove object' action");
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
