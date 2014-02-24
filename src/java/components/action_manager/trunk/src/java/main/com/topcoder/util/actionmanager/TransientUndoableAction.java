/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import javax.swing.undo.UndoableEdit;

/**
 * <p>
 * This class adapts a TransientAction, to be used as a non-significant UndoableAction.
 * </p>
 *
 * <p>
 * Its purpose is to allow the TransientAction to be used inside a CompoundUndoableAction.
 * </p>
 *
 * <p>
 * This class follows the Adapter pattern.
 * </p>
 *
 * <p>
 * Example of usage: the cut undoable action is composed by a transient copy action and an undoable remove action.
 * In order to be able to create a single undoable action for the cut action, and avoid creating a new class, the
 * action will be a compound undoable action, containing the non-significant undoable copy action and the undoable
 * remove action.
 * </p>
 *
 * <p>
 * Thread-Safety: This class has mutable instance members and no synchronized access is made to these and hence
 * the class is not thread-safe. Also it provides methods for executing the TransientAction it is adapting and
 * the TransientAction might not be thread-safe.
 * </p>
 *
 * @author fastprogrammer, TCSDEVELOPER
 * @version 1.0
 */
public class TransientUndoableAction implements UndoableAction {
    /**
     * <p>
     * Represents the instance of Transient Action which this class adapts to/as an Undoable Action.
     * </p>
     *
     * <p>
     * This instance member will be initialized to a non-null value in the constructor and will be immutable
     * later on.
     * </p>
     */
    private final TransientAction originalAction;

    /**
     * <p>
     * Represents a boolean value which indicates whether this instance of UndoableEdit is active or not.
     * </p>
     *
     * <p>
     * When inactive all the calls to the methods of this class like execute(), undo(), redo(), addEdit(),
     * replaceEdit() merely turn out to be a no-op.
     * </p>
     *
     * <p>
     * This instance member is initially set up with a value of "true" and will be set to false when the method die()
     * is called and will not change later on. This member is mutable.
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
     * <p
     * This instance member is initialized with a non-null, non-empty String in the constructor and is immutable
     * later on.
     * </p>
     */
    private final String presentationName;

    /**
     * <p>
     * Represents the last exception that occurred during the execution of some method of this class.
     * </p>
     *
     * <p>
     * This instance member is overwritten with the newer ActionExecutionException instance every time an
     * exception occurs.
     * </p>
     *
     * <p>
     * Note, the exception message is required to describe in detail what the exception is about
     * and when did it occur. This exception is returned when a call to the method getLastException() is made.
     * </p>
     *
     * <p>
     * This instance member is mutable and can be null. [initially null, unless an exception occurs]
     * </p>
     */
    private ActionExecutionException lastException;

    /**
     * <p>
     * Represents the instance of Log to be used for performing the logging of the exceptions whenever
     * exceptions [checked exceptions] are caught in the methods of this class.
     * </p>
     *
     * <p>
     * This instance member can be null indicating that no such logging needs to be done.
     * </p>
     *
     * <p>
     * Note, The Level of logging to be used here for doing the logging is Level.ERROR.
     * </p>
     *
     * <p>
     * This instance member is initialized in the constructor and is immutable later on.
     * </p>
     */
    private final Log logger;

    /**
     * <p>
     * Constructs a new TransientUndoableAction with the action to be wrapped and the presentation name specified.
     * </p>
     *
     * @param originalAction the original TransientAction that this class is adapting as an UndoableAction
     * @param presentationName the presentationName to be returned by this Action
     *
     * @throws IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     * is null or an empty String on trimming
     */
    public TransientUndoableAction(TransientAction originalAction, String presentationName) {
        this(originalAction, presentationName, null);
    }

    /**
     * <p>
     * Constructs a new TransientUndoableAction with the action to be wrapped, presentation name and logger specified.
     * </p>
     *
     * @param originalAction the original TransientAction that this class is adapting as an UndoableAction
     * @param presentationName the presentationName to be returned by this Action
     * @param logger the instance of Log to be used for performing the logging of any exception that occurs
     * [can be null to indicate no logging needs to be done]
     *
     * @throws IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     * is null or an empty String on trimming
     */
    public TransientUndoableAction(TransientAction originalAction, String presentationName, Log logger) {
        Util.checkNull(originalAction, "originalAction");
        Util.checkString(presentationName, "presentationName");

        this.originalAction = originalAction;
        this.presentationName = presentationName;
        this.logger = logger;
    }

    /**
     * <p>
     * Executes this Action.
     * </p>
     *
     * <p>
     * This class is an adapter of the TransientAction class, so the execute() is done via the wrapped TransientAction
     * instance.
     * </p>
     *
     * <p>
     * Note, if the die() method has been invoked, then ActionExecutionException will be thrown, logged and stored.
     * </p>
     *
     * @throws ActionExecutionException if there are any problems in the execution of the wrapped TransientAction or
     * this Action has been marked not to be used by calling the die() method
     */
    public void execute() throws ActionExecutionException {
        // check if the die() method is invoked before.
        // If the die() method has been called, then ActionExecutionException will be thrown, logged and stored.
        if (!isActive) {
            ActionExecutionException e = new ActionExecutionException(
                "The Action has been marked not to be used by calling the die() method, "
                    + "thrown in TransientUndoableAction#execute() method.");
            Util.logErrorMsg(logger, Level.ERROR, e);
            lastException = e;
            throw e;
        }

        // execute the original action that wrapped by this adapter
        try {
            originalAction.execute();
        } catch (ActionExecutionException e) {
            Util.logErrorMsg(logger, Level.ERROR, e);
            lastException = e;
            throw e;
        }
    }

    /**
     * <p>
     * This method does nothing and is an empty method and just provided here to satisfy the interface definition
     * that this class is implementing.
     * </p>
     */
    public void undo() {
        // empty
    }

    /**
     * <p>
     * Returns always true, unless this Action has been made dead by calling the die() method.
     * </p>
     *
     * @return true always unless the Action is made to be dead by calling the die method
     */
    public boolean canUndo() {
        return isActive;
    }

    /**
     * <p>
     * This method will redo the action, which in turn acts as the execute() method.
     *  by simply invoking the execute() method. In case of any exception thrown
     * by the execute method, it is caught and logged using the "logger" instance if not null and stored in the
     * "lastException" instance member.
     * </p>
     *
     */
    public void redo() {
        try {
            execute();
        } catch (ActionExecutionException e) {
            // ignore
        }
    }

    /**
     * <p>
     * Returns always true, unless this Action has been made dead by calling the die() method.
     * </p>
     *
     * @return true always unless the Action is made to be dead by calling the die method
     */
    public boolean canRedo() {
        return isActive;
    }

    /**
     * <p>
     * Signals the Action that it would not be used any more and so release any of the resources it might be holding.
     * </p>
     */
    public void die() {
        isActive = false;
    }

    /**
     * <p>
     * This method does nothing and is an empty method and just provided here to satisfy the interface definition
     * that this class is implementing.
     * </p>
     *
     * <p>
     * Note, this method will always return false.
     * </p>
     *
     * @param edit the instance of UndoableEdit to be added
     * @return always false
     */
    public boolean addEdit(UndoableEdit edit) {
        return false;
    }

    /**
     * <p>
     * This method does nothing and is an empty method and just provided here to satisfy the interface definition
     * that this class is implementing.
     * </p>
     *
     * <p>
     * Note, this method will always return false.
     * </p>
     *
     * @param edit the instance of UndoableEdit to be edited
     * @return always false
     */
    public boolean replaceEdit(UndoableEdit edit) {
        return false;
    }

    /**
     * <p>
     * Return whether the Action is significant for undo()/redo() operation.
     * </p>
     *
     * <p>
     * Note, this method will always return false as this is adapting a TransientAction.
     * </p>
     *
     * @return whether the Action is significant for undo()/redo() operation.
     */
    public boolean isSignificant() {
        return false;
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
     * Returns the last exception that occurred during the execution of this Action.
     * </p>
     *
     * <p>
     * If no exception had occurred this method will return null.
     * </p>
     *
     * @return the last exception that occurred during the execution of this Action or null of no exception has occurred
     */
    public ActionExecutionException getLastException() {
        return lastException;
    }
}
