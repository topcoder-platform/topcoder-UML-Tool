/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;

import javax.swing.undo.CannotUndoException;
import javax.swing.undo.CompoundEdit;
import javax.swing.undo.UndoableEdit;
import javax.swing.undo.CannotRedoException;

/**
 * <p>
 * This class adapts a javax.swing.undo.CompoundEdit to be used as an UndoableAction.
 * Its purpose is to allow the javax.swing.undo.CompoundEdit to be used as an UndoableAction.
 * </p>
 *
 * <p>
 * The method in this adapter merely delegates calls to the instance of javax.swing.undo.CompoundEdit
 * it is adapting.
 * </p>
 *
 * <p>
 * This class follows the Adapter pattern.
 * </p>
 *
 * <p>
 * Thread-Safety: This class has mutable instance members and no synchronized access is made to these and
 * hence the class is not thread-safe. Also it delegates the methods to the corresponding methods on the
 * CompoundEdit instance it is enclosing and since the class CompoundEdit is not thread-safe, this class
 * is also not thread-safe.
 * </p>
 *
 * @author fastprogrammer, TCSDEVELOPER
 * @version 1.0
 */
public class CompoundUndoableAction implements UndoableAction {
    /**
     * <p>
     * Represents the instance of CompounEdit which this class adapts to/as an Undoable Action.
     * </p>
     *
     * <p>
     * This instance member will be initialized to a non-null value in the constructor and will be immutable
     * later on.
     * </p>
     */
    private final AdvancedCompoundEdit compoundEdit = new AdvancedCompoundEdit();

    /**
     * <p>
     * Represents a boolean value which indicates whether this instance of UndoableEdit is active or not.
     * </p>
     *
     * <p>
     * When inactive all the calls to the methods of this class like execute(), undo(), redo(), addEdit(),
     * replaceEdit() merely turn out to be a no-op. This instance member is initially set up with a value
     * of "true" and will be set to false when the method die() is called and will not change later on.
     * </p>
     *
     * <p>
     * This member is mutable.
     * </p>
     */
    private boolean isActive = true;

    /**
     * <p>
     * Represents the presentation name for this UndoableEdit instance.
     * </p>
     *
     * <p>
     * This member is used for servicing the methods getPresentationName(), getUndoPresentationName() and
     * getRedoPresentationName() defined by the UndoableEdit interface.
     * </p>
     *
     * <p>
     * This instance member is initialized with a non-null, non-empty String in the constructor and is
     * immutable later on.
     * </p>
     */
    private final String presentationName;

    /**
     * <p>
     * Represents the last exception that occurred during the execution of some method of this class.
     * </p>
     *
     * <p>
     * This instance member is overwritten with the newer Exception instance every time an
     * exception occurs.
     * </p>
     *
     * <p>
     * Note, the exception message is required to describe in detail what the exception is about
     * and when did it occur.
     * </p>
     *
     * <p>
     * This exception is returned when a call to the method getLastException() is made.
     * This instance member is mutable and can be null. [initially null, unless an exception occurs]
     * </p>
     */
    private Exception lastException;

    /**
     * <p>
     * Represents the instance of Log to be used for performing the logging of the exceptions whenever
     * exceptions [checked exceptions] are caught in the methods of this class.
     * </p>
     *
     * <p>
     * The Level of logging to be used here for doing the logging is Level.ERROR.
     * </p>
     *
     * <p>
     * Note, this instance member can be null indicating that no such logging needs to be done.
     * </p>
     *
     * <p>
     * This instance member is initialized in the constructor and is immutable later on.
     * </p>
     *
     */
    private final Log logger;

    /**
     * <p>
     * Constructs a new CompoundUndoableAction instance with presentation name specified.
     * </p>
     *
     * @param presentationName the presentationName to be returned by this Action
     * @throws IllegalArgumentException if the parameter "presentationName" passed is null or
     * an empty String on trimming
     */
    public CompoundUndoableAction(String presentationName) {
        this(presentationName, null);
    }

    /**
     * <p>
     * Constructs a new CompoundUndoableAction instance with presentation name and logger specified.
     * </p>
     *
     * <p>
     * Note, the parameter "logger" passed can be null indicating that no logging needs to be
     * done for the exceptions that are detected during the execution of methods of this class.
     * </p>
     *
     * @param presentationName the presentationName to be returned by this Action
     * @param logger the instance of Log to be used for performing the logging of any exception
     * that occurs [can be null to indicate no logging needs to be done]
     *
     * @throws IllegalArgumentException if the parameter "presentationName" passed is null or
     * an empty String on trimming
     */
    public CompoundUndoableAction(String presentationName, Log logger) {
        Util.checkString(presentationName, "presentationName");

        this.presentationName = presentationName;
        this.logger = logger;
    }

    /**
     * <p>
     * Executes this Action.
     * <p>
     *
     * <p>
     * If the die() method has been invoked, then ActionExecutionException will be thrown, logged and stored.
     * </p>
     *
     * <p>
     * In case there is any exception thrown in this method, it will be logged and stored.
     * </p>
     *
     * @throws ActionExecutionException if there are any problems in the execution of the all the UndoableAction
     * instances contained in this compound UndoableAction or this Action has been marked not to be used by
     * calling the die() method
     */
    public void execute() throws ActionExecutionException {
        // ends the progress if it is still in progress when invoking execute().
        if (compoundEdit.isInProgress()) {
            compoundEdit.end();
        }

        // check if the die() method is invoked before.
        // If the die() method has been called, then ActionExecutionException will be thrown, logged and stored.
        if (!isActive) {
            ActionExecutionException e = new ActionExecutionException(
                "The Action has been marked not to be used by calling the die() method, "
                    + "thrown in CompoundUndoableAction#execute() method");
            Util.logErrorMsg(logger, Level.ERROR, e);
            lastException = e;
            throw e;
        }

        // execute all the UndoableAction instances contained in this compound UndoableAction.
        UndoableAction[] actions = compoundEdit.getAllUndoableActions();
        try {
            for (int i = 0; i < actions.length; i++) {
                actions[i].execute();
            }
        } catch (ActionExecutionException e) {
            Util.logErrorMsg(logger, Level.ERROR, e);
            lastException = e;
            throw e;
        }
    }

    /**
     * <p>
     * Performs an undo of the Action.
     * </p>
     *
     * <p>
     * Note, this method will not throw any exception.
     * </p>
     */
    public void undo() {
        try {
            compoundEdit.undo();
        } catch (CannotUndoException e) {
            Util.logErrorMsg(logger, Level.ERROR, e);
            lastException = e;
        }
    }

    /**
     * <p>
     * Returns true if this Action can be un-done, else false.
     * </p>
     *
     * @return true if this Action can be un-done, else false.
     */
    public boolean canUndo() {
        return compoundEdit.canUndo();
    }

    /**
     * <p>
     * Performs a redo of the Action.
     * </p>
     *
     * <p>
     * Note, this method will not throw any exception.
     * </p>
     */
    public void redo() {
        try {
            compoundEdit.redo();
        } catch (CannotRedoException e) {
            Util.logErrorMsg(logger, Level.ERROR, e);
            lastException = e;
        }
    }

    /**
     * <p>
     * Returns true if this Action can be re-done, else false.
     * </p>
     *
     * @return true if this Action can be re-done, else false
     */
    public boolean canRedo() {
        return compoundEdit.canRedo();
    }

    /**
     * <p>
     * Signals the Action that it would not be used any more and so release any of the resources it might be holding.
     * </p>
     */
    public void die() {
        this.isActive = false;
        compoundEdit.die();
    }

    /**
     * <p>
     * Requests the CompoundUndoableAction to absorb "edit" parameter passed if it can.
     * </p>
     *
     * <p>
     * Returns true if "edit" parameter passed has been incorporated, false if it has not.
     * </p>
     *
     * @param edit the instance of UndoableEdit to be added
     * @return true if "edit" parameter passed has been incorporated, false if it has not.
     *
     * @throws IllegalArgumentException if the passed parameter is not an instance of UndoableAction
     * or is null
     */
    public boolean addEdit(UndoableEdit edit) {
        checkEdit(edit);

        return compoundEdit.addEdit(edit);
    }

    /**
     * <p>
     * This default implementation returns false always.
     * </p>
     *
     * @param edit the "edit" that can be replaced by this instance of CompoundEdit
     * @return false always
     *
     * @throws IllegalArgumentException if the passed parameter is not an instance of UndoableAction or is null
     */
    public boolean replaceEdit(UndoableEdit edit) {
        checkEdit(edit);

        return compoundEdit.replaceEdit(edit);
    }

    /**
     * <p>
     * Returns if this Action has significant changes that can be un-done()/re-done() or not.
     * </p>
     *
     * @return if this Action has significant changes that can be un-done()/re-done() or not.
     */
    public boolean isSignificant() {
        return compoundEdit.isSignificant();
    }

    /**
     * <p>
     * Returns the presentation name for the Action.
     * </p>
     *
     * @return the presentation name for the Action.
     */
    public String getPresentationName() {
        return presentationName;
    }

    /**
     * <p>
     * Returns the undo presentation name for the Action.
     * </p>
     *
     * @return the undo presentation name for the Action.
     */
    public String getUndoPresentationName() {
        return "Undo: " + presentationName;
    }

    /**
     * <p>
     * Returns the redo presentation name for the Action.
     * </p>
     *
     * @return the redo presentation name for the Action.
     */
    public String getRedoPresentationName() {
        return "Redo: " + presentationName;
    }

    /**
     * <p>
     * Returns the last exception that occurred during the methods of this Action. If no exception had occurred this
     * method will return null.
     * </p>
     *
     * @return the last exception that occurred during the methods of this Action or null if no exception has occurred
     */
    public Exception getLastException() {
        return lastException;
    }

    /**
     * <p>
     * This method performs checking for edit parameter.
     * </p>
     *
     * <p>
     * Note, null and type are checked.
     * </p>
     *
     * @param edit the undoable edit to be checked
     *
     * @throws IllegalArgumentException if the edit parameter is not an instance of UndoableAction or is null
     */
    private void checkEdit(UndoableEdit edit) {
        Util.checkNull(edit, "edit");
        if (!(edit instanceof UndoableAction)) {
            throw new IllegalArgumentException("The given edit parameter is not of UndoableAction type.");
        }
    }

    /**
     * <p>
     * This class extends the javax.swing.undo.CompoundEdit class and provides an additional method which
     * is required for servicing the functional requirements required by the CompoundUndoableAction like
     * getting the array of UndoableAction/UndoableEdit that is stored inside a CompoundEdit and which is
     * not exposed by the CompoundEdit class as such.
     * </p>
     *
     * <p>
     * Thread-Safety: This class has no members of its own but accesses the members from the super class
     * which is not thread-safe and hence this class is not thread-safe.
     * </p>
     *
     * @author fastprogrammer, TCSDEVELOPER
     * @version 1.0
     */
    private class AdvancedCompoundEdit extends CompoundEdit {
        /**
         * <p>
         * Default Constructor. It does nothing here.
         * </p>
         */
        public AdvancedCompoundEdit() {
            // empty
        }

        /**
         * <p>
         * Returns all the UndoableAction instances that are a part of this CompoundEdit instance.
         * </p>
         *
         * <p>
         * If no element is found then a zero length array is returned.
         * Note that none of the elements in the returned array will be null.
         * </p>
         *
         * @return all the UndoableAction instances that are a part of this CompoundEdit instance.
         */
        public UndoableAction[] getAllUndoableActions() {
            return this.edits.toArray(new UndoableAction[edits.size()]);
        }
    }
}
