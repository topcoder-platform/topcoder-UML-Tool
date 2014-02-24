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
public class AddClassDiagramAction implements UndoableAction {
    /**
     * <p>
     * The boolean flag to specify whether the redo() method is called or not.
     * Default value is false, and is set in the redo() method.
     * </p>
     */
    private boolean redoCalled = false;

    /**
     * <p>
     * The boolean flag to specify whether the undo() method is called or not.
     * Default value is false, and is set in the undo() method.
     * </p>
     */
    private boolean undoCalled = false;

    /**
     * <p>
     * The boolean flag to specify whether the execute() method is called or not.
     * Default value is false, and is set in the execute() method.
     * </p>
     */
    private boolean executed = false;

    /**
     * <p>
     * This method implements the execute() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * This method will set the "executed" flag to true and when the system property value of "execute"
     * is "exception", ActionExecutionException will be thrown.
     * </p>
     *
     * @throws ActionExecutionException if the system property value of "execute" is "exception"
     */
    public void execute() throws ActionExecutionException {
        executed = true;

        if ("exception".equals(System.getProperty("execute"))) {
            throw new ActionExecutionException("exception");
        }
    }

    /**
     * <p>
     * This method implements the undo() method defined in the UndoableAction interface.
     * </p>
     *
     * <p>
     * This method will set the "undoCalled" flag to true.
     * </p>
     */
    public void undo() {
        undoCalled = true;
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
     * This method will set the "redoCalled" flag to true.
     * </p>
     */
    public void redo() {
        redoCalled = true;
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
     * This method will always return true when the system property value of "isSignificant" is "true",
     * otherwise false.
     * </p>
     *
     * @return true when the system property value of "isSignificant" is "true", otherwise false.
     */
    public boolean isSignificant() {
        if ("true".equals(System.getProperty("isSignificant"))) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * This method implements the getPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the presentation name.
     */
    public String getPresentationName() {
        return "AddClassDiagramAction";
    }

    /**
     * <p>
     * This method implements the getUndoPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the undo presentation name.
     */
    public String getUndoPresentationName() {
        return "Redo : AddClassDiagramAction";
    }

    /**
     * <p>
     * This method implements the getRedoPresentationName() method defined in the UndoableAction interface.
     * </p>
     *
     * @return the redo presentation name.
     */
    public String getRedoPresentationName() {
        return "Undo : AddClassDiagramAction";
    }

    /**
     * <p>
     * This method specifies whether the redo() method is called or not.
     * </p>
     *
     * @return true if the redo() method is called, otherwise false.
     */
    public boolean isRedoCalled() {
        return redoCalled;
    }

    /**
     * <p>
     * This method specifies whether the undo() method is called or not.
     * </p>
     *
     * @return true if the undo() method is called, otherwise false.
     */
    public boolean isUndoCalled() {
        return undoCalled;
    }

    /**
     * <p>
     * This method specifies whether the execute() method is called or not.
     * </p>
     *
     * @return true if the execute() method is called, otherwise false.
     */
    public boolean isExecuted() {
        return executed;
    }
}
