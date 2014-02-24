/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import javax.swing.undo.UndoableEdit;

import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * This class implements the UndoableAction interface and used for testing only.
 * </p>
 *
 * @author lyt
 * @version 1.0
 */
public class MockAddClassMemberAction implements UndoableAction {
    /**
     * <p>
     * This method implements the execute() method defined in the UndoableAction interface.
     * </p>
     */
    public void execute() {
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
     * This method will always return true.
     * </p>
     *
     * @return true
     */
    public boolean canUndo() {
        return true;
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
     * This method will always return true.
     * </p>
     *
     * @return true
     */
    public boolean canRedo() {
        return true;
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
     * This method will always return false.
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
     * This method will always return false.
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
     * This method will always return true.
     * </p>
     *
     * @return true
     */
    public boolean isSignificant() {
        return true;
    }

    /**
     * <p>
     * This method implements the getPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the presentation name
     */
    public String getPresentationName() {
        return "Action";
    }

    /**
     * <p>
     * This method implements the getUndoPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the undo presentation name
     */
    public String getUndoPresentationName() {
        return "Undo";
    }

    /**
     * <p>
     * This method implements the getRedoPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the redo presentation name
     */
    public String getRedoPresentationName() {
        return "Redo";
    }

    /**
     * <p>
     * This method specifies whether the execute() method is called or not.
     * </p>
     *
     * @return true if the execute() method is called, otherwise false.
     */
    public boolean isExecuted() {
        return false;
    }

}
