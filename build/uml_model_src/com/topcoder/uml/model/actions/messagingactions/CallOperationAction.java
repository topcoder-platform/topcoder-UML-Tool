/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.actions.messagingactions;

import com.topcoder.uml.model.core.Operation;

/**
 * <p>
 * This interface assembles the call arguments into an operation call request that is transmitted
 * to the target object. In the target object, the operation will cause the selection of a method and
 * the execution of its procedure. The argument values are available to the execution of the invoked procedure
 * as predefined <c>OutputPin</c> values. The action execution waits until the effect invoked by the request completes
 * and returns to the caller. When the execution of a procedure is complete, its result values are returned
 * to the calling execution. When a return message is received, execution of the action is complete and the
 * return values are used as the result values of the call operation action execution.
 * </p>
 *
 * <p>
 * <strong>Note</strong>:
 * The <c>OutputPin</c> values represent the values are available within the procedure.
 * </p>
 *
 * <p>
 * This interface extends <code>ExplicitInvocationAction</code> interface.
 * Currently there is one implementation - <code>CallOperationActionImpl</code>
 * </p>
 *
 * <p>
 * Operations supported by the <code>CallOperationAction</code> interface are:
 * <ul>
 * <li>
 * Gets whether the operation of this action will be called asynchronously or not.
 * </li>
 * <li>
 * Sets whether the operation of this action will be called asynchronously or not.
 * </li>
 * <li>
 * Gets the operation that will be invoked by this action.
 * </li>
 * <li>
 * Sets the operation that will be invoked by this action with the given value.
 * </li>
 * </ul>
 * </p>
 *
 * <p>
 * <strong>Thread Safety</strong>: Implementations of this interface do not have to be thread-safe.
 * In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.
 * </p>
 *
 * @author argolite, icyriver
 * @version 1.0
 */
public interface CallOperationAction extends ExplicitInvocationAction {
/**
 * <p>
 * Gets the value of asynchronous field. It represents whether the operation
 * will be called asynchronously or not.
 * </p>
 *
 * @return true if the operation will be called asynchronous, false otherwise.
 */
    public boolean isAsynchronous();

/**
 * <p>
 * Sets the asynchronous field with the given value. It represents whether the operation
 * will be called asynchronously or not.
 * </p>
 *
 * @param asynchronous a <code>boolean</code> value, which represents whether the operation
 *        will be called asynchronously or not.
 */
    public void setAsynchronous(boolean asynchronous);

/**
 * <p>
 * Gets the operation that will be invoked by this action.
 * </p>
 *
 * <p>
 * <strong>Note</strong>: The returned value can be <code>null</code>
 * </p>
 *
 * @return the operation that will be invoked by this action.
 */
    public Operation getOperation();

/**
 * <p>
 * Sets the operation that will be invoked by this action with the given value.
 * </p>
 *
 * <p>
 * <strong>Note</strong>: The value of the <c>operation</c> can be <code>null</code>.
 * </p>
 *
 * @param operation the operation that will be set to this action.
 */
    public void setOperation(Operation operation);
}


