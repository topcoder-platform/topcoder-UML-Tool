/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This class extends from <code>ObjectUndoableAction</code> and provides functionality to cut(copy+remove)
 * Object instance from model. Also it has ability to use redo and undo of cutting
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class CutObjectAction extends ObjectUndoableAction {

    /**
     * <p>
     * Represents human readable description of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Cut Object";

    /**
     * <p>
     * Represents Clipboard for this action. Cannot be <code>null</code> and it is set in constructor
     * </p>
     */
    private final Clipboard clipboard;

    /**
     * <p>
     * Constructs <code>CutObjectAction</code> with the passed <code>object</code> and the clipboard to
     * the system Clipboard.
     * <p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @throws IllegalArgumentException
     *             if the <code>object</code> is <code>null</code>.
     */
    public CutObjectAction(Object object) {
        super(object);
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * <p>
     * Constructs <code>CutObjectAction</code> with the passed <code>object</code> and the
     * <code>clipboard</code>.
     * <p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>;
     * @param clipboard
     *            Clipboard instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>object, clipboard</code> is <code>null</code>.
     */
    public CutObjectAction(Object object, Clipboard clipboard) {
        super(object);
        // check if clipboard is null
        Helper.checkObjectNotNull(clipboard, "clipboard in CutObjectAction#CutObjectAction");
        this.clipboard = clipboard;
    }

    /**
     * <p>
     * This method cuts the object the from the collaboration.
     * </p>
     * <p>
     * This method basically copies the object to the clipboard and then removes the instance from the
     * namespace
     * </p>
     *
     * @throws ActionExecutionException
     *             if the object is not present in the namespace.
     */
    public void execute() throws ActionExecutionException {
        ObjectUtil objectUtil = getObjectUtil();
        // copy to the clipboard
        objectUtil.addObjectToClipboard(getObjectUtil().copyObject(getObject()), clipboard);
        // remove if present
        if (objectUtil.checkObjectNamespace(getObject())) {
            objectUtil.removeObjectFromCollaboration(getObject());
        } else {
            throw new ActionExecutionException("The object is not present in the namespace");
        }
    }

    /**
     * <p>
     * This method redo's the cutting of object from the collaboration. If the redo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getObjectUtil().removeObjectFromCollaboration(getObject());
            super.redo();
        } else {
            getLog().log(Level.WARN, "Cannot redo 'Cut Object' action");
        }
    }

    /**
     * <p>
     * This method undo's the cutting of object to the collaboration. If the undo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getObjectUtil().addObjectToCollaboration(getObject());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Cannot undo 'Cut Object' action");
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
