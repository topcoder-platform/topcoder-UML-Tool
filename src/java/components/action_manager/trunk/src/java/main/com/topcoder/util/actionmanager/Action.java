/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

/**
 * <p>
 * This is the main interface defined by the component and defines the behavior of an action that can be executed
 * to perform an operation.
 * </p>
 *
 * <p>
 * This interface defines a single method called "execute" which is supposed to perform the Action when this method
 * is invoked. The Action is required as much as possible to be transactional in nature [though might not be
 * always possible] and when the Action fails to execute should try to return to the state before the Action was
 * executed. The execute() method of the Action is required to throw an ActionExecutionException if it fails to
 * execute the Action.
 * </p>
 *
 * <p>
 * Examples of Action:
 * <ul>
 * <li>Load a new project</li>
 * <li>Close the existing project</li>
 * </ul>
 * </p>
 *
 * <p>
 * Thread-Safety: The implementations of this interface may or may not be thread-safe. This is because the Action
 * implementation may make use of external resources and access to these cannot be made thread-safe as these external
 * resources might be used by other process as well.
 * </p>
 *
 * @author fastprogrammer, biotrail
 * @version 1.0
 */
public interface Action {
    /**
     * <p>
     * Executes the Action and if there are any problems in the execution of the Action, it is reported by throwing
     * an ActionExecutionException.
     * </p>
     *
     * @throws ActionExecutionException if there are problems in the execution of the action
     */
    public void execute() throws ActionExecutionException;
}
