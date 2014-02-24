/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.accuracytests;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * Dummy implementation of <code>UndoableAction</code>.
 */
public class DummyUndoableAction implements UndoableAction {

    /**
     * N/A.
     *
     * @throws ActionExecutionException
     *             N/A.
     */
    public void execute() throws ActionExecutionException {
    }

    public void undo() throws CannotUndoException {
    }

    public boolean canUndo() {
        return false;
    }

    public void redo() throws CannotRedoException {
    }

    public boolean canRedo() {
        return false;
    }

    public void die() {
    }

    public boolean addEdit(UndoableEdit anEdit) {
        return false;
    }

    public boolean replaceEdit(UndoableEdit anEdit) {
        return false;
    }

    public boolean isSignificant() {
        return false;
    }

    public String getPresentationName() {
        return null;
    }

    public String getUndoPresentationName() {
        return null;
    }

    public String getRedoPresentationName() {
        return null;
    }

}
