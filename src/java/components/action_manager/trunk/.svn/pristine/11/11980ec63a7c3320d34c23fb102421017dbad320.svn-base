/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.stresstests;

import javax.swing.undo.UndoableEdit;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * This is a simple implementation of <code>UndoableAction</code> used for
 * stress test.
 * @author fuyun
 * @version 1.0
 */
public class MyUndoableAction implements UndoableAction {

    /**
     * Represents the flag denoting whether to throw exception in
     * <code>execute()</code> method.
     */
    private boolean isThrowException = false;

    /**
     * Stress test for method <code>execute()</code>.
     * @throws ActionExecutionException if isThrowException is set.
     */
    public void execute() throws ActionExecutionException {
        if (isThrowException) {
            throw new ActionExecutionException("Dummy exception.");
        }
    }

    /**
     * Sets the flag which used to denote whether to throw exception in execute
     * method.
     * @param isThrowException whether to throw exception in execute method.
     */
    public void setThrowException(boolean isThrowException) {
        this.isThrowException = isThrowException;
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     * @param anEdit the edit to add.
     * @return false.
     */
    public boolean addEdit(UndoableEdit anEdit) {
        return false;
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     * @return true.
     */
    public boolean canRedo() {
        return true;
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     * @return true.
     */
    public boolean canUndo() {
        return true;
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     */
    public void die() {
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     * @return the string "MyUndoableAction".
     */
    public String getPresentationName() {
        return "MyUndoableAction";
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     * @return the string "Redo:MyUndoableAction".
     */
    public String getRedoPresentationName() {
        return "Redo:MyUndoableAction";
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     * @return the string "Undo:MyUndoableAction".
     */
    public String getUndoPresentationName() {
        return "Undo:MyUndoableAction";
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     * @return true.
     */
    public boolean isSignificant() {
        return true;
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     */
    public void redo() {
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     * @param edit the edit to replace.
     * @return false.
     */
    public boolean replaceEdit(UndoableEdit edit) {
        return false;
    }

    /**
     * <p>
     * Simple implementation of the corresponding method in interface.
     * </p>
     */
    public void undo() {
    }

}
