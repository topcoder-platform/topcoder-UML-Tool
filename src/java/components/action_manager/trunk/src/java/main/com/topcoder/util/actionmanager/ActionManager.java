/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

import com.topcoder.util.log.Log;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.LogException;
import com.topcoder.util.log.LogFactory;
import com.topcoder.util.collection.typesafeenum.Enum;

/**
 * <p>
 * This class is the main class of the component and is responsible for executing all types
 * of Action's like simple actions, transient actions, undoable actions and undo / redo actions.
 * </p>
 *
 * <p>
 * In this class, The following methods are provided:
 * <ol>
 * <li>Execute Action</li>
 * <li>To redo / undo Actions that exist in the undo / redo manager</li>
 * <li>To query about the Actions to be undone / redone</li>
 * </ol>
 * </p>
 *
 * <p>
 * Thread-Safety: This class has immutable instance members but is not thread-safe as it provides methods for
 * executing the Action and also methods for undo and redo of UndoableAction and the implementations of the
 * Actions and the UndoableAction interface might or might not be thread-safe and since this class invokes
 * methods of these interfaces, cannot be attributed to be thread-safe.
 * </p>
 *
 * @author fastprogrammer, biotrail
 * @version 1.0
 */
public class ActionManager {
    /**
     * <p>
     * This constant represents the <b>MaximumUndoableActions</b> property name.
     * </p>
     */
    private static final String MAXIMUM_UNDOABLE_ACTIONS = "MaximumUndoableActions";

    /**
     * <p>
     * This constant represents the <b>LoggerName</b> property name.
     * </p>
     */
    private static final String LOGGER_NAME = "LoggerName";

    /**
     * <p>
     * This constant represents the <b>LoggingLevel</b> property name.
     * </p>
     */
    private static final String LOGGING_LEVEL = "LoggingLevel";

    /**
     * <p>
     * The default number of maximum undoable actions when it is not specified.
     * </p>
     */
    private static final int DEFAULT_MAXIMUM_UNDOABLE_ACTIONS = 10;

    /**
     * <p>
     * Represents the instance of AdvancedUndoManager which is used to keep a track of the UndoableAction(s)
     * executed and which is used for undo/redo of the already executed UndoableAction(s) and also used to fetch the
     * information about the UndoableActions which can be undone/redone at the current instant.
     * </p>
     *
     * <p>
     * This instance member is initialized in the constructor and will be immutable later on. This instance member
     * will not be null after the initialization in the constructor.
     * </p>
     */
    private final AdvancedUndoManager undoManager;

    /**
     * <p>
     * Represents the instance of Log to be used for performing the Logging.
     * </p>
     *
     * <p>
     * This instance member is initialized in the constructor and is immutable later on.
     * </p>
     *
     * <p>
     * Note, this instance member can be null indicating that no logging needs to be performed.
     * </p>
     */
    private final Log logger;

    /**
     * <p>
     * Represents the level at which the Logging needs to be performed.
     * </p>
     *
     * <p>
     * This instance member is initialized in the constructor and is immutable later on.
     * </p>
     */
    private final Level loggingLevel;

    /**
     * <p>
     * Default Constructor.
     * </p>
     *
     * <p>
     * Note, in this constructor, the logger is set to null and loggingLevel is set to null too.
     * </p>
     */
    public ActionManager() {
        this(DEFAULT_MAXIMUM_UNDOABLE_ACTIONS, null, null);
    }

    /**
     * <p>
     * Constructs a new ActionManager instance with values read from the given namespace using Configuration Manager.
     * </p>
     *
     * <p>
     * In the configuration, the following properties are expected.
     * <ul>
     * <li>MaximumUndoableActions - required, specifies the maximum number of UndoableAction(s) that should be
     * maintained in the UndoManager</li>
     * <li>LoggerName - optional, specifies the name of the instance of the Log from the Logging Wrapper 1.2
     * component to be used for performing the logging</li>
     * <li>LoggingLevel - optional, specifies the level of logging to be done by the ActionManager, can be
     * &quot;OFF&quot;, &quot;INFO&quot;, &quot;WARN&quot;, &quot;DEBUG&quot; or &quot;ERROR&quot;, default
     * value for it is Level.DEBUG</li>
     * </ul>
     * </p>
     *
     * @param namespace the namespace in the configuration file from which the configuration properties needs to be read
     *
     * @throws IllegalArgumentException if the parameter "namespace" passed is null or an empty String on trimming.
     * @throws ActionManagerConfigurationException if the required properties are missing in the configuration file
     * or have invalid values or any exception is thrown when reading the properties using the Configuration Manager
     * component
     */
    public ActionManager(String namespace) throws ActionManagerConfigurationException {
        Util.checkString(namespace, "namespace");

        // read the configuration property values
        String maxUndoableActions = Util.getString(namespace, MAXIMUM_UNDOABLE_ACTIONS, true);
        String loggerName = Util.getString(namespace, LOGGER_NAME, false);

        if (loggerName != null && loggerName.trim().length() == 0) {
            throw new ActionManagerConfigurationException("The LoggerName property value is empty.");
        }

        // creates the undoManager instance
        try {
            // the property value should be an integer and must be large than zero.
            int limit = Integer.parseInt(maxUndoableActions.trim());
            if (limit <= 0) {
                throw new ActionManagerConfigurationException(
                    "The value for MaximumUndoableActions property is not more than 0.");
            }
            undoManager = new AdvancedUndoManager(limit);
        } catch (NumberFormatException nfe) {
            throw new ActionManagerConfigurationException(
                "The value for MaximumUndoableActions property in configuration file is not a valid integer", nfe);
        }

        // set the logger and loggingLevel
        // if the LoggerName property is missing, then it means no logging.
        // otherwise, the logger will be created from the LogFactory and the loggingLevel will be set too.
        if (loggerName == null) {
            logger = null;
            loggingLevel = null;
        } else {
            // If failed to create the logger from the LogFactory, the exception will be wrapped and rethrown
            try {
                logger = LogFactory.getLogWithExceptions(loggerName);
            } catch (LogException e) {
                throw new ActionManagerConfigurationException(
                    "LogException occurs when creating a Log instance from LogFactory", e);
            }

            // reads the LoggingLevel property and parse it.
            String levelValue = Util.getString(namespace, LOGGING_LEVEL, false);
            // the default value for the loggingLevel is Level.DEBUG
            loggingLevel = (levelValue == null) ? Level.DEBUG : parseLevelString(levelValue);
        }
    }

    /**
     * <p>
     * Constructs a new ActionManager instance with maximum number of UndoableActions, logger and
     * loggingLevel specified.
     * </p>
     *
     * <p>
     * Note, when the logger is null then it means no logging should be done.
     * When the logger is not null, then if the loggingLevel will be set to Level.DEBUG if the
     * passed loggingLevel is null.
     * </p>
     *
     * @param maxUndoableActions the maximum number of UndoableActions that need to be stored in the
     * AdvancedUndoManager to perform the undo/redo of these actions
     * @param logger the instance of Log to be used for performing the Logging (can be null)
     * @param loggingLevel the level of the logging to be performed (can be null)
     *
     * @throws IllegalArgumentException if the parameter "maxUndoableActions" is not more than 0, or when
     * loggingLevel is not null and the logger is not null, the loggingLevel is not one of the five levels
     * defined by this component
     */
    public ActionManager(int maxUndoableActions, Log logger, Level loggingLevel) {
        if (maxUndoableActions <= 0) {
            throw new IllegalArgumentException("The parameter 'maxUndoableActions' is not more than 0.");
        }

        // the loggingLevel must be one of the five levels defined by this component
        if (logger != null && loggingLevel != null && !isValidLevel(loggingLevel)) {
            throw new IllegalArgumentException("The loggingLevel is " + loggingLevel
                + " and is not valid, only OFF, ERROR, WARN, INFO and DEBUG are allowed.");
        }

        this.undoManager = new AdvancedUndoManager(maxUndoableActions);
        this.logger = logger;
        // when logger is null, then the loggingLevel will be set to null too.
        // otherwise, the loggingLevel will be set to Level.DEBUG if it is null
        if (logger == null) {
            this.loggingLevel = null;
        } else {
            this.loggingLevel = (loggingLevel == null) ? Level.DEBUG : loggingLevel;
        }
    }

    /**
     * <p>
     * Executes the passed Action and updates the state of the "undoManager" instance member.
     * </p>
     *
     * <p>
     * Depending upon the type of the Action, the state of the "undoManager" is modified.
     * If the action is of the type TransientAction no change is made to the state of "undoManager".
     * If the Action is of the type UndoableAction, then the Action is added to the "undoManager".
     * If the Action instance is of any other type then the "undoManager" is reset.
     * </p>
     *
     * @param action the Action instance that needs to be executed
     *
     * @throws ActionExecutionException if there are problems detected in the execution of the Action
     * @throws IllegalArgumentException if the passed parameter "action" is null
     */
    public void executeAction(Action action) throws ActionExecutionException {
        try {
            Util.checkNull(action, "action");
        } catch (IllegalArgumentException e) {
            Util.logErrorMsg(logger, loggingLevel, e);
            Util.logWarnMsg(logger, loggingLevel, "The processing terminates after IllegalArgumentException is thrown.");
            throw e;
        }

        Util.logDebugMsg(logger, loggingLevel, "entrance of method ActionManager#executeAction(Action):void.");
        Util.logInfoMsg(logger, loggingLevel, "Incoming Parameter [action] : " + action.toString());

        try {
            Util.logInfoMsg(logger, loggingLevel, "Execute the action [" + action.toString() + "] is started.");
            // execute the action
            action.execute();
            Util.logInfoMsg(logger, loggingLevel, "Execute the action [" + action.toString() + "] is completed.");

            // change the state of the undoManager according to the type of the given action
            if (action instanceof UndoableAction) {
                undoManager.addEdit((UndoableAction) action);
            } else if (!(action instanceof TransientAction)) {
                // reset the undoManager
                undoManager.discardAllEdits();
            }
        } catch (ActionExecutionException e) {
            Util.logErrorMsg(logger, loggingLevel, e);
            Util.logWarnMsg(logger, loggingLevel, "The processing terminates after ActionExecutionException is thrown.");
            throw e;
        } finally {
            Util.logDebugMsg(logger, loggingLevel, "exit of method ActionManager#executeAction(Action):void.");
            Util.logDebugMsg(logger, loggingLevel, "Return message: void");
        }
    }

    /**
     * <p>
     * Reverts (undoes) all the actions till the passed action including the passed "toAction".
     * </p>
     *
     * <p>
     * Note, if the method throws an UndoActionExecutionException it is wrapped into an IllegalArgumentException
     * and thrown.
     * </p>
     *
     * @param toAction the UndoableAction till which the Actions needs to be undone
     *
     * @throws IllegalArgumentException if the passed parameter is null or the passed "toAction" was not
     * executed using this ActionManager or might have been removed from the UndoManager since it was an older entry
     */
    public void undoActions(UndoableAction toAction) {
        try {
            Util.checkNull(toAction, "toAction");
        } catch (IllegalArgumentException e) {
            Util.logErrorMsg(logger, loggingLevel, e);
            Util.logWarnMsg(logger, loggingLevel, "The processing terminates after IllegalArgumentException is thrown.");
            throw e;
        }

        Util.logDebugMsg(logger, loggingLevel, "entrance of method ActionManager#undoActions(UndoableAction):void.");
        Util.logInfoMsg(logger, loggingLevel, "Incoming Parameter [toAction] : " + toAction.toString());

        try {
            Util.logInfoMsg(logger, loggingLevel, "Undo the action [" + toAction.toString() + "] is started.");

            // undo the given action
            undoManager.undoActions(toAction);

            Util.logInfoMsg(logger, loggingLevel, "Undo the action [" + toAction.toString() + "] is completed.");
        } catch (UndoActionExecutionException e) {
            Util.logErrorMsg(logger, loggingLevel, e);
            Util.logWarnMsg(logger, loggingLevel,
                "The processing terminates after UndoActionExecutionException is thrown.");
            throw new IllegalArgumentException("The passed UndoableAction is not present with AdvancedUndoManager", e);
        } finally {
            Util.logDebugMsg(logger, loggingLevel, "exit of method ActionManager#undoActions(UndoableAction):void.");
            Util.logDebugMsg(logger, loggingLevel, "Return message: void");
        }
    }

    /**
     * <p>
     * Re-does all the actions till the passed action including the passed "toAction".
     * </p>
     *
     * <p>
     * Note, if the method throws an RedoActionExecutionException it is wrapped into an IllegalArgumentException and
     * thrown.
     * </p>
     *
     * @param toAction the UndoableAction till which the Actions needs to be redone
     *
     * @throws IllegalArgumentException if the passed parameter is null or the passed "toAction" was not executed
     * using this ActionManager or might have been removed from the UndoManager since it was an older entry
     */
    public void redoActions(UndoableAction toAction) {
        try {
            Util.checkNull(toAction, "toAction");
        } catch (IllegalArgumentException e) {
            Util.logErrorMsg(logger, loggingLevel, e);
            Util.logWarnMsg(logger, loggingLevel, "The processing terminates after IllegalArgumentException is thrown.");
            throw e;
        }

        Util.logDebugMsg(logger, loggingLevel, "entrance of method ActionManager#redoActions(UndoableAction):void.");
        Util.logInfoMsg(logger, loggingLevel, "Incoming Parameter [toAction] : " + toAction.toString());

        try {
            Util.logInfoMsg(logger, loggingLevel, "Undo the action [" + toAction.toString() + "] is started.");

            // redo the given action
            undoManager.redoActions(toAction);

            Util.logInfoMsg(logger, loggingLevel, "Undo the action [" + toAction.toString() + "] is completed.");
        } catch (RedoActionExecutionException e) {
            Util.logErrorMsg(logger, loggingLevel, e);
            Util.logWarnMsg(logger, loggingLevel,
                "The processing terminates after RedoActionExecutionException is thrown.");
            throw new IllegalArgumentException("The passed UndoableAction is not present with AdvancedUndoManager", e);
        } finally {
            Util.logDebugMsg(logger, loggingLevel, "exit of method ActionManager#redoActions(UndoableAction):void.");
            Util.logDebugMsg(logger, loggingLevel, "Return message: void");
        }
    }

    /**
     * <p>
     * Returns the last UndoableAction that can be un-done.
     * </p>
     *
     * <p>
     * If there is no UndoableAction executed using this ActionManager that can be un-done then this method
     * returns null.
     * </p>
     *
     * @return the last UndoableAction that can be un-done or null if no such UndoableAction is found
     */
    public UndoableAction getUndoableActionToBeUndone() {
        Util.logDebugMsg(logger, loggingLevel,
            "entrance of method ActionManager#getUndoableActionToBeUndone():UndoableAction.");

        UndoableAction action = undoManager.getUndoableActionToBeUndone();

        Util.logDebugMsg(logger, loggingLevel,
            "exit of method ActionManager#getUndoableActionToBeUndone():UndoableAction.");
        Util.logDebugMsg(logger, loggingLevel, "Return message : " + action);

        return action;
    }

    /**
     * <p>
     * Returns the list of UndoableAction(s) that can be un-done.
     * </p>
     *
     * <p>
     * If there is no UndoableAction executed using this ActionManager that can be un-done then this method
     * returns an empty list. Note that each element of the returned list is of the type UndoableAction and
     * will not be null.
     * </p>
     *
     * @return the list of UndoableAction(s) that can be un-done or an empty list if no such UndoableAction(s)
     * are found to be present
     */
    public List<UndoableAction> getUndoableActionsToBeUndone() {
        Util.logDebugMsg(logger, loggingLevel,
            "entrance of method ActionManager#getUndoableActionsToBeUndone():List<UndoableAction>.");

        List<UndoableAction> actions = undoManager.getUndoableActionsToBeUndone();

        Util.logDebugMsg(logger, loggingLevel,
            "exit of method ActionManager#getUndoableActionsToBeUndone():List<UndoableAction>.");
        Util.logDebugMsg(logger, loggingLevel, "Return message : List, Size : " + actions.size() + ", Elements :"
            + actions.toString());
        return actions;
    }

    /**
     * <p>
     * Returns the last UndoableAction that can be re-done.
     * </p>
     *
     * <p>
     * If there is no UndoableAction executed using this ActionManager that can be re-done then this
     * method returns null.
     * </p>
     *
     * @return the last UndoableAction that can be re-done or null if no such UndoableAction exists
     */
    public UndoableAction getUndoableActionToBeRedone() {
        Util.logDebugMsg(logger, loggingLevel,
            "entrance of method ActionManager#getUndoableActionToBeRedone():UndoableAction.");

        UndoableAction action = undoManager.getUndoableActionToBeRedone();

        Util.logDebugMsg(logger, loggingLevel,
            "exit of method ActionManager#getUndoableActionToBeRedone():UndoableAction.");
        Util.logDebugMsg(logger, loggingLevel, "Return message : " + action);

        return action;
    }

    /**
     * <p>
     * Returns the list of UndoableAction(s) that can be re-done.
     * </p>
     *
     * <p>
     * If there is no UndoableAction executed using this ActionManager that can be re-done then this method
     * returns an empty list. Note that each element of the returned list is of the type UndoableAction
     * and will not be null.
     * </p>
     *
     * @return the list of UndoableAction(s) that can be re-done or an empty list if no such UndoableAction(s)
     * are found to be present
     */
    public List<UndoableAction> getUndoableActionsToBeRedone() {
        Util.logDebugMsg(logger, loggingLevel,
            "entrance of method ActionManager#getUndoableActionsToBeRedone():List<UndoableAction>.");

        List<UndoableAction> actions = undoManager.getUndoableActionsToBeRedone();

        Util.logDebugMsg(logger, loggingLevel,
            "exit of method ActionManager#getUndoableActionsToBeRedone():List<UndoableAction>.");
        Util.logDebugMsg(logger, loggingLevel, "Return message : List, " + actions.toString());

        return actions;
    }

    /**
     * <p>
     * Parses the level value for its corresponding Level representation.
     * </p>
     *
     * @param levelValue the string value of the logging level
     * @return the corresponding Level instance
     *
     * @throws ActionManagerConfigurationException if the given string is not a valid Level.
     */
    private Level parseLevelString(String levelValue) throws ActionManagerConfigurationException {
        Level level = (Level) Enum.getEnumByStringValue(levelValue, Level.class);

        // the level is validated, if it fails, then ActionManagerConfigurationException will be thrown
        if (isValidLevel(level)) {
            return level;
        } else {
            throw new ActionManagerConfigurationException("The property value " + levelValue
                + " for LoggingLevel is not valid, only OFF, DEBUG, INFO, WARN and ERROR are allowed.");
        }
    }

    /**
     * <p>
     * Checks whether the given logging level is one of the five levels defined by this component.
     * </p>
     *
     * <p>
     * The five logging levels are:
     * <ul>
     * <li>OFF</li>
     * <li>ERROR</li>
     * <li>WARN</li>
     * <li>INFO</li>
     * <li>DEBUG</li>
     * </ul>
     * </p>
     *
     * @param level the level of the logging to be performed
     * @return true if the given level is one of the five levels defined by this component, otherwise false.
     */
    private boolean isValidLevel(Level level) {
        return (level == Level.OFF || level == Level.ERROR || level == Level.WARN || level == Level.INFO || level == Level.DEBUG);
    }

    /**
     * <p>
     * This class extends the javax.swing.undo.UndoManager class.
     * </p>
     *
     * <p>
     * In this class, it provides additional methods which are required for servicing the functional requirements
     * required by the ActionManager like fetching the List of UndoableAction(s) that can be un-done/re-done, the
     * last UndoableAction that can be un-done/re-done and the methods that allow un-doing/re-doing all the
     * UndoableAction(s) it maintains till/including the passed UndoableAction.
     * </p>
     *
     * <p>
     * Thread-Safety: This class has no members of its own but accesses the members from the super class and allows the
     * undo/redo operations of the UndoableAction and these operations are not as such required to be thread-safe and
     * hence this class is not thread-safe.
     * </p>
     *
     * @author fastprogrammer, TCSDEVELOPER
     * @version 1.0
     */
    private class AdvancedUndoManager extends UndoManager {
        /**
         * <p>
         * Constructs an AdvancedUndoManager with the maximum number of UndoableActions specified.
         * </p>
         *
         * @param limit the number of UndoableActions that should be cached for performing the undo()/redo()
         * operations on them
         */
        public AdvancedUndoManager(int limit) {
            super.setLimit(limit);
        }

        /**
         * <p>
         * Retrieves the last significant UndoableAction that can be undone or null, if there are none that
         * can be undone.
         * </p>
         *
         * @return the last significant UndoableAction that can be undone or null, if there are none that
         * can be undone.
         */
        public UndoableAction getUndoableActionToBeUndone() {
            List<UndoableAction> actions = getUndoableActionsToBeUndone();
            return actions.isEmpty() ? null : actions.get(0);
        }

        /**
         * <p>
         * Returns a List of significant UndoableAction(s) that can be un-done.
         * </p>
         *
         * <p>
         * Note, each element of the returned list is of the type UndoableAction and will not be null.
         * If no such UndoableAction(s) are found, then an empty list is returned.
         * </p>
         *
         * @return a List of significant UndoableAction(s) that can be un-done
         */
        public List<UndoableAction> getUndoableActionsToBeUndone() {
            List<UndoableAction> undoableActions = new ArrayList<UndoableAction>();
            UndoableEdit edit = editToBeUndone();
            if (edit == null) {
                // returning an empty list if no UndoableActions are found.
                return undoableActions;
            }

            int index = edits.indexOf(edit);
            // last edit added first and later on other edits
            for (int i = index; i >= 0; i--) {
                UndoableAction action = (UndoableAction) edits.elementAt(i);
                if (action.isSignificant()) {
                    undoableActions.add(action);
                }
            }

            return undoableActions;
        }

        /**
         * <p>
         * Retrieves the last significant UndoableAction that can be redone or null, if there are none that
         * can be redone.
         * </p>
         *
         * @return the last significant UndoableAction that can be redone or null, if there are none that
         * can be redone.
         */
        public UndoableAction getUndoableActionToBeRedone() {
            List<UndoableAction> actions = getUndoableActionsToBeRedone();
            return actions.isEmpty() ? null : actions.get(0);
        }

        /**
         * <p>
         * Returns a List of significant UndoableAction(s) that can be re-done.
         * </p>
         *
         * <p>
         * Note, each element of the returned list is of the type UndoableAction and will not be null.
         * If no such UndoableAction(s) are found, then an empty list is returned.
         * </p>
         *
         * @return a List of significant UndoableAction(s) that can be re-done.
         */
        public List<UndoableAction> getUndoableActionsToBeRedone() {
            List<UndoableAction> undoableActions = new ArrayList<UndoableAction>();
            UndoableEdit edit = editToBeRedone();
            // return empty list if no UndoableAction that can be redone is found.
            if (edit == null) {
                return undoableActions;
            }
            int index = edits.indexOf(edit);
            // last undone edit added first and later on other edits
            for (int i = index; i < edits.size(); i++) {
                UndoableAction action = (UndoableAction) edits.elementAt(i);
                if (action.isSignificant()) {
                    undoableActions.add(action);
                }
            }
            return undoableActions;
        }

        /**
         * <p>
         * Un-does all the UndoableAction which are present in this UndoManager till the passed "toAction", the
         * "toAction" is included too.
         * </p>
         *
         * <p>
         * Note, if the passed "toAction" is not present in the UndoManager an UndoActionExecutionException is
         * thrown to indicate it.
         * </p>
         *
         * @param toAction the UndoableAction till which all the UndoableAction needs to be undone
         *
         * @throws IllegalArgumentException if the parameter "toAction" passed is null
         * @throws UndoActionExecutionException if the passed "toAction" is not present in this UndoManager
         */
        public void undoActions(UndoableAction toAction) throws UndoActionExecutionException {
            Util.checkNull(toAction, "toAction");

            int index = edits.indexOf(toAction);
            if (index == -1) {
                throw new UndoActionExecutionException("The given toAction is not present in the edits to be un-done.");
            }
            undoTo(toAction);
        }

        /**
         * <p>
         * Re-does all the UndoableAction which are present in this UndoManager till the passed "toAction", the
         * "toAction" is included too.
         * </p>
         *
         * <p>
         * Note, if the passed "toAction" is not present in the UndoManager a RedoActionExecutionException is
         * thrown to indicate it.
         * </p>
         *
         * @param toAction the UndoableAction till which all the UndoableActions needs to be redone including this
         * UndoableAction
         *
         * @throws RedoActionExecutionException: if the passed "toAction" is not present in this UndoManager
         * @throws IllegalArgumentException if the parameter "toAction" passed is null
         */
        public void redoActions(UndoableAction toAction) throws RedoActionExecutionException {
            Util.checkNull(toAction, "toAction");

            int index = edits.indexOf(toAction);
            if (index == -1) {
                throw new RedoActionExecutionException("The given toAction is not present in the edits to be re-done.");
            }
            redoTo(toAction);
        }
    }
}
