/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import javax.swing.undo.UndoableEdit;

/**
 * <p>
 * This class implements the UndoableAction interface and used for testing only.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class DeleteClassAction implements UndoableAction {
    /**
     * <p>
     * This method implements the execute() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * Empty method.
     * </p>
     */
    public void execute() {
        // empty
    }

    /**
     * <p>
     * This method implements the undo() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * Empty method.
     * </p>
     */
    public void undo() {
        // empty
    }

    /**
     * <p>
     * This method implements the canUndo() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * This method always returns false.
     * </p>
     *
     * @return false
     */
    public boolean canUndo() {
        return false;
    }

    /**
     * <p>
     * This method implements the redo() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * Empty method.
     * </p>
     */
    public void redo() {
        // empty
    }

    /**
     * <p>
     * This method implements the canRedo() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * This method always returns false.
     * </p>
     *
     * @return false
     */
    public boolean canRedo() {
        return false;
    }

    /**
     * <p>
     * This method implements the die() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * Empty method.
     * </p>
     */
    public void die() {
        // empty
    }

    /**
     * <p>
     * This method implements the addEdit() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * This method always returns false.
     * </p>
     *
     * @param anEdit anEdit
     * @return false
     */
    public boolean addEdit(UndoableEdit anEdit) {
        return false;
    }

    /**
     * <p>
     * This method implements the replaceEdit() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * This method always returns false.
     * </p>
     *
     * @param anEdit anEdit
     * @return false
     */
    public boolean replaceEdit(UndoableEdit anEdit) {
        return false;
    }

    /**
     * <p>
     * This method implements the isSignificant() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * This method always returns false.
     * </p>
     *
     * @return false
     */
    public boolean isSignificant() {
        return false;
    }

    /**
     * <p>
     * This method implements the getPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the presentation name
     */
    public String getPresentationName() {
        return "DeleteClassAction";
    }

    /**
     * <p>
     * This method implements the getUndoPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the undo presentation name
     */
    public String getUndoPresentationName() {
        return "Undo:DeleteClassAction";
    }

    /**
     * <p>
     * This method implements the getRedoPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the redo presentation name
     */
    public String getRedoPresentationName() {
        return "Redo:DeleteClassAction";
    }

}
